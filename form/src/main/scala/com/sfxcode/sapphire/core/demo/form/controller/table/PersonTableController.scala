package com.sfxcode.sapphire.core.demo.form.controller.table

import javafx.collections.ObservableList

import com.sfxcode.sapphire.control.table.FXTableViewController
import com.sfxcode.sapphire.core.demo.form.model.{Person, PersonDatabase}
import com.sfxcode.sapphire.core.value.FXBean

import scala.reflect._
import scalafx.collections.ObservableBuffer


class PersonTableController extends AbstractTableViewController {

  type R = Person

  def ct =  classTag[R]

  def records: ObservableList[FXBean[R]] =  ObservableBuffer(PersonDatabase.testPersonen)

  def initTable(tableController: FXTableViewController[R]): Unit = {
    tableController.hideColumn("tags")
    tableController.hideColumn("friends")
    tableController.hideColumn("about")
    tableController.addSearchBox("genderFilter", "gender", "all")
  }

}


