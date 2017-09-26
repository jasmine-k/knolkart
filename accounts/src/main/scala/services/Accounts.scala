package services

import java.util.Calendar
import java.util.logging.Logger

import models.User

import scala.collection.mutable
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt

import scala.concurrent.ExecutionContext.Implicits.global

class Accounts extends Database {

  def addUser(firstName: String, lastName: String, mobileNo: Long, userName: String, password: String, confirmPassword: String): Future[Boolean] = {
    Future {
      if (password == confirmPassword) {
        user += (mobileNo -> User(firstName, lastName, mobileNo, userName, password))
        true
      }
      else {
        false
      }
    }
  }

  def authenticate(userName: String, password: String): Future[(String, Boolean)] = {
    Future {
      val userDetailsResult = user.filter((userDetails) => userDetails._2.userName == userName && userDetails._2.password == password)
      if (userDetailsResult.isEmpty) {
        ("Invalid details..Login failed", false)
      }
      else {
      //  (BCrypt.hashpw(userDetailsResult.head._1.toString, BCrypt.gensalt()), true)
        val now = Calendar.getInstance()
        (BCrypt.hashpw(now.get(Calendar.MINUTE).toString,BCrypt.gensalt()),true)
      }

    }
  }

}
