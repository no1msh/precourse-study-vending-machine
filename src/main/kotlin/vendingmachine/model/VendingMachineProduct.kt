package vendingmachine.model

class VendingMachineProduct(inputProducts: String) {

    private val productDB = mutableListOf<Product>()

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
        productDB.add(Product(productFeature))
    }

}