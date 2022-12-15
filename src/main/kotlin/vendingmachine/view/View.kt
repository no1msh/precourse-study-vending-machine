package vendingmachine.view

import vendingmachine.Coin

object View {
    fun getVendingMachineMoney(): Int {
        UI.printRequestInputVendingMachineMoney()
        return InputView.inputVendingMachineMoney().toInt()
    }

    fun printVendingMachineHaveCoins(haveCoins: Map<Coin, Int>) {
        println()
        UI.printVendingMachineCoins()
        OutputView.printVendingMachineCoins(haveCoins)
    }

    fun getVendingMachineProduct(): String {
        UI.printRequestInputProduct()
        return InputView.inputVendingMachineProduct()
    }
}