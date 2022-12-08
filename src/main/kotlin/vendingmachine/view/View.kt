package vendingmachine.view

import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun requestMoney(isAdmin: Boolean): Int {
        outputView.requestInitialMoney(isAdmin)
        return try {
            inputView.getMoney()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            requestMoney(isAdmin)
        }
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
        outputView.printRemainingMoney(buyerMoney)
        outputView.requestGoodsName()
        return try {
            inputView.getBuyerGoods(stock)
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            requestGoodsName(buyerMoney, stock)
        }
    }

    fun printVendingMachineBalance(balance: VendingMachineBalance, isResult: Boolean, buyerMoney: Int) {
        outputView.printRemainingMoney(buyerMoney)
        outputView.printBalance(balance, isResult)
    }
}
