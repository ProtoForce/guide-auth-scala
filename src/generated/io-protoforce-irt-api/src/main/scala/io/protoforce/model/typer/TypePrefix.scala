package io.protoforce.model.typer

import izumi.functional.{Renderable, WithRenderableSyntax}
import io.protoforce.model.CachedHashcode
import io.protoforce.model.typer.IzTypeId.model.{IzPackage, IzSubNamespace}

sealed trait TypePrefix extends CachedHashcode {
  def location: IzPackage

  def maybeSubpath: Option[IzSubNamespace]
}

object TypePrefix extends WithRenderableSyntax {

  case class UserTLT(location: IzPackage) extends TypePrefix {
    override def maybeSubpath: Option[IzSubNamespace] = None
  }

  case class UserT(location: IzPackage, subpath: IzSubNamespace) extends TypePrefix {
    override def maybeSubpath: Option[IzSubNamespace] = Some(subpath)
  }

  implicit object IzTypePrefixRenderer extends Renderable[TypePrefix] {
    override def render(value: TypePrefix): String = {
      value match {
        case TypePrefix.UserTLT(location) =>
          location.path.mkString(".")
        case TypePrefix.UserT(location, subpath) =>
          location.path.mkString(".") + "/" + subpath.elements.map(_.name).mkString(".")
      }
    }
  }
}