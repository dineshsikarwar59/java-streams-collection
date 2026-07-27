# Java 8 Interview Questions

## 1. What are the main features introduced in Java 8?

- **Lambda Expressions** – Enable functional programming by allowing methods to be treated as expressions.
- **Functional Interfaces** – Interfaces with a single abstract method (e.g., `Runnable`, `Comparator`).
- **Stream API** – Supports functional-style operations on collections, such as filtering, mapping, and reducing.
- **Default and Static Methods in Interfaces** – Allow interfaces to provide method implementations without breaking existing code.
- **Method References** – A shorthand syntax for referring to methods using `::`.
- **Optional Class** – Helps avoid `NullPointerException` by representing optional values.
- **New Date and Time API (`java.time`)** – Introduces immutable and thread-safe date/time classes like `LocalDate`, `LocalTime`, and `LocalDateTime`.
- **CompletableFuture** – Simplifies asynchronous programming and supports non-blocking operations.
- **Nashorn JavaScript Engine** – Enabled execution of JavaScript code within Java applications (deprecated in later Java versions and removed in Java 15).

------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------

## 2. What is a Lambda Expression?

A **Lambda Expression** is an anonymous function introduced in Java 8 that provides a concise way to implement **functional interfaces** (interfaces with a single abstract method). It reduces boilerplate code and makes programs more readable.

### Syntax
```java
(parameters) -> expression
```

or

```java
(parameters) -> {
    // method body
}
```

### Example

```java
List<String> names = Arrays.asList("John", "Alice");

names.forEach(name -> System.out.println(name));
```

**Output:**
```
John
Alice
```

### Benefits
- Reduces boilerplate code.
- Improves code readability.
- Enables functional programming in Java.
- Works seamlessly with the Stream API.

------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------

## 3. What is a Functional Interface?

A **Functional Interface** is an interface that contains **exactly one abstract method**. It is the foundation of **Lambda Expressions** in Java 8. A functional interface can have multiple **default** and **static** methods, but only one abstract method.

The `@FunctionalInterface` annotation is optional but recommended because it ensures the interface remains functional at compile time.

### Common Functional Interfaces

- `Runnable`
- `Callable`
- `Comparator`
- `Consumer`
- `Supplier`
- `Predicate`
- `Function`

### Custom Example

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

### Using Lambda Expression

```java
Calculator calculator = (a, b) -> a + b;

System.out.println(calculator.add(10, 20));
```

**Output:**
```
30
```

### Key Points

- Contains **exactly one abstract method**.
- Can have multiple **default** and **static** methods.
- Can be implemented using **Lambda Expressions** or **Method References**.
- `@FunctionalInterface` helps prevent accidental addition of extra abstract methods.
- Widely used in the **Stream API** and Java's functional programming features.

--------------------------------------------
-------------------------------------------

## 4. What is the `@FunctionalInterface` Annotation?

The `@FunctionalInterface` annotation is used to indicate that an interface is intended to be a **functional interface**. It ensures that the interface contains **exactly one abstract method**. If more than one abstract method is declared, the compiler generates an error.

Although this annotation is **optional**, it is recommended because it provides compile-time validation and improves code readability.

### Example

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

### Invalid Example

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
    int subtract(int a, int b); // Compilation Error
}
```

### Key Points

- Ensures the interface has **only one abstract method**.
- Provides **compile-time checking**.
- Allows **default** and **static** methods in addition to the single abstract method.
- Commonly used with **Lambda Expressions** and **Method References**.
- Improves code readability and maintainability.


------------------------------------------------------
------------------------------------------------------

## 5. What are Method References?

**Method References** are a shorthand syntax for **Lambda Expressions** that refer directly to an existing method. They improve code readability by eliminating unnecessary lambda expressions when a method already exists.

The method reference operator is `::`.

### Types of Method References

1. **Static Method Reference**
   ```java
   ClassName::staticMethod
   ```

2. **Instance Method Reference**
   ```java
   object::instanceMethod
   ```

3. **Constructor Reference**
   ```java
   ClassName::new
   ```

### Example

```java
List<String> list = Arrays.asList("Java", "Python", "C++");

list.forEach(System.out::println);
```

**Output:**
```
Java
Python
C++
```

### More Examples

#### Static Method Reference

```java
Function<String, Integer> parser = Integer::parseInt;

System.out.println(parser.apply("100"));
```

**Output:**
```
100
```

#### Constructor Reference

```java
Supplier<List<String>> listSupplier = ArrayList::new;

List<String> names = listSupplier.get();
```

### Key Points

- Uses the `::` operator.
- Provides a concise alternative to lambda expressions.
- Improves code readability and maintainability.
- Can reference **static methods**, **instance methods**, and **constructors**.
- Commonly used with the **Stream API** and functional interfaces.


----------------------
-----------------------

## 6. What is the Stream API?

The **Stream API**, introduced in **Java 8**, provides a functional approach to processing collections of data. It allows operations such as **filtering, mapping, sorting, and reducing** without modifying the original collection.

A **Stream** does not store data; it processes data from a source (such as a collection or array) and produces a result.

### Example

```java
List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25);

List<Integer> result = numbers.stream()
                              .filter(n -> n > 10)
                              .collect(Collectors.toList());

