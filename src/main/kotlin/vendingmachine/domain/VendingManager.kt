package vendingmachine.domain

import vendingmachine.model.CoinList
import vendingmachine.view.View

class VendingManager {

    lateinit var items: MutableList<MutableList<String>>

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
        val minvalue = VendingCalculator().getMinValue(items)
        while (minvalue < money) {
            View().moneyNow(money)
            val buyResult = View().doShopping(items)
            if (VendingCalculator().canIBuy(money, buyResult.first)) {
                money -= buyResult.first
                items[buyResult.second][2] = (items[buyResult.second][2].toInt() - 1).toString()
            }
        }
    }


    private fun giveChange() {
        View().giveChange(money, coins)
    }

}