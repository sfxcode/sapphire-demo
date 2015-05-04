package com.sfxcode.sapphire.core.demo.form.controller.table

import com.sfxcode.sapphire.core.demo.form.controller.MainWindowController
import com.sfxcode.sapphire.extension.controller.DataTableController
import com.sfxcode.sapphire.extension.filter.DataTableFilter
import com.typesafe.scalalogging.LazyLogging

abstract class AbstractTableViewController extends DataTableController with LazyLogging {


  override def initTable(tableFilter: DataTableFilter[R]): Unit = {
    super.initTable(tableFilter)
    tableFilter.hideColumn("metaData")
    tableFilter.addSearchField("nameFilter", "name").setPromptText("Name")
  }

  override def didGainVisibility() {
    mainWindowController.statusBar.setText("%d records loaded".format(items.value.size))
  }

  def mainWindowController: MainWindowController = {
    parent.asInstanceOf[MainWindowController]
  }

  def workspaceManager = mainWindowController.workspaceManager


}