System.out.println(result);
```

**Output:**
```
[15, 20, 25]
```

### Common Stream Operations

- **filter()** – Selects elements based on a condition.
- **map()** – Transforms each element.
- **sorted()** – Sorts the elements.
- **distinct()** – Removes duplicate elements.
- **limit()** – Limits the number of elements.
- **skip()** – Skips a specified number of elements.
- **forEach()** – Performs an action on each element.
- **collect()** – Collects the result into a collection or another data structure.
- **reduce()** – Combines elements into a single result.

### Another Example

```java
List<String> names = Arrays.asList("John", "Alice", "Bob");

names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println);
```

**Output:**
```
JOHN
ALICE
BOB
```

### Key Points

- Introduced in **Java 8** for functional-style programming.
- Does **not modify** the original collection.
- Supports **lazy evaluation**, improving performance.
- Enables **parallel processing** using `parallelStream()`.
- Makes collection processing more concise and readable.

------------
------------

## 7. Difference Between Collection and Stream

A **Collection** is used to **store and manage data**, whereas a **Stream** is used to **process data** in a functional and declarative manner. Streams do not store elements; they operate on data from collections, arrays, or other data sources.

### Collection vs Stream

| Collection | Stream |
|------------|--------|
| Stores data | Processes data |
| Can iterate multiple times | Can be consumed only once |
| Supports add, remove, and update operations | Read-only processing; does not modify the source |
| Eager evaluation | Lazy evaluation |
| Available since Java 1.2 | Introduced in Java 8 |
| Uses external iteration (`for`, `foreach`) | Uses internal iteration |
| Suitable for storing and managing objects | Suitable for filtering, mapping, sorting, and aggregating data |

### Collection Example

```java
List<String> names = new ArrayList<>();
names.add("John");
names.add("Alice");

for (String name : names) {
    System.out.println(name);
}
```

### Stream Example

```java
List<String> names = Arrays.asList("John", "Alice", "Bob");

names.stream()
     .filter(name -> name.startsWith("A"))
     .forEach(System.out::println);
```

**Output:**
```
Alice
```

### Key Points

- **Collection** stores and manages data in memory.
- **Stream** processes data without modifying the original collection.
- A **Stream** can be traversed only **once**.
- Stream operations are **lazy**, executing only when a terminal operation (such as `collect()` or `forEach()`) is invoked.
- Streams support functional programming with operations like `filter()`, `map()`, `sorted()`, and `reduce()`.


--------------------
--------------------

## 8. Intermediate vs Terminal Operations

Stream operations are divided into **Intermediate Operations** and **Terminal Operations**.

- **Intermediate Operations** return a new stream and are **lazy**, meaning they are executed only when a terminal operation is invoked.
- **Terminal Operations** produce the final result or a side effect and **terminate** the stream.

### Intermediate Operations

| Operation | Description |
|-----------|-------------|
| `filter()` | Filters elements based on a condition. |
| `map()` | Transforms each element into another form. |
| `sorted()` | Sorts the elements. |
| `distinct()` | Removes duplicate elements. |
| `limit()` | Limits the number of elements in the stream. |
| `skip()` | Skips the specified number of elements. |

### Terminal Operations

| Operation | Description |
|-----------|-------------|
| `collect()` | Collects elements into a collection or another data structure. |
| `forEach()` | Performs an action on each element. |
| `count()` | Returns the number of elements in the stream. |
| `reduce()` | Combines elements into a single result. |
| `findFirst()` | Returns the first element, if present. |
| `anyMatch()` | Checks if any element matches the given condition. |
| `allMatch()` | Checks if all elements match the given condition. |

### Example

```java
List<String> names = Arrays.asList("John", "Alice", "Bob", "Alex");

List<String> result = names.stream()      // Create Stream
                           .filter(name -> name.startsWith("A")) // Intermediate
                           .map(String::toUpperCase)             // Intermediate
                           .sorted()                             // Intermediate
                           .collect(Collectors.toList());        // Terminal

System.out.println(result);
```

**Output:**
```
[ALEX, ALICE]
```

### Key Differences

| Intermediate Operations | Terminal Operations |
|-------------------------|---------------------|
| Return a new `Stream` | Return a result or produce a side effect |
| Lazy evaluation | Trigger stream execution |
| Can be chained | End the stream pipeline |
| Examples: `filter()`, `map()`, `sorted()`, `distinct()`, `limit()` | Examples: `collect()`, `forEach()`, `count()`, `reduce()`, `findFirst()` |

### Key Points

- Intermediate operations are **lazy** and do not execute immediately.
- A stream can have **multiple intermediate operations** but **only one terminal operation**.
- Without a terminal operation, intermediate operations are **not executed**.
- After a terminal operation is called, the stream **cannot be reused**.


-----------------
-----------------

## 9. What is Lazy Evaluation?

**Lazy Evaluation** means that **intermediate stream operations are not executed immediately**. They are executed only when a **terminal operation** is called.

This approach improves performance by avoiding unnecessary processing and allows Java to optimize the execution of stream operations.

### Example

```java
List<Integer> result = numbers.stream()
                              .filter(n -> n > 5)   // Intermediate operation
                              .map(n -> n * 2)      // Intermediate operation
                              .collect(Collectors.toList()); // Terminal operation
