package vendingmachine.controller

import vendingmachine.model.VendingMachine
import vendingmachine.view.View

object VendingMachineController {

    lateinit var vendingMachine: VendingMachine

    fun startVendingMachine(){
        initVendingMachine()
        printVendingMachinesMoney()
    }

    private fun initVendingMachine(){
        vendingMachine = VendingMachine(View.getVendingMachineMoney())
    }

    private fun printVendingMachinesMoney(){
        View.printVendingMachineHaveCoins(vendingMachine.getHaveCoins())
    }
}