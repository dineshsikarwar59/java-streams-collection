# Java String Interview Questions

# 1. What is a String in Java?

## Answer

A **String** in Java is an object that represents a sequence of characters. Strings are **immutable**, meaning once a `String` object is created, its value cannot be changed. Any operation that appears to modify a string actually creates a new `String` object.

### Example

```java
String s = "Hello";
```

### Example of Immutability

```java
String s = "Hello";
s.concat(" World");

System.out.println(s);
```

**Output:**

```text
Hello
```

The `concat()` method creates a new string (`"Hello World"`), but since the returned value is not assigned to a variable, the original string remains unchanged.

To update the value:

```java
String s = "Hello";
s = s.concat(" World");

System.out.println(s);
```

**Output:**

```text
Hello World
```

---

## Key Points

- A `String` is a sequence of characters.
- Strings are **immutable**.
- String literals are stored in the **String Pool**.
- Any modification creates a **new `String` object**.
- `String` objects are **thread-safe** because they cannot be modified after creation.


--------------
-------------


# 2. Why are Strings Immutable in Java?

## Answer

Strings in Java are **immutable**, meaning their value cannot be changed after they are created. If a string appears to be modified, Java actually creates a **new `String` object** instead of changing the existing one.

### Reasons for String Immutability

#### 1. Security
Strings are widely used to store sensitive information such as:
- Usernames
- Passwords
- File paths
- Network connections

Immutability prevents these values from being altered accidentally or maliciously after they are created.

#### 2. Thread Safety
Since `String` objects cannot be modified, multiple threads can safely share the same string without requiring synchronization.

#### 3. Better Performance through the String Pool
Java stores string literals in a special memory area called the **String Pool**. Because strings are immutable, multiple references can safely point to the same object, reducing memory usage and improving performance.

#### 4. Hash Code Caching
Strings are frequently used as keys in collections like `HashMap`. Since a string's value never changes, its hash code can be calculated once and cached, making lookups faster.

---

## Example

```java
String s = "Java";
s.concat(" Programming");

System.out.println(s);
```

### Output

```text
Java
```

The `concat()` method creates a new string (`"Java Programming"`), but the original string remains unchanged because the returned value is not assigned to a variable.

To modify the value, assign the result back to the variable:

```java
String s = "Java";
s = s.concat(" Programming");

System.out.println(s);
```

### Output

```text
Java Programming
```

---

## Advantages of String Immutability

- Improves application security.
- Ensures thread safety without synchronization.
- Enables efficient memory usage through the String Pool.
- Allows hash code caching for faster collection operations.
- Simplifies program design and reduces unintended side effects.

---

## Key Points

- Strings are **immutable** in Java.
- Any operation that modifies a string creates a **new object**.
- Immutability provides **security**, **thread safety**, **memory optimization**, and **better performance**.
- String literals are stored in the **String Pool**, allowing object reuse.


------------
-----------


# 3. What is the String Pool?

## Answer

The **String Pool** (also called the **String Intern Pool**) is a special memory area inside the **Java Heap** where Java stores **string literals**.

When a string literal is created, Java checks the String Pool first. If the same string already exists, Java reuses the existing object instead of creating a new one. This helps reduce memory usage and improves performance.

---

## Example

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

### Output

```text
true
```

### Explanation

Both `s1` and `s2` refer to the **same String object** in the String Pool.

```text
String Pool

+-----------+
|  "Java"   |
+-----------+
     ▲  ▲
     |  |
    s1  s2
```

---

## Creating Strings with `new`

When a String object is created using the `new` keyword, a new object is created outside the String Pool.

### Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

### Output

```text
false
```

### Explanation

Although both strings contain the same value, they are different objects in memory.

```text
Heap

+-----------+       +-----------+
|  "Java"   |       |  "Java"   |
+-----------+       +-----------+
     ▲                   ▲
     |                   |
    s1                  s2
```

---

## Using `intern()`

The `intern()` method returns the reference from the String Pool.

### Example

