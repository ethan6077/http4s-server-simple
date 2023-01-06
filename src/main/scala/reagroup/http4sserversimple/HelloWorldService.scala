package reagroup.http4sserversimple

import cats.effect._, org.http4s._, org.http4s.dsl.io._

/**
  * An HttpRoutes[F] is a simple alias for Kleisli[OptionT[F, *], Request, Response].
  * Kleisli is just a convenient wrapper around a Request => F[Response]
  */

object HelloWorldService {
  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello" / name =>
      Ok(s"Hello, $name.")
  }

}
