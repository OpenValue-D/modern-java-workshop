package de.openvalue.modernjava.kotlin.examples

// Copy everything from ConvertingFromJava
class ConvertingIntoKotlin {
    fun main() {
        for (i in 0..99) {
            if (i % 5 == 0 && i % 7 == 0) {
                println("FizzBuzz")
            } else if (i % 5 == 0) {
                println("Fizz")
            } else if (i % 7 == 0) {
                println("Buzz")
            } else {
                println(i)
            }
        }
    }
}
