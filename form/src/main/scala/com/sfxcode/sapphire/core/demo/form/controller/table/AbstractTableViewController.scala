package com.sfxcode.sapphire.core.demo.form.controller.table

import com.sfxcode.sapphire.extension.controller.TableViewController
import com.sfxcode.sapphire.extension.table.FXTableViewController
import com.sfxcode.sapphire.core.demo.form.controller.MainWindowController
import com.typesafe.scalalogging.LazyLogging

abstract class AbstractTableViewController extends TableViewController with LazyLogging {

  override def initTable(tableController: FXTableViewController[R]): Unit = {
    tableController.hideColumn("metaData")
    tableController.addSearchField("nameFilter", "name").setPromptText("Name")

  }

  override def didGainVisibility() {
    mainWindowController.statusBar.setText("%d records loaded".format(tableController.values.size))
  }

  def mainWindowController: MainWindowController = {
    parent.asInstanceOf[MainWindowController]
  }

  def workspaceManager = mainWindowController.workspaceManager


}

