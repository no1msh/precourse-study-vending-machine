package vendingmachine.model.data.coin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.assertThrows
import vendingmachine.model.data.coin.Coin
import vendingmachine.model.data.coin.CoinExchanger
import vendingmachine.model.random.RandomGenerator

internal class CoinExchangerTest {

    @Test
    fun `동전교환테스트_성공1`() {
        val generator = NumberGeneratorForTest(listOf(10, 50, 100, 500))
        val exchanger = CoinExchanger(generator)

        val coinCounts = exchanger.exchange(660)
        assertThat(coinCounts[Coin.COIN_10]).isEqualTo(1)
        assertThat(coinCounts[Coin.COIN_50]).isEqualTo(1)
        assertThat(coinCounts[Coin.COIN_100]).isEqualTo(1)
        assertThat(coinCounts[Coin.COIN_500]).isEqualTo(1)
    }

    @Test
    fun `동전교환테스트_성공2`() {
        val generator = NumberGeneratorForTest(listOf(10, 50, 100, 500))
        val exchanger = CoinExchanger(generator)

        val coinCounts = exchanger.exchange(825)
        assertThat(coinCounts[Coin.COIN_10]).isEqualTo(2)
        assertThat(coinCounts[Coin.COIN_50]).isEqualTo(2)
        assertThat(coinCounts[Coin.COIN_100]).isEqualTo(2)
        assertThat(coinCounts[Coin.COIN_500]).isEqualTo(1)
    }

    @Test
    fun `동전교환테스트_예외`() {
        val generator = NumberGeneratorForTest(listOf(11))
        val exchanger = CoinExchanger(generator)

        assertThrows<NullPointerException> {
            exchanger.exchange(1000)
        }
    }

    class NumberGeneratorForTest(private val numbers: List<Int>) : RandomGenerator {

        private var index = -1

        override fun generate(): Int = numbers[++index % numbers.size]
    }
}