```

### Execution Flow

1. `stream()` creates a stream from the collection.
2. `filter()` and `map()` are stored as operations but are not executed immediately.
3. `collect()` triggers the execution of all previous operations.
4. The final result is collected into a list.

### Key Points

- Intermediate operations are **lazy**.
- Execution starts only after a **terminal operation** is invoked.
- Helps improve performance by processing only required elements.
- Enables operation chaining in Stream API.
- A stream pipeline is executed only once.

### Example Without Terminal Operation

```java
numbers.stream()
       .filter(n -> n > 5)
       .map(n -> n * 2);
```

In this case, `filter()` and `map()` are **not executed** because there is no terminal operation.

-------------------------------------
-------------------------------------

## 10. What is `map()`?

The **`map()`** method is an intermediate operation in the **Stream API** that is used to **transform each element** of a stream into another form.

It applies a given function to every element and returns a new stream containing the transformed elements.

### Syntax

```java
stream.map(function)
```

### Example

```java
List<String> names = Arrays.asList("john", "alice", "bob");

List<String> upper = names.stream()
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());

System.out.println(upper);
```

**Output:**
```
[JOHN, ALICE, BOB]
```

### Another Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

List<Integer> squares = numbers.stream()
                               .map(n -> n * n)
                               .collect(Collectors.toList());

System.out.println(squares);
```

**Output:**
```
[1, 4, 9, 16]
```

### Key Points

- `map()` is an **intermediate operation**.
- It transforms each element of a stream.
- It returns a **new Stream**.
- It does not modify the original collection.
- Commonly used for data conversion and transformation.
- Works with Lambda Expressions and Method References.

-------------------------------------------------------
-------------------------------------------------------

## 11. Difference Between `map()` and `flatMap()`

Both **`map()`** and **`flatMap()`** are intermediate operations in the Stream API used for transforming data, but they differ in how they handle the output.

### `map()`

- Performs a **one-to-one transformation**.
- One input element produces **one output element**.
- Returns a stream containing the transformed elements.

### Example

```java
List<String> names = Arrays.asList("john", "alice", "bob");

List<String> upper = names.stream()
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());

System.out.println(upper);
```

**Output:**
```
[JOHN, ALICE, BOB]
```

---

### `flatMap()`

- Performs a **one-to-many transformation**.
- One input element can produce **multiple output elements**.
- Flattens nested streams into a single stream.

### Example

```java
List<List<String>> list = Arrays.asList(
        Arrays.asList("Java", "Python"),
        Arrays.asList("Spring", "Hibernate")
);

List<String> result = list.stream()
                          .flatMap(Collection::stream)
                          .collect(Collectors.toList());

System.out.println(result);
```

**Output:**
```
[Java, Python, Spring, Hibernate]
```

### Difference Between `map()` and `flatMap()`

| `map()` | `flatMap()` |
|---------|-------------|
| One input → One output | One input → Multiple outputs |
| Used for transformation | Used for transformation and flattening |
| Returns a stream of transformed elements | Returns a flattened stream |
| Does not flatten nested structures | Flattens nested collections or streams |
| Example: Convert names to uppercase | Example: Convert `List<List<T>>` to `List<T>` |

### Example Comparison

```java
// Using map()
List<List<String>> result1 = list.stream()
                                 .map(Collection::stream)
                                 .collect(Collectors.toList());
```

Output:
```
[List.stream(), List.stream()]
```

```java
// Using flatMap()
List<String> result2 = list.stream()
                           .flatMap(Collection::stream)
                           .collect(Collectors.toList());
```

Output:
```
[Java, Python, Spring, Hibernate]
```

### Key Points

- Use **`map()`** when each element needs to be converted into exactly one element.
- Use **`flatMap()`** when each element can produce multiple elements and you need a single flattened stream.
- `flatMap()` is commonly used with nested collections, optional values, and streams.


-------------------------------
-------------------------------

## 12. What is `filter()`?

The **`filter()`** method is an intermediate operation in the **Stream API** that is used to **filter elements based on a given condition**. It keeps only the elements that match the specified predicate and removes the remaining elements.

### Syntax

```java
stream.filter(condition)
```

### Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());

System.out.println(evenNumbers);
```

**Output:**
```
[2, 4, 6]
```

### Another Example

```java
List<String> names = Arrays.asList("John", "Alice", "Bob", "Alex");

List<String> result = names.stream()
                           .filter(name -> name.startsWith("A"))
                           .collect(Collectors.toList());

System.out.println(result);
```

**Output:**
```
[Alice, Alex]
```

### Key Points

- `filter()` is an **intermediate operation**.
- It uses a **Predicate functional interface**.
- It returns a new Stream containing only matching elements.
- It does not modify the original collection.
- Multiple `filter()` operations can be chained.
- Commonly used for selecting required data from collections.


-----------------------
-----------------------

## 13. What is `reduce()`?

The **`reduce()`** method is a terminal operation in the **Stream API** that is used to **combine all elements of a stream into a single result**. It performs a repeated operation, such as addition, multiplication, finding the maximum, or concatenation.

### Syntax

```java
stream.reduce(identity, accumulator)
```

- **Identity** – The initial value.
- **Accumulator** – A function that combines two values.

### Example: Sum of Numbers

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

int sum = numbers.stream()
                 .reduce(0, Integer::sum);

System.out.println(sum);
```

