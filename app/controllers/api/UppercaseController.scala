package controllers.api

import javax.inject._
import play.api.mvc._
import play.api.libs.json._
import models.{Uppercase}

class UppercaseController @Inject() (
    cc: ControllerComponents
) extends AbstractController(cc) {

  implicit val uppercaseFormat = Json.format[Uppercase]

  def getAll(string: String) =
    Action {
      val inputstring = new Uppercase(string.toUpperCase())
      Ok(Json.toJson(inputstring))
    }
}
