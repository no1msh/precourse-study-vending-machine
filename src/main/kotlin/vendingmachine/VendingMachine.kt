package vendingmachine

class VendingMachine {
    private val admin = Admin()
    private val balance = VendingMachineBalance()
    private val stock = VendingMachineStock()

    fun run() {
        admin.putMoney(balance)
        admin.putGoods(stock)
    }
}