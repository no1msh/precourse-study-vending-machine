package vendingmachine.view

import camp.nextstep.edu.missionutils.Console.readLine
import vendingmachine.Exceptions

class InputView {
    private val exceptions = Exceptions()

    fun getAdminMoney(): Int {
        val input = readLine()
        exceptions.validateAdminInput(input)
        return input.toInt()
    }

    fun getAdminGoods(): MutableList<List<String>> {
        val input = readLine()
        val products = input.split(";")
        var goods = mutableListOf<List<String>>()
        for (product in products) {
            goods.add(product.replace("[\\[\\]]".toRegex(),"").split(",").toMutableList())
        }
        exceptions.validateGoodsInput(goods)
        return goods
    }

}