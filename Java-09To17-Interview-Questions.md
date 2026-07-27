# Java 9 Interview Questions

## 1. What are the major features introduced in Java 9?

### Answer:

Major Java 9 features include:

- **Java Platform Module System (JPMS)**
- **JShell (Java REPL)**
- **Private methods in interfaces**
- **Collection factory methods**
- **Stream API enhancements**
- **Optional class enhancements**
- **Improved Process API**
- **HTTP/2 Client API (incubating)**

-------------
-------------


## 2. What is the Java Module System (JPMS)?

### Answer:

The **Java Module System (JPMS)** allows developers to divide applications into independent modules with explicit dependencies.

A module:

- Groups related packages
- Defines dependencies
- Improves encapsulation
- Reduces application size

### Example:

**module-info.java**

```java
module com.example.app {
    requires java.sql;
    exports com.example.service;
}
```

-----------------
----------------


## 4. What are the benefits of Java Modules?

### Answer:

Benefits of Java Modules include:

- **Strong encapsulation**
- **Better security**
- **Smaller runtime images**
- **Improved dependency management**
- **Better application organization**

-------------------------
----------------------------



## 5. What is JShell in Java 9?

### Answer:

**JShell** is an interactive command-line tool introduced in Java 9 that allows developers to execute Java code without creating classes or methods.

### Example:

```text
jshell> int x = 10;
jshell> System.out.println(x);
10
```


------------------
------------------


## 6. Can interfaces have private methods in Java 9?

### Answer:

Yes. **Java 9 introduced private methods inside interfaces** to reuse common logic between default methods.

### Example:

```java
interface Vehicle {

    default void start() {
        checkEngine();
        System.out.println("Started");
    }

    private void checkEngine() {
        System.out.println("Checking engine");
    }
}
```

-------------------------
-------------------------


## 7. What are collection factory methods in Java 9?

### Answer:

Java 9 introduced **convenient factory methods** to create immutable collections easily.

### Example:

```java
List<String> names = List.of("John", "Mike");

Set<Integer> numbers = Set.of(1, 2, 3);

Map<Integer, String> map = Map.of(
    1, "Java",
    2, "Spring"
);
```

---------------
----------------

## 8. Difference between Arrays.asList() and List.of()

### Answer:

| Arrays.asList() | List.of() |
|-----------------|-----------|
| Mutable elements | Immutable |
| Allows null values | Does not allow null values |
| Can update existing elements | Cannot modify |

----------
-----------


## 9. What are Stream API enhancements in Java 9?

### Answer:

Java 9 introduced new methods in the Stream API:

### 1. `takeWhile()`

```java
list.stream()
    .takeWhile(x -> x < 5);
```
Takes elements from the stream until the condition fails.
Stops processing as soon as the predicate returns false.

Example:
```java
List<Integer> list = List.of(1, 2, 3, 6, 7);

list.stream()
    .takeWhile(x -> x < 5)
    .forEach(System.out::println);
```
Output:
```text
1
2
3
```
**2. dropWhile()**
``java
list.stream()
    .dropWhile(x -> x < 5);
```
Drops elements from the stream until the condition fails.
After the first failure, remaining elements are processed.

Example:
```java
List<Integer> list = List.of(1, 2, 3, 6, 7);

list.stream()
    .dropWhile(x -> x < 5)
    .forEach(System.out::println);
```
Output:
```text
6
7
```

**3. iterate()**
```java
Stream.iterate(1, i -> i < 10, i -> i + 1);
```
Enhanced version of Stream.iterate() introduced in Java 9.
Allows adding a termination condition.

Example:
```java
Stream.iterate(1, i -> i < 10, i -> i + 1)
      .forEach(System.out::println);
