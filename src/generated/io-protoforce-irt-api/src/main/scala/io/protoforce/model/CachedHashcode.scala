package io.protoforce.model

trait CachedHashcode extends Product {
  override lazy val hashCode: Int = {
    scala.runtime.ScalaRunTime._hashCode(this)
  }
}