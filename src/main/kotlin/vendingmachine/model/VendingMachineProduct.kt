package vendingmachine.model

class VendingMachineProduct(inputProducts: String) {

    private val productDB = mutableMapOf<String, Product>()

    init {
        val notWrappedProducts = inputProducts.split(";")
        for (notWrappedProduct in notWrappedProducts) {
            val processedProduct = trimBothSide(notWrappedProduct)
            wrapProduct(processedProduct)
        }
    }

    // 양 옆 대괄호 떼기
    private fun trimBothSide(notWrappedProduct: String): String {
        return notWrappedProduct.removeSurrounding("[", "]")
    }

    // Product 객체에 포장해서 productDB에 추가
    private fun wrapProduct(notProcessedProduct: String) {
        val productFeature = notProcessedProduct.split(",")
        val productName = productFeature[PRODUCT_NAME]
        productDB[productName] = Product(productFeature)
    }

    // 해당상품이 존재하는지 체크
    fun hasProduct(inputProductName: String): Boolean {
        return productDB.containsKey(inputProductName)
    }

    fun purchaseProduct(productName: String): Int {
        val product = productDB[productName]!!
        product.purchaseProduct()
        return product.getPrice()
    }

    fun isNotSoldOut(): Boolean {
        for (product in productDB.values) {
            if (product.getQuantity().canPurchase()) {
                return true
            }
        }
        return false
    }

    fun getMinimumPrice(): Int {
        var minimumPrice = Int.MAX_VALUE
        for (product in productDB.values) {
            if (product.getPrice() < minimumPrice) {
                minimumPrice = product.getPrice()
            }
        }
        return minimumPrice
    }

    companion object {
        const val PRODUCT_NAME = 0
    }

}