---
marp: true
title: Modern Java Workshop
description: Modern Java Workshop
theme: uncover
paginate: true
_paginate: false
header: "**Jens Knipper** Modern Java Workshop"
footer: "![image height:32px](images/logos/openvalue.png)"
---

## Introduction to Kotlin
![image height:100px](images/logos/kotlin.png)

---
### What is Kotlin?
- open source
- initial release: 2011, stable: 2016
- developed by JetBrains
- statically-typed programming language 
- compiled to Java bytecode
  - runs on the JVM
- official language for Android development

---
### Why Kotlin for Java Developers?
- designed to be more concise, expressive, and safe compared to Java. 
- smooth learning curve for Java developers due to its similarity
- reduces boilerplate code
- modern features: null safety, higher-order functions, smart casts, etc
- full interoperability with Java
  - can call Kotlin code from Java and vice versa.

---
### Why Kotlin for Java Developers?
- BUT: 
  - Java caught up with features - a little different syntax
  - additional features might make it harder to read for beginners 

---
#### Null Safety
- Kotlin has built-in null safety
  - `?` for nullable types 
  - `?.` for safe calls
- the compiler helps you prevent NullPointerExceptions
- you can disable the null safety using `!!`

---
#### Null Safety - Example
Java:
``` java
String name = null;
if (name != null) {
  name.length();
}
```
Kotlin:
``` kotlin
val name: String? = null
name?.length
```

---
#### Elvis Operator
- Elvis operator to provide default value if null
- safe call `?.` and the Elvis operator `?:` are concise ways to deal with nullable types.

---
#### Elvis Operator - Example
``` kotlin
val name: String? = null
println(name?.length ?: "Unknown") 
```
- Showcase: [NullSafety.kt](../kotlin-examples/src/main/java/de/openvalue/modernjava/kotlin/examples/NullSafety.kt)

---
#### Classes
- public by default
- open keyword is used to mark a class as inheritable
    - by default, all classes in Kotlin are final
- Kotlin uses primary constructors directly in the class header
- properties should be accessed directly
- `get` and `set` method are generated during compilation
- `new` keyword not needed for instantiation

---
#### Classes - Example
Java:
``` java
public class Person {
  String name;
  public Person(String name) {
    this.name = name;
  }
}
```
Kotlin:
``` kotlin
open class Person(val name: String)
```

---
#### Data Classes
- automatically generate equals(), hashCode(), toString(), and other utility methods
- similar to records in Java, but Java records are immutable
- use `@JvmRecord` to compile to Java record

---
#### Data Classes - Example
``` kotlin
data class Person(val name: String, val age: Int)
```
- Showcase: [DataClass.kt](../kotlin-examples/src/main/java/de/openvalue/modernjava/kotlin/examples/DataClass.kt)

---
#### Functions
- functions are defined using the fun keyword.
- Kotlin allows type inference, so the return type and parameters can often be omitted
- `void` if return type omitted
- function as method parameter possible

---
#### Functions - Example
Java:
``` java
public String greet(String name) {
  return "Hello, " + name;
}
```
Kotlin:
``` kotlin
fun greet(name: String): String {
  return "Hello, $name"
}
```
- Showcase: [Functions.kt](../kotlin-examples/src/main/java/de/openvalue/modernjava/kotlin/examples/Functions.kt)

---
#### Coroutines
- write asynchronous, non-blocking code
- more lightweight than traditional threads
- following structured concurrency principles
  - control flow constructs that have clear entry and exit points
  - making code easier to read and debug

---
#### Coroutines
- useful for tasks like network requests, file I/O, or heavy computations
- implemented using lightweight continuations and suspendable functions
- higher abstraction than threads, can run e.g. on virtual threads

---
#### Coroutines - Example
``` kotlin
runBlocking {
    val data = async { fetchData() }
    println(data.await())
}
```
- Showcase: [Coroutines.kt](../kotlin-examples/src/main/java/de/openvalue/modernjava/kotlin/examples/Coroutines.kt)

---
#### Functional Programming
- older than Java's functional API
- supports lambda expressions and allows passing functions as parameters (forEach {}).
- `it` keyword refers to the current element in a lambda expression (similar to this in Java).
- no `stream` unlike in Java

---
#### Functional Programming - Example
Java:
``` java
List<String> names = List.of("Alice", "Bob", "Charlie");
names.stream().map(String::toLowerCase).forEach(System.out::println);
```
Kotlin:
``` kotlin
val names = listOf("Alice", "Bob", "Charlie")
names.map { it.lowercase() }.forEach { println(it) }
```

---
#### Extension Functions
- Java does not support extension functions directly 
  - create utility classes
- Kotlin allows to add new functions to existing classes via extension functions

``` kotlin
fun String.printWithStars() {
  println("*** $this ***")
}

"Hello".printWithStars()
```

 ---
### Resources and more
- Kotlin documentation: https://kotlinlang.org/docs/home.html
- [Roman Elizarov: Coroutines and Loom behind the scenes](https://www.youtube.com/watch?v=zluKcazgkV4)
