package services

import models.User

import scala.collection.mutable
import scala.collection.mutable.Map

trait Database {

  val user = Map(
    9898989810L -> User("jas", "kaur", 9898989810L, "jas", "jasmine"),
    9898989811L -> User("jas", "kaur", 9898989811L, "jas", "jasmine"),
    9898989812L -> User("jas", "kaur", 9898989812L, "jas", "jasmine")
  )

}
