
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    try {
        coroutineScope {
            launch {
                try {
                    delay(1000)
                    println("A done")
                } catch (e: CancellationException) {
                    println("A cancelled")
                    throw e
                }
            }
            launch {
                try {
                    delay(300)
                    println("B done")
                } catch (e: CancellationException) {
                    println("B cancelled")
                    throw e
                }
            }
            launch {
                delay(200)
                throw IllegalStateException("boom")
            }
        }
    } catch (e: IllegalStateException) {
        println("caught: ${e.message}")
    }
}