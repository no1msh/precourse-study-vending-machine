package vendingmachine.model

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin
import kotlin.math.max

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

    fun getChangeCoins(remain: Int): Map<Coin, Int> {
        var remainMoney = remain
        val changeCoins = mutableMapOf<Coin, Int>()
        for (coin in Coin.values()) {
            if (remainMoney / coin.getAmount() > 0) {
                val count = getMinimumCount(coin, remainMoney)
                remainMoney -= count * coin.getAmount()
                changeCoins[coin] = count
            }
        }
        return changeCoins.toMap()
    }

    private fun getMinimumCount(coin: Coin, remain: Int): Int {
        if (haveCoins[coin]!! > (remain / coin.getAmount())) {
            return remain / coin.getAmount()
        }
        return haveCoins[coin]!!

    }

    fun getCoinCount(coin: Coin) = haveCoins[coin]!!

    private fun createRandomCoin(): Int {
        val coins = Coin.getCoins()
        return Randoms.pickNumberInList(coins)
    }
}