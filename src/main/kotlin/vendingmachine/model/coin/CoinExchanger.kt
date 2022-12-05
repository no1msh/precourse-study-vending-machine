package vendingmachine.model.coin

import vendingmachine.model.random.RandomGenerator
import java.util.*

class CoinExchanger(private val generator: RandomGenerator) {

    fun exchange(money: Int): EnumMap<Coin, Int> {
        val coinCounts = EnumMap<Coin, Int>(Coin::class.java)
        var deposit = money

        while (Coin.MIN_AMOUNT <= deposit) {
            val amount = generator.generate()
            if (deposit < amount) {
                continue
            }

            deposit -= amount
            coinCounts[Coin[amount]]!!.plus(1)
        }

        return coinCounts
    }
}