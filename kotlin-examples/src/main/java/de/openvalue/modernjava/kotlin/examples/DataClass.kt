package de.openvalue.modernjava.kotlin.examples

// turn this into a data class and show difference
class DataClass (val x: Int, var y: Int){
}

fun main() {
    val data = DataClass(1, 2)
    println(data.toString())

    data.y = 1
    println(data.y)
}