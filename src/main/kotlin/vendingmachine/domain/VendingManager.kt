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
        coins.settingCoins(View().giveMeCoin())
        View().showChanges(coins.getCoins())
    }

    private fun getItems() {

    }

    private fun doShopping() {

    }

    private fun giveChange() {

    }
}