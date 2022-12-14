package vendingmachine.model.data.coin

import vendingmachine.model.random.RandomGenerator

class CoinExchanger(private val generator: RandomGenerator) {

    fun exchange(money: Int): CoinBox {
        val coinBox = MutableCoinBoxImpl()
        var remaining = money

        while (Coin.MIN_AMOUNT <= remaining) {
            val coin = generateCoin()
            if (coin > remaining) {
                continue
            }

            remaining = coin.minusFrom(remaining)

            coinBox.add(coin)
        }

        return coinBox
    }

    private fun generateCoin(): Coin {
        return Coin[generator.generate()]
    }
}