**Output:**
```
15
```

### How It Works

```
Initial value: 0

0 + 1 = 1
1 + 2 = 3
3 + 3 = 6
6 + 4 = 10
10 + 5 = 15
```

### Another Example: Find Maximum Value

```java
List<Integer> numbers = Arrays.asList(10, 25, 5, 40);

int max = numbers.stream()
                 .reduce(Integer::max)
                 .get();

System.out.println(max);
```

**Output:**
```
40
```

### Key Points

- `reduce()` is a **terminal operation**.
- It combines stream elements into a **single result**.
- Commonly used for sum, product, minimum, maximum, and string concatenation.
- It does not modify the original collection.
- Supports functional programming by using Lambda Expressions or Method References.
- Can be used with parallel streams when the reduction operation is associative.


------------------
------------------

## 14. Difference Between `findFirst()` and `findAny()`

Both **`findFirst()`** and **`findAny()`** are terminal operations in the **Stream API** used to retrieve an element from a stream.

### `findFirst()`

- Returns the **first element** of the stream.
- Maintains the encounter order of elements.
- Useful when the order of elements matters.
- Works consistently with both sequential and parallel streams.

### Example

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

Optional<Integer> first = numbers.stream()
                                 .findFirst();

System.out.println(first.get());
```

**Output:**
```
10
```

---

### `findAny()`

- Returns **any element** from the stream.
- Does not guarantee which element will be returned.
- Useful with **parallel streams** because it allows better performance by returning any available element.

### Example

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

Optional<Integer> any = numbers.parallelStream()
                               .findAny();

System.out.println(any.get());
```

**Possible Output:**
```
10
```

or

```
30
```

or any other element.

---

### Difference Between `findFirst()` and `findAny()`

| `findFirst()` | `findAny()` |
|---------------|-------------|
| Returns the first element | Returns any available element |
| Maintains encounter order | Does not guarantee order |
| Preferred when order matters | Preferred for better performance in parallel streams |
| More predictable | Less predictable |
| May be slower in parallel execution | Can be faster in parallel execution |

### Key Points

- Both methods return an **`Optional<T>`**.
- Both are **terminal operations**.
- Use `findFirst()` when you need a specific first element.
- Use `findAny()` when any matching element is sufficient, especially with parallel streams.


--------------------
--------------------

## 15. What is `Optional`?

**`Optional`** is a container class introduced in **Java 8** that may or may not contain a value. It is used to represent the presence or absence of a value and helps reduce the chances of **`NullPointerException`**.

Instead of returning `null`, methods can return an `Optional` object, making null handling more explicit and safer.

### Example

```java
Optional<String> name = Optional.of("Java");

System.out.println(name.get());
```

**Output:**
```
Java
```

### Creating Optional Objects

#### 1. `Optional.of()`

Used when the value is guaranteed to be non-null.

```java
Optional<String> value = Optional.of("Hello");
```

#### 2. `Optional.ofNullable()`

Used when the value may be null.

```java
String name = null;

Optional<String> value = Optional.ofNullable(name);
```

#### 3. `Optional.empty()`

Creates an empty Optional object.

```java
Optional<String> value = Optional.empty();
```

### Common Optional Methods

| Method | Description |
|--------|-------------|
| `isPresent()` | Checks whether a value exists |
| `ifPresent()` | Executes an action if a value exists |
| `orElse()` | Returns a default value if empty |
| `orElseGet()` | Returns a value using a supplier if empty |
| `orElseThrow()` | Throws an exception if empty |
| `get()` | Retrieves the value (throws exception if empty) |

### Example Using `orElse()`

```java
Optional<String> name = Optional.ofNullable(null);

System.out.println(name.orElse("Default Name"));
```

**Output:**
```
Default Name
```

### Key Points

- Introduced in **Java 8**.
- Helps avoid direct `null` checks.
- Reduces the risk of `NullPointerException`.
- Represents either a value or an empty state.
- Commonly used as a return type for methods that may not always have a result.
- Should not generally be used for class fields or method parameters.

-----------------------
-----------------------

## 16. Difference Between `Optional.of()` and `Optional.ofNullable()`

Both **`Optional.of()`** and **`Optional.ofNullable()`** are used to create `Optional` objects, but they handle `null` values differently.

### `Optional.of()`

- Used when the value is **guaranteed to be non-null**.
- Throws a **`NullPointerException`** if the provided value is `null`.

### Example

```java
Optional<String> name = Optional.of("Java");

System.out.println(name.get());
```

**Output:**
```
Java
```

If the value is null:

```java
String value = null;

Optional<String> name = Optional.of(value);
```

**Result:**
```
NullPointerException
```

---

### `Optional.ofNullable()`

- Used when the value **may be null**.
- Returns an empty `Optional` if the value is `null`.
- Does not throw an exception.

### Example

```java
String value = null;

Optional<String> name = Optional.ofNullable(value);

System.out.println(name.isPresent());
```

**Output:**
```
false
```

---

