package vendingmachine

import vendingmachine.model.VendingMachineStock

class Exceptions {
    fun validateMoneyInput(input: String) {
        val money = input.toIntOrNull()
        require(money != null) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_TYPE_MESSAGE) }
        require(money >= 0) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_RANGE_MESSAGE) }
        require(money % 10 == 0) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_INPUT_REST_MESSAGE) }
    }

    fun validateGoodsInput(goods: MutableList<List<String>>) {
        val tmp = mutableListOf<String>()
        goods.forEach { tmp.add(it[0]) }
        require(tmp.distinct().size == tmp.size) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_GOODS_SIZE_MESSAGE) }
        require(goods.all { it[1].toIntOrNull() != null }) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_PRICE_TYPE_MESSAGE) }
        require(goods.all { it[2].toIntOrNull() != null }) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_STOCK_TYPE_MESSAGE) }
        require(goods.all { it[1].toInt() >= 100 }) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_PRICE_RANGE_MESSAGE) }
        require(goods.all { it[1].toInt() % 10 == 0 }) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_PRICE_INPUT_MESSAGE) }
        require(goods.all { it[2].toInt() > 0 }) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_STOCK_RANGE_MESSAGE) }
    }

    fun validateItemInput(input: String, stock: VendingMachineStock) {
        require(stock.isInStock(input)) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_ITEM_INPUT_MESSAGE) }
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR] "
        const val WRONG_INPUT_TYPE_MESSAGE = "투입금액은 숫자만 입력가능합니다."
        const val WRONG_INPUT_RANGE_MESSAGE = "투입금액은 0원 이상부터 가능합니다."
        const val WRONG_INPUT_REST_MESSAGE = "투입금액은 최소 10원단위가 가능합니다."
        const val WRONG_GOODS_SIZE_MESSAGE = "상품은 중복이 있으면 안됩니다."
        const val WRONG_PRICE_TYPE_MESSAGE = "상품 가격은 숫자만 입력가능합니다."
        const val WRONG_PRICE_RANGE_MESSAGE = "상품 가격은 100원 이상부터 가능합니다."
        const val WRONG_PRICE_INPUT_MESSAGE = "상품 가격은 10원 단위만 입력 가능합니다."
        const val WRONG_STOCK_TYPE_MESSAGE = "상품 재고는 숫자만 입력 가능합니다."
        const val WRONG_STOCK_RANGE_MESSAGE = "상품 재고는 1개 이상부터 가능합니다."
        const val WRONG_ITEM_INPUT_MESSAGE = "해당 상품은 존재하지 않습니다."
    }

}