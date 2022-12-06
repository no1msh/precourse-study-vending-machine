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
        val minvalue = getMinValue()
        while (minvalue < money) {
            View().moneyNow(money)
            money -= View().doShopping(items)
        }
    }

    private fun giveChange() {

    }

    private fun getMinValue(): Int {
        var minvalue = items[0][1].toInt()
        for (count in items.indices) {
            if (minvalue > items[count][1].toInt())
                minvalue = items[count][1].toInt()
        }
        return minvalue
    }

}