package reagroup.http4sserversimple

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  def run(args: List[String]) =
    Http4sserversimpleServer.stream[IO].compile.drain.as(ExitCode.Success)
}
