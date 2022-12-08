package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.domain.VendingCalculator
import vendingmachine.domain.VendingException


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

    fun getItems(): MutableList<MutableList<String>> {
        while (true) {
            try {
                return getItemNTrim()
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun getItemNTrim(): MutableList<MutableList<String>> {
        var getString = Console.readLine()
        getString = getString.replace("[", "")
        getString = getString.replace("]", "")
        return VendingCalculator().divideString(getString)
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
        return money.toInt()
    }

    fun doShopping(items: List<List<String>>): Pair<Int, Int> {
        while (true) {
            try {
                val buy = Console.readLine()
                val matchingValue = itemMatching(buy, items)
                return Pair(items[matchingValue][1].toInt(), matchingValue)
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    private fun itemMatching(item: String, items: List<List<String>>): Int {
        for (count in items.indices) {
            if (item == items[count][0] && items[count][2].toInt() > 0)
                return count
            if (item == items[count][0] && items[count][2].toInt() == 0)
                throw IllegalArgumentException("[ERROR] 재고가 소진된 상품입니다.")
        }
        throw IllegalArgumentException("[ERROR] 상품 목록에 없는 품목입니다.")
    }
}
