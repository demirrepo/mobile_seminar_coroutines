package lab12

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
suspend fun task5() = coroutineScope {
    println("--- Task 5 ---")

    launch(Dispatchers.Default) {
        println("Default: " + Thread.currentThread().name)
    }.join()

    launch(Dispatchers.IO) {
        println("IO: " + Thread.currentThread().name)
    }.join()

    launch(Dispatchers.Unconfined) {
        println("Unconfined: " + Thread.currentThread().name)
    }.join()

    val single = newSingleThreadContext("MyThread")
    launch(single) {
        println("single before delay: " + Thread.currentThread().name)
        delay(50)
        println("single after delay: " + Thread.currentThread().name)
    }.join()
    single.close()

    launch {
        println("inherited: " + Thread.currentThread().name)
    }.join()
}