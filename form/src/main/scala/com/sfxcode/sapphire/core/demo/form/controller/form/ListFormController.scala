package com.sfxcode.sapphire.core.demo.form.controller.form

import javafx.fxml.FXML
import javafx.scene.control.{ComboBox, ListView}

import com.sfxcode.sapphire.control.FXListCellFactory
import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.demo.form.model.{Friend, PersonDatabase}
import com.sfxcode.sapphire.core.value.FXBean
import com.sfxcode.sapphire.core.Includes._

import scalafx.Includes._
import scalafx.collections.ObservableBuffer


class ListFormController extends AbstractBaseController {

  @FXML
  var comboBox: ComboBox[String] = _

  @FXML
  var listView: ListView[FXBean[Friend]] = _

  val personsMap = PersonDatabase.smallPersonList.map(value=>(value.bean.name, value)).toMap
  val buffer = ObservableBuffer(personsMap.keySet.toList)

  override def didGainVisibilityFirstTime(): Unit = {
    comboBox.getSelectionModel.selectedItemProperty.onChange((_, _, newValue) => comboBoxDidChange(newValue))
    comboBox.setItems(buffer)
    val cellFactory = new FXListCellFactory[FXBean[Friend]]
    cellFactory.setProperty("Name: ${_self.name()} ID: ${_self.id()}")
    listView.setCellFactory(cellFactory)

  }

  def comboBoxDidChange(newValue: String)  {
    println(personsMap(newValue).bean.friends)
    listView.setItems(personsMap(newValue).bean.friends)
  }


}
