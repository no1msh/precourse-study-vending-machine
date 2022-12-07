package vendingmachine

import vendingmachine.view.View

class Admin {
    private val view = View()

    fun putMoney(balance: VendingMachineBalance) {
        val adminMoney = view.getAdminMoney()
        balance.putAdminMoney(adminMoney)
        view.printVendingMachineBalance(balance)
    }

    fun putGoods(stock: VendingMachineStock) {
        val goods = view.getAdminGoods()
        stock.putAdminGoods(goods)
    }
}