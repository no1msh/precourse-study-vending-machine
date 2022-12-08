package vendingmachine.view

import vendingmachine.model.VendingMachineBalance

class OutputView {

    fun requestInitialMoney(isAdmin: Boolean) {
        if(isAdmin) {
            println(REQUEST_ADMIN_MONEY_MESSAGE)
        }
        if (!isAdmin) {
            println(REQUEST_BUYER_MONEY_MESSAGE)
        }
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e)
    }

    fun printBalance(balance: VendingMachineBalance, isResult: Boolean) {
        if (isResult) {
            println(REMAINING_MONEY_MESSAGE)
        }
        if (!isResult) {
            println(VENDING_MACHINE_BALANCE_MESSAGE)
        }
        println(balance.getBalance(isResult))
    }

    fun requestGoods() {
        println(REQUEST_GOODS_MESSAGE)
    }

    fun requestGoodsName() {
        println(REQUEST_GOODS_NAME_MESSAGE)
    }

    fun printRemainingMoney(buyerMoney: Int) {
        println(REMAINING_AMOUNT_MESSAGE + buyerMoney + WON_MESSAGE)
    }

    companion object {
        const val REQUEST_ADMIN_MONEY_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요."
        const val VENDING_MACHINE_BALANCE_MESSAGE = "자판기가 보유한 동전"
        const val REQUEST_GOODS_MESSAGE = "상품명과 가격, 수량을 입력해 주세요."
        const val REQUEST_BUYER_MONEY_MESSAGE = "투입 금액을 입력해 주세요."
        const val REMAINING_AMOUNT_MESSAGE = "투입 금액: "
        const val REMAINING_MONEY_MESSAGE = "잔돈"
        const val WON_MESSAGE = "원"
        const val REQUEST_GOODS_NAME_MESSAGE = "구매할 상품명을 입력해 주세요."
    }
}