package vendingmachine.model.repository

import vendingmachine.model.data.coin.Coin
import vendingmachine.model.data.coin.CoinBox
import vendingmachine.model.data.coin.MutableCoinBoxImpl
import vendingmachine.model.data.coin.CoinExchanger
import vendingmachine.model.data.product.Product
import vendingmachine.model.data.product.ProductInfo
import vendingmachine.model.data.product.ProductMap
import vendingmachine.model.random.RandomNumberGenerator
import vendingmachine.model.repository.Result.Success
import vendingmachine.model.repository.Result.Failure

class VendingMachineRepository {

    val minPrice: Int
        get() = products.minPrice

    val totalStock: Int
        get() = products.totalStock

    private val _coinBox: MutableCoinBoxImpl = MutableCoinBoxImpl()
    val coinBox: CoinBox
        get() = _coinBox

    private lateinit var products: ProductMap

    fun makeCoins(money: Int) {
        val coinBox = CoinExchanger(RandomNumberGenerator(Coin.Amounts))
            .exchange(money)

        _coinBox.addAll(coinBox)
    }

    fun setProducts(products: List<Product>) {
        this.products = ProductMap(products)
    }

    fun buyProduct(productName: String, money: Int): Result<ProductInfo> = when {
        !checkExistsProduct(productName) -> Failure(Error.NotExists)
        !checkProductStock(productName) -> Failure(Error.OutOfStock)
        !checkPrice(productName, money) -> Failure(Error.InsufficientBalance)
        else -> {
            products.decreaseStockOf(productName)

            Success(products[productName])
        }
    }

    private fun checkExistsProduct(name: String): Boolean {
        return name in products
    }

    private fun checkProductStock(productName: String): Boolean {
        return products.isExistsStockOf(productName)
    }

    private fun checkPrice(productName: String, money: Int): Boolean {
        return products.getPrice(productName) <= money
    }

    fun getChangeCoins(money: Int): CoinBox {
        return coinBox.takeOf(money)
    }
}