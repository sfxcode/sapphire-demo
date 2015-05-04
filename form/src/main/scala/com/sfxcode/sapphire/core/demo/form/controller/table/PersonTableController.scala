package com.sfxcode.sapphire.core.demo.form.controller.table

import com.sfxcode.sapphire.core.demo.form.model.{Person, PersonDatabase}
import com.sfxcode.sapphire.extension.filter.DataTableFilter

import scala.reflect._


class PersonTableController extends AbstractTableViewController {

  type R = Person

  def ct =  classTag[R]

  def items =  PersonDatabase.persons

  override def initTable(tableFilter: DataTableFilter[R]): Unit = {
    super.initTable(tableFilter)
    tableFilter.hideColumn("tags", "friends","about","guid","picture")

    tableFilter.addSearchField("addressFilter", "address").setPromptText("Address")
    tableFilter.addSearchBox("genderFilter", "gender", "male/female")
    tableFilter.addSearchBox("fruitFilter", "favoriteFruit", "all fruits")
  }



}


