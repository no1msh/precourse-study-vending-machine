package vendingmachine.model.data.coin

interface CoinBox {

    operator fun get(coin: Coin): Int

    operator fun iterator(): Iterator<Pair<Coin, Int>>

    fun takeOf(money: Int): CoinBox
}