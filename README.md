sapphire-demo
=============

sapphire demo applications.

based on [sapphire-core](http://sfxcode.github.io/sapphire-core/) 1.0.0.

## Demos

### Notes

If you start the demos from sbt with run,

the resource com/sun/javafx/scene/control/skin/modena/modena.css can not be found.

Workaround sbt setting:

unmanagedJars in Compile += Attributed.blank(file(System.getenv("JAVA_HOME") + "/jre/lib/ext/jfxrt.jar"))


All demos are tested with IntelliJ Idea.
               
### Login Demo

JavaFX Login Demo pimped by Sapphire.

### Issues Demo

JavaFX Issues Demo pimped by Sapphire.

FXML support by scalafxml.

[https://github.com/vigoo/scalafxml/] (https://github.com/vigoo/scalafxml)

compile from IntelliJ IDEA, because of sbt console compile problems

### Blueprint

Blueprint Application for initial usage.

