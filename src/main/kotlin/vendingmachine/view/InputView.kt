package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.exceptions.ValidateUserInput

object InputView {
    fun inputVendingMachineMoney(): String {
        val money = Console.readLine().trim()
        try {
            ValidateUserInput.validateInputOnlyNumber(money)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputVendingMachineMoney()
        }
        return money
    }

    fun inputVendingMachineProduct(): String {
        val product = Console.readLine().trim()
        try {
            ValidateUserInput.validateInputProductForm(product)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputVendingMachineProduct()
        }
        return product
    }

    fun inputUserInputMoney(): String {
        val userInputMoney = Console.readLine().trim()
        try {
            ValidateUserInput.validateInputOnlyNumber(userInputMoney)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return inputUserInputMoney()
        }
        return userInputMoney
    }

    fun inputUserInputProductToBuy(): String {
        return Console.readLine().trim()
    }
}