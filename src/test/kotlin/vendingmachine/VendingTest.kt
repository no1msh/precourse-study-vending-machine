package vendingmachine

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest
import org.junit.jupiter.api.Test
import vendingmachine.model.CoinList


class VendingTest {

    @Test
    fun `코인 생성 테스트`() {
        assertRandomNumberInListTest(
            {
                val coins = CoinList()
                coins.settingCoins(1150)
                equals(mutableListOf(2, 1, 1, 0) == coins.getCoins())

            }, 500, 100, 500, 50
        )
    }

}