### Difference Between `Optional.of()` and `Optional.ofNullable()`

| `Optional.of()` | `Optional.ofNullable()` |
|-----------------|-------------------------|
| Does not accept `null` values | Accepts `null` values |
| Throws `NullPointerException` if value is null | Returns `Optional.empty()` if value is null |
| Used when value is always available | Used when value may or may not be available |
| Safer when null is impossible | Safer for uncertain values |

### Key Points

- Use `Optional.of()` when you are certain the value is not null.
- Use `Optional.ofNullable()` when handling values that may be null.
- `Optional.ofNullable()` is more commonly used when receiving data from external sources like databases or APIs.


----------------------------
----------------------------

## 17. What is a Default Method?

A **Default Method** is a method with an implementation inside an interface. It was introduced in **Java 8** to allow interfaces to add new methods without breaking the existing classes that implement them.

Default methods are declared using the **`default`** keyword.

### Example

```java
interface Demo {
    default void display() {
        System.out.println("Hello");
    }
}

class Test implements Demo {
    public static void main(String[] args) {
        Test obj = new Test();
        obj.display();
    }
}
```

**Output:**
```
Hello
```

### Key Points

- Introduced in **Java 8**.
- Allows interfaces to contain method implementations.
- Declared using the `default` keyword.
- Helps maintain backward compatibility when adding new methods to interfaces.
- Implementing classes can use the default implementation or override it.
- Interfaces can have multiple default methods.
- If a class implements multiple interfaces with the same default method, it must override the method to resolve the conflict.

### Example of Overriding Default Method

```java
interface Demo {
    default void display() {
        System.out.println("Default Display");
    }
}

class Test implements Demo {
    @Override
    public void display() {
        System.out.println("Custom Display");
    }
}
```

**Output:**
```
Custom Display
```

------------------------
-----------------------

## 18. What is a Static Method in an Interface?

A **Static Method in an Interface** is a method that belongs to the interface itself rather than to the implementing classes. It was introduced in **Java 8** to allow interfaces to contain utility methods with their own implementation.

Static methods are declared using the **`static`** keyword and can be called directly using the **interface name**.

### Example

```java
interface Demo {
    static void show() {
        System.out.println("Static");
    }
}
```

### Calling Static Method

```java
Demo.show();
```

**Output:**
```
Static
```

### Key Points

- Introduced in **Java 8**.
- Static methods belong to the interface, not implementing classes.
- Called using the **interface name**.
- Cannot be overridden by implementing classes.
- Can contain method implementation.
- Useful for providing utility/helper methods related to the interface.

### Example with Default and Static Methods

```java
interface Calculator {

    default void calculate() {
        System.out.println("Default method");
    }

    static void info() {
        System.out.println("Calculator Interface");
    }
}

class Test implements Calculator {
    public static void main(String[] args) {
        Calculator.info();

        Test obj = new Test();
        obj.calculate();
    }
}
```

**Output:**
```
Calculator Interface
Default method
```

-----------------------------
-----------------------------

## 19. What are Consumer, Supplier, Predicate, and Function?

Java 8 provides several built-in **Functional Interfaces** in the `java.util.function` package. These interfaces are commonly used with **Lambda Expressions** and the **Stream API**.

| Interface | Method | Purpose |
|-----------|--------|---------|
| `Consumer<T>` | `accept()` | Consumes data and performs an operation without returning a value. |
| `Supplier<T>` | `get()` | Supplies or provides a value without taking any input. |
| `Predicate<T>` | `test()` | Takes an input and returns a boolean result (`true` or `false`). |
| `Function<T, R>` | `apply()` | Takes an input and converts it into an output. |

---

### 1. Consumer<T>

- Accepts one argument.
- Does not return any value.
- Used for performing actions like printing or updating data.

### Example

```java
Consumer<String> print = name -> System.out.println(name);

print.accept("Java");
```

**Output:**
```
Java
```

---

### 2. Supplier<T>

- Does not take any argument.
- Returns a value.
- Used for generating or providing data.

### Example

```java
Supplier<String> message = () -> "Hello Java";

System.out.println(message.get());
```

**Output:**
```
Hello Java
```

---

### 3. Predicate<T>

- Takes one argument.
- Returns a boolean value.
- Used for filtering conditions.

### Example

```java
Predicate<Integer> isEven = n -> n % 2 == 0;

System.out.println(isEven.test(10));
```

**Output:**
```
true
```

---

### 4. Function<T, R>

- Takes one input and returns one output.
- Used for data transformation.

### Example

```java
Function<String, Integer> length = str -> str.length();

System.out.println(length.apply("Java"));
```

**Output:**
```
4
```

---

### Key Points

- All four interfaces are part of `java.util.function`.
- They are **functional interfaces** and contain one abstract method.
- They are widely used with Lambda Expressions and Stream API.
- `Consumer` → Takes input, returns nothing.
- `Supplier` → Takes nothing, returns output.
- `Predicate` → Takes input, returns boolean.
- `Function` → Takes input, returns transformed output.

-----------------------
-----------------------

## 20. What is `forEach()`?

The **`forEach()`** method is a terminal operation in the **Stream API** and a default method in the **Iterable interface** that is used to perform an action on each element of a collection or stream.