```java
String s1 = new String("Java");
String s2 = s1.intern();

System.out.println(s2 == "Java");
```

### Output

```text
true
```

---

## Benefits of String Pool

- Reduces memory consumption by reusing string objects.
- Improves application performance.
- Works efficiently because Strings are immutable.
- Allows multiple references to safely share the same object.

---

## Key Points

- String Pool stores **unique string literals**.
- String literals are automatically added to the pool.
- Strings created with `new` create separate objects.
- `==` compares object references, while `.equals()` compares string values.
- The `intern()` method can be used to get the pooled string reference.


---------
--------


# 4. Difference Between `==` and `equals()` in Java

## Answer

In Java, both `==` and `equals()` are used to compare objects, but they work differently.

| `==` Operator | `equals()` Method |
|--------------|-------------------|
| Compares object references (memory addresses) | Compares object content (values) |
| Returns `true` only when both references point to the same object | Returns `true` when the contents are equal |
| Used for reference comparison | Used for logical equality comparison |

---

## Example

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

### Output

```text
false
true
```

---

## Explanation

### Using `==`

```java
s1 == s2
```

- `s1` and `s2` are two different objects created using `new`.
- They have the same value, but they refer to different memory locations.
- Therefore, `==` returns `false`.

### Using `equals()`

```java
s1.equals(s2)
```

- The `equals()` method compares the actual string content.
- Both strings contain `"Java"`.
- Therefore, it returns `true`.

---

## Example with String Pool

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

### Output

```text
true
true
```

### Explanation

Both variables refer to the same object in the String Pool, so:
- `==` returns `true` because references are the same.
- `equals()` returns `true` because values are the same.

---

## Key Points

- Use `==` to compare **object references**.
- Use `equals()` to compare **object values/content**.
- For comparing Strings, prefer `equals()` instead of `==`.
- The `equals()` method is overridden in classes like `String` to provide content-based comparison.


----------
----------


# 5. Difference Between String, StringBuffer, and StringBuilder

## Answer

In Java, `String`, `StringBuffer`, and `StringBuilder` are used to work with sequences of characters, but they differ in terms of **mutability**, **thread safety**, and **performance**.

## Comparison Table

| Feature | String | StringBuffer | StringBuilder |
|---------|--------|--------------|---------------|
| Mutability | Immutable | Mutable | Mutable |
| Thread Safety | Yes | Yes | No |
| Performance | Slow (when modifying frequently) | Medium | Fast |
| Synchronization | Not required | Synchronized methods | Not synchronized |

---

## 1. String

- `String` objects are **immutable**.
- Once created, the value cannot be changed.
- Any modification creates a new object.
- Best suited for fixed text values.

### Example

```java
String name = "Java";
name = name + " Programming";

System.out.println(name);
```

Output:

```text
Java Programming
```

---

## 2. StringBuffer

- `StringBuffer` is **mutable**, meaning its content can be changed.
- It is **thread-safe** because its methods are synchronized.
- Suitable for applications where multiple threads modify the same string data.

### Example

```java
StringBuffer sb = new StringBuffer("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

---

## 3. StringBuilder

- `StringBuilder` is also **mutable**.
- It is not synchronized, so it is **not thread-safe**.
- Provides better performance than `StringBuffer`.
- Recommended for single-threaded applications.

### Example

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

---

## When to Use?

| Class | Use Case |
|-------|----------|
| `String` | When the text value does not change frequently |
| `StringBuffer` | When multiple threads modify string data |
| `StringBuilder` | When modifications happen frequently in a single-threaded environment |

---

## Key Points

- **String** → Immutable and safe for fixed text.
- **StringBuffer** → Mutable and thread-safe.
- **StringBuilder** → Mutable and faster, but not thread-safe.
- For most string modifications in modern applications, `StringBuilder` is preferred unless thread safety is required.


-----------------
----------------


# 6. What is `intern()` Method in Java?

## Answer

The **`intern()`** method is a method of the `String` class that returns the **reference of the string from the String Pool**.

If the string already exists in the String Pool, `intern()` returns the existing pooled reference. Otherwise, it adds the string to the pool and returns that reference.

---

## Example

```java
String s1 = new String("Java");
String s2 = s1.intern();

