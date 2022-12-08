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

    fun getItems(): MutableList<MutableList<String>> {
        lateinit var result: MutableList<MutableList<String>>
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

    private fun itemGet(): MutableList<MutableList<String>> {
        var getString = Console.readLine()
        getString = getString.replace("[", "")
        getString = getString.replace("]", "")
        return divideString(getString)
    }

    private fun divideString(getString: String): MutableList<MutableList<String>> {
        val result = mutableListOf<MutableList<String>>()
        val middle = getString.split(";")
        for (count in middle) {
            result.add(count.split(",").toMutableList())
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

    fun doShopping(items: List<List<String>>): Pair<Int, Int> {
        var buy = ""
        while (true) {
            try {
                buy = Console.readLine()
                val MatchingValue = itemMatching(buy, items)
                return Pair(items[MatchingValue][1].toInt(), MatchingValue)
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
