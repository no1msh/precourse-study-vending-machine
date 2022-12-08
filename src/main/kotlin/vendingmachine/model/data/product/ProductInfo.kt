package vendingmachine.model.data.product

data class ProductInfo(
    val name: String,
    val price: Int,
) {

    init {
        require(name.isNotBlank()) { "Product's name is blank" }
        require(price in PRICE_MIN..PRICE_MAX) { "Invalid price range" }
    }

    companion object {
        const val PRICE_MIN = 100
        const val PRICE_MAX = 100_000
    }
}