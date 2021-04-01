package io.protoforce.runtime.codecs

import io.circe.Json

package object circe {
  type IRTCodecJson[T] = IRTCodec[T, Json]


  private[codecs] implicit class OptionArrowSyntax[T](val opt: Option[T]) extends AnyVal{
    def second[U](f:T => U): Option[(T,U)] = secondFmap(f.andThen(Option.apply))
    def secondFmap[U](f: T => Option[U]): Option[(T,U)] = opt.flatMap(x => f(x).map((x, _)))
  }

  private[codecs] implicit class OptionTupleSyntax[L,R](val tupOpt: Option[(L,R)]) extends AnyVal{
    def rightMap[R2](f: R=> R2): Option[(L,R2)] = tupOpt.map{_.rightMap(f)}
    def rightBiMap[R2](f: (L, R) => R2): Option[(L,R2)] = tupOpt.map{_.rightBiMap(f)}
    def leftMap[L2](f: L=> L2): Option[(L2,R)] = tupOpt.map{_.leftMap(f)}
  }

  private[codecs] implicit class Tuple2Syntax[L,R](val tup: (L,R)) extends AnyVal{
    def rightMap[R2](f: R => R2): (L,R2) = (tup._1, f(tup._2))
    def rightBiMap[R2](f: (L,R) => R2): (L,R2) = (tup._1, f(tup._1, tup._2))
    def leftMap[L2](f: L => L2): (L2,R) = (f(tup._1), tup._2)
  }

  private[codecs] implicit class AsEitherSyntax[T](val t: T) extends AnyVal{
    def toRight[L]: Either[L,T] = Right(t)
    def toLeft[R]: Either[T,R] = Left(t)
  }

  object AsJsonString{
    def unapply(arg: Json): Option[String] = arg.asString
  }

  object AsJsonArray{
    def unapply(arg: Json): Option[Vector[Json]] = arg.asArray
  }

//  private[codecs] implicit class PartitionMapOps[T](val list: List[T]){
//    def partitionBiMap[L,R](predicate: T => Boolean)(leftMap: T => L)(rightMap: T => R): (List[L], List[R]) = {
//      val (lefts, rights) = list.foldLeft((List.empty[L], List.empty[R])){ case ((lefts, rights), element) =>
//        if(predicate(element))
//          (leftMap(element) :: lefts, rights)
//        else
//          (lefts, rightMap(element) :: rights)
//      }
//      (lefts.reverse, rights.reverse)
//    }
//  }
}