System.out.println(s2 == "Java");
```

### Output

```text
true
```

---

## Explanation

```java
String s1 = new String("Java");
```

- Creates a new String object in the heap.
- The literal `"Java"` is also stored in the String Pool.

```java
String s2 = s1.intern();
```

- Returns the reference of the `"Java"` object from the String Pool.
- Now `s2` points to the pooled string.

```java
s2 == "Java"
```

- Both references point to the same String Pool object.
- Therefore, the result is `true`.

---

## Example Without `intern()`

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

### Output

```text
false
```

### Explanation

- `s1` and `s2` are two different objects created in the heap.
- They contain the same value but have different references.

---

## Benefits of `intern()`

- Reduces memory usage by reusing string objects.
- Allows comparison using `==` for pooled strings.
- Improves memory efficiency when many duplicate strings exist.

---

## Key Points

- `intern()` returns the pooled reference of a String object.
- It helps reuse existing strings from the String Pool.
- Use `equals()` for comparing string values.
- Use `intern()` when you need to work with pooled String references.


----------------
---------------


# 7. Difference Between `String s = "Java";` and `String s = new String("Java");`

## Answer

In Java, both statements create String objects, but they behave differently in terms of **memory allocation** and **object creation**.

---

## 1. `String s = "Java";`

```java
String s = "Java";
```

### Explanation

- The string literal `"Java"` is stored in the **String Pool**.
- If the same string already exists in the pool, Java reuses the existing object.
- No new object is created if the literal is already present.

### Memory Representation

```text
String Pool

+----------+
|  "Java"  |
+----------+
     ▲
     |
     s
```

---

## 2. `String s = new String("Java");`

```java
String s = new String("Java");
```

### Explanation

- A **new String object** is created in the **Heap memory**.
- The string literal `"Java"` may also exist in the String Pool.
- The variable `s` refers to the new heap object, not the pooled object.

### Memory Representation

```text
String Pool              Heap

+----------+        +----------+
|  "Java"  |        |  "Java"  |
+----------+        +----------+
                       ▲
                       |
                       s
```

---

## Comparison Table

| Feature | `String s = "Java";` | `String s = new String("Java");` |
|---------|----------------------|-----------------------------------|
| Object Creation | Uses existing String Pool object if available | Always creates a new String object |
| Memory Location | String Pool | Heap memory |
| Performance | Faster | Slower due to object creation |
| Memory Usage | More efficient | Uses additional memory |
| Reference Comparison (`==`) | May return `true` for same literals | Usually returns `false` |

---

## Example

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1 == s2);
```

Output:

```text
true
```

Both references point to the same object in the String Pool.

---

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
```

Output:

```text
false
```

Both variables refer to different objects in the Heap.

---

## Key Points

- `String s = "Java";` → Creates or reuses a String Pool object.
- `String s = new String("Java");` → Always creates a new object in Heap memory.
- String literals are preferred when possible because they save memory.
- Use `.equals()` to compare String values instead of `==`.


--------------
--------------


# 8. Can String Be Subclassed in Java?

## Answer

No, the **String class cannot be subclassed** in Java because it is declared as a **`final` class**.

### String Class Declaration

```java
public final class String
```

The `final` keyword prevents other classes from extending or inheriting from the `String` class.

---

## Example

```java
class MyString extends String {
    // Compilation Error
}
```

### Output

```text
Cannot inherit from final String
```

---

## Why is String Declared as Final?

### 1. Security
- Strings are used for sensitive operations like:
  - File paths
  - URLs
  - Database connections
  - Class loading
- Preventing inheritance ensures String behavior cannot be modified.

### 2. Immutability
- String objects are immutable.
- If String could be subclassed, a subclass could override methods and break immutability.

### 3. Thread Safety
- Since String cannot be changed or extended, it is safe to share between multiple threads.

### 4. String Pool Optimization
- Java reuses String objects through the String Pool.
- Making String final ensures its behavior remains predictable and reliable.

---

## Key Points

- `String` is a **final class** in Java.
- It cannot be extended or subclassed.
- The `final` keyword provides security, immutability, and thread safety.
- String objects are safe to share across applications and threads.



-------------
--------------


# 9. How Do You Reverse a String in Java?

## Answer

A String can be reversed in Java using different approaches. Two common methods are:

1. Using `StringBuilder`
2. Using a loop

---

## Method 1: Using `StringBuilder`

The `StringBuilder` class provides a built-in `reverse()` method that reverses the characters of a string.

### Example

```java
String s = "Java";

