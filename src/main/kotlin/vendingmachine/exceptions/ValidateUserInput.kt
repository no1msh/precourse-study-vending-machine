package vendingmachine.exceptions

object ValidateUserInput {
    private const val PREFIX = "[ERROR] "

    fun validateInputMoney(inputMoney: String) {
        require(inputMoney.matches("^\\d*\$".toRegex())){ PREFIX + "숫자로 입력해주세요."}
    }
}