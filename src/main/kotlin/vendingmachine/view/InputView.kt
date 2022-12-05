package vendingmachine.view

import camp.nextstep.edu.missionutils.Console


class InputView {

    fun giveMeCoin(): Int {
        var check = false
        var money = ""
        while (!check) {
            money = Console.readLine()
            check = errorCheckCoin(money)
        }
        return money.toInt()
    }


    private fun errorCheckCoin(money: String): Boolean {
        return try {
            VendingException().isItNumber(money)
            VendingException().isItHaveRemainder(money.toInt())
            true
        } catch (error: IllegalArgumentException) {
            println(error.message)
            false
        }
    }

    fun getItems(): List<List<String>> {
        
    }

}
