package vendingmachine.model

class Product(
    productFeatures: List<String>
) {
    private val name = productFeatures[0]
    private var price = Price(productFeatures[1])
    private var quantity = Quantity(productFeatures[2])

    fun getName() = name
    fun getPrice() = price.getPrice()
    fun getQuantity() = quantity

    fun purchaseProduct(){
        this.quantity.purchase()
    }

}