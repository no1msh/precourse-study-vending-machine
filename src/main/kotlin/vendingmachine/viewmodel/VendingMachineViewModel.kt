package vendingmachine.viewmodel

import vendingmachine.model.data.coin.CoinBox
import vendingmachine.model.data.coin.MutableCoinBoxImpl
import vendingmachine.model.data.product.Product
import vendingmachine.model.data.product.ProductInfo
import vendingmachine.model.repository.Result
import vendingmachine.model.repository.Result.Success
import vendingmachine.model.repository.VendingMachineRepository

class VendingMachineViewModel(
    private val repository: VendingMachineRepository
) {

    val canMorePurchase: Boolean
        get() = isNotEmptyProductStocks && isEnoughBalance

    val isNotEmptyProductStocks: Boolean
        get() = repository.totalStock > 0

    val isEnoughBalance: Boolean
        get() = repository.minPrice < balance

    var balance: Int = 0
        private set

    fun makeCoins(money: Int) {
        repository.makeCoins(money)
    }

    fun getCoinBox(): CoinBox {
        return repository.coinBox
    }

    fun setProducts(products: List<Product>) {
        repository.setProducts(products)
    }

    fun pay(money: Int) {
        balance = money
    }

    fun addProductInShoppingCart(productName: String): Result<ProductInfo> {
        val result = repository.buyProduct(productName, balance)

        if (result is Success) {
            balance -= result.data.price
        }

        return result
    }

    fun getChangeCoins(): CoinBox {
        return repository.getChangeCoins(balance)
    }
}