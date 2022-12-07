package vendingmachine.ui.input

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class InputViewTest {

    private val inputView = InputView()

    @ParameterizedTest
    @CsvSource(DIGIT_EXCEPTION, REMAINDER_EXCEPTION)
    fun `자판기 보유 금액 입력 테스트`(money: String) {
        assertThrows<IllegalArgumentException> { inputView.readHoldMoney(money) }
    }

    @ParameterizedTest
    @CsvSource(FORMAT_EXCEPTION, ORDER_EXCEPTION, PRODUCT_EXCEPTION)
    fun `상품 정보 입력 테스트`(product: String) {
        assertThrows<IllegalArgumentException> { inputView.readProduct(product) }
    }

    @ParameterizedTest
    @CsvSource(DIGIT_EXCEPTION, REMAINDER_EXCEPTION)
    fun `투입 금액 입력 테스트`(money: String) {
        assertThrows<IllegalArgumentException> { inputView.readInsertMoney(money) }
    }

    @Test
    fun `구매할 상품명 입력 테스트`() {
        assertThrows<IllegalArgumentException> { inputView.readProductName(DIGIT_EXCEPTION) }
    }

    companion object {
        private const val DIGIT_EXCEPTION = "10aa"
        private const val REMAINDER_EXCEPTION = "111"

        private const val FORMAT_EXCEPTION = "[콜라,1500,20][사이다,1000,10]"
        private const val ORDER_EXCEPTION = "[1500,콜라,20];[사이다,1000,10]"
        private const val PRODUCT_EXCEPTION = "[콜라,1501,20];[사이다,1000,10]"
    }
}