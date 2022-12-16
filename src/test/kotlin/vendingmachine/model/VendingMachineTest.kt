package vendingmachine.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInListTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import vendingmachine.main


class VendingMachineTest : NsTest() {

    private lateinit var vendingMachine: VendingMachine
    private lateinit var vendingMachineProduct: VendingMachineProduct

    @BeforeEach
    fun setUp() {
        vendingMachine = VendingMachine(420)
        vendingMachineProduct = VendingMachineProduct("[콜라,1500,20];[사이다,1000,10]")
    }

    @Test
    fun `자판기가 가진 동전의 합이 입력한 금액과 같은가?`() {
        assertThat(vendingMachine.getTotalCoinAmount()).isEqualTo(420)
    }

    @Test
    fun `자판기가 가진 동전을 제대로 반환 하는가?`() {
        assertRandomNumberInListTest(
            {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다")
                assertThat(output()).contains(
                    "자판기가 보유한 동전", "500원 - 0개", "100원 - 4개", "50원 - 1개", "10원 - 0개",
                )
            },
            100, 100, 100, 100, 50
        )
    }

    @Test
    fun `상품이 없을 때 남은 잔돈을 제대로 반환하는가?`() {
        assertRandomNumberInListTest(
            {
                run("1500", "[콜라,1500,1];[사이다,1000,1]", "4000", "콜라", "사이다")
                assertThat(output()).contains(
                    "잔돈", "500원 - 2개", "100원 - 4개"
                )
            },
            500, 500, 100, 100, 100, 100, 50, 10, 10, 10, 10, 10
        )
    }

    @Test
    fun `남은 금액이 상품가격 최소가격보다 낮은 경우 남은 잔돈을 제대로 반환하는가?`() {
        assertRandomNumberInListTest(
            {
                run("450", "[콜라,1500,20];[사이다,1000,10]", "3000", "콜라", "사이다")
                assertThat(output()).contains(
                    "투입 금액: 500원\n" +
                            "잔돈\n" +
                            "100원 - 4개\n" +
                            "50원 - 1개"
                )
            },
            100, 100, 100, 100, 50
        )
    }

    @Test
    fun `상품 가격이 10원 단위로 나누어 떨어지지 않으면 에러를 발생하는가?`() {
        assertThrows<IllegalArgumentException> {
            Product(listOf("콜라", "85", "10"))
        }
    }

    @Test
    fun `상품 가격이 100원 보다 아래로 입력되면 에러를 발생하는가?`() {
        assertThrows<IllegalArgumentException> {
            Product(listOf("콜라", "80", "10"))
        }
    }

    override fun runMain() {
        main()
    }

}