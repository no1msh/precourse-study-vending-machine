package vendingmachine.exceptions

object ValidateUserInput {
    private const val PREFIX = "[ERROR] "

    fun validateInputOnlyNumber(input: String) {
        require(input.matches("^\\d*\$".toRegex())){ PREFIX + "숫자로 입력해주세요."}
    }
}