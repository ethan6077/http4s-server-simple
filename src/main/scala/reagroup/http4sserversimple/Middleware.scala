package reagroup.http4sserversimple

import cats.data.Kleisli
import cats.effect.IO
import org.http4s.{Header, HttpRoutes, Request, Status}
import org.typelevel.ci.CIString

object Middleware {
  def transactionIdMiddle(service: HttpRoutes[IO]): HttpRoutes[IO] = Kleisli { (req: Request[IO]) =>
    service(req).map {
      case Status.Successful(resp) => {
        val transactionIdHeader = Header.Raw(CIString("X-Transaction-Id"), "12345")
        resp.putHeaders(transactionIdHeader)
      }
      case resp => resp
    }
  }
}
