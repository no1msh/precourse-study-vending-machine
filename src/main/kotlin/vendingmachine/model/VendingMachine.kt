package vendingmachine.model

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class VendingMachine(private var totalMoney: Int) {

    private val haveCoins = mutableMapOf<Int, Int>()

    init {
        haveCoins[500] = 0
        haveCoins[100] = 0
        haveCoins[50] = 0
        haveCoins[10] = 0
        createRandomCoins()
    }

    fun getHaveCoins() = haveCoins.toMap()

    fun getTotalCoinAmount(): Int {
        var total = 0
        for (coin in haveCoins.keys) {
            total += coin * haveCoins[coin]!!
        }
        return total
    }

    private fun createRandomCoins() {
        var tempTotal = totalMoney
        val coins = Coin.getCoins()
        while (tempTotal != 0) {
            val randomCoin = Randoms.pickNumberInList(coins)
            if (randomCoin <= tempTotal) {
                tempTotal -= randomCoin
                this.haveCoins[randomCoin] = this.haveCoins[randomCoin]!! + 1
            }
        }
    }
}