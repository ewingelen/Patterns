package decorator

//class GooglePixel(private val good: Good): Good {
//
//    override fun sum() = good.sum() + PRICE
//
//    override fun receipt() = "${good.receipt()} \n Google Pixel ..... $$PRICE"
//
//    private companion object {
//        const val PRICE = 700
//    }
//}

class GooglePixel(good: Good): Good.Base(good, "Google Pixel", 700)