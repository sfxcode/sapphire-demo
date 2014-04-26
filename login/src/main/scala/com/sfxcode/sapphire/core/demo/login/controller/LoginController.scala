package com.sfxcode.sapphire.core.demo.login.controller

import com.sfxcode.sapphire.core.controller.ViewController
import scalafx.scene.control._
import scalafx.event.ActionEvent
import com.sfxcode.sapphire.core.demo.login.LoginApplicationController
import scalafxml.core.macros.sfxml
import com.sfxcode.sapphire.core.demo.login.model.UserDatabase
import com.sfxcode.sapphire.core.Includes._

class LoginController extends ViewController {
  def ui = fxml.asInstanceOf[LoginFxml]
  def applicationController() = getBean[LoginApplicationController]()

  override def didGainVisibility() {
    ui.errorMessage.setText("")
    ui.email.setText("admin@logindemo.com")
  }

  def actionLogin(event: ActionEvent) {
    val user = UserDatabase.find(ui.email.getText, ui.password.getText)
    val authenticated = user.isDefined
    if (authenticated) {
      applicationController().applicationUser = user
      applicationController().showMain()
    }
  }
}

@sfxml
class LoginFxml(val email: TextField, val password: PasswordField, val loginButton: Button, val errorMessage: Label, var viewController: LoginController) {

  def actionLogin(event: ActionEvent) {
    viewController.actionLogin(event)
  }
}
