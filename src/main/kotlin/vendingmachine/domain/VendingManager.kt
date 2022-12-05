package vendingmachine.domain

import vendingmachine.model.CoinList
import vendingmachine.view.View

class VendingManager {

    val coins: CoinList = CoinList()
    fun start() {
        getMoney()
        getItems()
        doShopping()
        giveChange()
    }

    private fun getMoney() {
        View().giveMeCoin()

    }

    private fun getItems() {

    }

    private fun doShopping() {

    }

    private fun giveChange() {

    }
}