package vendingmachine.model

enum class Coin(private val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    // 추가 기능 구현
    fun getAmount(): Int = amount

    companion object {
        fun getCoin(amount: Int): Coin? {
            return when (amount) {
                COIN_500.amount -> COIN_500
                COIN_100.amount -> COIN_100
                COIN_50.amount -> COIN_50
                COIN_10.amount -> COIN_10
                else -> null
            }
        }
    }
}