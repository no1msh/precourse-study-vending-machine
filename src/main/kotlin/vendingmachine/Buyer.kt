package vendingmachine

import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock
import vendingmachine.view.View

class Buyer {
    private val view = View()

    fun getGoods(balance: VendingMachineBalance, stock: VendingMachineStock) {
        val buyerMoney = view.requestMoney()
        while(true) {
            var item = view.requestGoodsName(buyerMoney, stock)
        }
    }

}