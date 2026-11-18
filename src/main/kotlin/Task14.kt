
import kotlinx.coroutines.*

fun main() = runBlocking<Unit> {
    launch(CoroutineName("A")) {
        repeat(3) {
            println("A $it")
            delay(300)
        }
    }
    launch(CoroutineName("B")) {
        repeat(3) {
            println("B $it")
            delay(500)
        }
    }
}