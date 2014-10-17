package com.sfxcode.sapphire.core.demo.form.controller.table

import javafx.collections.ObservableList

import com.sfxcode.sapphire.control.table.FXTableViewController
import com.sfxcode.sapphire.core.demo.form.model.{Friend, PersonDatabase}
import com.sfxcode.sapphire.core.value.FXBean

import scala.reflect._
import scalafx.collections.ObservableBuffer


class FriendTableController extends AbstractTableViewController {

   type R = Friend

   def ct =  classTag[R]

   def records: ObservableList[FXBean[R]] =  ObservableBuffer(PersonDatabase.friendList)

   def initTable(tableController: FXTableViewController[R]): Unit = {

   }

 }


