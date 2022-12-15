package vendingmachine.view

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import vendingmachine.Coin
import vendingmachine.main

class OutputViewTest : NsTest() {

    private val haveCoin = mutableMapOf<Coin, Int>()

    @Test
    fun `자판기가 보유한 동전을 제대로 출력하는가?`() {
        val inputMoney = "500원 - 1개\n100원 - 2개\n50원 - 3개\n10원 - 4개"
        initHaveCoin()
        OutputView.printVendingMachineCoins(haveCoin)
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }

    @Test
    fun `투입 금액을 제대로 출력하는가?`(inputMoney: String) {
//        OutputView.printInputMoney()
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }

    @Test
    fun `반환할 잔돈을 제대로 출력하는가?`(inputMoney: String) {
//        OutputView.printChange()
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }

    override fun runMain() {
        main()
    }

    private fun initHaveCoin() {
        haveCoin[Coin.COIN_500] = 1
        haveCoin[Coin.COIN_100] = 2
        haveCoin[Coin.COIN_50] = 3
        haveCoin[Coin.COIN_10] = 4
    }


}