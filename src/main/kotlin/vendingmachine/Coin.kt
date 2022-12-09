package vendingmachine

enum class Coin(private val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    override fun toString(): String {
        return "${amount}원"
    }

    fun getAmount() = amount

    companion object{
        fun getCoins(): List<Int> {
            return listOf(
                COIN_500.amount,
                COIN_100.amount,
                COIN_50.amount,
                COIN_10.amount,
            )
        }
    }

}