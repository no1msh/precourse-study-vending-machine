package vendingmachine.view

import camp.nextstep.edu.missionutils.Console.readLine
import vendingmachine.Exceptions
import vendingmachine.model.VendingMachineStock

class InputView {
    private val exceptions = Exceptions()

    fun getMoney(): Int {
        val input = readLine()
        exceptions.validateMoneyInput(input)
        return input.toInt()
    }

    fun getAdminGoods(): MutableList<List<String>> {
        val input = readLine()
        val products = input.split(";")
        var goods = mutableListOf<List<String>>()
        for (product in products) {
            goods.add(product.replace("[\\[\\]]".toRegex(), "").split(",").toMutableList())
        }
        exceptions.validateGoodsInput(goods)
        return goods
    }

    fun getBuyerGoods(stock: VendingMachineStock): String {
        val input = readLine()
        exceptions.validateItemInput(input, stock)
        return input
    }

}