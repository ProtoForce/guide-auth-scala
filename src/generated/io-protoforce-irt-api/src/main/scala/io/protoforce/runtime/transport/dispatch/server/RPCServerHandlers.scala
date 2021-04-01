package io.protoforce.runtime.transport.dispatch.server

import io.protoforce.model.typer.IRTRestSpec

trait RPCHandlers[F[+_, +_], -C, Wire] {
  def handlers: Seq[GeneratedServerBase[F, C, Wire]]
  def toRestSpec: Map[GeneratedServerBase.MethodId, IRTRestSpec] = {
    handlers.flatMap(d => d._specs.toSeq).toMap
  }
}

case class RPCServerHandlers[F[+_, +_], -C, Wire](handlers: Seq[GeneratedServerBase[F, C, Wire]]) extends RPCHandlers[F, C, Wire]

case class RPCClientHandlers[F[+_, +_], -C, Wire](handlers: Seq[GeneratedServerBase[F, C, Wire]]) extends RPCHandlers[F, C, Wire]