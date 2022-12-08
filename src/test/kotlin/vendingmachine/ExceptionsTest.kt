package vendingmachine

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ExceptionsTest {
    private val exceptions = Exceptions()

    @ParameterizedTest
    @ValueSource(strings = ["five", "-1", "1235"])
    fun `관리자 금액 입력 오류 테스트`(input: String) {
        assertThrows<IllegalArgumentException> {
            exceptions.validateMoneyInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 중복이 존재하는 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","1000","10"), listOf("사이다","1500","20"), listOf("콜라","1500","20"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 가격이 숫자가 아닌 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","10o0","10"), listOf("사이다","1500","20"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 재고가 숫자가 아닌 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","1000","10"), listOf("사이다","1500","2o"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 가격이 100보다 작은 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","80","10"), listOf("사이다","1500","20"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 가격이 10원 단위가 아닌 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","1000","10"), listOf("사이다","1505","20"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }

    @Test
    fun `관리자 상품 입력 상품 재고가 0개 이하인 경우 오류 테스트`() {
        val input = mutableListOf(listOf("콜라","1000","10"), listOf("사이다","1500","0"))
        assertThrows<IllegalArgumentException> {
            exceptions.validateGoodsInput(input)
        }
    }
}