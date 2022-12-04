package vendingmachine.view

class View {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun getAdminMoney(): Int {
        outputView.requestInitialMoney()
        return try {
            inputView.getAdminMoney()
        } catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            getAdminMoney()
        }
    }
}