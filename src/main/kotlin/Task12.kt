

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking<Unit> {
    val rows = mutableListOf<Pair<String, Long>>()

    rows += "runBlocking + delay" to measureTimeMillis {
        coroutineScope { repeat(4) { launch { delay(500) } } }
    }

    rows += "runBlocking + Thread.sleep" to measureTimeMillis {
        coroutineScope { repeat(4) { launch { Thread.sleep(500) } } }
    }

    rows += "Default + Thread.sleep" to measureTimeMillis {
        coroutineScope { repeat(4) { launch(Dispatchers.Default) { Thread.sleep(500) } } }
    }

    val single = newSingleThreadContext("one")
    rows += "singleThread + Thread.sleep" to measureTimeMillis {
        coroutineScope { repeat(4) { launch(single) { Thread.sleep(500) } } }
    }
    single.close()

    println("setup                        ms")
    rows.forEach { (name, ms) -> println(name.padEnd(28) + ms) }
    println("cores: " + Runtime.getRuntime().availableProcessors())
}