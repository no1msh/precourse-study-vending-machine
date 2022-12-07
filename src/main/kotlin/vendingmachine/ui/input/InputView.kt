package vendingmachine.ui.input

import vendingmachine.model.Product

class InputView {

    fun readHoldMoney(input: String): Int {
        return 0
    }

    fun readProduct(input:String): List<Product> {
        return listOf(Product("", 0, 0))
    }

    fun readInsertMoney(input: String): Int {
        return 0
    }

    fun readProductName(input: String): String {
        return ""
    }
}