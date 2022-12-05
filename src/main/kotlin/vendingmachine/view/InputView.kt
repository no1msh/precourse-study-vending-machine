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
        lateinit var result: List<List<String>>
        while (true) {
            try {
                result = itemGet()
                break
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
        return result
    }

    private fun itemGet(): List<List<String>> {
        var getString = Console.readLine()
        getString = getString.replace("[", "")
        getString = getString.replace("]", "")
        return divideString(getString)
    }

    private fun divideString(getString: String): List<List<String>> {
        val result = mutableListOf<List<String>>()
        val middle = getString.split(";")
        for (count in middle) {
            result.add(count.split(","))
            VendingException().itemException(result.last())
        }
        VendingException().checkOverLap(result)
        return result
    }

    fun getMyMoney(): Int {
        while (true) {
            try {
                val money = Console.readLine()
                return moneyErrorCheck(money)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun moneyErrorCheck(money: String): Int {
        VendingException().isItNumber(money)

        //그 외의 예외처리가 필요한가???

        return money.toInt()
    }
}
