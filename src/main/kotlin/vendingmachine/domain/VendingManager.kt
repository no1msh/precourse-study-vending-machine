package vendingmachine.domain

import vendingmachine.model.CoinList
import vendingmachine.view.View

class VendingManager {

    lateinit var items: List<List<String>>

    private val coins: CoinList = CoinList()
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
        items = View().getItems()
    }

    private fun doShopping() {

    }

    private fun giveChange() {

    }
    
}