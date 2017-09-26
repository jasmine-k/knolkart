package services

import models.{Inventory, Item}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class InventoryServices extends InventoryDatabase {

  def searchItem(itemCategory: String): Future[List[Item]] = {
    Future {
      val itemsRequired: List[Item] = listOfItem.filter(_.category == itemCategory)

      if (itemsRequired.isEmpty) {
        throw new NoSuchElementException
      }
      else {
        itemsRequired
      }
    }
  }

  def sortItems(selectionProcess: Option[String], rateOrPrice: Option[String]): Future[List[Item]] = {
    Future {
      rateOrPrice match {
        case Some("rate") =>
          selectionProcess match {
            case Some("low") => listOfItem.sortBy(_.rating)
            case _ => listOfItem.sortBy(_.rating).reverse
          }
        case _ =>
          selectionProcess match {
            case Some("low") => listOfItem.sortBy(_.price)
            case _ => listOfItem.sortBy(_.price).reverse
          }
      }
    }
  }

}
