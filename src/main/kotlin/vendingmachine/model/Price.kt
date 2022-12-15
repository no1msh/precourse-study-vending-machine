package vendingmachine.model

import vendingmachine.exceptions.ValidateUserInput

class Price(private val price : String) {
    init {
        ValidateUserInput.validateInputOnlyNumber(price)
        require(price.toInt() >= 100){ PREFIX + "100원 부터 가능합니다."}
        require(price.toInt() % 10 == 0 ){ PREFIX + "10원으로 나누어 떨어져야합니다."}
    }

    fun getPrice() = price.toInt()

    companion object{
        private const val PREFIX = "[ERROR] "
    }
}