```
Output:
```text
1
2
3
4
5
6
7
8
9
```

---------------
----------------

# Java 10 Interview Questions

## 10. What was introduced in Java 10?

### Answer:

Main features introduced in Java 10:

- **Local Variable Type Inference (`var`)**
  - Allows developers to declare local variables without explicitly specifying the data type.
  - The compiler automatically infers the type based on the assigned value.

  Example:
  ```java
  var message = "Hello Java 10";
  // Compiler infers: String message
  ```
  
- **Application Class Data Sharing (AppCDS)**
  - Improved Class Data Sharing (CDS) to allow application classes to be stored and shared.
  - Helps reduce startup time and memory usage.

- **Garbage Collector Improvements**
   - Introduced improvements to garbage collection performance.
   - Added the ability to use different garbage collectors as per application requirements.

  ----------
  ----------


  ## 11. What is var in Java 10?

**Answer:**

`var` allows local variable type inference. The compiler determines the variable type automatically.

**Example:**

```java
var name = "Java";
var number = 100;
```
**The compiler automatically infers:**

```java
String name = "Java";
int number = 100;
```

----------------
-----------------

## 12. Where can var be used?

**Answer:**

`var` can be used only for local variables where the compiler can infer the type.

**Allowed:**

```java
var list = new ArrayList<String>();
```

**Not allowed:**
```java
var x;
var method(var value);
var result = null;
```

--------------
--------------

## 13. Is Java dynamically typed because of var?

**Answer:**

No. Java remains statically typed.

The compiler determines the variable type at compile time.

**Example:**

```java
var value = "Hello";
```


----------
---------

# Java 11 Interview Questions

## 14. What are the major features of Java 11?

**Answer:**

Major features of Java 11 include:

- Standard HTTP Client API
- String methods enhancements
- Local variable syntax improvements
- Java Flight Recorder
- Removed Java EE and CORBA modules

-----------
----------

## 15. What new String methods were introduced in Java 11?

**Answer:**

Java 11 introduced several new `String` methods:

### 1. isBlank()

Checks whether a string is empty or contains only whitespace.

```java
" ".isBlank();
// true
```

**2. lines()**

Returns a stream of lines from a string.
```java
"Java\nSpring".lines();
```

**3. strip()**

Removes leading and trailing whitespace (Unicode-aware).
```java
" Java ".strip();
```

**4. repeat()**

Repeats a string the specified number of times.
```java
"Java".repeat(3);
```
Output:
```text
JavaJavaJava
```

----------------
-----------------


## 16. Difference between trim() and strip()?

| trim() | strip() |
|--------|---------|
| Removes ASCII spaces | Supports Unicode whitespace |
| Older method | Java 11 feature |

------------
------------


## 17. What is the HTTP Client API in Java 11?

**Answer:**

Java 11 introduced a standard HTTP Client API that supports HTTP/1.1 and HTTP/2.

**Example:**

```java
HttpClient client =
    HttpClient.newHttpClient();

HttpRequest request =
    HttpRequest.newBuilder()
    .uri(URI.create("https://example.com"))
    .build();
```

----------------
---------------


## 18. What are Local Variable Syntax Improvements in Java 11?

**Answer:**

Java 10 introduced local variable type inference using the `var` keyword.

### Java 10:
```java
var message = new String("Hello");
```
The compiler automatically infers the variable type as String.

### Java 11 Improvements:

Java 11 allows the use of var in lambda expression parameters.

Example:
```java
(var x, var y) -> x + y
```
This allows developers to use annotations with lambda parameters while maintaining consistent syntax.

------------------
-----------------



# Java 12 Interview Questions

## 19. What features were introduced in Java 12?

**Answer:**

- Switch expressions (preview)
- JVM Constants API
- Shenandoah Garbage Collector (experimental)

-------------------------
------------------------

## 20. What are Switch Expressions?

**Answer:**

Switch expressions are an enhancement introduced in Java 12 (preview) that allow `switch` statements to return values. They provide a more concise syntax and reduce boilerplate code.

### Traditional switch:

```java
String day;

switch(number){
    case 1:
        day = "Monday";
        break;
}
```

**Java 12+ Switch Expression:**
```java
String day = switch(number) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Invalid";
};
```

-----------------------------
---------------------------


# Java 13 Interview Questions

## 21. What is Text Block?

**Answer:**

Text blocks are a feature introduced in Java 15 (preview in Java 13 and Java 14) that allow developers to write multi-line string literals without using escape characters like `\n` and `\"`.

### Example:

```java
String json = """
{
 "name":"Java"
}
""";
```

--------------
----------------

# Java 14 Interview Questions

## 22. What are Records in Java?

**Answer:**

Records are a compact way to create immutable data classes. They were introduced in Java 14 as a preview feature and became a standard feature in Java 16.

### Example:

```java
record Employee(
    int id,
    String name
){}
```
**The compiler automatically creates:**

- Constructor
- Getter methods (accessor methods)
- equals()
- hashCode()
- toString()

-------------
---------------

## 23. Difference between Record and Class?

| Record | Class |
|--------|-------|
| Immutable by default | Mutable possible |
| Less boilerplate code | Requires more code |
| Used for data objects | General purpose usage |
| Automatically provides constructor, accessors, `equals()`, `hashCode()`, and `toString()` | Developers need to define these methods when required |

