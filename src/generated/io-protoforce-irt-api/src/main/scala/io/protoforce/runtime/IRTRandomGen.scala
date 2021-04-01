package io.protoforce.runtime

import java.time._
import java.util.{Random, UUID}

import izumi.fundamentals.platform.language.Quirks

import scala.collection.compat.immutable.ArraySeq
import scala.reflect.{ClassTag, _}

trait IRTRandomGen[T] {
  def id: String

  def widen[O >: T]: IRTRandomGen[O] = map(identity)

  def map[O](f: T => O): IRTRandomGen[O] = {
    new IRTRandomGen[O] {
      override def id: String = IRTRandomGen.this.id

      override def makeRandom(random: util.Random, path: List[String]): O = f(IRTRandomGen.this.makeRandom(random, path))
    }
  }

  def makeRandom(random: scala.util.Random, path: List[String]): T
}

object IRTRandomGen {

  class IRTRandomGenException(message: String) extends RuntimeException(message)

  abstract class ClassBased[T: ClassTag] extends IRTRandomGen[T] {
    override def id: String = classTag[T].runtimeClass.getName
  }

  implicit def rndInt: IRTRandomGen[Int] = new ClassBased[Int] {
    override def makeRandom(random: util.Random, path: List[String]): Int = {
      Quirks.discard(path)
      random.nextInt()
    }
  }

  implicit def rndBoolean: IRTRandomGen[Boolean] = new ClassBased[Boolean] {
    override def makeRandom(random: util.Random, path: List[String]): Boolean = {
      Quirks.discard(path)
      random.nextBoolean()
    }
  }

  implicit def rndString: IRTRandomGen[String] = new ClassBased[String] {
    override def makeRandom(random: util.Random, path: List[String]): String = {
      Quirks.discard(path)
      random.nextString(random.nextInt(10))
    }
  }

  implicit def rndTypeId: IRTRandomGen[IRTTypeId] = new ClassBased[IRTTypeId] {
    override def makeRandom(random: util.Random, path: List[String]): IRTTypeId = {
      Quirks.discard(path)
      IRTTypeId(IRTRandomGen[String].makeRandom(random, path))
    }
  }

  implicit def rndByte: IRTRandomGen[Byte] = new ClassBased[Byte] {
    override def makeRandom(random: util.Random, path: List[String]): Byte = {
      Quirks.discard(path)
      random.nextInt().toByte
    }
  }

  implicit def rndBigInt: IRTRandomGen[BigInt] = new ClassBased[BigInt] {
    override def makeRandom(random: util.Random, path: List[String]): BigInt = {
      Quirks.discard(path)

      if (random.nextBoolean()) {
        BigInt(Long.MaxValue) + random.nextLong()
      } else {
        BigInt(Long.MinValue) - random.nextLong()
      }
    }
  }

  implicit def rndLong: IRTRandomGen[Long] = new ClassBased[Long] {
    override def makeRandom(random: util.Random, path: List[String]): Long = {
      Quirks.discard(path)
      random.nextLong()
    }
  }

  implicit def rndFloat: IRTRandomGen[Float] = new ClassBased[Float] {
    override def makeRandom(random: util.Random, path: List[String]): Float = {
      Quirks.discard(path)
      random.nextFloat()
    }
  }

  implicit def rndDouble: IRTRandomGen[Double] = new ClassBased[Double] {
    override def makeRandom(random: util.Random, path: List[String]): Double = {
      Quirks.discard(path)
      random.nextDouble()
    }
  }

  implicit def rndUUID: IRTRandomGen[UUID] = new ClassBased[UUID] {
    override def makeRandom(random: util.Random, path: List[String]): UUID = {
      Quirks.discard(path)
      new UUID(random.nextLong(), random.nextLong())
    }
  }

  implicit def rndLocalDateTime: IRTRandomGen[IRTLocalDateTime] = new ClassBased[IRTLocalDateTime] {
    override def makeRandom(random: util.Random, path: List[String]): IRTLocalDateTime = {
      Quirks.discard(path)
      IRTLocalDateTime(IRTRandomGen[IRTOffsetDateTime].makeRandom(random, path).toLocalDateTime)
    }
  }

  implicit def rndLocalTime: IRTRandomGen[IRTLocalTime] = new ClassBased[IRTLocalTime] {
    override def makeRandom(random: util.Random, path: List[String]): IRTLocalTime = {
      Quirks.discard(path)
      IRTLocalTime(IRTRandomGen[IRTOffsetDateTime].makeRandom(random, path).toLocalTime)
    }
  }

  implicit def rndLocalDate: IRTRandomGen[IRTLocalDate] = new ClassBased[IRTLocalDate] {
    override def makeRandom(random: util.Random, path: List[String]): IRTLocalDate = {
      Quirks.discard(path)
      IRTLocalDate(IRTRandomGen[IRTOffsetDateTime].makeRandom(random, path).toLocalDate)
    }
  }

