package vendingmachine.model.coin

import vendingmachine.model.random.RandomGenerator
import java.util.*

class CoinExchanger(private val generator: RandomGenerator) {

    fun exchange(money: Int): EnumMap<Coin, Int> {
        val countOf: EnumMap<Coin, Int> = Coin.associateWith { 0 }
        var deposit = money

        while (Coin.MIN_AMOUNT <= deposit) {
            val amount = generator.generate()
            if (deposit < amount) {
                continue
            }

            val coin = Coin[amount]

            deposit -= amount

            countOf[coin] = countOf[coin]!!.plus(1)
        }

        return countOf
    }
}