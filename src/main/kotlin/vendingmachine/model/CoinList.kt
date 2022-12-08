package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin


class CoinList {

    private val coins = mutableListOf<Int>(0, 0, 0, 0)

    fun settingCoins(money: Int) {
        var pair = Pair(money, false)
        while (!pair.second) {
            pair = coinSetting(pair)
        }
    }

    fun getCoins(): MutableList<Int> = coins

    private fun coinSetting(pair: Pair<Int, Boolean>): Pair<Int, Boolean> {
        val random = Randoms.pickNumberInList(
            listOf(
                Coin.COIN_10.money(),
                Coin.COIN_50.money(),
                Coin.COIN_100.money(),
                Coin.COIN_500.money()
            )
        )
        if (random > pair.first)
            return pair
        if (random == pair.first) {
            coinPlus(random)
            return Pair(0, true)
        }
        coinPlus(random)
        return Pair(pair.first - random, false)
    }

    private fun coinPlus(money: Int) {
        if (money == 500)
            coins[0] += 1
        if (money == 100)
            coins[1] += 1
        if (money == 50)
            coins[2] += 1
        if (money == 10)
            coins[3] += 1
    }

    fun getChanges(money: Int): List<Int> {
        var leftOverMoney = money
        leftOverMoney = calculate500(leftOverMoney)
        leftOverMoney = calculate100(leftOverMoney)
        leftOverMoney = calculate50(leftOverMoney)
        calculate10(leftOverMoney)
        return coins
    }

    private fun calculate500(money: Int): Int {
        val quotient = money / Coin.COIN_500.money()
        if (quotient > coins[0]) {
            return money - coins[0] * Coin.COIN_500.money()
        }
        coins[0] = quotient
        return money - coins[0] * Coin.COIN_500.money()
    }

    private fun calculate100(money: Int): Int {
        val quotient = money / Coin.COIN_100.money()
        if (quotient > coins[1]) {
            return money - coins[1] * Coin.COIN_100.money()
        }
        coins[1] = quotient
        return money - coins[1] * Coin.COIN_100.money()
    }

    private fun calculate50(money: Int): Int {
        val quotient = money / Coin.COIN_50.money()
        if (quotient > coins[2]) {
            return money - coins[2] * Coin.COIN_50.money()
        }
        coins[2] = quotient
        return money - coins[2] * Coin.COIN_50.money()
    }

    private fun calculate10(money: Int): Int {
        val quotient = money / Coin.COIN_10.money()
        if (quotient > coins[3]) {
            return money - coins[3] * Coin.COIN_10.money()
        }
        coins[3] = quotient
        return money - coins[3] * Coin.COIN_10.money()
    }

}
