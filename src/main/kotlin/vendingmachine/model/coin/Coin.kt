package vendingmachine.model.coin

import java.util.*

enum class Coin(private val amount: Int) : Comparable<Coin> {
    COIN_10(10),
    COIN_50(50),
    COIN_100(100),
    COIN_500(500),;

    operator fun compareTo(number: Int): Int = amount.compareTo(number)

    companion object {
        val MAX_AMOUNT = values().maxOf { it.amount }
        val MIN_AMOUNT = values().minOf { it.amount }

        private val coins: EnumSet<Coin> = EnumSet.allOf(Coin::class.java)

        private val amounts: Map<Int, Coin> = values().associateBy { it.amount }

        operator fun get(amount: Int): Coin = amounts[amount]!!

        operator fun contains(amount: Int): Boolean = amounts.contains(amount)

        inline fun <V> associateWith(valueSelector: (Coin) -> V): EnumMap<Coin, V> {
            val map = EnumMap<Coin, V>(Coin::class.java)
            for (element in values()) map[element] = valueSelector(element)
            return map
        }
    }
}