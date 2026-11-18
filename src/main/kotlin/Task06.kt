
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    val job = launch(Dispatchers.Default) {
        repeat(5) {
            ensureActive()
            Thread.sleep(100)
            println("work $it")
            Thread.sleep(100)
            println("work $it")
        }
    }

    delay(250)
    job.cancelAndJoin()
    println("done")
}