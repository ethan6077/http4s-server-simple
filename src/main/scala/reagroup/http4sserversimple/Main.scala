package reagroup.http4sserversimple

import cats.effect.{ExitCode, IO, IOApp}
import cats.syntax.all._
import com.comcast.ip4s._
import org.http4s.ember.server._
import org.http4s.server.Router
import reagroup.http4sserversimple.HelloWorldService.helloWorldService
import reagroup.http4sserversimple.TweetService.tweetService


object Main extends IOApp {
  val services = tweetService <+> helloWorldService
  val httpApp = Router("/" -> helloWorldService, "/api" -> services).orNotFound

  def run(args: List[String]): IO[ExitCode] =
    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp(httpApp)
      .build
      .use(_ => IO.never)
      .as(ExitCode.Success)
}
