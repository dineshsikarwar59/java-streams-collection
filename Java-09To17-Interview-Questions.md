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

  