String rev = new StringBuilder(s).reverse().toString();

System.out.println(rev);
```

### Output

```text
avaJ
```

### Explanation

- `new StringBuilder(s)` creates a mutable string object.
- `reverse()` reverses the characters.
- `toString()` converts the result back into a String.

---

## Method 2: Using a Loop

We can reverse a string by iterating from the last character to the first character.

### Example

```java
String s = "Java";

for (int i = s.length() - 1; i >= 0; i--) {
    System.out.print(s.charAt(i));
}
```

### Output

```text
avaJ
```

### Explanation

- `s.length() - 1` gives the index of the last character.
- The loop moves backward until index `0`.
- `charAt(i)` retrieves each character in reverse order.

---

## Comparison

| Method | Advantage |
|--------|-----------|
| `StringBuilder.reverse()` | Simple, readable, and efficient |
| Loop approach | Helps understand string manipulation logic |

---

## Key Points

- `String` is immutable, so direct modification is not possible.
- `StringBuilder` is commonly preferred for reversing strings because it is mutable and provides a built-in `reverse()` method.
- A loop can be used when you need more control over the reversal logic.


-------
------


# 10. Difference Between `substring()` and `subSequence()` in Java

## Answer

Both `substring()` and `subSequence()` are used to extract a portion of a String, but they differ in their **return type**.

| Feature | `substring()` | `subSequence()` |
|---------|---------------|-----------------|
| Return Type | `String` | `CharSequence` |
| Available In | `String` class | `String` class |
| Purpose | Extracts a part of a string | Returns a character sequence from a string |
| Mutability | Returns an immutable `String` | Returns a `CharSequence` |

---

## 1. `substring()`

The `substring()` method returns a new **String** containing characters from the specified range.

### Syntax

```java
substring(beginIndex)
substring(beginIndex, endIndex)
```

- `beginIndex` is inclusive.
- `endIndex` is exclusive.

### Example

```java
String s = "Programming";

System.out.println(s.substring(3, 7));
```

### Output

```text
gram
```

### Explanation

String indexes:

```text
P r o g r a m m i n g
0 1 2 3 4 5 6 7 8 9 10
```

`substring(3, 7)` extracts characters from index `3` to `6`:

```text
g r a m
```

---

## 2. `subSequence()`

The `subSequence()` method returns a `CharSequence` containing characters from the specified range.

### Example

```java
String s = "Programming";

CharSequence result = s.subSequence(3, 7);

System.out.println(result);
```

### Output

```text
gram
```

---

## Key Differences

```java
String s = "Programming";

String a = s.substring(3, 7);
CharSequence b = s.subSequence(3, 7);
```

- `substring()` returns a `String`.
- `subSequence()` returns a `CharSequence`.

Both produce the same characters, but their return types are different.

---

## Key Points

- Both methods use **zero-based indexing**.
- The starting index is **inclusive**.
- The ending index is **exclusive**.
- Use `substring()` when you need a `String`.
- Use `subSequence()` when working with the general `CharSequence` interface.


------------
----------

# 11. What Happens If String Is `null` in Java?

## Answer

If a String reference is `null`, it means the variable does not point to any String object. Calling a method on a `null` String reference causes a **`NullPointerException`**.

---

## Example

```java
String s = null;

