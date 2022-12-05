package vendingmachine.model;

import camp.nextstep.edu.missionutils.Randoms


class CoinList {

    private val coins = mutableListOf<Int>(0, 0, 0, 0)

    fun settingCoins(money: Int) {
        var pair = Pair<Int, Boolean>(money, false)
        while (!pair.second) {
            pair = coinSetting(pair)
        }
    }

    fun getCoins(): MutableList<Int> = coins

    private fun coinSetting(pair: Pair<Int, Boolean>): Pair<Int, Boolean> {
        val random = Randoms.pickNumberInList(listOf(500, 100, 50, 10))
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

}
