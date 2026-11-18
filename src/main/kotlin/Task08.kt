
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch {
        try {
            repeat(10) { delay(100) }
        } finally {
            println("cleanup start")
            withContext(NonCancellable) {
                delay(100)
                println("draft saved")
            }
        }
    }

    delay(250)
    job.cancelAndJoin()
    println("done")
}