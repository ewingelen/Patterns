package decorator

//class MacBook(private val good: Good): Good {
//
//    override fun sum() = good.sum() + PRICE
//
//    override fun receipt() = "${good.receipt()} \n MacBook ..... $$PRICE"
//
//    private companion object {
//        const val PRICE = 2000
//    }
//}

class MacBook(good: Good): Good.Base(good, "MacBook", 2000)