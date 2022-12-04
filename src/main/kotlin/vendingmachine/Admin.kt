package vendingmachine

import vendingmachine.view.View

class Admin {
    private val view = View()

    fun putMoney() {
        val adminMoney = view.getAdminMoney()
    }
}