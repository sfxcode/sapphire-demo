package com.sfxcode.sapphire.core.demo.issues.controller

import com.sfxcode.sapphire.core.controller.ViewController
import scalafx.event.ActionEvent
import com.sfxcode.sapphire.core.demo.issues.model.{Issue, IssueDataBase}
import scalafx.scene.control._
import scalafx.collections._
import scalafx.Includes._
import scalafx.scene.control.SelectionMode
import com.sfxcode.sapphire.core.value._
import scalafx.scene.layout.AnchorPane
import scalafxml.core.macros.sfxml

class IssueTrackingLiteController extends ViewController {
  def ui = fxml.asInstanceOf[IssueTrackingLiteFxml]

  lazy val issueAdapter = FXBeanAdapter[Issue](this, ui.detailPane)

  val displayedProjectNames = new ObservableBuffer[String]()
  val displayedIssues = new ObservableBuffer[String]()


  override def didGainVisibility() {
    super.didGainVisibility()
    issueAdapter.addBindings(KeyBindings("synopsis", "description"))
    issueAdapter.addBinding(ui.saveButton.visibleProperty(), "_hasChanges")

    // issueAdapter.parent = detailPane
    displayedProjectNames.++=(IssueDataBase.projectNames.sortBy(name => name))
    ui.list.setItems(displayedProjectNames)
  }

}

@sfxml
class IssueTrackingLiteFxml(val list: ListView[String], val table: TableView[FXBean[Issue]], val detailPane: AnchorPane, var deleteButton: Button, var saveButton: Button, viewController: IssueTrackingLiteController) {

  detailPane.setVisible(false)
  deleteButton.setVisible(false)
  saveButton.setVisible(false)

  list.getSelectionModel.setSelectionMode(SelectionMode.SINGLE)
  list.getSelectionModel.selectedItemProperty.onChange((_, oldValue, newValue) => updateProject(oldValue, newValue))
  table.getSelectionModel.selectedItemProperty.onChange((_, _, newValue) => selectIssue(newValue))

  def issueAdapter = viewController.issueAdapter

  def actionCreateIssue(event: ActionEvent) {
    val projectName = list.getSelectionModel.selectedItem.value
    val newIssue = IssueDataBase.createIssue(projectName, "New Issue")
    updateProject(projectName, projectName)
    selectIssue(newIssue)
  }

  def actionDeleteIssue(event: ActionEvent) {
    val projectName = list.getSelectionModel.selectedItem.value
    IssueDataBase.deleteIssue(issueAdapter.getBean.get.id)
    updateProject(projectName, projectName)
  }

  def actionSaveIssue(event: ActionEvent) {
    issueAdapter.clearChanges()
  }

  def selectIssue(issue: FXBean[Issue]) {
    issue match {
      case issue: FXBean[Issue] =>
        issueAdapter.revert()
        issueAdapter.set(Some(issue))
        detailPane.setVisible(true)
        deleteButton.setVisible(true)
      case _ =>
        issueAdapter.set()
        detailPane.setVisible(false)
        deleteButton.setVisible(false)
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
        newItems.foreach(item => table.getItems.add(item))
    }
  }

  def projectUnselected(projectName: String) {
    table.getItems.clear()
  }


}

