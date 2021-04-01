package io.protoforce.model.common

import io.protoforce.model.{CachedHashcode, common}
import io.protoforce.model.typer.IzTypeId.model.{IzPackage, IzSubNamespace}

final case class DomainId(pkg: common.Pkg, id: String) extends CachedHashcode {
  override def toString: String = s"{${pkg.path.mkString(".")}:$id}"

  def asPackage: common.Pkg = common.Pkg(pkg._path :+ id)

  def asIzPackage(izSubNamespace: Option[IzSubNamespace] = None): IzPackage = IzPackage(this, izSubNamespace.getOrElse(IzSubNamespace.empty))
}