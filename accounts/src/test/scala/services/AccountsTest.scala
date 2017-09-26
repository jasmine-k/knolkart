
package services

import org.scalatest.AsyncFunSuite

class AccountsTest extends AsyncFunSuite with Database {

  val accounts = new Accounts
  test("addUser with valid details") {
    accounts.addUser("jas", "kaur", 9898989810L, "jas", "jasmine", "jasmine").map(result => assert(result === true))

  }

  test("addUser with invalid details") {
    accounts.addUser("jas", "kaur", 9898989810L, "jas", "jasmine", "jasminee").map(result => assert(result === false))

  }

  test("authenticate user with valid details") {
    accounts.authenticate("jas", "jasmine").map(result => assert(result._2 === true))

  }

  test("authenticate user with invalid details") {
    accounts.authenticate("jas", "jasminee").map(result => assert(result._2 === false))

  }

}
