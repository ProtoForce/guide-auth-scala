package io.protoforce.runtime.codecs

import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}

import io.protoforce.runtime.IRTRandomGen

object IRTCodecTest {
  def check[T: IRTRandomGen](domain: String, id: String)(implicit c: IRTCodec[T, String]): Unit = {
    val v = IRTRandomGen[T].random()

    val e = c.encode(v)

    val base = Paths.get("target", "codec-tests", domain)
    base.toFile.mkdirs()
    Files.write(base.resolve(s"$id.json"), e.getBytes(StandardCharsets.UTF_8))

    val d =
      try {
        c.decode(e)
      } catch {
        case t: Throwable =>
          throw new RuntimeException(s"[$domain/$id] encoded=$e, input=$v, message=${t.getMessage}", t)
      }

    if (!d.contains(v)) {
      throw new RuntimeException(s"[$domain/$id] Unexpected output: encoded=$e, decoded=$d, input=$v")
    }
  }
}