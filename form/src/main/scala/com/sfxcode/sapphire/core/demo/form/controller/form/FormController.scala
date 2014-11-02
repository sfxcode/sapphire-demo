package com.sfxcode.sapphire.core.demo.form.controller.form

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.layout.Pane

import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.demo.form.model.{Person, PersonDatabase}
import com.sfxcode.sapphire.core.value.{FXBean, FXBeanAdapter, KeyBindings}

import scala.util.Random
import scalafx.Includes._


class FormController extends AbstractBaseController {
  @FXML
  var formPane: Pane = _

  lazy val formAdapter = FXBeanAdapter[Person](this, formPane.asInstanceOf[Node])
  lazy val adapter = FXBeanAdapter[Person](this)

  val random = new Random()

  override def didGainVisibilityFirstTime() {
    super.didGainVisibilityFirstTime()

    val bindings = KeyBindings()
    bindings.add("person", "Person ${_self.name()} with age of ${_self.age()} is active: ${_self.isActive()}")
    adapter.addBindings(bindings)

    val bindingList = List("name", "age", "address", "isActive")
    val formBindings = KeyBindings(bindingList, "form1_")
    formBindings.add(bindingList, "form2_")
    formAdapter.addBindings(formBindings)
    formAdapter.addConverter("form1_age", "IntegerStringConverter")
    formAdapter.addConverter("form2_age", "IntegerStringConverter")
    formAdapter.addConverter("form2_isActive", "BooleanStringConverter")

  }

  override def didGainVisibility() {
    super.didGainVisibility()
    setRandomPerson()
  }

  def actionChangePerson(event:ActionEvent): Unit = {
    setRandomPerson()
  }

  def setRandomPerson(): Unit = {
    val person: FXBean[Person] = PersonDatabase.testPerson(random.nextInt(100))
    formAdapter.set(Some(person))
    adapter.set(Some(person))
  }

}
