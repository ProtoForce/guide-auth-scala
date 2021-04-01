package io.protoforce.model.typer

import izumi.functional.{Renderable, WithRenderableSyntax}
import io.protoforce.model.CachedHashcode
import io.protoforce.model.common.TypeName
import io.protoforce.model.typer.BasicField.FName
import io.protoforce.model.typer.IzTypeReference.model.IzTypeArgValue

sealed trait IzTypeReference extends CachedHashcode {
  def id: IzTypeId
  def args: Seq[IzTypeArgValue]
}

object IzTypeReference extends WithRenderableSyntax {
  object model {
    case class IzTypeArgName(name: String)
    case class IzTypeArgValue(ref: IzTypeReference)
  }
  import model._

  final case class Scalar(id: IzTypeId) extends IzTypeReference {
    override def args: Seq[IzTypeArgValue] = Seq.empty
  }
  final case class Generic(
    id: IzTypeId,
    args: Seq[IzTypeArgValue],
    adhocName: Option[TypeName],
  ) extends IzTypeReference

  implicit object IzTypeArgRenderer extends Renderable[IzTypeArgValue] {
    override def render(value: IzTypeArgValue): String = {
      s"#${IzTypeReferenceRenderer.render(value.ref)}"
    }
  }

  implicit object IzTypeReferenceRenderer extends Renderable[IzTypeReference] {
    override def render(value: IzTypeReference): String = {
      value match {
        case IzTypeReference.Scalar(id) =>
          id.render() // it's important for scalar reference id to be exactly the same as typeid
        case IzTypeReference.Generic(id, args, adhocName) =>
          adhocName
            .map(_.name)
            .getOrElse(
              s"${id.render()}[${args.map(arg => arg.render()).mkString(",")}]"
            )
      }
    }
  }
}

final case class BasicField(name: FName, ref: IzTypeReference)

object BasicField {
  final case class FName(name: String)
}

//object Test {
//  val a: IzTypeReference = ???
//  a.render()
//}