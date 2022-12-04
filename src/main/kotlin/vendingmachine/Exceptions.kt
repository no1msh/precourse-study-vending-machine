package vendingmachine

class Exceptions {
    fun validateAdminInput(input: String) {
        val money = input.toIntOrNull()
        require(money != null) { throw IllegalArgumentException(WRONG_INPUT_TYPE_MESSAGE) }
        require(money >= 0) { throw IllegalArgumentException(WRONG_INPUT_RANGE_MESSAGE) }
        require(money % 10 == 0) { throw IllegalArgumentException(WRONG_INPUT_REST_MESSAGE) }
    }

    companion object {
        const val WRONG_INPUT_TYPE_MESSAGE = "투입금액은 숫자만 입력가능합니다."
        const val WRONG_INPUT_RANGE_MESSAGE = "투입금액은 0원 이상부터 가능합니다."
        const val WRONG_INPUT_REST_MESSAGE = "투입금액은 최소 10원단위가 가능합니다."
    }

}