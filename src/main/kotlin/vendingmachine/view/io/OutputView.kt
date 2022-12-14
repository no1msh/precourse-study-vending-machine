package vendingmachine.view.io

import vendingmachine.model.data.coin.CoinBox
import vendingmachine.model.repository.Error
import vendingmachine.view.strings.ErrorMessage
import vendingmachine.view.strings.Message

class OutputView {

    fun printInputVendingMachineMoney() {
        println(Message.INPUT_VENDING_MACHINE_MONEY)
    }

    fun printVendingMachineCoins(coinBox: CoinBox) {
        println(LineSeparator + Message.VENDING_MACHINE_COINS)

        for ((coin, count) in coinBox) {
            println(Message.EACH_COIN_FORMAT.format(coin, count))
        }
    }

    fun printInputProducts() {
        println(LineSeparator + Message.INPUT_PRODUCT_INFO)
    }

    fun printInputCosts() {
        println(LineSeparator + Message.INPUT_COSTS)
    }

    fun printBalance(balance: Int) {
        println(LineSeparator + Message.BALANCE_FORMAT.format(balance))
    }

    fun printInputPurchaseProduct() {
        println(Message.INPUT_PURCHASE_PRODUCT)
    }

    fun printChangeCoins(coinBox: CoinBox) {
        println(Message.CHANGE_MONEY)

        for ((coin, count) in coinBox) {
            if (count == 0) continue

            println(Message.CHANGE_EACH_COIN_FORMAT.format(coin, count))
        }
    }

    fun printErrorMessage(error: Error) {
        when (error) {
            Error.NotExists -> printErrorMessage(ErrorMessage.NOT_EXISTS_PRODUCT)
            Error.OutOfStock -> printErrorMessage(ErrorMessage.OUT_OF_STOCK_PRODUCT)
            Error.InsufficientBalance -> printErrorMessage(ErrorMessage.INSUFFICIENT_BALANCE)
        }
    }

    fun printErrorMessage(e: Throwable) {
        printErrorMessage(e.message!!)
    }

    private fun printErrorMessage(message: String) {
        println("${ErrorMessage.PREFIX} $message")
    }

    companion object {
        private val LineSeparator = System.lineSeparator()
    }
}