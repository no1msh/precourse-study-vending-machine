package vendingmachine.model.product

data class Product(
    val name: String,
    val price: Int,
    var count: Int,
) {
    init {
        require(price in PRICE_MIN..PRICE_MAX) { "invalid price range" }
        require(count in COUNT_MIN..COUNT_MAX) { "invalid count range" }
    }

    companion object {
        const val PRICE_MIN = 100
        const val PRICE_MAX = 100_000
        const val COUNT_MIN = 1
        const val COUNT_MAX = 100_000
    }
}