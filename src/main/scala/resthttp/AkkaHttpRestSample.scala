package resthttp

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpMethods, HttpRequest, HttpResponse}
import akka.stream.ActorMaterializer

import java.net.URLEncoder
import java.util.Collections
import scala.concurrent.Future
import scala.concurrent.duration.DurationInt

object AkkaHttpRestSample {

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()
  import system.dispatcher

  val source =
    """
      |object SimpleApp {
      |  val aField = 2
      |}
      |""".stripMargin

  val request = HttpRequest(
    method = HttpMethods.POST,
    uri = "http://markup.su/api/highlighter",
    entity = HttpEntity(
      ContentTypes.`application/x-www-form-urlencoded`,
      s"source=${URLEncoder.encode(source, "UTF-8")}&language=Scala&theme=Sunburst"
    )
  )

  def sendRequest(): Future[String] = {
    val responseFuture: Future[HttpResponse] = Http().singleRequest(request)
    val entityFuture: Future[HttpEntity.Strict] = responseFuture.flatMap(response => response.entity.toStrict(2.seconds))
    entityFuture.map(entity => entity.data.utf8String)
  }

  def main(args: Array[String]): Unit = {
    sendRequest().foreach(println)
  }

}
