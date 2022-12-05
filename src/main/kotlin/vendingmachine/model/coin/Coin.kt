package vendingmachine.model.coin

enum class Coin(private val amount: Int) : Comparable<Coin> {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);



    companion object {

        private val amounts: Map<Int, Coin> = values().associateBy { it.amount }

        operator fun get(amount: Int): Coin = amounts[amount]!!
    }
}