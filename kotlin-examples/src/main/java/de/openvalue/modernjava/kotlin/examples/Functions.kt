package de.openvalue.modernjava.kotlin.examples

// 1. use string templates
// 2. write the function with '=' instead of '{}'
// 3. let doSomething() return a String and put greet() as a parameter in it
fun main() {
    println(greet("Alice"))
    doSomething("Bob", ::println)
}

fun greet(name: String): String {
    return "Hello, " + name
}

fun doSomething(parameter: String, method: (parameter: String) -> Unit){
    method(parameter);
}