package vendingmachine.view

import vendingmachine.model.repository.Result
import vendingmachine.model.repository.VendingMachineRepository
import vendingmachine.view.io.InputView
import vendingmachine.view.io.OutputView
import vendingmachine.viewmodel.VendingMachineViewModel

class VendingMachineView(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    private lateinit var viewModel: VendingMachineViewModel

    fun show() {
        initViewModel()

        initVendingMachineMoneyAndMakeCoins()
        showVendingMachineCoins()
        initVendingMachineProducts()

        runVendingMachine()
    }

    private fun initViewModel() {
        viewModel = VendingMachineViewModel(
            VendingMachineRepository()
        )
    }

    private fun initVendingMachineMoneyAndMakeCoins() {
        outputView.printInputVendingMachineMoney()

        val money = repeatIfThrows(inputView::readVendingMachineMoney)
        viewModel.makeCoins(money)
    }

    private fun showVendingMachineCoins() {
        val coinBox = viewModel.getCoinBox()

        outputView.printVendingMachineCoins(coinBox)
    }

    private fun initVendingMachineProducts() {
        outputView.printInputProducts()

        val products = repeatIfThrows(inputView::readVendingMachineProducts)

        viewModel.setProducts(products)
    }

    private fun runVendingMachine() {
        waitUserInputCost()
        startShopping()
        showChangeMoney()
    }

    private fun waitUserInputCost() {
        outputView.printInputCosts()

        val cost = repeatIfThrows(inputView::readInputCost)

        viewModel.pay(cost)
    }

    private fun startShopping() {
        while (viewModel.canMorePurchase) {
            outputView.printBalance(viewModel.balance)

            readAndAddPurchaseProduct()
        }
    }

    private tailrec fun readAndAddPurchaseProduct() {
        outputView.printInputPurchaseProduct()

        val productName = repeatIfThrows(inputView::readPurchaseProduct)

        return when (val result = viewModel.addProductInShoppingCart(productName)) {
            is Result.Success -> Unit
            is Result.Failure -> {
                outputView.printErrorMessage(result.error)

                readAndAddPurchaseProduct()
            }
        }
    }

    private fun showChangeMoney() {
        outputView.printBalance(viewModel.balance)
        outputView.printChangeCoins(viewModel.getChangeCoins())
    }

    private inline fun <T> repeatIfThrows(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                outputView.printErrorMessage(e)
            }
        }
    }

    companion object {

        fun newInstance(): VendingMachineView =
            VendingMachineView(InputView(), OutputView())
    }
}