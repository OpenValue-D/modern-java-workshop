package de.openvalue.modernjava.kotlin.examples

fun main() {
    // 1. remove the ? and show what happens
    // 2. use !! operator
    // 3. use the elvis operator to set a default
    val map = mapOf(
        1 to "A",
        2 to "B",
        3 to "C"
    )
    print(map[4]?.lowercase());
}
