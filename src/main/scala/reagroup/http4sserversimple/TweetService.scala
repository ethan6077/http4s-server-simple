package reagroup.http4sserversimple

import cats.effect.IO
import org.http4s.HttpRoutes
import org.http4s.dsl.io._
import reagroup.http4sserversimple.models.Tweet

object TweetService {
  def getTweet(tweetId: Int): IO[Tweet] = ???

  def getPopularTweets(): IO[Seq[Tweet]] = ???

  val tweetService = HttpRoutes.of[IO] {
    case GET -> Root / "tweets" / "popular" =>
      getPopularTweets().flatMap(Ok(_))
    case GET -> Root / "tweets" / IntVar(tweetId) =>
      getTweet(tweetId).flatMap(Ok(_))
  }
}
