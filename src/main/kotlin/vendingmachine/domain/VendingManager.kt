package vendingmachine.domain

import vendingmachine.model.CoinList
import vendingmachine.view.View

class VendingManager {

    lateinit var items: List<List<String>>

    private val coins: CoinList = CoinList()

    var money = 0
    fun start() {
        getMoney()
        getItems()
        getMyMoney()
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

    private fun getMyMoney() {
        money = View().getMyMoney()
    }

    private fun doShopping() {

    }

    private fun giveChange() {

    }

}