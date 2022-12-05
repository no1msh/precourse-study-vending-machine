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

    fun getMoney() {

    }

    fun getItems() {

    }

    fun doShoping() {

    }

    fun giveChange() {

    }
}