package vendingmachine.model

import vendingmachine.view.View

class Admin {
    private val view = View()

    fun putMoney(balance: VendingMachineBalance) {
        val adminMoney = view.requestMoney(true)
        balance.putAdminMoney(adminMoney)
        view.printVendingMachineBalance(balance, false)
    }

    fun putGoods(stock: VendingMachineStock) {
        val goods = view.getAdminGoods()
        stock.putAdminGoods(goods)
    }
}