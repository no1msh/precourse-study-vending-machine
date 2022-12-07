package vendingmachine.model

class Product(private val name: String, private val price: Int, private val amount: Int) {

    fun calculate(money: Int): Int {
        return 0
    }
}