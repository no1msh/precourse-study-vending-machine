package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.exceptions.ValidateUserInput

object InputView {
    fun inputVendingMachineMoney() : String{
        val money = Console.readLine()
        try {
            ValidateUserInput.validateInputMoney(money)
        } catch (e : IllegalArgumentException){
            println(e.message)
            return inputVendingMachineMoney()
        }
        return money
    }
}