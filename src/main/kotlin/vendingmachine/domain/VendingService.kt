package vendingmachine.domain

import vendingmachine.Coin
import vendingmachine.model.Product

class VendingService {

    fun makeChanges(money: Int): List<Coin> {
        return listOf(Coin.COIN_500)
    }

    fun returnChanges(money: Int, coins: List<Coin>): List<Coin> {
        return listOf(Coin.COIN_500)
    }
}