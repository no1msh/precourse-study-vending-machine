package vendingmachine

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApplicationTest : NsTest() {


    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            runException("123")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
