package vendingmachine.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import vendingmachine.main

class OutputViewTest : NsTest(){
    @Test
    fun `투입 금액을 제대로 출력하는가?`(inputMoney : String){
//        OutputView.printInputMoney()
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }

    @Test
    fun `자판기가 보유한 동전을 제대로 출력하는가?`(inputMoney : String){
//        OutputView.printVendingMachineCoins()
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }

    @Test
    fun `반환할 잔돈을 제대로 출력하는가?`(inputMoney : String){
//        OutputView.printChange()
        assertSimpleTest {
            Assertions.assertThat(output()).isEqualTo(inputMoney)
        }
    }
    override fun runMain() {
        main()
    }

}