System.out.println(s.length());
```

### Output

```text
NullPointerException
```

---

## Explanation

```java
String s = null;
```

- The variable `s` does not refer to any object.
- It only contains a `null` reference.

```java
s.length();
```

- The `length()` method is called on a `null` reference.
- Since there is no String object to execute the method, Java throws a `NullPointerException`.

---

## Avoiding NullPointerException

### Method 1: Check for `null`

```java
String s = null;

if (s != null) {
    System.out.println(s.length());
}
```

---

### Method 2: Use `Objects` Utility

```java
import java.util.Objects;

String s = null;

System.out.println(Objects.toString(s, ""));
```

Output:

```text

```

---

### Method 3: Use Default Value

```java
String s = null;

String value = s == null ? "" : s;

System.out.println(value.length());
```

---

## Key Points

- A `null` String is not the same as an empty String (`""`).
- Calling methods like `length()`, `charAt()`, or `substring()` on a `null` String causes `NullPointerException`.
- Always check for `null` before performing operations on a String reference.


---------
--------


# 13. Difference Between `isEmpty()` and `isBlank()` in Java

## Answer

Both `isEmpty()` and `isBlank()` are used to check whether a String contains characters, but they handle **whitespace characters** differently.

| Feature | `isEmpty()` | `isBlank()` |
|---------|-------------|-------------|
| Available Since | Java 1.6 | Java 11 |
| Checks | String length is 0 | String contains no characters or only whitespace |
| Whitespace Handling | Considers whitespace as a character | Ignores whitespace characters |
| Return Type | `boolean` | `boolean` |

---

## 1. `isEmpty()`

The `isEmpty()` method returns `true` only when the String length is **zero**.

### Example

```java
String s1 = "";

System.out.println(s1.isEmpty());
```

### Output

```text
true
```

### Example with spaces

```java
String s2 = "   ";

System.out.println(s2.isEmpty());
```

### Output

```text
false
```

### Explanation

The String contains spaces, so its length is greater than zero.

---

## 2. `isBlank()`

The `isBlank()` method returns `true` when the String is:

- Empty (`""`)
- Contains only whitespace characters (`" "`)

**Available from Java 11 onwards.**

### Example

```java
String s2 = "   ";

System.out.println(s2.isBlank());
```

### Output

```text
true
```

### Explanation

The String contains only spaces, so it is considered blank.

---

## Complete Example

```java
String s1 = "";
String s2 = "   ";

System.out.println(s1.isEmpty());
System.out.println(s2.isEmpty());

System.out.println(s2.isBlank());
```

### Output

```text
true
false
true
```

---

## Comparison Example

```java
String s1 = "";
String s2 = "Java";
String s3 = "   ";

System.out.println(s1.isEmpty());
System.out.println(s2.isBlank());
System.out.println(s3.isBlank());
```

### Output

```text
true
false
true
```

---

## Key Points

- `isEmpty()` checks whether the String length is `0`.
- `isBlank()` checks whether the String is empty or contains only whitespace.
- Use `isEmpty()` when you only care about zero length.
- Use `isBlank()` when validating user input where spaces should be treated as empty values.


----------
---------


# 15. How to Convert String to int in Java?

## Answer

In Java, a `String` can be converted into an `int` using the `Integer.parseInt()` method.

### Example

```java
String s = "100";

int n = Integer.parseInt(s);

System.out.println(n);
```

### Output

```text
100
```

### Explanation

- `Integer.parseInt()` converts a numeric String into a primitive `int` value.
- The String must contain a valid integer value.

### Example with Invalid String

```java
String s = "abc";

int n = Integer.parseInt(s);
```

### Output

```text
NumberFormatException
```

---

# 16. How to Convert int to String in Java?

## Answer

An `int` can be converted into a `String` using:

1. `String.valueOf()`
2. `Integer.toString()`

---

## Method 1: Using `String.valueOf()`

### Example

```java
int n = 100;

String s = String.valueOf(n);

System.out.println(s);
```

### Output

```text
100
```

---

## Method 2: Using `Integer.toString()`

### Example

```java
int n = 100;

