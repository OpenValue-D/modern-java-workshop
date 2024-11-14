# Modern Java Workshop
This is an application a librarian can use to track which books have been rented to which customer. When a book is returned the librarian can also use this application to track it.  
The inventory management is done from another system using a Rest-API.

The application is kind dated now and uses old Java features. It is your job to refactor this application using the latest Java features

Please be aware that some parts of the application are not considered best practice, especially the persistence part. This is due to being able to show the new Java features in a setting like this.

## Tasks

### 1. Examples

#### 1.1 Java
Go through the Java examples in the `java-examples` module and solve them to get used to the new features.

#### 1.2 Kotlin
Go through the Java examples in the `kotlin-examples` module and solve them to get used to the language.


### 2. Refactoring 

#### 2.1 Stream API
The application does not yet make use of the stream API. Use it where possible

<details>
<summary>Hint</summary>

Have a look int the `controller`, `mapper` and the `service` package

Search for all occurrences of `for` and `while` loops and iterators.
</details>

#### 2.2 Records
Use records where possible. 

<details>
<summary>Hint</summary>

You can change all the classes in the `dto` package.

Hibernate does not allow entities to be records.  
The class needs to be a not final bean with parameterless constructor.

more information:  
[Java Records – How to use them with Hibernate and JPA](https://thorben-janssen.com/java-records-hibernate-jpa/)  
[Java Records as Embeddables with Hibernate 6](https://thorben-janssen.com/java-records-embeddables-hibernate/)
</details>

#### 2.3. Text Blocks
Use text blocks where possible.

<details>
<summary>Hint</summary>

The main use case is SQL-Queries and JSONs.  
Have a look in the `repository` package and in the tests.
</details>

#### 2.4 Switch-Statements
The new features Pattern Matching for instanceof, Switch Expressions and Pattern Matching for Switch can be used together in this example application.

Is it possible to use Record Patterns?  
If not make a comment to the switch statement.

<details>
<summary>Hint</summary>

Search for all occurrences of the `instanceof` operator.
</details>

### 3. Development

#### 3.1 new feature: late fees API

The application is also used to collect fees for returning a book too late. Another system needs to use this data.  
Your task is to write an endpoint which returns the collected amount for a given date range.

Steps:
- write a Rest endpoint which accepts a date range and returns the amount of collected fees
  - use validation to ensure there is actually a date interval
  - test the endpoint
- the fees for returning something too late are the following
  - book, less than one week too late: 2€
  - book, more than one week too late: 3€
  - audiobook, less than one week too late: 4€
  - audiobook, more than one week too late: 6€
- you should only calculate the fees from returned books and audiobooks

#### 3.1 new feature: late fees UI

When returning something in the UI the late fees should be displayed in an intermediate step before it is actually returned.  
Use the specified fees from the former step.