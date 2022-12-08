package vendingmachine.view

import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock

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

    fun requestGoodsName(buyerMoney: Int, stock: VendingMachineStock): String {
        outputView.requestGoodsName(buyerMoney)
        return try {
            inputView.getBuyerGoods(stock)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            requestGoodsName(buyerMoney, stock)
        }
    }
}