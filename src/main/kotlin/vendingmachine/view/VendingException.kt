package vendingmachine.view

const val ERROR = "[ERROR]"
const val NOT_NUMBER = "금액은 숫자여야합니다."
const val CAN_NOT_DIVIDE_10 = "10으로 나눴을 때 나머지가 없어야합니다."
const val IT_IS_UNDER_100 = "상품의 가격은 100 이상이여야 합니다."

class VendingException {
    fun isItNumber(number: String) {
        require(number.toIntOrNull() != null) { "$ERROR $NOT_NUMBER" }
    }

    fun isItHaveRemainder(number: Int) {
        require(number % 10 == 0) { "$ERROR $CAN_NOT_DIVIDE_10" }
    }


}
