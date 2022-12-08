package vendingmachine.controller

import vendingmachine.model.Coin
import vendingmachine.domain.SellingProduct
import vendingmachine.domain.VendingService
import vendingmachine.ui.View

class Controller {

    private val view = View()
    private val vendingService = VendingService()

    fun execute() {
        val changes = start()
        val products = settingProducts()
        buyProduct(changes, products)
    }

    private fun start(): List<Coin> {
        val changes = view.getChanges()
        val coins = vendingService.makeChanges(changes)
        view.showInitialChanges(coins)
        return coins
    }

    private fun settingProducts() = SellingProduct(view.getProduct())

    private fun buyProduct(changes: List<Coin>, products: SellingProduct) {
        var insertMoney = view.getInsertMoney()
        val minimumPrice = products.getMinimumPrice()
        while (insertMoney > minimumPrice) {
            val product = products.find(view.getProductName(insertMoney))
            if (product != null)
                insertMoney = product.calculate(insertMoney)
        }
        val remainChanges = vendingService.returnChanges(insertMoney, changes)
        view.showRemainChanges(remainChanges, insertMoney)
    }
}