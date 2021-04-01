package io.protoforce.runtime

import io.protoforce.model.versioning.IRTSchema.{TypeBaseVersion, TypeFullVersion}

trait IRTMetadata[T] {
  def typeId: IRTTypeId
  def baseVersion: TypeBaseVersion
  def fullVersion: TypeFullVersion
}

object IRTMetadata {
  def apply[T: IRTMetadata]: IRTMetadata[T] = implicitly
}