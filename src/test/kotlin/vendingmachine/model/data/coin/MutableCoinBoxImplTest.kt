package vendingmachine.model.data.coin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MutableCoinBoxImplTest {

    @Test
    fun addAll() {

    }

    @Test
    fun add() {
    }

    @Test
    fun remove() {
    }

    @Test
    fun `takeOf_1`() {
        val coinBox: MutableCoinBox = MutableCoinBoxImpl()
        coinBox[Coin.COIN_500] = 2
        coinBox[Coin.COIN_100] = 2
        coinBox[Coin.COIN_50] = 2
        coinBox[Coin.COIN_10] = 2

        val changeCoins: CoinBox = coinBox.takeOf(660)
        assertThat(changeCoins[Coin.COIN_500]).isEqualTo(1)
        assertThat(changeCoins[Coin.COIN_100]).isEqualTo(1)
        assertThat(changeCoins[Coin.COIN_50]).isEqualTo(1)
        assertThat(changeCoins[Coin.COIN_10]).isEqualTo(1)
    }

    @Test
    fun `takeOf_2`() {
        val coinBox: MutableCoinBox = MutableCoinBoxImpl()
        coinBox[Coin.COIN_500] = 2
        coinBox[Coin.COIN_100] = 2
        coinBox[Coin.COIN_50] = 2
        coinBox[Coin.COIN_10] = 2

        val changeCoins: CoinBox = coinBox.takeOf(500)
        assertThat(changeCoins[Coin.COIN_500]).isEqualTo(1)
        assertThat(changeCoins[Coin.COIN_100]).isEqualTo(0)
        assertThat(changeCoins[Coin.COIN_50]).isEqualTo(0)
        assertThat(changeCoins[Coin.COIN_10]).isEqualTo(0)
    }

    @Test
    fun `takeOf_3`() {
        val coinBox: MutableCoinBox = MutableCoinBoxImpl()
        coinBox[Coin.COIN_500] = 2
        coinBox[Coin.COIN_100] = 2
        coinBox[Coin.COIN_50] = 2
        coinBox[Coin.COIN_10] = 2

        val changeCoins: CoinBox = coinBox.takeOf(690)
        assertThat(listOf(
            changeCoins[Coin.COIN_500],
            changeCoins[Coin.COIN_100],
            changeCoins[Coin.COIN_50],
            changeCoins[Coin.COIN_10],
        ))
            .containsExactly(1, 1, 1, 2)
    }

    @Test
    operator fun iterator() {
    }

    private fun mutableCoinBox(vararg counts: Int): MutableCoinBoxImpl {
        val coins = Coin.values()
        val coinBox = MutableCoinBoxImpl()

        for ((i, count) in counts.withIndex()) {
            coinBox.add(coins[i], count)
        }

        return coinBox
    }
}