package vendingmachine.model

import camp.nextstep.edu.missionutils.Randoms.pickNumberInList
import kotlin.math.min
import java.lang.StringBuilder

class VendingMachineBalance {
    private val stringBuilder = StringBuilder()
    private val coins = listOf(Coin.COIN_500.amount(), Coin.COIN_100.amount(), Coin.COIN_50.amount())

    private var balance = mutableMapOf(
        Coin.COIN_500.amount() to 0,
        Coin.COIN_100.amount() to 0,
        Coin.COIN_50.amount() to 0,
        Coin.COIN_10.amount() to 0
    )

    fun putAdminMoney(adminMoney: Int) {
        var money = adminMoney
        for (coin in coins) {
            var counts = (0..money / coin).toList()
            balance[coin] = pickNumberInList(counts)
            money -= (balance[coin]!! * coin)
        }
        balance[Coin.COIN_10.amount()] = money / Coin.COIN_10.amount()
    }

    fun getBalance(isResult: Boolean): StringBuilder {
        for (elem in balance) {
            if (isResult && elem.value == 0) {
                continue
            }
            stringBuilder.append(elem.key)
            stringBuilder.append("원 - ")
            stringBuilder.append(elem.value)
            stringBuilder.append("개\n")
        }
        return stringBuilder
    }

    fun updateBalance(buyerMoney: Int) {
        var money = buyerMoney
        for (coin in coins) {
            if (coin >= money) {
                balance[coin] = balance[coin]!! - min(balance[coin]!!, money/coin)
                money -= (balance[coin]!! * coin)
            }
        }
    }
}