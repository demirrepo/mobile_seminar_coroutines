package lab12

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun loadName(): String {
    delay(100)
    return "Ada"
}

suspend fun loadAge(): Int {
    delay(100)
    return 36
}

suspend fun task4() = coroutineScope {
    println("--- Task 4 ---")

    val t1 = measureTimeMillis {
        val name = loadName()
        val age = loadAge()
        println("$name $age")
    }
    println("sequential: $t1 ms")

    val t2 = measureTimeMillis {
        val name = async { loadName() }
        val age = async { loadAge() }
        println("${name.await()} ${age.await()}")
    }
    println("async then await: $t2 ms")

    val t3 = measureTimeMillis {
        val name = async { loadName() }.await()
        val age = async { loadAge() }.await()
        println("$name $age")
    }
    println("await immediately: $t3 ms")
}