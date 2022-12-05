package vendingmachine.view

const val ERROR = "[ERROR]"
const val NOT_NUMBER_MONEY = "금액은 숫자여야합니다."
const val NOT_NUMBER_COUNT = "수량은 숫자여야합니다."
const val CAN_NOT_DIVIDE_10 = "10으로 나눴을 때 나머지가 없어야합니다."
const val IT_LOSE_SOMETHING = "누락된 사항이 있습니다."
const val IT_IS_UNDER_100 = "상품의 가격은 100 이상이여야 합니다."

class VendingException {
    fun isItNumber(number: String) {
        require(number.toIntOrNull() != null) { "$ERROR $NOT_NUMBER_MONEY" }
    }

    fun isItHaveRemainder(number: Int) {
        require(number % 10 == 0) { "$ERROR $CAN_NOT_DIVIDE_10" }
    }

    fun itemException(items: List<String>) {
        require(items.size == 3) { "$ERROR $IT_LOSE_SOMETHING" }
        require(items[1].toIntOrNull() != null) { "$ERROR $NOT_NUMBER_MONEY" }
        require(items[2].toIntOrNull() != null) { "$ERROR $NOT_NUMBER_COUNT" }
        require(items[1].toInt() >= 100) { "$ERROR $IT_IS_UNDER_100" }
        require(items[1].toInt() % 10 == 0) { "$ERROR $CAN_NOT_DIVIDE_10" }
    }


}
