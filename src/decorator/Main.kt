package decorator

/**
 * Декоратор — это структурный паттерн проектирования,
 * который позволяет динамически добавлять объектам новую функциональность,
 * оборачивая их в полезные «обёртки».
 */
fun main() {
    var good = buyMacbook(Good.Empty())
    good = buyIphone(good)
    good = buyGooglePixel(good)
    good = finishShopping(good)
    println(good.receipt())
}

fun buyMacbook(good: Good): Good = MacBook(good)

fun buyIphone(good: Good): Good = Iphone(good)

fun buyGooglePixel(good: Good): Good = GooglePixel(good)

fun finishShopping(good: Good) = Total(good)