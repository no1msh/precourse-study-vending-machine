package vendingmachine.ui

import vendingmachine.model.Product
import vendingmachine.ui.input.InputView
import vendingmachine.ui.output.OutputView

class View {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun getHoldMoney(): Int {
        outputView.printInputHoldMoney()
        while (true) {
            try {
                return inputView.readHoldMoney(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getProduct(): List<Product> {
        while (true) {
            try {
                return inputView.readProduct(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getInsertMoney(): Int {
        while (true) {
            try {
                return inputView.readInsertMoney(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }

    fun getProductName(): String {
        while (true) {
            try {
                return inputView.readProductName(inputView.getInput())
            } catch (e: IllegalArgumentException) {
                outputView.printError(e)
            }
        }
    }
}