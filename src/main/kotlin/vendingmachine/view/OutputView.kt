package vendingmachine.view

class OutputView {
    fun requestInitialMoney() {
        println(REQUEST_ADMIN_MONEY_MESSAGE)
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e)
    }

    companion object {
        const val REQUEST_ADMIN_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요."
    }
}