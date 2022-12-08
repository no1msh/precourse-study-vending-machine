package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import vendingmachine.model.Product

internal class SellingProductTest {
    private val cider = Product("사이다", "1000", "20")
    private val sellingProduct = SellingProduct(listOf(cider))


    @Test
    fun `해당 상품이 존재하는지 여부 테스트`() {
        val name = "사이다"
        assertThat(sellingProduct.find(name)).isEqualTo(cider)
    }
}