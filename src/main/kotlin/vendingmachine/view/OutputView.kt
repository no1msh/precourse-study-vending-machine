package vendingmachine.view

import vendingmachine.VendingMachineBalance
import java.lang.StringBuilder

class OutputView {

    fun requestInitialMoney() {
        println(REQUEST_ADMIN_MONEY_MESSAGE)
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e)
    }

    fun printBalance(balance: VendingMachineBalance) {

        println(VENDING_MACHINE_BALANCE_MESSAGE)
        println(balance.getBalance())
    }

    fun requestGoods() {
        println(REQUEST_GOODS_MESSAGE)
    }

    companion object {
        const val REQUEST_ADMIN_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요."
        const val VENDING_MACHINE_BALANCE_MESSAGE = "자판기가 보유한 동전"
        const val REQUEST_GOODS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요."
    }
}