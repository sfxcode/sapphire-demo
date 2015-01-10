package com.sfxcode.sapphire.core.demo.form.controller.form

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.layout.AnchorPane

import com.sfxcode.sapphire.control.properties.BeanItem
import com.sfxcode.sapphire.core.demo.form.controller.AbstractBaseController
import com.sfxcode.sapphire.core.demo.form.model.{Person, PersonDatabase}
import com.sfxcode.sapphire.core.value.{KeyBindings, FXBeanAdapter, FXBean}
import org.controlsfx.control.PropertySheet
import org.controlsfx.control.PropertySheet.Item

import scala.util.Random
import scalafx.collections.ObservableBuffer


class PropertiesFormController extends AbstractBaseController {

  @FXML
  var propPane: AnchorPane = _

  val random = new Random()
  val propertySheet = new PropertySheet()

  lazy val adapter = FXBeanAdapter[Person](this)


  override def didGainVisibilityFirstTime() {
    super.didGainVisibilityFirstTime()
    propPane.getChildren.add(propertySheet)

    val bindings = KeyBindings()
    bindings.add("person", "Person ${_self.name()} with age of ${_self.age()} is active: ${_self.isActive()}")
    adapter.addBindings(bindings)

    setRandomPerson()

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
    adapter.set(Some(person))

    val items = new ObservableBuffer[Item]()
    items.add(BeanItem(person, "name", "Basic", "Name"))
    items.add(BeanItem(person, "age", "Basic", "Age"))
    items.add(BeanItem(person, "isActive", "Extended", "Active"))
    items.add(BeanItem(person, "registered", "Extended", "Registered"))

    propertySheet.getItems.setAll(items)

  }

}
