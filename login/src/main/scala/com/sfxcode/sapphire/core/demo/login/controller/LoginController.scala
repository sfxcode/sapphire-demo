package com.sfxcode.sapphire.core.demo.login.controller

import javafx.fxml.FXML
import javafx.scene.control._

import com.sfxcode.sapphire.core.Includes._
import com.sfxcode.sapphire.core.controller.ViewController
import com.sfxcode.sapphire.core.demo.login.LoginApplicationController
import com.sfxcode.sapphire.core.demo.login.model.UserDatabase


class LoginController extends ViewController {

  @FXML
  var email: TextField = _
  @FXML
  var password: PasswordField = _
  @FXML
  var loginButton: Button = _
  @FXML
  var errorMessage: Label = _

  override def didGainVisibility() {
    super.didGainVisibility()
    errorMessage.setText("")
    email.setText("admin@logindemo.com")
  }

  def actionLogin() {
    val user = UserDatabase.find(email.getText, password.getText)
    val authenticated = user.isDefined
    if (authenticated) {
      password.clear()
      applicationController().applicationUser = user
      applicationController().showMain()
    }
    else
      errorMessage.setText("Login Error")
  }

  def applicationController():LoginApplicationController =   {
    getBean[LoginApplicationController]()
  }

}
