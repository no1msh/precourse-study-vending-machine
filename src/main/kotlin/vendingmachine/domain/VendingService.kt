package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.model.Coin

class VendingService {

    fun makeChanges(money: Int): List<Coin> {
        var coinsAndMoney: Pair<MutableList<Coin>, Int> = Pair(mutableListOf(), money)
        var randomCount = Randoms.pickNumberInList(listOf(10, 50, 100, 500))
        do {
            coinsAndMoney = addCoin500(coinsAndMoney.first, coinsAndMoney.second, randomCount)
            coinsAndMoney = addCoin100(coinsAndMoney.first, coinsAndMoney.second, randomCount)
            coinsAndMoney = addCoin50(coinsAndMoney.first, coinsAndMoney.second, randomCount)
            coinsAndMoney = addCoin10(coinsAndMoney.first, coinsAndMoney.second, randomCount)
        } while (coinsAndMoney.second > 0)
        return coinsAndMoney.first
    }

    fun returnChanges(money: Int, coins: List<Coin>): List<Coin?> {
        var calculatedMoney = money
        val sortedCoins = sortCoins(coins).toMutableList()
        val changes: MutableList<Coin?> = mutableListOf()
        var index = sortedCoins.size - 1
        while ((calculatedMoney - sortedCoins[index] >= 0) and (--index >= 0)) {
            calculatedMoney -= sortedCoins[index]
            changes.add(Coin.getCoin(sortedCoins[index]))
        }
        return changes
    }

    private fun sortCoins(coins: List<Coin>): List<Int> {
        val sortedCoins: MutableList<Int> = mutableListOf()
        for (coin in coins) {
            sortedCoins.add(coin.getAmount())
        }
        return sortedCoins.sorted()
    }

    private fun addCoin10(coins: MutableList<Coin>, money: Int, randomCount: Int): Pair<MutableList<Coin>, Int> {
        var calculatedMoney = money
        var count = randomCount
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_10.getAmount() >= 0)) {
            coins.add(Coin.COIN_10)
            count -= 1
            calculatedMoney -= 10
        }
        return coins to calculatedMoney
    }

    private fun addCoin50(coins: MutableList<Coin>, money: Int, randomCount: Int): Pair<MutableList<Coin>, Int> {
        var calculatedMoney = money
        var count = randomCount
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_50.getAmount() >= 0)) {
            coins.add(Coin.COIN_50)
            count -= 1
            calculatedMoney -= 50
        }
        return coins to calculatedMoney
    }

    private fun addCoin100(coins: MutableList<Coin>, money: Int, randomCount: Int): Pair<MutableList<Coin>, Int> {
        var calculatedMoney = money
        var count = randomCount
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_100.getAmount() >= 0)) {
            coins.add(Coin.COIN_100)
            count -= 1
            calculatedMoney -= 100
        }
        return coins to calculatedMoney
    }

    private fun addCoin500(coins: MutableList<Coin>, money: Int, randomCount: Int): Pair<MutableList<Coin>, Int> {
        var calculatedMoney = money
        var count = randomCount
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_500.getAmount() >= 0)) {
            coins.add(Coin.COIN_500)
            count -= 1
            calculatedMoney -= 500
        }
        return coins to calculatedMoney
    }
}