package reagroup.http4sserversimple

import cats.data.Kleisli
import cats.effect.IO
import org.http4s.{Header, HttpRoutes, Request, Status}

object Middleware {
  def myMiddle(service: HttpRoutes[IO], header: Header.ToRaw): HttpRoutes[IO] = Kleisli { (req: Request[IO]) =>
    service(req).map {
      case Status.Successful(resp) =>
        resp.putHeaders(header)
      case resp => resp
    }
  }
}
