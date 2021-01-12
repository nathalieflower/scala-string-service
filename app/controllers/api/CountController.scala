package controllers.api

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.{Count}

class CountController @Inject() (
    cc: ControllerComponents
) extends AbstractController(cc) {

  implicit val countFormat = Json.format[Count]

  def getAll(string: String) =
    Action {
      val inputstring = new Count(string.length.toString)
      Ok(Json.toJson(inputstring))
    }
}
