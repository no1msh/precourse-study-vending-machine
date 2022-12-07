package vendingmachine.view

import vendingmachine.model.VendingMachineBalance

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun getAdminMoney(): Int {
        outputView.requestInitialMoney()
        return try {
            inputView.getAdminMoney()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            getAdminMoney()
        }
    }

    fun printVendingMachineBalance(balance: VendingMachineBalance) {
        outputView.printBalance(balance)
    }

    fun getAdminGoods(): MutableList<List<String>> {
        outputView.requestGoods()
        return try {
            inputView.getAdminGoods()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            getAdminGoods()
        }
    }
}