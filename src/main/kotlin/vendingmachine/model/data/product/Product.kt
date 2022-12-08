package vendingmachine.model.data.product

class Product(
    val info: ProductInfo,
    _stock: Int,
) {

    var stock: Int = _stock
        private set

    val isEmpty: Boolean
        get() = (stock == 0)

    val isNotEmpty: Boolean
        get() = !isEmpty

    init {
        require(_stock in STOCK_MIN..STOCK_MAX) { "Invalid stock range" }
    }

    fun increaseStock(count: Int) {
        stock += count
    }

    fun decreaseStock() {
        check(isNotEmpty) { "Product is empty" }
        stock -= 1
    }

    companion object {
        const val STOCK_MIN = 1
        const val STOCK_MAX = 100
    }
}