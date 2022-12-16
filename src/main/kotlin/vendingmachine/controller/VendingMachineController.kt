package vendingmachine.controller

import vendingmachine.exceptions.ValidateBusinessLogic
import vendingmachine.model.VendingMachine
import vendingmachine.model.VendingMachineProduct
import vendingmachine.view.View

object VendingMachineController {

    private lateinit var vendingMachineCoin: VendingMachine
    lateinit var vendingMachineProduct: VendingMachineProduct
    private var inputtedMoney = 0
    private var minimumPrice = Int.MAX_VALUE

    fun startVendingMachine() {
        initVendingMachineCoin()
        printVendingMachinesMoney()
        initVendingMachineProduct()
        initMinimumPrice()
        initUserInputMoney()
        purchaseTime()
        printChangeCoins()
    }

    private fun purchaseTime() {
        while (validatePurchase()) {
            val productToBuy = getPurchaseForProduct()
            inputtedMoney -= vendingMachineProduct.purchaseProduct(productToBuy)
        }

    }

    private fun initVendingMachineCoin() {
        vendingMachineCoin = VendingMachine(View.getVendingMachineMoney())
    }

    private fun initVendingMachineProduct() {
        vendingMachineProduct = VendingMachineProduct(View.getVendingMachineProduct())
    }

    private fun printVendingMachinesMoney() {
        View.printVendingMachineHaveCoins(vendingMachineCoin.getHaveCoins())
    }

    private fun initUserInputMoney() {
        this.inputtedMoney = View.getUserInputMoney()
    }

    private fun initMinimumPrice() {
        minimumPrice = vendingMachineProduct.getMinimumPrice()
    }

    private fun validatePurchase() = inputtedMoney >= minimumPrice && vendingMachineProduct.isNotSoldOut()

    private fun getPurchaseForProduct(): String {
        val userInputProduct: String
        try {
            userInputProduct = View.getProductToBuy(inputtedMoney)
            ValidateBusinessLogic.validateHasProduct(userInputProduct)
        } catch (e: Exception) {
            println(e.message)
            return getPurchaseForProduct()
        }
        return userInputProduct
    }

    fun printChangeCoins() {
        View.printChange(inputtedMoney, vendingMachineCoin.getChangeCoins(inputtedMoney))
    }

}