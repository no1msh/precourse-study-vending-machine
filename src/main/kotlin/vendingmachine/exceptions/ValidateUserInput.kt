package vendingmachine.exceptions

object ValidateUserInput {
    private const val PREFIX = "[ERROR] "

    fun validateInputOnlyNumber(input: String) {
        require(input.matches("^\\d*\$".toRegex())) { PREFIX + "숫자로 입력해주세요." }
        require(input.isNotBlank()) { PREFIX + "빈 값이 들어있습니다." }
    }

    fun validateInputProductForm(input: String) {
        val products = input.split(";")
        for (product in products) {
            require(product.isNotBlank()) { PREFIX + "빈 값이 들어있습니다." }
            require(validateInputProductFormBothSide(product)) { PREFIX + "대괄호를 이용해 상품 특성을 묶어주세요." }
            require(validateInputProductFormFeature(product)) { PREFIX + "상품명, 가격, 수량을 콤마(,)로 구분하여 입력해주세요." }
        }
    }

    private fun validateInputProductFormBothSide(product: String): Boolean {
        if (product[0] == '[' && product[product.length - 1] == ']') {
            return true
        }
        return false
    }

    private fun validateInputProductFormFeature(product: String): Boolean {
        val productFeature = product.split(",")
        if (productFeature.size == 3) {
            return true
        }
        return false
    }
}