String s = Integer.toString(n);

System.out.println(s);
```

### Output

```text
100
```

---

## Comparison

| Conversion | Method |
|------------|--------|
| String → int | `Integer.parseInt()` |
| int → String | `String.valueOf()` |
| int → String | `Integer.toString()` |

---

## Key Points

- Use `Integer.parseInt()` to convert a numeric String into an `int`.
- Use `String.valueOf()` or `Integer.toString()` to convert an `int` into a String.
- Invalid numeric Strings cause `NumberFormatException`.


------------
------------


# 17. How to Check Palindrome String in Java?

## Answer

A **palindrome** is a String that remains the same when reversed.

Examples:
- `madam` → Palindrome
- `level` → Palindrome
- `java` → Not a palindrome

To check whether a String is a palindrome, reverse the String and compare it with the original String using `equals()`.

---

## Example Using `StringBuilder`

```java
String s = "madam";

String rev = new StringBuilder(s).reverse().toString();

System.out.println(s.equals(rev));
```

### Output

```text
true
```

---

## Explanation

1. Original String:

```text
madam
```

2. Reverse the String:

```text
madam
```

3. Compare both Strings:

```java
s.equals(rev)
```

Since both values are the same, the result is `true`.

---

## Example with Non-Palindrome String

```java
String s = "java";

String rev = new StringBuilder(s).reverse().toString();

System.out.println(s.equals(rev));
```

### Output

```text
false
```

---

## Key Points

- A palindrome reads the same from left to right and right to left.
- Use `StringBuilder.reverse()` to reverse a String easily.
- Use `equals()` to compare String values.
- Do not use `==` because it compares object references, not content.



-----------
----------


# 18. How to Remove Spaces from a String in Java?

## Answer

In Java, spaces can be removed from a String using the `replace()` method.

The `replace()` method replaces all occurrences of a specified character or sequence with another value.

---

## Example

```java
String s = "Java Programming";

String result = s.replace(" ", "");

System.out.println(result);
```

### Output

```text
JavaProgramming
```

---

## Explanation

```java
s.replace(" ", "");
```

- Finds all space characters (`" "`) in the String.
- Replaces them with an empty String (`""`).
- Returns a new String because String objects are immutable.

---

## Removing All Whitespace Characters

If you want to remove all types of whitespace (spaces, tabs, new lines), use `replaceAll()` with a regular expression.

### Example

```java
String s = "Java \t Programming\n";

String result = s.replaceAll("\\s", "");

System.out.println(result);
```

### Output

```text
JavaProgramming
```

---

## Key Points

- `replace(" ", "")` removes only normal spaces.
- `replaceAll("\\s", "")` removes all whitespace characters.
- Strings are immutable, so the original String is not changed.
- The method returns a new String after modification.


-----------
-----------


# 19. Difference Between `replace()` and `replaceAll()` in Java

## Answer

Both `replace()` and `replaceAll()` are used to replace characters or sequences in a String, but they work differently.

| Feature | `replace()` | `replaceAll()` |
|---------|-------------|----------------|
| Replacement Type | Replaces literal characters or strings | Uses regular expressions (Regex) |
| Regex Support | ❌ No | ✅ Yes |
| Performance | Faster for simple replacements | Slower due to regex processing |
| Use Case | Simple character or text replacement | Pattern-based replacement |

---

# 1. `replace()`

The `replace()` method replaces all occurrences of a specific character or String with another character or String.

### Example (Character Replacement)

```java
String s = "Java";

System.out.println(s.replace('a', 'o'));
```

### Output

```text
Jovo
```

### Example (String Replacement)

```java
String s = "Java Programming";

System.out.println(s.replace("Java", "Python"));
```

### Output

```text
Python Programming
```

---

# 2. `replaceAll()`

The `replaceAll()` method uses **regular expressions** to find matching patterns and replace them.

### Example

```java
String s = "abc123";

