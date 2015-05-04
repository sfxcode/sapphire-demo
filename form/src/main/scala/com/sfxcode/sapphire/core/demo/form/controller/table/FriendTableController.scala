package com.sfxcode.sapphire.core.demo.form.controller.table

import com.sfxcode.sapphire.core.demo.form.model.{Friend, PersonDatabase}

import scala.reflect._


class FriendTableController extends AbstractTableViewController {

   type R = Friend

   def ct =  classTag[R]

   def items = PersonDatabase.friends



 }


