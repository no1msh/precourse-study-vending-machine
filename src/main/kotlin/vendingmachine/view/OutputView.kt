package vendingmachine.view

import vendingmachine.Coin


const val GIMME_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요."
const val VENDING_MACHINE_HAVE = "자판기가 보유한 동전"
const val GIMME_ITEMS = "상품명과 가격, 수량을 입력해 주세요."
const val GIMME_MY_MONEY = "투입 금액을 입력해 주세요."
const val GIMME_WHAT_YOU_BUY = "구매할 상품명을 입력해 주세요."

class OutputView {
    fun giveMeCoin() {
        println(GIMME_COIN)
    }

    fun showChanges(coins: MutableList<Int>) {
        val string = StringBuilder()
        string.appendLine(VENDING_MACHINE_HAVE)
        for (count in Coin.values()) {
            string.append(count.toString())
            string.appendLine(changesCount(coins[count.ordinal]))
        }
        println(string)
    }

    private fun changesCount(count: Int): String {
        var string = " - "
        string += count
        return string + "개"
    }

    fun getItems() {
        println(GIMME_ITEMS)
    }

    fun getMyMoney() {
        println(GIMME_MY_MONEY)
    }

    fun doShopping() {
        println(GIMME_WHAT_YOU_BUY)
    }

    fun moneyNow(money: Int) {
        println("투입 금액: ${money}원")
    }
}
