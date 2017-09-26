package services

import models.{Item, Vendor}
import scala.concurrent.ExecutionContext.Implicits.global

trait InventoryDatabase {

  val item1 = Item(1, "item1", "cat1", 2, Vendor(1, "vendor1"), 20)
  val item2 = Item(2, "item2", "cat2", 4, Vendor(1, "vendor1"), 10)
  val listOfItem = List(item1, item2)

}
