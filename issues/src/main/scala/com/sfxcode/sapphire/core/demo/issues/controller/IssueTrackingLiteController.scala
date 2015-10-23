package com.sfxcode.sapphire.core.demo.issues.controller

import javax.inject.Inject

import com.sfxcode.sapphire.core.cdi.BeanResolver
import com.sfxcode.sapphire.core.controller.ViewController
import com.sfxcode.sapphire.core.demo.issues.EmptyName
import com.sfxcode.sapphire.core.demo.issues.model.{Issue, IssueDataBase}
import com.sfxcode.sapphire.core.value._
import com.typesafe.scalalogging.LazyLogging

import scalafx.Includes._
import scalafx.collections._
import scalafx.event.ActionEvent
import scalafx.scene.control.{SelectionMode, _}
import scalafx.scene.layout.AnchorPane
import scalafxml.core.macros.sfxml

class IssueTrackingLiteController extends ViewController with LazyLogging {
  def ui = fxml.asInstanceOf[IssueTrackingLiteFxml]

  @Inject
  var emptyName:EmptyName = _

  lazy val issueAdapter = FXBeanAdapter[Issue](this, ui.detailPane)

  val displayedProjectNames = new ObservableBuffer[String]()
  val displayedIssues = new ObservableBuffer[String]()



  override def didGainVisibility() {
    super.didGainVisibility()
    logger.debug(applicationEnvironment.controllerMap.toString())
    issueAdapter.addBindings(KeyBindings("synopsis", "description"))
    issueAdapter.addBinding(ui.saveButton.visibleProperty(), "_hasChanges")

    // issueAdapter.parent = detailPane
    displayedProjectNames.++=(IssueDataBase.projectNames.sortBy(name => name))
    ui.list.setItems(displayedProjectNames)

    ui.detailPane.visibleProperty.bind(issueAdapter.hasBeanProperty)
    ui.deleteButton.visibleProperty.bind(issueAdapter.hasBeanProperty)
  }

  def selectedProjectName:Option[String] = {
    val selected = ui.list.getSelectionModel.selectedItem
    if (selected.value == null)
      return None
    Some(selected.value)
  }

  def actionCreateIssue() {
    selectedProjectName.foreach(projectName => {
      val newIssue = IssueDataBase.createIssue(projectName, emptyName.name)
      updateProject(projectName, projectName)
      selectIssue(newIssue)
    })
  }

  def actionDeleteIssue(event: ActionEvent) {
    selectedProjectName.foreach(projectName => {
      IssueDataBase.deleteIssue(issueAdapter.beanProperty.value.bean.id)
      updateProject(projectName, projectName)
    })
  }

  def actionSaveIssue(event: ActionEvent) {
    issueAdapter.clearChanges()
  }

  def selectIssue(issue: FXBean[Issue]) {
    issue match {
      case issue: FXBean[Issue] =>
        issueAdapter.revert()
        issueAdapter.beanProperty.value = issue
      case _ =>
        issueAdapter.unset()
    }
  }

  def updateProject(oldValue: String, newValue: String) {
    projectUnselected(oldValue)
    projectSelected(newValue)
  }

  def projectSelected(projectName: String) {
    projectName match {
      case name: String =>
        val newItems = IssueDataBase.projectsMap(projectName)
        newItems.foreach(item => ui.table.getItems.add(item))
    }
  }

  def projectUnselected(projectName: String) {
    ui.table.getItems.clear()
  }


}


@sfxml
class IssueTrackingLiteFxml(val list: ListView[String], val table: TableView[FXBean[Issue]], val detailPane: AnchorPane, var deleteButton: Button, var saveButton: Button, var viewController: IssueTrackingLiteController) extends BeanResolver {

  detailPane.setVisible(false)
  deleteButton.setVisible(false)
  saveButton.setVisible(false)

  list.getSelectionModel.setSelectionMode(SelectionMode.SINGLE)
  list.getSelectionModel.selectedItemProperty.onChange((_, oldValue, newValue) => viewController.updateProject(oldValue, newValue))
  table.getSelectionModel.selectedItemProperty.onChange((_, _, newValue) => viewController.selectIssue(newValue))


  def actionCreateIssue() {
    viewController.actionCreateIssue()
  }

  def actionDeleteIssue(event: ActionEvent) {
    viewController.actionDeleteIssue(event)
  }

  def actionSaveIssue(event: ActionEvent) {
    viewController.actionSaveIssue(event)
  }

}

