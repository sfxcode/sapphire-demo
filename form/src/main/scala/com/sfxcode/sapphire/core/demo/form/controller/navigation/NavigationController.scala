package com.sfxcode.sapphire.core.demo.form.controller.navigation

import javafx.event.ActionEvent

import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.demo.form.controller.form.{PropertiesFormController, ListFormController, FormController}
import com.sfxcode.sapphire.core.demo.form.controller.table.{FriendTableController, PersonTableController}


class DefaultNavigationController extends AbstractBaseController {
  lazy val formController = getController[FormController]()
  lazy val listFormController = getController[ListFormController]()
  lazy val propertiesFormController = getController[PropertiesFormController]()


  def actionShowForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(formController)
  }
  def actionShowListForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(listFormController)
  }
  def actionShowPropertiesForm(event: ActionEvent) {
    workspaceManager.updatePaneContent(propertiesFormController)
  }



}

class TableNavigationController extends AbstractBaseController {
  lazy val personTableController = getController[PersonTableController]()
  lazy val friendTableController = getController[FriendTableController]()


  def actionShowPersonTable(event: ActionEvent) {
    workspaceManager.updatePaneContent(personTableController)
  }

  def actionShowFriendTable(event: ActionEvent) {
    workspaceManager.updatePaneContent(friendTableController)
  }
}

