package vendingmachine.controller

import vendingmachine.model.VendingMachine
import vendingmachine.view.View

object VendingMachineController {

    lateinit var vendingMachine: VendingMachine

    fun startVendingMachine(){
        initVendingMachine()
    }

    private fun initVendingMachine(){
        vendingMachine = VendingMachine(View.getVendingMachineMoney())
    }

}