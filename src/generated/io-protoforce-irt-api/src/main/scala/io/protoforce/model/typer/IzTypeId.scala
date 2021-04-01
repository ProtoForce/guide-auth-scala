package io.protoforce.model.typer

import izumi.functional.{Renderable, WithRenderableSyntax}
import io.protoforce.model.CachedHashcode
import io.protoforce.model.common.{DomainId, TypeName}

sealed trait IzTypeId extends CachedHashcode {
  def name: TypeName
  def maybePrefix: Option[TypePrefix]
}

object IzTypeId extends WithRenderableSyntax {
  implicit object IzTypeIdRenderer extends Renderable[IzTypeId] {
    override def render(value: IzTypeId): String = {
      value match {
        case IzTypeId.BuiltinTypeId(name) =>
          s":${name.name}"
        case IzTypeId.UserTypeId(prefix, name) =>
          s"${prefix.render()}:${name.name}"

      }
    }
  }
  object model {

    case class IzNsSegment(name: String, origin: Option[IzTypeId] = None) {
      override lazy val hashCode: Int = name.hashCode

      override def equals(obj: Any): Boolean = obj match {
        case o: IzNsSegment => this.name == o.name
        case _ => false
      }
    }

    case class IzSubNamespace(elements: Seq[IzNsSegment]) extends CachedHashcode {
      def :+(namespace: IzNsSegment): IzSubNamespace = IzSubNamespace(elements :+ namespace)
      def ++(other: IzSubNamespace): IzSubNamespace = IzSubNamespace(elements ++ other.elements)
      def isEmpty: Boolean = elements.isEmpty
      def nonEmpty: Boolean = elements.nonEmpty
    }

    object IzSubNamespace {
      val empty: IzSubNamespace = IzSubNamespace(Seq.empty)
    }

    case class IzPackage(domainId: DomainId, sub: IzSubNamespace) extends CachedHashcode {
      def subPkg(more: IzSubNamespace): IzPackage = {
        this.copy(sub = sub ++ more)
      }

      def path: Seq[String] = {
        domainId.pkg.path ++ Seq(domainId.id) ++ sub.elements.map(_.name)
      }
    }

  }

  final case class BuiltinTypeId(name: TypeName) extends IzTypeId {
    override def maybePrefix: Option[TypePrefix] = None
  }

  final case class UserTypeId(prefix: TypePrefix, name: TypeName) extends IzTypeId {
    override def maybePrefix: Option[TypePrefix] = Some(prefix)
  }

}