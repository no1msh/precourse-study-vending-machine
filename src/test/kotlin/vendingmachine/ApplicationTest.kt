package vendingmachine

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import vendingmachine.model.CoinList
import vendingmachine.view.InputView
import vendingmachine.view.View
import java.io.ByteArrayInputStream

class ApplicationTest : NsTest() {

    @Test
    fun `기능_테스트`() {
        assertRandomNumberInListTest(
            {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다")
                assertThat(output()).contains(
                    "자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
                    "투입 금액: 3000원", "투입 금액: 1500원"
                )
            },
            100, 100, 100, 100, 50
        )
    }

    @Test
    fun `예외_테스트`() {
        assertSimpleTest {
            runException("-1")
            assertThat(output()).contains(ERROR_MESSAGE)
        }
    }

    override fun runMain() {
        main()
    }


    @Test
    fun `코인_생성_테스트`() {
        assertRandomNumberInListTest(
            {
                val coins = CoinList()
                coins.settingCoins(1150)
                assertThat(coins.getCoins()).isEqualTo(mutableListOf(2, 1, 1, 0))

            }, 500, 100, 500, 50
        )
    }

    @Test
    fun `코인_상황_출력_테스트`() {
        assertSimpleTest {
            View().showChanges(mutableListOf(3, 2, 1, 4))

            assertThat(output()).contains(
                "자판기가 보유한 동전", "500원 - 3개", "100원 - 2개", "50원 - 1개", "10원 - 4개"
            )
        }
    }

    @Test
    fun `아이템 입력에 관한 테스트`() {
        assertSimpleTest {
            command("[콜라,1500,20];[사이다,1000,10]")
            assertThat(listOf(listOf("콜라", "1500", "20"), listOf("사이다", "1000", "10"))).isEqualTo(InputView().getItems())
        }

    }


    private fun command(vararg args: String) {
        val buf = java.lang.String.join("\n", *args).toByteArray()
        System.setIn(ByteArrayInputStream(buf))
    }

    companion object {
        private const val ERROR_MESSAGE = "[ERROR]"
    }
}
