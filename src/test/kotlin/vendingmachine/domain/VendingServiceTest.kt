package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import vendingmachine.Coin

internal class VendingServiceTest {

    private val vendingService = VendingService()

    @Test
    fun `자판기 보유 동전 생성 테스트`() {
        val money = 450
        var total = 0
        assertThat(
            vendingService.makeChanges(money).forEach { total += it.getAmount() }
        ).isEqualTo(450)
    }

    @Test
    fun `반환해야하는 잔돈 계산 테스트`() {
        val money = 300
        val coins = listOf<Coin>(
            Coin.COIN_100,
            Coin.COIN_100,
            Coin.COIN_100,
            Coin.COIN_100,
            Coin.COIN_50
        )
        assertThat(vendingService.returnChanges(money, coins)).isEqualTo(
            listOf<Coin>(
                Coin.COIN_100,
                Coin.COIN_100,
                Coin.COIN_100
            )
        )
    }
}