
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    println("runBlocking: " + Thread.currentThread().name)

    launch(CoroutineName("worker-1")) {
        println("worker: " + Thread.currentThread().name)
    }
}