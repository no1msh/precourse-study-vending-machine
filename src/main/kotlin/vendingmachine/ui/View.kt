package vendingmachine.ui

import vendingmachine.model.Coin
import vendingmachine.model.Product
import vendingmachine.ui.input.InputView
import vendingmachine.ui.output.OutputView

class View {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun getChanges(): Int {
        outputView.printInputChanges()
        while (true) {
            try {
                return inputView.readChanges(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getProduct(): List<Product> {
        outputView.printInputProductInfo()
        while (true) {
            try {
                return inputView.readProduct(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getInsertMoney(): Int {
        outputView.printInputInsertMoney()
        while (true) {
            try {
                return inputView.readInsertMoney(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getProductName(insertMoney: Int): String {
        outputView.printInsertMoney(insertMoney)
        outputView.printInputProductName()
        while (true) {
            try {
                return inputView.readProductName(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun showInitialChanges(coins: List<Coin>) = outputView.printInitialChanges(coins)

    fun showRemainChanges(coins: List<Coin?>, insertMoney: Int) {
        outputView.printInsertMoney(insertMoney)
        outputView.printChanges(coins)
    }
}