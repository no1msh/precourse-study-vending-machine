package vendingmachine.model.data.coin

import java.util.EnumMap

class MutableCoinBoxImpl : MutableCoinBox {

    private val countOfCoin: EnumMap<Coin, Int> = makeCoinMap()

    override operator fun get(coin: Coin): Int {
        return countOfCoin[coin]!!
    }

    override operator fun set(coin: Coin, count: Int) {
        require(count >= 0)

        countOfCoin[coin] = count
    }

    override operator fun iterator(): Iterator<Pair<Coin, Int>> {
        return countOfCoin.toList().iterator()
    }

    override fun addAll(coinBox: CoinBox) {
        for ((coin, count) in coinBox) {
            countOfCoin[coin] = countOfCoin[coin]!! + count
        }
    }

    override fun add(coin: Coin) {
        add(coin, 1)
    }

    override fun add(coin: Coin, count: Int) {
        countOfCoin[coin] = countOfCoin[coin]!! + count
    }

    override fun remove(coin: Coin) {
        check(countOfCoin[coin]!! > 0)

        countOfCoin[coin] = countOfCoin[coin]!! - 1
    }

    override fun takeOf(money: Int): CoinBox {
        val coinBox = MutableCoinBoxImpl()
        var remaining = money

        for ((coin, _) in countOfCoin) {
            if (remaining <= 0) break

            val removeCount = removeOf(coin, remaining)
            remaining -= coin * removeCount

            coinBox.add(coin, removeCount)
        }

        return coinBox
    }

    private fun removeOf(coin: Coin, money: Int): Int {
        var count = 0
        var remaining = money

        for (i in 0 until countOfCoin[coin]!!) {
            if (coin > remaining) break

            remaining = coin.minusFrom(remaining)
            countOfCoin[coin] = countOfCoin[coin]!! - 1

            count += 1
        }

        return count
    }

    private fun makeCoinMap(): EnumMap<Coin, Int> {
        val map = EnumMap<Coin, Int>(Coin::class.java)

        for (element in Coin.Descending) {
            map[element] = 0
        }

        return map
    }
}