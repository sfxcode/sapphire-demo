package com.sfxcode.sapphire.core.demo.issues

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Named

import com.sfxcode.sapphire.core.cdi.FXApp
import com.sfxcode.sapphire.core.controller.AppController
import com.sfxcode.sapphire.core.demo.issues.controller.IssueTrackingLiteController
import com.typesafe.config.ConfigFactory

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.stage.Stage

object Application extends FXApp {

  override def applicationStage: Stage = {
    val conf = ConfigFactory.load()
    new PrimaryStage {
      title = "%s Issue Tracking Lite Sample (%s)".format(conf.getString("sapphire.core.name"), conf.getString("sapphire.core.version"))
      minWidth = 390
      minHeight = 500
      width = 800
      height = 600
      scene = new Scene {
        scene = new Scene {
          fill = LightBlue
        }
      }
    }
  }

}

case class EmptyName(name: String)

@Named
@ApplicationScoped
class ApplicationController extends AppController {
  lazy val mainController = getController[IssueTrackingLiteController]()

  def applicationDidLaunch() {
    println("start " + this)
    replaceSceneContent(mainController)
  }

  @Produces
  def emptyName: EmptyName = {
    EmptyName("New Issue")
  }

}
