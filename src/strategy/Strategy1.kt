package strategy

/**
 * Стратегия — это поведенческий паттерн проектирования,
 * который определяет семейство схожих алгоритмов
 * и помещает каждый из них в собственный класс,
 * после чего алгоритмы можно взаимозаменять прямо во время исполнения программы.
 */
interface Strategy {

    fun execute(a: Int, b: Int): Int
}

class ConcreteStrategyAdd: Strategy {

    override fun execute(a: Int, b: Int) = a + b
}

class ConcreteStrategySubtract: Strategy {

    override fun execute(a: Int, b: Int) = a - b
}

class Context(private var strategy: Strategy) {

    fun setStrategy(strategy: Strategy) {
        this.strategy = strategy
    }

    fun executeStrategy() = strategy.execute(2, 2)
}

fun main() {
    val context = Context(ConcreteStrategyAdd())
    println(context.executeStrategy())
    context.setStrategy(ConcreteStrategySubtract())
    println(context.executeStrategy())
}