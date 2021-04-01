package io.protoforce.runtime.transport.dispatch.server.ws

import io.circe.{Json, Printer}
import izumi.functional.bio.{Entropy2, F, Primitives2, Temporal2}
import io.protoforce.runtime.transport.dispatch.client.{ClientRequestHook, ClientTransport}
import io.protoforce.runtime.transport.dispatch.server.Envelopes.{AsyncRequest, AsyncResponse}
import io.protoforce.runtime.transport.dispatch.server.GeneratedServerBase.ClientResponse
import io.protoforce.runtime.transport.dispatch.server._
import io.protoforce.runtime.transport.errors.ClientDispatcherError

class WsBuzzerTransport[
  F[
    +_,
    +_,
  ]: Temporal2: Primitives2,
  Meta,
  BzrRequestContext,
](pollingConfig: PollingConfig,
  client: WsSessionBuzzer[F, Meta],
  hook: ClientRequestHook[IdentifiedRequestContext[
    BzrRequestContext
  ], AsyncRequest],
  printer: Printer,
  random: Entropy2[F],
) extends ClientTransport[F, BzrRequestContext, Json] {

  import io.circe.syntax._

  override def connect(): F[ClientDispatcherError, Unit] = F.fail(ClientDispatcherError.OperationUnsupported())

  override def disconnect(): F[ClientDispatcherError, Unit] = F.fail(ClientDispatcherError.OperationUnsupported())

  override def dispatch(
    requestContext: BzrRequestContext,
    methodId: GeneratedServerBase.MethodId,
    body: Json,
  ): F[ClientDispatcherError, ClientResponse[Json]] = {
    def work(id: InvokationId): F[ClientDispatcherError, ClientResponse[Json]] =
      for {
        envelope <- F.fromEither(
          hook.onRequest(
            IdentifiedRequestContext(requestContext, id, methodId, body),
            c => AsyncRequest(c.methodId, Map.empty, c.body, c.invokationId),
          )
        )
        _ <- client.setPending(id)
        _ <-
          client
            .send(envelope.asJson.printWith(printer))
            .leftMap(e => ClientDispatcherError.UnknownException(e))

        promise <-
          Primitives2[F].mkPromise[ClientDispatcherError, ClientResponse[Json]]
        check = for {
          status <- client.takePending(id)
          _ <- status match {
            case Some(value) =>
              for {
                _ <- value.envelope match {
                  case s: AsyncResponse.AsyncSuccess =>
                    promise.succeed(ClientResponse(s.body))
                  case f: AsyncResponse.AsyncFailure =>
                    promise.fail(ClientDispatcherError.ServerError(f.error))
                }
              } yield ()

            case None =>
              F.unit
          }
          done <- promise.poll
          out <- done match {
            case Some(value) =>
              value.map(f => Some(f))

            case None =>
              F.pure(None): F[ClientDispatcherError, Option[
                ClientResponse[Json]
              ]]
          }
        } yield out
        result <- check.repeatUntil(
          tooManyAttemptsError = ClientDispatcherError.TimeoutException(id, methodId),
          sleep = pollingConfig.sleep,
          maxAttempts = pollingConfig.maxAttempts,
        )
      } yield result

    for {
      id <- random.nextTimeUUID()
      iid = InvokationId(id.toString)
      result <- work(iid).guarantee(client.dropPending(iid))
    } yield result
  }
}