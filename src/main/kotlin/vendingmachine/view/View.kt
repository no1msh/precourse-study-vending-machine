package vendingmachine.view

object View {
    fun getVendingMachineMoney(): Int {
        UI.printRequestInputVendingMachineMoney()
        return InputView.inputVendingMachineMoney().toInt()
    }
}