It accepts a **Consumer functional interface** as an argument and executes the provided action for every element.

### Example

```java
List<String> list = Arrays.asList("Java", "Python", "C++");

list.forEach(System.out::println);
```

**Output:**
```
Java
Python
C++
```

### Using Lambda Expression

```java
list.forEach(item -> System.out.println(item));
```

### Key Points

- `forEach()` performs an operation on each element.
- It uses the **Consumer functional interface**.
- It is commonly used with Lambda Expressions and Method References.
- In Stream API, it is a **terminal operation**.
- It does not return a value.
- It can be used with collections and streams.

### Example with Stream

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

**Output:**
```
2
4
```

------------------
------------------

## 21. Difference Between `peek()` and `map()`

Both **`peek()`** and **`map()`** are intermediate operations in the **Stream API**, but they serve different purposes.

### `peek()`

- Used mainly for **debugging** and observing elements during stream processing.
- Performs an action on each element without changing the elements.
- Returns the same stream with the original elements.

### Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

numbers.stream()
       .peek(n -> System.out.println("Before: " + n))
       .filter(n -> n > 2)
       .forEach(System.out::println);
```

**Output:**
```
Before: 1
Before: 2
Before: 3
3
Before: 4
4
```

---

### `map()`

- Used to **transform elements** from one form to another.
- Returns a new stream containing the transformed elements.
- Commonly used for data conversion.

### Example

```java
List<String> names = Arrays.asList("java", "python");

List<String> upper = names.stream()
                          .map(String::toUpperCase)
                          .collect(Collectors.toList());

System.out.println(upper);
```

**Output:**
```
[JAVA, PYTHON]
```

---

### Difference Between `peek()` and `map()`

| `peek()` | `map()` |
|----------|---------|
| Used mainly for debugging or observing data | Used for transforming data |
| Does not modify elements | Modifies/transforms elements into new values |
| Returns the same elements | Returns transformed elements |
| Accepts a `Consumer` | Accepts a `Function` |
| Intermediate operation | Intermediate operation |

### Key Points

- Use **`peek()`** when you want to inspect elements while debugging a stream pipeline.
- Use **`map()`** when you need to convert or transform each element.
- Avoid using `peek()` for modifying data because it is intended mainly for observation.


-----------------------
-----------------------

## 22. What is Parallel Stream?

A **Parallel Stream** is a feature of the Java 8 Stream API that allows stream operations to be executed **concurrently using multiple threads**. It divides the stream into multiple parts, processes them in parallel, and combines the results.

Parallel streams can improve performance when processing large amounts of data, especially on multi-core processors.

### Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

numbers.parallelStream()
       .forEach(System.out::println);
```

**Possible Output:**
```
3
1
5
2
4
```

The order may vary because elements are processed by different threads.

### Creating Parallel Streams

#### Using `parallelStream()`

```java
list.parallelStream()
    .forEach(System.out::println);
```

#### Converting a Stream to Parallel

```java
list.stream()
    .parallel()
    .forEach(System.out::println);
```

### Difference Between Stream and Parallel Stream

| Stream | Parallel Stream |
|--------|-----------------|
| Executes sequentially | Executes using multiple threads |
| Uses a single thread | Uses ForkJoinPool common pool |
| Maintains predictable order | Order may not be guaranteed |
| Suitable for small data processing | Suitable for large data processing |

### Key Points

- Introduced in **Java 8**.
- Uses multiple threads for processing.
- Uses the **ForkJoinPool** internally.
- Improves performance for CPU-intensive and large data operations.
- Not always faster; overhead can make it slower for small collections.
- Avoid using parallel streams when operations require maintaining strict order or shared mutable state.


------------------------
------------------------

## 23. Difference Between Sequential and Parallel Streams

**Sequential Stream** processes elements one by one using a single thread, whereas a **Parallel Stream** divides the workload into multiple tasks and processes them concurrently using multiple threads.

### Sequential vs Parallel Streams

| Sequential Stream | Parallel Stream |
|-------------------|-----------------|
| Uses a single thread | Uses multiple threads |
| Maintains predictable encounter order | Order may vary during processing |
| Has lower overhead | Has higher overhead due to thread management |
| Suitable for small datasets | Suitable for large datasets |
| Best for simple operations | Best for CPU-intensive operations |
| Executes tasks sequentially | Executes tasks concurrently |
| Easier to debug and maintain | Requires attention to thread safety |

### Sequential Stream Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

numbers.stream()
       .forEach(System.out::println);
```

**Output:**
```
1
2
3
4
5
```

### Parallel Stream Example

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

numbers.parallelStream()
       .forEach(System.out::println);
```

**Possible Output:**
```
3
1
5
2
4
```

### Key Points

- Use **Sequential Streams** when data size is small or when maintaining order is important.
- Use **Parallel Streams** for large datasets and computationally intensive tasks.
- Parallel streams use the **Fork/Join Framework** internally.
- Parallel processing does not always guarantee better performance because of thread management overhead.
- Avoid parallel streams when operations modify shared mutable data.


--------------------
--------------------


## 24. What is `Collectors`?

**`Collectors`** is a utility class in Java 8 that provides predefined implementations of the **Collector interface**. It is mainly used with the **Stream API** to collect processed stream elements into different data structures or perform aggregation operations.

