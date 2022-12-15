package vendingmachine.controller

import vendingmachine.model.VendingMachine
import vendingmachine.model.VendingMachineProduct
import vendingmachine.view.View

object VendingMachineController {

    lateinit var vendingMachineCoin: VendingMachine
    lateinit var vendingMachineProduct: VendingMachineProduct

    fun startVendingMachine(){
        initVendingMachine()
        printVendingMachinesMoney()
    }

    private fun initVendingMachine(){
        vendingMachineCoin = VendingMachine(View.getVendingMachineMoney())
        vendingMachineProduct = VendingMachineProduct(View.getVendingMachineProduct())
    }

    private fun printVendingMachinesMoney(){
        View.printVendingMachineHaveCoins(vendingMachineCoin.getHaveCoins())
    }
}