package vendingmachine.Controller

import vendingmachine.model.Admin
import vendingmachine.model.Buyer
import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock

class VendingMachine {
    private val admin = Admin()
    private val buyer = Buyer()
    private val balance = VendingMachineBalance()
    private val stock = VendingMachineStock()

    fun run() {
        admin.putMoney(balance)
        admin.putGoods(stock)
        buyer.getGoods(stock)
        buyer.getBalance(balance)
    }
}