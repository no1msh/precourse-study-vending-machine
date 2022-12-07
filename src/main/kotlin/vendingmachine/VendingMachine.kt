package vendingmachine

import vendingmachine.model.VendingMachineBalance
import vendingmachine.model.VendingMachineStock

class VendingMachine {
    private val admin = Admin()
    private val balance = VendingMachineBalance()
    private val stock = VendingMachineStock()

    fun run() {
        admin.putMoney(balance)
        admin.putGoods(stock)

    }
}