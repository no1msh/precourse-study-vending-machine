package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun giveMeCoin():Int {
        val money= Console.readLine()


        return money.toInt()
    }
}
