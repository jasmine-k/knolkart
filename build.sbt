
lazy val commonSettings = Seq(
  version := "1.0" ,
  scalaVersion := "2.12.3",
  scapegoatVersion := "1.3.0",
  libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.mindrot" % "jbcrypt" % "0.4")
)

lazy val accounts = project.
  settings(commonSettings)

lazy val apiResource = project.
  dependsOn(accounts,checkout,inventory,notification).
  aggregate(accounts,checkout,inventory,notification).
  settings( commonSettings).
  enablePlugins(CopyPasteDetector)

lazy val checkout = project.
  settings( commonSettings).
  enablePlugins(CopyPasteDetector)

lazy val dashboard = project.
  dependsOn(apiResource).
  aggregate(apiResource).
  settings( commonSettings).
  enablePlugins(CopyPasteDetector)

lazy val inventory = project.
  settings( commonSettings).
  enablePlugins(CopyPasteDetector)

lazy val notification = project.
  settings( commonSettings).
  enablePlugins(CopyPasteDetector)

lazy val root = (project in file(".")).
  aggregate(accounts, apiResource, checkout, dashboard, inventory, notification).
  settings(commonSettings).
  enablePlugins(CopyPasteDetector)