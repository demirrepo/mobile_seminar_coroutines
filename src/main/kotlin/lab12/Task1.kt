package lab12

import kotlinx.coroutines.*

suspend fun task1() = coroutineScope {
    println("--- Task 1 ---")
    launch {
        delay(200)
        println("A done")
    }
    launch {
        delay(100)
        println("B done")
    }
    println("Start")
}