package vendingmachine.domain

import vendingmachine.model.Product
import kotlin.math.max
import kotlin.math.min

class SellingProduct(private val products: List<Product>) {

    fun find(name: String): Product? {
        for (product in products) {
            if (product.getName() == name) {
                return product
            }
        }
        return null
    }

    fun getMinimumPrice(): Int {
        var minimum = getMaxPrice()
        for (product in products) {
            minimum = min(minimum, product.getPrice())
        }
        return minimum
    }

    private fun getMaxPrice(): Int {
        var maximum = 0
        for (product in products) {
            maximum = max(maximum, product.getPrice())
        }
        return maximum
    }
}