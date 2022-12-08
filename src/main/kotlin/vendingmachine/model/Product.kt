package vendingmachine.model

class Product(private val name: String, private val inputPrice: String, private val inputAmount: String) {

    private var price = 0
    private var amount = 0

    init {
        require(name.all { it.isLetter() }) { "[ERROR] 글자가 아닙니다." }
        require(inputPrice.all { it.isDigit() }) { "[ERROR] 숫자가 아닙니다." }
        require((inputPrice.toInt() >= 100) and (inputPrice.toInt() % 10 == 0)) { "[ERROR] 상품가격에 문제가 있습니다." }
        require(inputAmount.all { it.isDigit() }) { "[ERROR] 숫자가 아닙니다." }
        require(inputAmount.toInt() >= 0) { "[ERROR] 수량이 0보다 작습니다." }

        price = inputPrice.toInt()
        amount = inputAmount.toInt()
    }

    fun calculate(money: Int): Int {
        if (amount == 0) {
            return money
        }
        if (price > money) {
            return money
        }
        amount -= 1
        return money - price
    }
}