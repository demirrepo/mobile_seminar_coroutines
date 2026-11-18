package lab12

import kotlinx.coroutines.*

suspend fun task3() = coroutineScope {
    println("--- Task 3 ---")
    val job = launch {
        try {
            repeat(5) {
                println("tick $it")
                delay(100)
            }
        } finally {
            println("cleanup")
        }
    }

    delay(250)
    job.cancelAndJoin()
    println("isCancelled=${job.isCancelled}")
}