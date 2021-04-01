package io.protoforce.runtime.transport.dispatch.server.http

import io.circe._
import io.circe.syntax._
import izumi.functional.bio.{Error2, F}
import io.protoforce.runtime.codecs.IRTCodec
import io.protoforce.runtime.transport.dispatch.RPCResult
import io.protoforce.runtime.transport.dispatch.server.Envelopes.RemoteError
import io.protoforce.runtime.transport.dispatch.server.Envelopes.RemoteError.ShortException
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.{ClientResponse, ResponseKind}
import io.protoforce.runtime.transport.dispatch.server.TransportResponse
import io.protoforce.runtime.transport.errors.ClientDispatcherError
import io.protoforce.runtime.transport.errors.ClientDispatcherError.{ClientCodecFailure, WrongRpcEnvelope}

trait RestlikeResponseConvention[F[+_, +_], Header] {
  def mapResponse(out: TransportResponse): (Int, Map[Header, String], Json)
  def unpackEnvelope(
    parsedBody: Json,
    headers: Map[String, Set[String]],
  ): F[ClientDispatcherError, ClientResponse[Json]]
}

class RestlikeResponseConventionImpl[F[+_, +_]: Error2, Header: AbstractHeader](
  headers: HttpResponseHeaders[Header]
) extends RestlikeResponseConvention[F, Header] {
  private val Header = implicitly[AbstractHeader[Header]]

  import headers._

  protected def fail: Json =
    RemoteError
      .Critical(
        List(
          ShortException(
            "Unexpected RPC output",
            Some("Server bug: unexpected RPC layer output"),
          )
        )
      )
      .asJson

  def mapResponse(out: TransportResponse): (Int, Map[Header, String], Json) = {
    val (c, h, b) = out match {
      case TransportResponse.Success(res) =>
        res.kind match {
          case ResponseKind.Scalar =>
            (
              200,
              Map(
                XResponseType -> XResponseTypeSuccess,
                XSuccess -> XSuccessScalar,
              ),
              res.value,
            )

          case ResponseKind.RpcSuccess =>
            res.value.asObject.flatMap(_.values.headOption) match {
              case Some(value) =>
                (
                  200,
                  Map(
                    XResponseType -> XResponseTypeSuccess,
                    XSuccess -> XSuccessRight,
                  ),
                  value,
                )

              case None =>
                (
                  501,
                  Map(
                    XResponseType -> XResponseTypeFailure,
                    XFailure -> XFailureServer,
                  ),
                  fail,
                )
            }

          case ResponseKind.RpcFailure =>
            res.value.asObject.flatMap(_.values.headOption) match {
              case Some(value) =>
                (
                  400,
                  Map(
                    XResponseType -> XResponseTypeSuccess,
                    XSuccess -> XSuccessLeft,
                  ),
                  value,
                )

              case None =>
                (
                  501,
                  Map(
                    XResponseType -> XResponseTypeFailure,
                    XFailure -> XFailureServer,
                  ),
                  fail,
                )
            }

        }

      case TransportResponse.Failure(e) =>
        e match {
          case r: RemoteError.Transport =>
            (
              500,
              Map(
                XResponseType -> XResponseTypeFailure,
                XFailure -> XFailureBadInput,
              ),
              r.asJson,
            )

          case r: RemoteError.Critical =>
            (
              501,
              Map(
                XResponseType -> XResponseTypeFailure,
                XFailure -> XFailureServer,
              ),
              r.asJson,
            )
        }
    }

    (c, baseHeaders ++ h, b)
  }

  def unpackEnvelope(
    parsedBody: Json,
    headers: Map[String, Set[String]],
  ): F[ClientDispatcherError, ClientResponse[Json]] = {
    val normalizedHeaders = headers
      .toSeq.map {
        case (k, v) => (k.toLowerCase, v)
      }.toMap

    val typeHeader = Header.asString(XResponseType)
    normalizedHeaders.get(typeHeader.toLowerCase).flatMap(_.headOption) match {
      case Some(XResponseTypeSuccess) =>
        val successHeader = Header.asString(XSuccess)
        normalizedHeaders
          .get(successHeader.toLowerCase)
          .flatMap(_.headOption) match {
          case Some(XSuccessRight) =>
            F.pure(ClientResponse(RPCResult.wireRight(parsedBody)))
          case Some(XSuccessLeft) =>
            F.pure(ClientResponse(RPCResult.wireLeft(parsedBody)))
          case Some(XSuccessScalar) =>
            F.pure(ClientResponse(parsedBody))
          case Some(_) =>
            F.fail(WrongRpcEnvelope(None, Some(successHeader)))
          case None =>
            F.fail(WrongRpcEnvelope(Some(successHeader), None))
        }
      case Some(XResponseTypeFailure) =>
        val failureHeader = Header.asString(XFailure)
        normalizedHeaders
          .get(failureHeader.toLowerCase)
          .flatMap(_.headOption) match {
          case Some(XFailureBadInput) =>
            parseAs[RemoteError.Transport](parsedBody)
              .map(ClientDispatcherError.ServerError)
              .flatMap(F.fail(_))
          case Some(XFailureServer) =>
            parseAs[RemoteError.Critical](parsedBody)
              .map(ClientDispatcherError.ServerError)
              .flatMap(F.fail(_))
          case Some(_) =>
            F.fail(WrongRpcEnvelope(None, Some(failureHeader)))
          case None =>
            F.fail(WrongRpcEnvelope(Some(failureHeader), None))
        }
      case Some(_) =>
        F.fail(WrongRpcEnvelope(None, Some(typeHeader)))
      case None =>
        F.fail(WrongRpcEnvelope(Some(typeHeader), None))
    }
  }

  def parseAs[T: Decoder](json: Json): F[ClientDispatcherError, T] = {
    F.fromEither(json.as[T])
      .leftMap(
        e =>
          ClientCodecFailure(
            List(IRTCodec.IRTCodecFailure.IRTParserException(json.toString(), e))
          )
      )
  }
}