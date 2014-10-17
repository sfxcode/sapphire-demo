package com.sfxcode.sapphire.core.demo.form.controller.table

import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.scene.control.TableView
import javafx.scene.layout.HBox

import com.sfxcode.sapphire.control.table.FXTableViewController
import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.value.FXBean
import com.typesafe.scalalogging.LazyLogging

import scala.reflect.ClassTag
import scalafx.Includes._

abstract class AbstractTableViewController extends AbstractBaseController with LazyLogging{

  type R<:AnyRef

  def ct:ClassTag[R]

  @FXML
  var table: TableView[FXBean[R]] = _

  @FXML
  var searchBox: HBox = _

  var tableController:FXTableViewController[R] = _

  def records: ObservableList[FXBean[R]]

  override def didGainVisibilityFirstTime() {
    super.didGainVisibilityFirstTime()
    tableController = FXTableViewController[R](table, records, searchBox)(ct)
    // add default search Field
    tableController.addColumns()
    tableController.hideColumn("metaData")
    tableController.addSearchField("nameFilter", "name").setPromptText("Name")
    initTable(tableController)
    tableController.selectedItem.onChange((_, oldValue, newValue) => selectedTableViewItemDidChange(oldValue, newValue))

  }

  override def didGainVisibility() {
    mainWindowController.statusBar.setText("%d Daten wurden geladen".format(tableController.values.size))
  }

  def initTable(tableController:FXTableViewController[R])

  def selectedTableViewItemDidChange(oldValue:FXBean[R], newValue:FXBean[R]): Unit = {
    logger.info("new value: %s".format(newValue.bean))
  }



}

