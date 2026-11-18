
import kotlinx.coroutines.*

fun Job.state() = "$isActive $isCompleted $isCancelled"

fun main() = runBlocking<Unit> {
    val job = launch(start = CoroutineStart.LAZY) {
        delay(500)
        println("body")
    }

    println("1: " + job.state())

    job.start()
    delay(100)
    println("2: " + job.state())

    job.cancel()
    println("3: " + job.state())

    job.join()
    println("4: " + job.state())
}