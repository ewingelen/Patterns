package decorator

//class Iphone(private val good: Good): Good {
//
//    override fun sum() = good.sum() + PRICE
//
//    override fun receipt() = "${good.receipt()} \n Iphone ..... $$PRICE"
//
//    private companion object {
//        const val PRICE = 1000
//    }
//}

class Iphone(good: Good): Good.Base(good, "Iphone", 1000)