-------------------
------------------


## 24. What is Pattern Matching for instanceof?

**Answer:**

Pattern Matching for `instanceof` is a feature introduced in Java 16 that simplifies type checking and casting by combining both operations into a single step.

### Before Java 16:

```java
if(obj instanceof String){
    String s = (String)obj;
}
```

**Java 16+:**
```java
if(obj instanceof String s){
    System.out.println(s.length());
}
```
**Benefits:**

`Reduces explicit type casting
`Makes code shorter and more readable
`Improves type safety

---------------------
----------------------


# Java 15 Interview Questions

## 25. What are Sealed Classes?

**Answer:**

Sealed classes are a feature introduced in Java 17 that restrict which classes can extend or implement them. They provide better control over inheritance by allowing only specified classes to be part of the hierarchy.

### Example:

```java
public sealed class Shape
    permits Circle, Rectangle {
}
```
**Benefits:**

- Controls class inheritance
- Improves security and maintainability
- Makes class hierarchies more predictable

---------------
---------------

## 26. Why use Sealed Classes?

**Answer:**

Sealed classes provide better control over inheritance by restricting which classes can extend or implement a class.

Benefits:

- Better inheritance control
- Improved security
- Easier maintenance
- Supports pattern matching

------------
-----------

# Java 16 Interview Questions

## 27. What features became permanent in Java 16?

**Answer:**

The following features became permanent (standard) features in Java 16:

- Records
- Pattern Matching for `instanceof`
- Unix Domain Sockets
- `Stream.toList()`


----------------
----------------

## 28. Difference between Collectors.toList() and Stream.toList()?

| Collectors.toList() | Stream.toList() |
|---------------------|------------------|
| Mutable list possible | Immutable list |
| Older approach | Java 16 feature |
| Part of `Collectors` utility class | Direct method available on Stream API |

### Example:

```java
List<String> list = stream.toList();
```

---------------
----------------


# Java 17 Interview Questions

## 29. What are the major features of Java 17?

**Answer:**

Java 17 is a Long-Term Support (LTS) release that introduced several important language, JVM, and security improvements.

### Features:

- Sealed Classes finalized
- Pattern matching improvements
- Strong encapsulation
- Enhanced pseudo-random number generators
- Removal of Security Manager
- Context-specific deserialization filters

---------------------
--------------------

## 31. Explain Sealed Classes in Java 17.

**Answer:**

Sealed classes are a feature finalized in Java 17 that allow developers to control inheritance by specifying which classes or interfaces are allowed to extend or implement them.

They improve code security, maintainability, and make class hierarchies more predictable.

### Example:

```java
sealed interface Payment
    permits CardPayment, CashPayment {
}

final class CardPayment implements Payment {}

final class CashPayment implements Payment {}
```

**In this example:**

- Payment is a sealed interface.
- Only CardPayment and CashPayment are permitted to implement it.
- Other classes cannot implement Payment directly.


----------
-----------

## 32. What is Pattern Matching for Switch in Java 17?

**Answer:**

Pattern Matching for `switch` is a preview feature introduced in Java 17 that allows `switch` expressions and statements to match objects based on their type and extract values directly into variables. It reduces the need for explicit type checks and manual type casting.

### Example (Preview in Java 17):

```java
Object obj = 100;

switch (obj) {
    case Integer i -> System.out.println("Integer: " + i);
    case String s -> System.out.println("String: " + s);
    default -> System.out.println("Unknown type");
}
```
**Explanation:**

- Integer i checks whether obj is an Integer and automatically casts it to variable i.
- String s checks whether obj is a String and automatically casts it to variable s.
- It makes code cleaner compared to using instanceof followed by manual casting.

**Note:**
Pattern Matching for switch was a preview feature in Java 17 and became a standard feature later in Java 21.


-----------------
--------------

## 33. What is the difference between Java 8 and Java 17?

**Answer:**

Java 8 and Java 17 are both important Java releases, but they introduced different features. Java 8 focused on functional programming improvements, while Java 17 added modern language features, better security, and JVM enhancements.

| Java 8 | Java 17 |
|--------|---------|
| Lambda expressions | Records |
| Streams API | Sealed Classes |
| Optional | Pattern Matching |
| Default methods | Modules |
| Old Date and Time API improvements | Improved JVM performance and features |
| Functional programming support | Modern language enhancements |

---------------
------------------


