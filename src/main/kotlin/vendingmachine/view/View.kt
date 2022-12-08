package vendingmachine.view

import vendingmachine.model.CoinList

class View {

    fun giveMeCoin(): Int {
        OutputView().giveMeCoin()
        return InputView().giveMeCoin()
    }

    fun showChanges(coins: MutableList<Int>) {
        OutputView().showChanges(coins)
    }

    fun getItems(): MutableList<MutableList<String>> {
        OutputView().getItems()
        return InputView().getItems()
    }

    fun getMyMoney(): Int {
        OutputView().getMyMoney()
        return InputView().getMyMoney()
    }

    fun doShopping(items: List<List<String>>): Pair<Int, Int> {
        OutputView().doShopping()
        return InputView().doShopping(items)
    }

    fun moneyNow(money: Int) {
        OutputView().moneyNow(money)
    }

    fun canNotBuy() {
        OutputView().canNotBuy()
    }

    fun giveChange(money: Int, coins: CoinList) {
        OutputView().giveChange(money, coins)
    }

}
