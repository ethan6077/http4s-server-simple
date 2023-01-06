package reagroup.http4sserversimple.models

import cats.effect.IO
import org.http4s.EntityEncoder

case class Tweet(id: Int, message: String)

object Tweet {
  implicit def tweetEncoder: EntityEncoder[IO, Tweet] = ???
  implicit def tweetsEncoder: EntityEncoder[IO, Seq[Tweet]] = ???
}
