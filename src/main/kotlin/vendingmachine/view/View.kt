package vendingmachine.view

import vendingmachine.Coin

object View {
    fun getVendingMachineMoney(): Int {
        UI.printRequestInputVendingMachineMoney()
        return InputView.inputVendingMachineMoney().toInt()
    }

    fun printVendingMachineHaveCoins(haveCoins: Map<Coin, Int>) {
        println()
        UI.printVendingMachineCoins()
        OutputView.printVendingMachineCoins(haveCoins)
    }

    fun getVendingMachineProduct(): String {
        println()
        UI.printRequestInputProduct()
        return InputView.inputVendingMachineProduct()
    }

    fun getUserInputMoney(): Int {
        println()
        UI.printRequestInputMoney()
        return InputView.inputUserInputMoney().toInt()
    }

    fun getProductToBuy(inputMoney: Int): String {
        println()
        OutputView.printRemainInputMoney(inputMoney)
        UI.printRequestInputProductToBuy()
        return InputView.inputUserInputProductToBuy()
    }

    fun printChange(inputMoney: Int , changeCoins : Map<Coin,Int>) {
        println()
        OutputView.printRemainInputMoney(inputMoney)
        println("잔돈")
        printChangeList(changeCoins)
    }

    private fun printChangeList (changeCoins : Map<Coin,Int>){
        val changeList = StringBuilder()
        for (changeCoin in changeCoins.keys){
            if (changeCoins[changeCoin]!! > 0){
                changeList.append("$changeCoin - ${changeCoins[changeCoin]}개\n")
            }
        }
        println(changeList.toString())
    }

}