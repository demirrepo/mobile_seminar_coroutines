

import kotlinx.coroutines.*
import java.io.IOException
import kotlin.system.measureTimeMillis

data class Dashboard(val weather: String?, val news: String?, val rates: String?)

suspend fun loadDashboard(): Dashboard = coroutineScope {
    val weather = async<String?>(Dispatchers.IO) {
        withTimeoutOrNull(450) {
            try {
                delay(300)
                "Sunny"
            } finally {
                println("weather stopped")
            }
        }
    }

    val news = async<String?>(Dispatchers.IO) {
        withTimeoutOrNull(450) {
            try {
                delay(600)
                "Headlines"
            } finally {
                println("news stopped")
            }
        }
    }

    val rates = async<String?>(Dispatchers.IO) {
        try {
            withTimeoutOrNull(450) {
                delay(100)
                throw IOException("rates down")
            }
        } catch (e: IOException) {
            null
        }
    }

    Dashboard(weather.await(), news.await(), rates.await())
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val d = loadDashboard()
        println("weather=${d.weather}, news=${d.news}, rates=${d.rates}")
    }
    println("time $time ms")
}