
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val parent = launch {
        repeat(3) { i ->
            val k = i + 1
            launch {
                try {
                    delay(k * 100L)
                    println("child $k done")
                } catch (e: CancellationException) {
                    println("child $k cancelled")
                    throw e
                }
            }
        }
        println("parent body done")
    }

    delay(150)
    parent.cancelAndJoin()
    println("parent completed")
}