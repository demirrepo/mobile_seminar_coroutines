import kotlinx.coroutines.*

suspend fun main() {
    coroutineScope {
        launch {
            delay(300)
            println("A")
        }
        launch {
            delay(200)
            println("B")
        }
        launch {
            delay(100)
            println("C")
        }
        println("All launched")
    }
    println("Scope done")
}