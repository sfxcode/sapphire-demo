package com.sfxcode.sapphire.core.demo.blueprint

import com.sfxcode.sapphire.core.cdi.FXApp
import com.typesafe.config.ConfigFactory

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.stage.Stage

object Application extends FXApp {

  JFXApp.AUTO_SHOW = true

  override def applicationStage:Stage  = {
    val conf = ConfigFactory.load()
    new PrimaryStage {
      title = "%s Blueprint (%s)".format(conf.getString("sapphire.core.name"), conf.getString("sapphire.core.version"))
      minHeight = 400
      minWidth = 600
      scene = new Scene {
      }
    }
  }
}


