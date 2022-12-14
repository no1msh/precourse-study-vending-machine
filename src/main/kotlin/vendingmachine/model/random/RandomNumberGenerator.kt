package vendingmachine.model.random

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator(private val numbers: List<Int>) : RandomGenerator {
    override fun generate(): Int {
        return Randoms.pickNumberInList(numbers)
    }
}