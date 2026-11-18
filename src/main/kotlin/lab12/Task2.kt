package lab12

import kotlinx.coroutines.*

private var calls = 0

suspend fun fetchName(): String? {
    delay(100)
    calls++
    return if (calls <= 2) null else "Ada"
}

suspend fun showUser(n: Int) {
    repeat(n) { i ->
        val name = fetchName()
        if (name != null) {
            println("User: $name")
            return
        }
        println("try ${i + 1} failed")
    }
    println("Server is down, show cached user")
}

suspend fun task2() {
    println("--- Task 2 ---")
    calls = 0
    showUser(3)

    calls = 0
    showUser(2)
}