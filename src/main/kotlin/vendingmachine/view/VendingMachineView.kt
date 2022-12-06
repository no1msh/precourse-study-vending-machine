package vendingmachine.view

import vendingmachine.view.io.InputView
import vendingmachine.view.io.OutputView

class VendingMachineView(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun show() {
        initViewModel()

        setupVendingMachineMoneyAndShowCoins()
        setupVendingMachineProducts()

        runVendingMachine()
    }

    private fun initViewModel() {

    }

    private fun setupVendingMachineMoneyAndShowCoins() {
        outputView.printInputVendingMachineMoney()

        outputView.printVendingMachineCoins(
            //viewModel
        )
    }

    private fun setupVendingMachineProducts() {

    }

    private fun runVendingMachine() {
        val cost = inputView.readInputCost()

        // viewModel.쇼핑카트

        // viewModel.돈이 들어왔다
        // viewModel.상품(콜라)을 선택했다
        // viewModel.상품(사이다)을 선택했다
        //
    }

    companion object {

        fun newInstance(): VendingMachineView =
            VendingMachineView(InputView(), OutputView())
    }
}