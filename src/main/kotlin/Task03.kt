
import kotlinx.coroutines.*

fun CoroutineScope.launchTicker(name: String, period: Long, times: Int): Job = launch {
    repeat(times) { i ->
        delay(period)
        println("$name ${i + 1}")
    }
}

suspend fun main() {
    coroutineScope {
        launchTicker("fast", 100, 3)
        launchTicker("slow", 250, 2)
        println("Tickers launched")
    }
    println("Scope done")
}