import sbt._
object Dependencies {


  val commonDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.mindrot" % "jbcrypt" % "0.4"

  )

}