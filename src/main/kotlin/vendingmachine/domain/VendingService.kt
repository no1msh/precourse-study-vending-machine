package vendingmachine.domain

import vendingmachine.Coin

class VendingService {

    fun makeChanges(money: Int): List<Coin> {
        return listOf(Coin.COIN_500)
    }

    fun remainMoney(money: Int, products: SellingProduct): Int {
        return 0
    }

    fun returnChanges(money: Int, coins: List<Coin>): List<Coin> {
        return listOf(Coin.COIN_500)
    }
}