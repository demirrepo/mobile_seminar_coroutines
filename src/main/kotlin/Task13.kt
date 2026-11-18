
import kotlinx.coroutines.*

class FakeViewModel {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    fun load() {
        scope.launch {
            repeat(3) { i ->
                delay(200)
                println("step ${i + 1}")
            }
        }
    }

    fun onCleared() {
        println("onCleared")
        scope.cancel()
    }
}

fun main() = runBlocking<Unit> {
    val vm = FakeViewModel()
    vm.load()
    delay(300)
    vm.onCleared()
    delay(1000)
}