  implicit def rndOffsetDateTime: IRTRandomGen[IRTOffsetDateTime] = new ClassBased[IRTOffsetDateTime] {
    override def makeRandom(random: util.Random, path: List[String]): IRTOffsetDateTime = {
      Quirks.discard(path)
      val offset = if (random.nextBoolean()) {
        random.nextInt(3600 * 2)
      } else {
        -random.nextInt(3600 * 2)
      }
      IRTOffsetDateTime(
        OffsetDateTime.of(
          1900 + random.nextInt(600),
          1 + random.nextInt(12),
          1 + random.nextInt(28),
          random.nextInt(24),
          random.nextInt(60),
          random.nextInt(60),
          random.nextInt(999999999),
          ZoneOffset.ofTotalSeconds(offset),
        )
      )
    }
  }

  implicit def rndList[T: IRTRandomGen: ClassTag]: IRTRandomGen[List[T]] = new ClassBased[List[T]] {
    override def makeRandom(random: util.Random, path: List[String]): List[T] = {
      val elgen = IRTRandomGen[T]
      if (path.contains(elgen.id)) {
        List.empty
      } else {
        try {
          List.fill(random.nextInt(10))(elgen.makeRandom(random, path))
        } catch {
          case _: IRTRandomGenException =>
            List.empty
        }
      }
    }
  }

  implicit def rndOption[T: IRTRandomGen: ClassTag]: IRTRandomGen[Option[T]] = new ClassBased[Option[T]] {
    override def makeRandom(random: util.Random, path: List[String]): Option[T] = {
      val elgen = IRTRandomGen[T]
      if (random.nextBoolean() && !path.contains(elgen.id)) {
        try {
          Some(elgen.makeRandom(random, path))
        } catch {
          case _: IRTRandomGenException =>
            None
        }
      } else {
        None
      }
    }
  }

  implicit def rndMap[K: IRTRandomGen: ClassTag, V: IRTRandomGen: ClassTag]: IRTRandomGen[Map[K, V]] = new ClassBased[Map[K, V]] {
    override def makeRandom(random: util.Random, path: List[String]): Map[K, V] = {
      val k = IRTRandomGen[K]
      val v = IRTRandomGen[V]
      if (!path.contains(k.id) && !path.contains(v.id)) {
        try {
          List.fill(random.nextInt(10))((k.makeRandom(random, path), v.makeRandom(random, path))).toMap
        } catch {
          case _: IRTRandomGenException =>
            Map.empty
        }
      } else {
        Map.empty
      }
    }
  }

  implicit def rndSet[T: IRTRandomGen: ClassTag]: IRTRandomGen[Set[T]] = new ClassBased[Set[T]] {
    override def makeRandom(random: util.Random, path: List[String]): Set[T] = {
      IRTRandomGen[List[T]].makeRandom(random, path).toSet
    }
  }

  implicit def rndArray[T: IRTRandomGen: ClassTag]: IRTRandomGen[ArraySeq[T]] = new ClassBased[ArraySeq[T]] {
    override def makeRandom(random: util.Random, path: List[String]): ArraySeq[T] = {
      ArraySeq.unsafeWrapArray(IRTRandomGen[List[T]].makeRandom(random, path).toArray)
    }
  }

  implicit def rndEither[L: IRTRandomGen: ClassTag, R: IRTRandomGen: ClassTag]: IRTRandomGen[Either[L, R]] = new ClassBased[Either[L, R]] {
    override def makeRandom(random: util.Random, path: List[String]): Either[L, R] = {
      val r = IRTRandomGen[R].map(Right.apply)
      val l = IRTRandomGen[L].map(Left.apply)
      _safeChoose[Either[L, R]](Seq(l.widen, r.widen), path, random)
    }
  }

  def _safeChoose[T](a: Seq[IRTRandomGen[T]], path: List[String], random: util.Random): T = {
    val bad = path.toSet
    val filtered = a.filterNot(g => bad.contains(g.id))

    if (filtered.nonEmpty) {
      _choose(filtered, random).makeRandom(random, path)
    } else {
      throw new IRTRandomGenException(
        s"Cannot generate random instance from alternatives ${a.map(_.id).mkString(",")}: cannot terminate recursion at path ${path.mkString("->")}"
      )
    }
  }

  def _choose[T](a: Seq[T], random: util.Random): T = {
    val index = random.nextInt(a.size)
    a(index)
  }

  private val sharedRandom = new ThreadLocal[scala.util.Random] {
    override def initialValue(): util.Random = scala.util.Random.javaRandomToRandom(new Random(System.nanoTime()))
  }

  trait IRTRandomGenSyntax[T] extends IRTRandomGen[T] {
    protected def gen: IRTRandomGen[T]

    override def id: String = gen.id

    override def makeRandom(random: util.Random, path: List[String]): T = gen.makeRandom(random, path)

    def random(): T = implicitly[IRTRandomGen[T]](gen).makeRandom(sharedRandom.get(), List.empty)

    def random(random: util.Random): T = gen.makeRandom(random, List.empty)
  }

  def apply[T: IRTRandomGen]: IRTRandomGenSyntax[T] = new IRTRandomGenSyntax[T] {
    override protected def gen: IRTRandomGen[T] = implicitly[IRTRandomGen[T]]
  }

}