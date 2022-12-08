package vendingmachine.domain

import vendingmachine.view.View

class VendingCalculator {

    fun divideString(getString: String): MutableList<MutableList<String>> {
        val result = mutableListOf<MutableList<String>>()
        val middle = getString.split(";")
        for (count in middle) {
            result.add(count.split(",").toMutableList())
            VendingException().itemException(result.last())
        }
        VendingException().checkOverLap(result)
        return result
    }

    fun getMinValue(items: List<List<String>>): Int {
        var minvalue = items[0][1].toInt()
        for (count in items.indices) {
            if (minvalue > items[count][1].toInt())
                minvalue = items[count][1].toInt()
        }
        return minvalue
    }

    fun changesCount(count: Int): String {
        var string = " - "
        string += count
        return string + "개"
    }

    fun canIBuy(money: Int, price: Int): Boolean {
        if (price > money) {
            View().canNotBuy()
            return false
        }
        return true
    }

    fun changes(coins: List<Int>): String {
        val str = StringBuilder()
        if (coins[0] != 0)
            str.appendLine("500원 - ${coins[0]}개")
        if (coins[1] != 0)
            str.appendLine("100원 - ${coins[1]}개")
        if (coins[2] != 0)
            str.appendLine("50원 - ${coins[2]}개")
        if (coins[3] != 0)
            str.appendLine("10원 - ${coins[3]}개")
        return str.toString()
    }

}