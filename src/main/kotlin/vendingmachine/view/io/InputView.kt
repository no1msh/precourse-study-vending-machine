package vendingmachine.view.io

import camp.nextstep.edu.missionutils.Console
import vendingmachine.model.data.product.Product
import vendingmachine.model.data.product.ProductInfo
import vendingmachine.util.flattenMap
import vendingmachine.view.strings.ErrorMessage

class InputView {

    fun readVendingMachineMoney(): Int {
        val money = Console.readLine().toIntOrNull()

        require(money != null) { ErrorMessage.INVALID_NUMBER_FORMAT }
        require(money in MONEY_MIN..MONEY_MAX) { ErrorMessage.INVALID_PRICE_RANGE }

        return money
    }

    fun readVendingMachineProducts(): List<Product> {
        return Console.readLine()
            .split(PRODUCT_DELIMITERS)
            .map(::trimBracket)
            .map(::splitProductInfo)
            .flattenMap(::toProduct)
    }

    private fun trimBracket(str: String): String {
        return str.trim(BRACKET_LEFT, BRACKET_RIGHT)
    }

    private fun splitProductInfo(str: String): List<String> {
        return str.split(PRODUCT_INFO_DELIMITERS)
    }

    private fun toProduct(str: List<String>): Product {
        require(str.size == 3) { ErrorMessage.INVALID_PRODUCT_INFO }
        require(str[0].isNotBlank()) { ErrorMessage.INVALID_PRODUCT_INFO }

        val productInfo = ProductInfo(
            name = str[0],
            price = requireNotNull(str[1].toIntOrNull()) { ErrorMessage.INVALID_PRODUCT_INFO }
        )
        val stock = requireNotNull(str[2].toIntOrNull()) { ErrorMessage.INVALID_PRODUCT_INFO }

        return Product(productInfo, stock)
    }

    fun readInputCost(): Int {
        val cost = Console.readLine().toIntOrNull()

        require(cost != null) { ErrorMessage.INVALID_NUMBER_FORMAT }
        require(cost in MONEY_MIN..MONEY_MAX) { ErrorMessage.INVALID_PRICE_RANGE }

        return cost
    }

    fun readPurchaseProduct(): String {
        return Console.readLine()
    }

    companion object {
        const val MONEY_MIN = 0
        const val MONEY_MAX = Int.MAX_VALUE
        const val PRODUCT_DELIMITERS = ";"
        const val PRODUCT_INFO_DELIMITERS = ","
        const val BRACKET_LEFT = '['
        const val BRACKET_RIGHT = ']'
    }
}