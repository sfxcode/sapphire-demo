package com.sfxcode.sapphire.core.demo.form.controller.form

import javafx.fxml.FXML
import javafx.scene.control.{ComboBox, ListView}

import com.sfxcode.sapphire.extension.FXListCellFactory
import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.demo.form.model.{Friend, PersonDatabase}
import com.sfxcode.sapphire.core.value.FXBean
import com.sfxcode.sapphire.core.Includes._
import com.typesafe.scalalogging.LazyLogging

import scalafx.Includes._
import scalafx.collections.ObservableBuffer


class ListFormController extends AbstractBaseController with LazyLogging {

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
    comboBox.getSelectionModel.selectFirst()

  }


  override def willGainVisibility(): Unit = {
    super.willGainVisibility()
    comboBox.getSelectionModel.selectFirst()
  }

  def comboBoxDidChange(newValue: String)  {
    logger.debug(personsMap(newValue).bean.friends.toString())
    listView.setItems(personsMap(newValue).bean.friends)
  }


}
