package vendingmachine.view

const val GIMME_COIN = "자판기가 보유하고 있는 금액을 입력해 주세요."

class OutputView {
    fun giveMeCoin() {
        println(GIMME_COIN)
    }

}
