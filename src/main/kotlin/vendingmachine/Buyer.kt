package vendingmachine

import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock
import vendingmachine.view.View

class Buyer {
    private val view = View()
    private var buyerMoney = 0

    fun getGoods(stock: VendingMachineStock) {
        buyerMoney = view.requestMoney(false)
        while (isAvailablePurchase(stock, buyerMoney)) {
            val item = view.requestGoodsName(buyerMoney, stock)
            val price = stock.updateVendingMachine(item, buyerMoney)
            if (price == -1) {
                break
            }
            buyerMoney -= price
        }
    }

    private fun isAvailablePurchase(stock: VendingMachineStock, buyerMoney: Int): Boolean {
        return (stock.getMinPrice() < buyerMoney) && (stock.getStockCount() != 0)
    }

    fun getBalance(balance: VendingMachineBalance) {
        view.printRemainMoney(buyerMoney)
        view.printVendingMachineBalance(balance, true)
    }

}