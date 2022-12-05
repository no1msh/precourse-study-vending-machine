package vendingmachine.domain

import vendingmachine.model.CoinList

class VendingManager {

    val coins: CoinList = CoinList()
    fun start() {
        getMoney()
        getItems()
        doShoping()
        giveChange()
    }

    private fun getMoney() {

    }

    private fun getItems() {

    }

    private fun doShoping() {

    }

    private fun giveChange() {

    }
}