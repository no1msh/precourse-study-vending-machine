package vendingmachine.model.data.coin

import java.util.*

enum class Coin(private val amount: Int) : Comparable<Coin> {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),;

    operator fun compareTo(number: Int): Int {
        return amount - number
    }

    operator fun times(number: Int): Int {
        return amount * number
    }

    fun minusFrom(number: Int): Int {
        return number - amount
    }

    override fun toString(): String = amount.toString()

    companion object {

        val MAX_AMOUNT = values().maxOf { it.amount }
        val MIN_AMOUNT = values().minOf { it.amount }

        val Amounts: List<Int>
            get() = values().map { it.amount }

        val Ascending: List<Coin>
            get() = values().sortedBy { it.amount }

        val Descending: List<Coin>
            get() = values().sortedByDescending { it.amount }

        private val amounts: Map<Int, Coin> = values().associateBy { it.amount }

        operator fun get(amount: Int): Coin = amounts[amount]!!

        operator fun contains(amount: Int): Boolean = amounts.containsKey(amount)

    }
}