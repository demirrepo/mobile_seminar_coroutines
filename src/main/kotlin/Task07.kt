
import kotlinx.coroutines.*

suspend fun fetchPrice(): Int {
    delay(500)
    return 42
}

fun main() = runBlocking<Unit> {
    val a = withTimeoutOrNull(300) { fetchPrice() }
    if (a == null) println("timeout, show cached price") else println("price=$a")

    val b = withTimeoutOrNull(800) { fetchPrice() }
    if (b == null) println("timeout, show cached price") else println("price=$b")

    try {
        val c = withTimeout(300) { fetchPrice() }
        println("price=$c")
    } catch (e: TimeoutCancellationException) {
        println("timeout caught")
    }
}