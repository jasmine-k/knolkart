package services

import org.scalatest.AsyncFunSuite

class InventoryServicesTest extends AsyncFunSuite with InventoryDatabase {

  val inventory = new InventoryServices
  test("Search item with valid search") {
    inventory.searchItem("cat1").map(result => assert(result === List(item1)))

  }

  test("Search item with invalid search") {
    recoverToSucceededIf[java.util.NoSuchElementException] {
      inventory.searchItem("cat90")

    }
  }


  test("sort item high to low by price") {
    inventory.sortItems(Some("high"), Some("price")).map(result => assert(result === List(item1, item2)))

  }

  test("sort item low to high by price") {
    inventory.sortItems(Some("low"), Some("price")).map(result => assert(result === List(item2, item1)))

  }

  test("sort item high to low by rating") {
    inventory.sortItems(Some("high"), Some("rate")).map(result => assert(result === List(item2, item1)))

  }

  test("sort item low to high by rating") {
    inventory.sortItems(Some("low"), Some("rate")).map(result => assert(result === List(item1, item2)))

  }

  test("sort item by rating where process selection is default") {
    inventory.sortItems(None, Some("rate")).map(result => assert(result === List(item2, item1)))

  }

  test("sort item price where process selection is default") {
    inventory.sortItems(None, Some("price")).map(result => assert(result === List(item1, item2)))

  }

  test("sort item price high to low where selection choice is default") {
    inventory.sortItems(Some("high"), None).map(result => assert(result === List(item1, item2)))

  }

  test("sort item low to high where selection choice is default") {
    inventory.sortItems(Some("low"), None).map(result => assert(result === List(item2, item1)))

  }

  test("sort item where selection choice and process is default") {
    inventory.sortItems(None, None).map(result => assert(result === List(item1, item2)))

  }

}
