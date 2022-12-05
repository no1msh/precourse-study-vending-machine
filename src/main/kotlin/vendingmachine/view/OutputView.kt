package vendingmachine.view

import vendingmachine.Coin


const val GIMME_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요."
const val VENDING_MACHINE_HAVE = "자판기가 보유한 동전"

class OutputView {
    fun giveMeCoin() {
        println(GIMME_COIN)
    }

    fun showChanges(coins: MutableList<Int>) {
        val string = StringBuilder()
        string.appendLine(VENDING_MACHINE_HAVE)
        for (count in Coin.values()) {
            string.append(count.toString())
            string.append(coins[count.ordinal])
            string.appendLine("개")
        }
        println(string)
    }

}
