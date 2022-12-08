package vendingmachine.view

import vendingmachine.model.VendingMachineBalance

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun requestMoney(): Int {
        outputView.requestInitialMoney()
        return try {
            inputView.getMoney()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            requestMoney()
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