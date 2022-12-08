package vendingmachine.model.data.product

class ProductMap(products: List<Product>) {

    val totalStock: Int
        get() = products.values.sumOf { it.stock }

    val minPrice: Int
        get() = products.values.minOf { it.info.price }

    private val products: Map<String, Product> = buildProductMap(products)

    operator fun get(name: String): ProductInfo = products[name]!!.info

    operator fun contains(name: String): Boolean = products.containsKey(name)

    fun getPrice(name: String): Int = products[name]!!.info.price

    fun getStock(name: String): Int = products[name]!!.stock

    fun isExistsStockOf(name: String): Boolean = products[name]!!.isNotEmpty

    fun decreaseStockOf(name: String) {
        products[name]!!.decreaseStock()
    }

    private fun buildProductMap(products: List<Product>): Map<String, Product> = buildMap {
        for (product in products) {
            put(product.info.name, product)
        }
    }
}