package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class VendingService {

    fun makeChanges(money: Int): List<Coin> {
        var coinsAndMoney: Pair<MutableList<Coin>, Int> = Pair(mutableListOf(), money)
        do {
            coinsAndMoney = addCoin10(coinsAndMoney.first, coinsAndMoney.second)
            coinsAndMoney = addCoin50(coinsAndMoney.first, coinsAndMoney.second)
            coinsAndMoney = addCoin100(coinsAndMoney.first, coinsAndMoney.second)
            coinsAndMoney = addCoin500(coinsAndMoney.first, coinsAndMoney.second)
        } while (coinsAndMoney.second > 0)
        return coinsAndMoney.first
    }

    fun returnChanges(money: Int, coins: List<Coin>): List<Coin?> {
        var calculatedMoney = money
        val sortedCoins = sortCoins(coins).toMutableList()
        val changes: MutableList<Coin?> = mutableListOf()
        while ((calculatedMoney - sortedCoins.last() >= 0) and (sortedCoins.isNotEmpty())) {
            calculatedMoney -= sortedCoins.last()
            changes.add(Coin.getCoin(sortedCoins.last()))
            sortedCoins.removeLast()
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

    private fun addCoin10(coins: MutableList<Coin>, money: Int): Pair<MutableList<Coin>, Int> {
        var randomCount = Randoms.pickNumberInList(listOf(Coin.COIN_10.getAmount()))
        var calculatedMoney = money
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_10.getAmount() >= 0)) {
            coins.add(Coin.COIN_10)
            randomCount -= 1
            calculatedMoney -= 10
        }
        return coins to calculatedMoney
    }

    private fun addCoin50(coins: MutableList<Coin>, money: Int): Pair<MutableList<Coin>, Int> {
        var randomCount = Randoms.pickNumberInList(listOf(Coin.COIN_50.getAmount()))
        var calculatedMoney = money
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_50.getAmount() >= 0)) {
            coins.add(Coin.COIN_50)
            randomCount -= 1
            calculatedMoney -= 50
        }
        return coins to calculatedMoney
    }

    private fun addCoin100(coins: MutableList<Coin>, money: Int): Pair<MutableList<Coin>, Int> {
        var randomCount = Randoms.pickNumberInList(listOf(Coin.COIN_100.getAmount()))
        var calculatedMoney = money
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_100.getAmount() >= 0)) {
            coins.add(Coin.COIN_100)
            randomCount -= 1
            calculatedMoney -= 100
        }
        return coins to calculatedMoney
    }

    private fun addCoin500(coins: MutableList<Coin>, money: Int): Pair<MutableList<Coin>, Int> {
        var randomCount = Randoms.pickNumberInList(listOf(Coin.COIN_500.getAmount()))
        var calculatedMoney = money
        while ((randomCount != 0) and (calculatedMoney - Coin.COIN_500.getAmount() >= 0)) {
            coins.add(Coin.COIN_500)
            randomCount -= 1
            calculatedMoney -= 500
        }
        return coins to calculatedMoney
    }
}