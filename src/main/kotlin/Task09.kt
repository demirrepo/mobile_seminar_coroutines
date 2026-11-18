
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun download(ms: Long): String {
    delay(ms)
    return "file-$ms"
}

fun main() = runBlocking<Unit> {
    val sizes = listOf(100L, 200L, 300L, 400L, 500L)

    val t1 = measureTimeMillis {
        val files = sizes.map { download(it) }
        println(files)
    }
    println("sequential: $t1 ms")

    val t2 = measureTimeMillis {
        val files = sizes.map { async { download(it) } }.awaitAll()
        println(files)
    }
    println("async awaitAll: $t2 ms")

    val t3 = measureTimeMillis {
        val files = sizes
            .map { async(start = CoroutineStart.LAZY) { download(it) } }
            .map { it.await() }
        println(files)
    }
    println("lazy async: $t3 ms")
}