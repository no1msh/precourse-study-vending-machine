package vendingmachine.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ProductTest {

    @Test
    fun `남은 돈 계산 테스트`() {
        val money = 3000
        val cider = Product("사이다", "1000", "20")
        assertThat(cider.calculate(money)).isEqualTo(2000)
    }
}