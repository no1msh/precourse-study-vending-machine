package vendingmachine.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTest {
    @Test
    fun `숫자가 아닌 값을 입력 했을 때 에러가 발생하는가?` () {
        assertThrows<IllegalArgumentException> {
//            InputView.inputVendingMachineMoney()
        }
    }

    @Test
    fun `입력받은 상품 문자열이 올바른 형식이 아닐 때 예외 처리하는가?`(){
        assertThrows<IllegalArgumentException> {
//            InputView.inputProduct()
        }
    }
}