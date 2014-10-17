package com.sfxcode.sapphire.core.demo.form

import javax.enterprise.context.ApplicationScoped
import javax.inject.Named

import com.sfxcode.sapphire.core.cdi.FXApp
import com.sfxcode.sapphire.core.controller.AppController
import com.sfxcode.sapphire.core.demo.form.controller.MainWindowController

import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.stage.Stage


object Application extends FXApp {

  override def applicationStage:Stage  = new PrimaryStage {
    title = "Sapphire Form Demo"
    scene = new Scene {

    }
  }
}

@Named
@ApplicationScoped
class DemoApplicationController extends AppController {

  lazy val controller = getController[MainWindowController]()

  def applicationDidLaunch() {
    println("start " + this)
    replaceSceneContent(controller)
  }

}




