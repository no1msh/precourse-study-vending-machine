package vendingmachine.model

import vendingmachine.exceptions.ValidateUserInput

class Quantity(inputtedQuantity: String) {

    private var quantity: Int = 0

    init {
        ValidateUserInput.validateInputOnlyNumber(inputtedQuantity)
        quantity = inputtedQuantity.toInt()
    }

    fun getQuantity() = quantity

    fun purchase() {
        quantity -= 1
    }

    fun canPurchase(): Boolean = quantity >= 1

    companion object {
        private const val PREFIX = "[ERROR] "
    }

}