package vendingmachine.view

class View {

    fun giveMeCoin(): Int {
        OutputView().giveMeCoin()
        return InputView().giveMeCoin()
    }

    fun showChanges(coins: MutableList<Int>) {
        OutputView().showChanges(coins)
    }

}
