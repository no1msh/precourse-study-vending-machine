package vendingmachine.model

import vendingmachine.exceptions.ValidateUserInput

class Quantity(private val quantity: String) {
    init {
        ValidateUserInput.validateInputOnlyNumber(quantity)
    }

    fun getQuantity() = quantity.toInt()

    companion object {
        private const val PREFIX = "[ERROR] "
    }

}