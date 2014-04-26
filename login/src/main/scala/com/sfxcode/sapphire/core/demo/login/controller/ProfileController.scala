package com.sfxcode.sapphire.core.demo.login.controller

import com.sfxcode.sapphire.core.controller.ViewController
import scalafx.event.ActionEvent
import com.sfxcode.sapphire.core.demo.login.LoginApplicationController
import com.sfxcode.sapphire.core.value._
import com.sfxcode.sapphire.core.demo.login.model.User
import scalafxml.core.macros.sfxml

class ProfileController extends ViewController {

  lazy val userAdapter = FXBeanAdapter[User](this)

  override def didGainVisibility() {
    val bindings = KeyBindings("email", "phone", "address", "subscribed")
    bindings.add("user", "User: ${_self.name()} Mailsize: (${_self.email().length()})")
    userAdapter.addBindings(bindings)
    userAdapter.set(applicationController().applicationUser)
    println(this)
  }


  def actionLogout(event: ActionEvent) {
    userAdapter.set()
    applicationController().applicationUser = None
    applicationController() showLogin()
  }

  def applicationController(): LoginApplicationController = {
    getBean[LoginApplicationController]()
  }

  def debugUserData() {
    println(locateTextField("user"))
    println(applicationController().applicationUser.get.bean)
  }
}

@sfxml
class ProfileFxml(var viewController: ProfileController) {

  def actionLogout(event: ActionEvent) {
    viewController.actionLogout(event)
  }

  def actionUpdate(event: ActionEvent) {
    viewController.debugUserData()
  }

}
