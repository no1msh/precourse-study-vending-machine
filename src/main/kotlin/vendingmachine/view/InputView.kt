package vendingmachine.view

import camp.nextstep.edu.missionutils.Console.readLine
import vendingmachine.Exceptions

class InputView {
    private val exceptions = Exceptions()

    fun getAdminMoney(): Int {
        val input = readLine()
        exceptions.validateAdminInput(input)
        return input.toInt()
    }

}