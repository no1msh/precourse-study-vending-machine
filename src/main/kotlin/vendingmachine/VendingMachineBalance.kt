package vendingmachine

import camp.nextstep.edu.missionutils.Randoms.pickNumberInList
import java.lang.StringBuilder

class VendingMachineBalance {
    private var balance = mutableMapOf(500 to 0, 100 to 0, 50 to 0, 10 to 0)

    fun putAdminMoney(adminMoney: Int) {
        var money = adminMoney
        val coins = listOf(500,100,50)
        for (coin in coins) {
            var counts = (0..money/coin).toList()
            balance[coin] = pickNumberInList(counts)
            money -= (balance[coin]!!*coin)
        }
        balance[10] = money / 10
    }

    fun getBalance(): StringBuilder {
        val stringBuilder = StringBuilder()
        for (elem in balance) {
            stringBuilder.append(elem.key)
            stringBuilder.append("원 - ")
            stringBuilder.append(elem.value)
            stringBuilder.append("개\n")
        }
        return stringBuilder
    }

}