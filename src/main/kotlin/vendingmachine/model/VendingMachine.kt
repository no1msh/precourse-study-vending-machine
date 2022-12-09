package vendingmachine.model

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class VendingMachine(private var totalMoney: Int) {

    private val haveCoins = mutableMapOf<Coin, Int>()

    init {
        haveCoins[Coin.COIN_500] = 0
        haveCoins[Coin.COIN_100] = 0
        haveCoins[Coin.COIN_50] = 0
        haveCoins[Coin.COIN_10] = 0
        initHaveCoins()
    }

    fun getHaveCoins() = haveCoins.toMap()

    fun getTotalCoinAmount(): Int {
        var total = 0
        for (coin in haveCoins.keys) {
            total += coin.getAmount() * haveCoins[coin]!!
        }
        return total
    }

    private fun initHaveCoins() {
        var tempTotal = totalMoney
        while (tempTotal != 0) {
            val randomCoin = createRandomCoin()
            if (randomCoin <= tempTotal) {
                tempTotal -= randomCoin
                this.haveCoins[Coin.getEnumCoin(randomCoin)] = this.haveCoins[Coin.getEnumCoin(randomCoin)]!! + 1
            }
        }
    }

    private fun createRandomCoin(): Int {
        val coins = Coin.getCoins()
        return Randoms.pickNumberInList(coins)
    }
}