It is commonly used with the `collect()` terminal operation.

### Example

```java
List<String> names = Arrays.asList("John", "Alice", "Bob");

List<String> result = names.stream()
                           .collect(Collectors.toList());

System.out.println(result);
```

**Output:**
```
[John, Alice, Bob]
```

### Common `Collectors` Methods

| Method | Purpose |
|--------|---------|
| `Collectors.toList()` | Collects elements into a `List`. |
| `Collectors.toSet()` | Collects elements into a `Set` and removes duplicates. |
| `Collectors.joining()` | Joins string elements into a single string. |
| `Collectors.groupingBy()` | Groups elements based on a classifier function. |
| `Collectors.partitioningBy()` | Divides elements into two groups based on a condition. |
| `Collectors.counting()` | Counts the number of elements. |

---

### 1. `Collectors.toList()`

```java
List<Integer> numbers = Arrays.asList(1, 2, 3);

List<Integer> result = numbers.stream()
                              .collect(Collectors.toList());
```

Output:
```
[1, 2, 3]
```

---

### 2. `Collectors.toSet()`

```java
List<Integer> numbers = Arrays.asList(1, 2, 2, 3);

Set<Integer> result = numbers.stream()
                              .collect(Collectors.toSet());
```

Output:
```
[1, 2, 3]
```

---

### 3. `Collectors.joining()`

```java
List<String> names = Arrays.asList("Java", "Spring", "Hibernate");

String result = names.stream()
                     .collect(Collectors.joining(", "));
```

Output:
```
Java, Spring, Hibernate
```

---

### 4. `Collectors.groupingBy()`

Groups elements based on a specific property.

```java
Map<Integer, List<String>> result =
        names.stream()
             .collect(Collectors.groupingBy(String::length));
```

---

### 5. `Collectors.partitioningBy()`

Partitions elements into two groups based on a condition.

```java
Map<Boolean, List<Integer>> result =
        numbers.stream()
               .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```

Output:
```
true  -> [2, 4]
false -> [1, 3]
```

---

### 6. `Collectors.counting()`

Counts the number of elements.

```java
long count = names.stream()
                  .collect(Collectors.counting());
```

### Key Points

- Part of the `java.util.stream` package.
- Used with the `collect()` terminal operation.
- Converts stream results into collections or aggregated values.
- Provides ready-made collectors for common data processing tasks.
- Commonly used with `groupingBy()`, `partitioningBy()`, and aggregation operations.


------------------
------------------

## 25. What is `groupingBy()`?

The **`groupingBy()`** method is a collector in the **Stream API** used to **group stream elements based on a specific attribute or condition**. It returns a `Map` where the key represents the grouping criteria and the value contains a list of elements belonging to that group.

It is commonly used for categorizing objects based on their properties.

### Syntax

```java
Collectors.groupingBy(classifier)
```

- **classifier** – A function that determines the key used for grouping.

### Example

```java
Map<String, List<Employee>> map =
        employees.stream()
                 .collect(Collectors.groupingBy(Employee::getDepartment));
```

In this example:
- Employees are grouped based on their department.
- The department name becomes the **Map key**.
- The list of employees becomes the **Map value**.

### Example Output

```
IT -> [Employee1, Employee2]
HR -> [Employee3, Employee4]
Finance -> [Employee5]
```

### Another Example

```java
List<String> names = Arrays.asList("Java", "Spring", "SQL", "HTML");

Map<Integer, List<String>> result =
        names.stream()
             .collect(Collectors.groupingBy(String::length));

System.out.println(result);
```

**Output:**
```
{3=[SQL], 4=[Java, HTML], 6=[Spring]}
```

### Grouping With Counting

```java
Map<String, Long> count =
        employees.stream()
                 .collect(Collectors.groupingBy(
                     Employee::getDepartment,
                     Collectors.counting()
                 ));
```

**Output:**
```
IT -> 2
HR -> 1
Finance -> 3
```

### Key Points

- `groupingBy()` is part of the `Collectors` utility class.
- Used with the `collect()` terminal operation.
- Returns a `Map<K, List<T>>` by default.
- Groups elements based on a classifier function.
- Supports downstream collectors like `counting()`, `mapping()`, and `summingInt()`.
- Useful for data analysis and categorization tasks.


------------
------------


## 26. What is `partitioningBy()`?

The **`partitioningBy()`** method is a collector in the **Stream API** that is used to **divide elements into two groups based on a boolean condition**.

It returns a `Map<Boolean, List<T>>` where:
- `true` key contains elements that match the condition.
- `false` key contains elements that do not match the condition.

### Syntax

```java
Collectors.partitioningBy(condition)
```

### Example

```java
Map<Boolean, List<Employee>> result =
        employees.stream()
                 .collect(Collectors.partitioningBy(
                     emp -> emp.getSalary() > 50000
                 ));
```

### Output Example

```
true  -> [Employee1, Employee2]
false -> [Employee3, Employee4]
```

Employees with a salary greater than `50000` are placed in the `true` group, and the remaining employees are placed in the `false` group.

### Another Example

```java
List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

Map<Boolean, List<Integer>> result =
        numbers.stream()
               .collect(Collectors.partitioningBy(n -> n % 2 == 0));

System.out.println(result);
```

