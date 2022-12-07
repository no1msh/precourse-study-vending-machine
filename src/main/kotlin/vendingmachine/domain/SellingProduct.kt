package vendingmachine.domain

import vendingmachine.model.Product

class SellingProduct(private val products: List<Product>) {

    fun find(name: String): Boolean {
        return true
    }

    fun amount(name: String): Boolean {
        return true
    }

    fun enable(money: Int): Boolean {
        return true
    }
}