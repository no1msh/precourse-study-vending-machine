package vendingmachine.ui.input

import camp.nextstep.edu.missionutils.Console
import vendingmachine.model.Product

class InputView {

    private val inputValidations = InputValidations()

    fun readHoldMoney(input: String): Int {
        inputValidations.checkDigit(input)
        inputValidations.checkRemainder(input)
        return input.toInt()
    }

    fun readProduct(input: String): List<Product> = inputValidations.checkFormat(input)

    fun readInsertMoney(input: String): Int {
        inputValidations.checkDigit(input)
        inputValidations.checkRemainder(input)
        return input.toInt()
    }

    fun readProductName(input: String): String {
        inputValidations.checkLetter(input)
        return input
    }

    fun getInput(): String = Console.readLine()
}