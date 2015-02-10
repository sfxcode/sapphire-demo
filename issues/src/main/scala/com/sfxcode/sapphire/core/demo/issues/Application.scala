package com.sfxcode.sapphire.core.demo.issues

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import javax.inject.Named

import com.sfxcode.sapphire.extension.fxml.ScalaFxmlLoading
import com.sfxcode.sapphire.core.cdi.FXApp
import com.sfxcode.sapphire.core.controller.AppController
import com.sfxcode.sapphire.core.demo.issues.controller.IssueTrackingLiteController

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.stage.Stage

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

case class EmptyName(name:String)

@Named
@ApplicationScoped
class ApplicationController extends AppController with ScalaFxmlLoading {
  lazy val mainController = getScalaController[IssueTrackingLiteController]()

  def applicationDidLaunch() {
    println("start " + this)
    replaceSceneContent(mainController)
  }

  @Produces
  def emptyName:EmptyName = {
    EmptyName("New Issue")
  }

}
