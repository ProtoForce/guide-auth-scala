package io.protoforce.runtime

class IRTException(val message: String) extends RuntimeException(message) {
  def canEqual(other: Any): Boolean = other.isInstanceOf[IRTException]

  override def equals(other: Any): Boolean = other match {
    case that: IRTException =>
      (that canEqual this) &&
      message == that.message
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(message)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}