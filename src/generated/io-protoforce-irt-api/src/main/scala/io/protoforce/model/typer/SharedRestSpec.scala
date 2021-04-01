package io.protoforce.model.typer

object SharedRestSpec {
  final case class QueryParameterName(value: String) extends AnyVal

  final case class RawRestPath(value: String) extends AnyVal {
    def normalized: List[String] = value.split('/').filterNot(_.isEmpty).toList
    def ++(other: RawRestPath): RawRestPath = RawRestPath((normalized ++ other.normalized).mkString("/", "/", ""))
    def ++(other: List[String]): RawRestPath = RawRestPath((normalized ++ other).mkString("/", "/", ""))
  }
  sealed trait IRTType
  object IRTType {
    object IRTString extends IRTType
    object IRTInteger extends IRTType
    object IRTBool extends IRTType
    object IRTDouble extends IRTType
  }

  sealed trait OnWireGenericType
  object OnWireGenericType {
    case class Map(key: IRTType, value: IRTType) extends OnWireGenericType
    case class List(ref: IRTType, unpacked: Boolean) extends OnWireGenericType
    case class Option(ref: IRTType) extends OnWireGenericType
  }

  sealed trait HttpMethod {
    def name: String
  }

  object HttpMethod {
    final val all = List(Get, Post, Put, Delete, Patch).map {
      m =>
        m.name.toLowerCase -> m
    }.toMap

    final case object Get extends HttpMethod {
      override def name: String = "Get"
    }

    final case object Post extends HttpMethod {
      override def name: String = "Post"
    }

    final case object Put extends HttpMethod {
      override def name: String = "Put"
    }

    final case object Delete extends HttpMethod {
      override def name: String = "Delete"
    }

    final case object Patch extends HttpMethod {
      override def name: String = "Patch"
    }

    // final case object Head extends HttpMethod
    //  final case object Connect extends HttpMethod
    //  final case object Options extends HttpMethod
    //  final case object Trace extends HttpMethod
  }
}