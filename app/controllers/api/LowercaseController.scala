package controllers.api

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.Lowercase

class LowercaseController @Inject() (
    cc: ControllerComponents
) extends AbstractController(cc) {

  implicit val lowercaseFormat = Json.format[Lowercase]

  def getAll(string: String) =
    Action {
      val inputstring = new Lowercase(string.toLowerCase)
      Ok(Json.toJson(inputstring))
    }
}
