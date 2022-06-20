package decorator

interface Good {

    fun sum(): Int

    fun receipt(): String

    class Empty : Good {

        override fun sum() = 0

        override fun receipt() = "Receipt"
    }

    abstract class Base(
        private val good: Good,
        private val name: String,
        private val price: Int
    ) : Good {

        override fun sum() = good.sum() + price

        override fun receipt() = "${good.receipt()} \n $name ..... $$price"
    }
}