**Output:**
```
{
 true=[10, 20, 30],
 false=[15, 25]
}
```

### Difference Between `groupingBy()` and `partitioningBy()`

| `groupingBy()` | `partitioningBy()` |
|----------------|-------------------|
| Groups elements based on any classifier | Divides elements based on a boolean condition |
| Can create multiple groups | Always creates two groups (`true` and `false`) |
| Returns `Map<K, List<T>>` | Returns `Map<Boolean, List<T>>` |
| Example: Group employees by department | Example: Separate employees by salary condition |

### Key Points

- `partitioningBy()` is part of the `Collectors` class.
- Used with the `collect()` terminal operation.
- Always creates exactly two partitions.
- Useful when data needs to be separated based on a condition.
- Supports downstream collectors like `counting()` and `mapping()`.



------------------
------------------


## 27. What is `CompletableFuture`?

**`CompletableFuture`** is a class introduced in **Java 8** that supports **asynchronous programming**. It allows tasks to run independently in the background and provides methods to **chain multiple asynchronous operations** without blocking the main thread.

It is part of the `java.util.concurrent` package and is an enhanced version of `Future`.

### Example

```java
CompletableFuture.supplyAsync(() -> "Hello")
                 .thenApply(String::toUpperCase)
                 .thenAccept(System.out::println);
```

**Output:**
```
HELLO
```

### Execution Flow

1. `supplyAsync()` starts an asynchronous task and returns a result.
2. `thenApply()` transforms the result.
3. `thenAccept()` consumes the final result.

### Common `CompletableFuture` Methods

| Method | Purpose |
|--------|---------|
| `supplyAsync()` | Runs an asynchronous task that returns a value. |
| `runAsync()` | Runs an asynchronous task without returning a value. |
| `thenApply()` | Transforms the result of a previous stage. |
| `thenAccept()` | Consumes the result without returning a value. |
| `thenRun()` | Executes another task after completion without using the result. |
| `thenCombine()` | Combines results of two independent futures. |
| `exceptionally()` | Handles exceptions during execution. |
| `allOf()` | Waits for multiple futures to complete. |
| `anyOf()` | Completes when any one future completes. |

### Example with Exception Handling

```java
CompletableFuture.supplyAsync(() -> {
    if (true) {
        throw new RuntimeException("Error occurred");
    }
    return "Success";
})
.exceptionally(ex -> "Handled: " + ex.getMessage())
.thenAccept(System.out::println);
```

**Output:**
```
Handled: Error occurred
```

### Key Points

- Introduced in **Java 8**.
- Supports non-blocking asynchronous programming.
- Allows chaining multiple dependent tasks.
- Uses Lambda Expressions for cleaner code.
- Helps avoid callback complexity.
- Supports exception handling in asynchronous workflows.
- Commonly used for API calls, background tasks, and parallel processing.


---------------
---------------


## 28. Difference Between Runnable and Lambda

**Runnable** is a functional interface in Java that represents a task that can be executed by a thread. Since it contains exactly one abstract method (`run()`), it can be implemented using a **Lambda Expression** introduced in Java 8.

A Lambda Expression provides a shorter way to implement the `Runnable` interface without creating an anonymous class.

### Using Anonymous Class (Before Java 8)

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running");
    }
};

new Thread(r).start();
```

### Using Lambda Expression (Java 8)

```java
Runnable r = () -> System.out.println("Running");

new Thread(r).start();
```

**Output:**
```
Running
```

### Difference Between Runnable and Lambda

| Runnable | Lambda Expression |
|----------|-------------------|
| A functional interface | A concise way to implement a functional interface |
| Contains the `run()` method | Provides implementation for the abstract method |
| Can be implemented using a class or anonymous class | Used to reduce boilerplate code |
| Available before Java 8 | Introduced in Java 8 |

### Key Points

- `Runnable` contains a single abstract method: `void run()`.
- Lambda expressions can replace anonymous implementations of functional interfaces.
- Lambda expressions make concurrent programming code shorter and more readable.
- A Lambda expression does not create a new type; it provides the implementation of an existing functional interface.


----------------------
----------------------


## 29. Can Lambda Expressions Access Local Variables?

Yes, **Lambda Expressions can access local variables**, but the variables must be **final or effectively final**.

- **Final variable**: A variable declared with the `final` keyword and cannot be reassigned.
- **Effectively final variable**: A variable that is not declared as `final` but whose value is never changed after initialization.

### Example

```java
int x = 10;

Runnable r = () -> System.out.println(x);

r.run();
```

**Output:**
```
10
```

Here, `x` is effectively final because its value is not modified after initialization.

### Invalid Example

```java
int x = 10;

Runnable r = () -> System.out.println(x);

x = 20; // Compilation Error
```

The variable `x` cannot be modified because it is accessed inside the Lambda Expression.

### Key Points

- Lambda expressions can access local variables from the enclosing scope.
- Local variables must be **final or effectively final**.
- Instance variables and static variables do not have this restriction.
- The restriction exists because local variables are stored on the stack, while lambda expressions may execute later in another thread.
- Modifying captured local variables could lead to inconsistent behavior.
