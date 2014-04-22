package com.sfxcode.sapphire.core.demo.issues

import javax.inject.Named
import javax.enterprise.context.ApplicationScoped
import com.sfxcode.sapphire.core.controller.AppController
import scalafx.stage.Stage
import com.sfxcode.sapphire.core.cdi.FXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import com.sfxcode.sapphire.core.demo.issues.controller.IssueTrackingLiteController

object Application extends FXApp {

  override def applicationStage:Stage  = new PrimaryStage {
    title = "Sapphire - Issue Tracking Lite Sample"
    minWidth = 390
    minHeight = 500
    width = 800
    height = 600
    scene = new Scene {
      scene = new Scene {
        fill = LIGHTBLUE
      }
    }
  }

}

@Named
@ApplicationScoped
class IssuesApplicationController extends AppController {
  lazy val mainController = getController[IssueTrackingLiteController]()

  def applicationDidLaunch() {
    println("start " + this)
    replaceSceneContent(mainController)

  }

}
