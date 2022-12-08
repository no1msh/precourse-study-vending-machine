package vendingmachine.ui.output

import vendingmachine.Coin

enum class GameMessages(private val message: String) {
    INPUT_HOLD_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요."),
    HOLD_MONEY("자판기가 보유한 동전"),
    COIN_500("500원 -"),
    COIN_100("100원 -"),
    COIN_50("50원 -"),
    COIN_10("10원 -"),
    INPUT_PRODUCT_INFO("상품명과 가격, 수량을 입력해 주세요."),
    INPUT_INSERT_MONEY("투입 금액을 입력해 주세요."),
    INSERT_MONEY("투입 금액:"),
    INPUT_PRODUCT_NAME("구매할 상품명을 입력해 주세요."),
    CHANGES("잔돈");

    override fun toString(): String = message
}

class OutputView {

    fun printInputChanges() = println(GameMessages.INPUT_HOLD_MONEY.toString())

    fun printInitialChanges(coins: List<Coin>) {
        val coin500 = coins.count { it == Coin.COIN_500 }
        val coin100 = coins.count { it == Coin.COIN_100 }
        val coin50 = coins.count { it == Coin.COIN_50 }
        val coin10 = coins.count { it == Coin.COIN_10 }
        println(GameMessages.HOLD_MONEY.toString())
        println("${GameMessages.COIN_500.toString()} ${coin500}개")
        println("${GameMessages.COIN_100.toString()} ${coin100}개")
        println("${GameMessages.COIN_50.toString()} ${coin50}개")
        println("${GameMessages.COIN_10.toString()} ${coin10}개")
    }

    fun printInputProductInfo() = println(GameMessages.INPUT_PRODUCT_INFO.toString())

    fun printInputInsertMoney() = println(GameMessages.INPUT_INSERT_MONEY.toString())

    fun printInsertMoney(insertMoney: Int) = println("${GameMessages.INSERT_MONEY.toString()} ${insertMoney}원")

    fun printInputProductName() {
        println(GameMessages.INPUT_PRODUCT_NAME.toString())
    }

    fun printChanges(coins: List<Coin?>) {
        val coin500 = coins.count { it == Coin.COIN_500 }
        val coin100 = coins.count { it == Coin.COIN_100 }
        val coin50 = coins.count { it == Coin.COIN_50 }
        val coin10 = coins.count { it == Coin.COIN_10 }
        println(GameMessages.CHANGES.toString())
        println("${GameMessages.COIN_500.toString()} ${coin500}개")
        println("${GameMessages.COIN_100.toString()} ${coin100}개")
        println("${GameMessages.COIN_50.toString()} ${coin50}개")
        println("${GameMessages.COIN_10.toString()} ${coin10}개")
    }

    fun printError(e: IllegalArgumentException) {
        println(e.message)
    }
}