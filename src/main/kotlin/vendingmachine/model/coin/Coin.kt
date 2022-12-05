package vendingmachine.model.coin

enum class Coin(private val amount: Int) : Comparable<Coin> {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    companion object {
        val MAX_AMOUNT = values().maxOf { it.amount }
        val MIN_AMOUNT = values().minOf { it.amount }

        private val amounts: Map<Int, Coin> = values().associateBy { it.amount }

        operator fun get(amount: Int): Coin = amounts[amount]!!
    }
}