System.out.println(s.replaceAll("\\d", ""));
```

### Output

```text
abc
```

### Explanation

- `\\d` is a regular expression that matches digits (`0-9`).
- All numbers are replaced with an empty String.

---

## More Examples

### Using `replace()`

```java
String s = "hello123";

System.out.println(s.replace("123", "world"));
```

Output:

```text
helloworld
```

---

### Using `replaceAll()`

```java
String s = "hello123";

System.out.println(s.replaceAll("\\d+", ""));
```

Output:

```text
hello
```

---

## Key Points

- Use `replace()` for simple character or String replacement.
- Use `replaceAll()` when you need pattern matching with regular expressions.
- `replace()` does not support regex.
- `replaceAll()` is more powerful but has additional processing overhead.


-------
-------


# 23. Difference Between `concat()` and `+` in Java

## Answer

Both `concat()` and the `+` operator are used to combine Strings in Java, but they work differently.

| Feature | `concat()` | `+` Operator |
|---------|------------|--------------|
| Purpose | Appends one String to another | Concatenates Strings with other values |
| Supports Other Data Types | ❌ No, accepts only String | ✅ Yes, supports int, char, boolean, objects, etc. |
| Internal Implementation | Uses String concatenation logic | Uses `StringBuilder` internally (for multiple concatenations) |
| Null Handling | Throws `NullPointerException` if argument is `null` | Converts `null` to the String `"null"` |

---

## 1. Using `concat()`

The `concat()` method appends another String value to the existing String.

### Example

```java
String s = "Java";

System.out.println(s.concat(" 17"));
```

### Output

```text
Java 17
```

### Note

`concat()` accepts only String arguments:

```java
String s = "Java";

s.concat(17); // Compilation Error
```

---

## 2. Using `+` Operator

The `+` operator can concatenate Strings with other data types because Java automatically converts non-String values into Strings.

### Example

```java
String s = "Java";

System.out.println(s + 17);
```

### Output

```text
Java17
```

### Example with Multiple Data Types

```java
String s = "Value: ";

System.out.println(s + 100 + true);
```

### Output

```text
Value: 100true
```

---

## Difference Example

```java
String s = "Java";

System.out.println(s.concat(" 17"));
System.out.println(s + 17);
```

### Output

```text
Java 17
Java17
```

---

## Key Points

- `concat()` is used only for combining Strings.
- `+` can concatenate Strings with any data type.
- Both return a new String because String objects are immutable.
- Use `+` for simple concatenation and `StringBuilder` for repeated concatenation in loops.


--------
-------


# 24. Is String Thread-Safe in Java?

## Answer

Yes, **String is thread-safe in Java** because it is **immutable**.

Since a `String` object cannot be modified after it is created, multiple threads can safely share the same String object without requiring synchronization.

---

## Example

```java
String message = "Hello";

Thread t1 = new Thread(() -> {
    System.out.println(message);
});

Thread t2 = new Thread(() -> {
    System.out.println(message);
});

t1.start();
t2.start();
```

### Output

```text
Hello
Hello
```

Both threads can access the same String object safely because its value cannot be changed.

---

## Why is String Thread-Safe?

### 1. Immutability

```java
String s = "Java";

s = s.concat(" Programming");
```

The original String `"Java"` is not modified. A new String object is created:

```text
Original Object:
"Java"

New Object:
"Java Programming"
```

No thread can modify the existing String object.

---

### 2. No Synchronization Required

Since String objects cannot change:

- Multiple threads can read the same String safely.
- No locking or synchronization is required.
- There is no risk of data corruption.

---

## Comparison with Mutable Classes

| Class | Mutable | Thread-Safe |
|-------|---------|-------------|
| `String` | ❌ No | ✅ Yes |
| `StringBuffer` | ✅ Yes | ✅ Yes |
| `StringBuilder` | ✅ Yes | ❌ No |

---

## Key Points

- `String` is thread-safe because it is immutable.
- Multiple threads can share the same String object safely.
- No synchronization is required for String operations.
- Any modification creates a new String object instead of changing the original one.



