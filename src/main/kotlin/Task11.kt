
import kotlinx.coroutines.*

suspend fun loadAndShow() {
    println("start on " + Thread.currentThread().name)

    val raw = withContext(Dispatchers.IO) {
        delay(100)
        println("read file on " + Thread.currentThread().name)
        "10,20,30"
    }

    val sum = withContext(Dispatchers.Default) {
        println("parse on " + Thread.currentThread().name)
        raw.split(",").sumOf { it.trim().toInt() }
    }

    println("show $sum on " + Thread.currentThread().name)
}

fun main() = runBlocking<Unit> {
    loadAndShow()
}