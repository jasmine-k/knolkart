package models

case class Item(id: Long, name: String, category: String, rating: Int,
                vendorInformation: Vendor, price: Double)
