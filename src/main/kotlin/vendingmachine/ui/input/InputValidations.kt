package vendingmachine.ui.input

import vendingmachine.model.Product

enum class ErrorMessages(private val message: String) {
    PREFIX("[ERROR]"),
    DIGIT_EXCEPTION("숫자가 아닙니다."),
    LETTER_EXCEPTION("글자가 아닙니다."),
    REMAINDER_EXCEPTION("10원 단위로 입력해야 합니다.");

    override fun toString(): String = "${PREFIX.message} $message"
}

class InputValidations {
    fun checkDigit(input: String) {
        require(input.all { it.isDigit() }) { ErrorMessages.DIGIT_EXCEPTION.toString() }
    }

    fun checkRemainder(input: String) {
        require(input.toInt() % 10 == 0) { ErrorMessages.REMAINDER_EXCEPTION.toString() }
    }

    fun checkLetter(input: String) {
        require(input.all { it.isLetter() }) { ErrorMessages.LETTER_EXCEPTION.toString() }
    }

    fun checkFormat(input: String): List<Product> {
        val slicedInput = input.split(";")
        val products: MutableList<Product> = mutableListOf()
        for (product in slicedInput) {
            val slicedProduct = product.substring(1, product.length - 1).split(",")
            products.add(Product(slicedProduct[0], slicedProduct[1], slicedProduct[2]))
        }
        return products
    }
}