package vendingmachine.view

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import vendingmachine.exceptions.ValidateUserInput

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = ["12a3", "", "dd", "12 3"])
    fun `유저의 입력이 숫자가 아닐 때 예외처리를 하는가?`(input: String) {
        assertThrows<IllegalArgumentException> {
            ValidateUserInput.validateInputOnlyNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["[콜라,ㅇㅇ,12][사이다"])
    fun `입력받은 상품 문자열이 올바른 형식이 아닐 때 예외 처리하는가?`(input : String) {
        assertThrows<IllegalArgumentException> {
            ValidateUserInput.validateInputProductForm(input)
        }
    }
}