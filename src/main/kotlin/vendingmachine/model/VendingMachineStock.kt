package vendingmachine.model

import java.util.Collections

class VendingMachineStock {
    private var stock = mutableMapOf<String, Int>()
    private var price = mutableMapOf<String, Int>()
    private var stockCount = 0
    private var minPrice = 0

    fun putAdminGoods(goods: MutableList<List<String>>) {
        for (elem in goods) {
            price[elem[0]] = elem[1].toInt()
            stock[elem[0]] = elem[2].toInt()
        }
        stock.values.forEach {stockCount += it }
        minPrice = Collections.min(price.values)
    }

    fun isInStock(item: String): Boolean {
        if (item in stock.keys) {
            return true
        }
        return false
    }

    fun updateVendingMachine(item: String, buyerMoney: Int): Int {
        if (stock[item] == 0) {
            return -1
        }
        if (price[item]!! > buyerMoney) {
            return -1
        }
        stock[item] = stock[item]!! - 1
        stockCount -= 1
        return price[item]!!
    }

    fun getStockCount(): Int = stockCount
    fun getMinPrice(): Int = minPrice
}