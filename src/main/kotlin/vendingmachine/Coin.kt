package vendingmachine

enum class Coin(private val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    fun getAmount() = amount

    override fun toString(): String {
        return "${this.amount}원"
    }

    companion object {
        fun getCoins(): List<Int> {
            return listOf(
                COIN_500.amount,
                COIN_100.amount,
                COIN_50.amount,
                COIN_10.amount,
            )
        }

        fun getEnumCoin(amount: Int) = when (amount) {
            500 -> COIN_500
            100 -> COIN_100
            50 -> COIN_50
            10 -> COIN_10
            else -> throw IllegalArgumentException()
        }
    }

}