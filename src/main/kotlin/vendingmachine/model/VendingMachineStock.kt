package vendingmachine.model

class VendingMachineStock {
    private var stock = mutableMapOf<String, Int>()
    private var price = mutableMapOf<String, Int>()

    fun putAdminGoods(goods: MutableList<List<String>>) {
        for (elem in goods) {
            price[elem[0]] = elem[1].toInt()
            stock[elem[0]] = elem[2].toInt()
        }
    }

    fun isInStock(item: String): Boolean {
        if (item in stock.keys)
            return true
        return false
    }
}