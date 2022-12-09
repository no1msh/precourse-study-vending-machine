package vendingmachine.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class VendingMachineTest {

    @Test
    fun `자판기가 가진 동전의 합이 입력한 금액과 같은가?`(total: Int) {
//        assertThat().isEqualTo(total)
    }

    @Test
    fun `자판기가 가진 동전을 제대로 반환 하는가?`() {
//        assertThat().isEqualTo()
    }

    @Test
    fun `상품이 없을 때 남은 잔돈을 제대로 반환하는가?`() {

    }

    @Test
    fun `남은 금액이 상품가격 최소가격보다 낮은 경우 남은 잔돈을 제대로 반환하는가?`() {

    }

    @Test
    @ParameterizedTest
    @CsvSource("콜라,1500,20", "사이다,1000,10")
    fun `입력받은 상품 문자열을 제대로 다듬는가?` (productFeatures : String){
        val input = "[콜라,1500,20];[사이다,1000,10]"
        val products = input.split(";")
        for (product in products){
//            Product.trimBothSide(product).isEqualTo(productFeatures)
        }
    }

    @Test
    fun `상품 가격이 10원 단위로 나눠 떨어지는가?`() {

    }

    @Test
    fun `상품 가격이 10원 단위로 나누어 떨어지지 않으면 에러를 발생하는가?`() {
        assertThrows<IllegalArgumentException> {
//            Product()
        }
    }

    @Test
    fun `상품 가격이 100원 보다 아래로 입력되면 에러를 발생하는가?`() {
        assertThrows<IllegalArgumentException> {
//            Product()
        }
    }

}