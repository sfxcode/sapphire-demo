package com.sfxcode.sapphire.core.demo.form.controller

import com.sfxcode.sapphire.core.controller.ViewController


class AbstractBaseController extends ViewController {

  def mainWindowController:MainWindowController = {
    parent.asInstanceOf[MainWindowController]
  }

  def workspaceManager = mainWindowController.workspaceManager

}
