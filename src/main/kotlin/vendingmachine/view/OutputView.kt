package vendingmachine.view

import vendingmachine.Coin

object OutputView {
    fun printVendingMachineCoins(haveCoins: Map<Coin, Int>) {
        val vendingMachineCoins = StringBuilder()
        vendingMachineCoins.append("500원 - ${haveCoins[Coin.COIN_500]}개\n")
        vendingMachineCoins.append("100원 - ${haveCoins[Coin.COIN_100]}개\n")
        vendingMachineCoins.append("50원 - ${haveCoins[Coin.COIN_50]}개\n")
        vendingMachineCoins.append("10원 - ${haveCoins[Coin.COIN_10]}개")
        println(vendingMachineCoins.toString())
    }
}