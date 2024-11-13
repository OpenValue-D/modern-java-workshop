package de.openvalue.modernjava.kotlin.examples

import kotlinx.coroutines.*

// add a second async and await
fun main() = runBlocking {
    val data = async { fetchData() }
    println("Data received: ${data.await()}")
}

suspend fun fetchData(): String {
    delay(1000)
    return "Hello from Kotlin Coroutines!"
}