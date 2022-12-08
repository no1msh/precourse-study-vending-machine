package vendingmachine

enum class Coin(private val amount: Int) {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    // 추가 기능 구현

    fun money(): Int = this.amount
    override fun toString(): String = "${this.amount}원"


}