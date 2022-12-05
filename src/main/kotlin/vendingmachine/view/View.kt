package vendingmachine.view

import kotlin.text.StringBuilder

class View {

    fun giveMeCoin(): Int {
        OutputView().giveMeCoin()
        return InputView().giveMeCoin()
    }

    fun showChanges(coins: MutableList<Int>) {
        var str = StringBuilder()

    }

}
