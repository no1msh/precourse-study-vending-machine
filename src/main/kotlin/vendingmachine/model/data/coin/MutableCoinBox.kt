package vendingmachine.model.data.coin

interface MutableCoinBox : CoinBox {

    operator fun set(coin: Coin, count: Int)

    fun addAll(coinBox: CoinBox)

    fun add(coin: Coin)

    fun add(coin: Coin, count: Int)

    fun remove(coin: Coin)

}