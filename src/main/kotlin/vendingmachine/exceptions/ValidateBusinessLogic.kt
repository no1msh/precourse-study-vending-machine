package vendingmachine.exceptions

import vendingmachine.controller.VendingMachineController

object ValidateBusinessLogic {
    private const val PREFIX = "[ERROR] "

    private val vendingMachineProduct = VendingMachineController.vendingMachineProduct

    fun validateHasProduct(productForPurchase: String) {
        require(vendingMachineProduct.hasProduct(productForPurchase)) { PREFIX + "상품명을 다시 확인해주세요."}
    }
}