# Java Collection Framework Interview Questions

## 1. What is the Java Collection Framework?

**Answer:**

The **Java Collection Framework (JCF)** is a set of classes and interfaces that provides reusable data structures and algorithms to store and manipulate groups of objects efficiently.

### Main Interfaces

- **List:** If we want to represent a group of individual objects as a single entity where “duplicates are allow and insertion order must be preserved” then we should go for List interface.
- **Set:** If we want to represent a group of individual objects as single entity “where duplicates are not allow and insertion order is not preserved” then we should go for Set interface.
- **Queue:** If we want to represent a group of individual objects prior to processing then we should go for queue concept.
- **Map:** If we want to represent a group of objects as key-value pairs then we should go for Map interface.
          *(not part of the `Collection` interface, but part of the Java Collections Framework)*

  -----------------
  ----------------

  ## 2. Difference between `Collection` and `Collections`

| `Collection` | `Collections` |
|--------------|---------------|
| **Interface** | **Utility class** |
| Used to store and manage groups of objects | Provides utility methods for collection objects |
| Parent interface of `List`, `Set`, and `Queue` | Contains methods like `sort()`, `reverse()`, `binarySearch()`, `shuffle()`, etc. |

**Example**

- **Collection:** `List`, `Set`, `Queue`
- **Collections:** `Collections.sort(list)`, `Collections.reverse(list)`, `Collections.binarySearch(list, key)`


-------
--------

## 3. Difference between `List` and `Set`

| `List` | `Set` |
|--------|-------|
| Allows duplicate elements | Does not allow duplicate elements |
| Maintains insertion order | May or may not maintain insertion order (depends on the implementation) |
| Index-based (elements can be accessed by index) | Not index-based |

### Example

```java
List<String> list = new ArrayList<>();
list.add("Java");
list.add("Java"); // Allowed

Set<String> set = new HashSet<>();
set.add("Java");
set.add("Java"); // Ignored
```

--------------
----------------

## 4. Difference between `ArrayList` and `LinkedList`

| `ArrayList` | `LinkedList` |
|-------------|--------------|
| Uses a dynamic array | Uses a doubly linked list |
| Fast random access (`get(index)`) | Slow random access |
| Slow insertion/deletion in the middle (elements need to be shifted) | Fast insertion/deletion in the middle (no shifting required) |
| Uses less memory | Uses more memory (stores extra node references) |

### When to Use

- **Use `ArrayList`** when frequent element access is required.
- **Use `LinkedList`** when frequent insertions and deletions are required, especially in the middle of the list.


--------------
--------------


## 5. Difference between `HashMap` and `Hashtable`

| `HashMap` | `Hashtable` |
|------------|-------------|
| Not synchronized | Synchronized (thread-safe) |
| Allows one `null` key | Does not allow `null` keys |
| Allows multiple `null` values | Does not allow `null` values |
| Faster due to no synchronization overhead | Slower because of synchronization |

### When to Use

- **Use `HashMap`** for better performance in single-threaded or externally synchronized applications.
- **Use `Hashtable`** only when you specifically need its legacy synchronized behavior. In modern Java, `ConcurrentHashMap` is generally preferred for thread-safe map operations.

-----------
-----------


## 6. Difference between `HashMap` and `ConcurrentHashMap`

| `HashMap` | `ConcurrentHashMap` |
|------------|---------------------|
| Not thread-safe | Thread-safe |
| Faster in single-threaded applications | Designed for concurrent (multi-threaded) applications |
| May throw `ConcurrentModificationException` during concurrent modifications | Supports concurrent read and write operations safely |
| No internal synchronization | Uses bucket-level locking and other concurrency mechanisms for better performance |

### When to Use

- **Use `HashMap`** in single-threaded applications or when external synchronization is provided.
- **Use `ConcurrentHashMap`** in multi-threaded applications where multiple threads need to access and modify the map concurrently.

### Key Advantages of `ConcurrentHashMap`

- Thread-safe without locking the entire map.
- Better performance than `Hashtable` in concurrent environments.
- Allows multiple threads to read and write simultaneously with minimal contention.


-----------------------
----------------------


## 7. Difference between `HashSet` and `TreeSet`

| `HashSet` | `TreeSet` |
|------------|-----------|
| Does not maintain any ordering | Maintains elements in sorted (natural or custom) order |
| Faster for add, remove, and search operations | Slower due to sorting overhead |
| Internally uses a `HashMap` | Internally uses a `TreeMap` |
| Allows one `null` element | Does not allow `null` elements (throws `NullPointerException`) |

### When to Use

- **Use `HashSet`** when you need fast performance and ordering is not important.
- **Use `TreeSet`** when you need unique elements in sorted order.

### Example

```java
Set<String> hashSet = new HashSet<>();
hashSet.add("Banana");
hashSet.add("Apple");
hashSet.add("Mango");

Set<String> treeSet = new TreeSet<>();
treeSet.add("Banana");
treeSet.add("Apple");
treeSet.add("Mango");

System.out.println(hashSet); // Order is not guaranteed
System.out.println(treeSet); // [Apple, Banana, Mango]
```

--------------
--------------


## 8. Difference between `HashMap` and `TreeMap`

| `HashMap` | `TreeMap` |
|------------|-----------|
| Does not maintain any ordering | Stores entries in sorted order based on keys |
| Average time complexity: **O(1)** for `put()` and `get()` | Time complexity: **O(log n)** for `put()` and `get()` |
| Allows one `null` key and multiple `null` values | Does not allow `null` keys, but allows multiple `null` values |
| Internally uses a hash table | Internally uses a Red-Black Tree |

### When to Use

- **Use `HashMap`** when fast lookup is the priority and key ordering is not required.
- **Use `TreeMap`** when you need the keys to be stored in sorted order or need operations like `firstKey()`, `lastKey()`, `higherKey()`, and `lowerKey()`.

### Example

```java
Map<Integer, String> hashMap = new HashMap<>();
hashMap.put(3, "C");
hashMap.put(1, "A");
hashMap.put(2, "B");

Map<Integer, String> treeMap = new TreeMap<>();
treeMap.put(3, "C");
treeMap.put(1, "A");
treeMap.put(2, "B");

System.out.println(hashMap); // Order is not guaranteed
System.out.println(treeMap); // {1=A, 2=B, 3=C}
```


--------------
--------------


## 9. Why is `HashMap` so fast?

**Answer:**

`HashMap` is fast because it uses **hashing** to store and retrieve data directly using keys instead of searching through all elements.

### HashMap Uses

- **Hashing** - Converts a key into a hash value to determine the storage location.
- **`hashCode()`** - Generates a hash value for the key.
- **Buckets** - Stores entries in specific locations based on the hash value.
- **`equals()`** - Compares keys to handle collisions and find the exact entry.

### Time Complexity (Average Case)

| Operation | Complexity |
|-----------|------------|
| `put()` | O(1) |
| `get()` | O(1) |
| `remove()` | O(1) |

### Example

```java
Map<Integer, String> map = new HashMap<>();

map.put(101, "Java");
map.put(102, "Spring");

System.out.println(map.get(101)); // Java
```

The key `101` is converted into a hash value, which helps `HashMap` quickly locate the corresponding bucket and retrieve the value.


----------
---------



## 10. Difference between Fail-Fast and Fail-Safe Iterator

| Fail-Fast Iterator | Fail-Safe Iterator |
|--------------------|--------------------|
| Throws `ConcurrentModificationException` if the collection is modified during iteration | Works on a copy of the collection, so modifications do not affect the iterator |
| Does not allow structural modification while iterating | Allows modification while iterating |
| Faster because it does not create a copy | Slightly slower because it works with a copied collection |

### Fail-Fast Examples

- `ArrayList`
- `HashMap`
- `HashSet`

### Fail-Safe Examples

- `ConcurrentHashMap`
- `CopyOnWriteArrayList`

### Example: Fail-Fast

```java
List<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");

for (String item : list) {
    list.add("C++"); // Throws ConcurrentModificationException
}
```

### Example: Fail-Safe

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

list.add("Java");
list.add("Python");

for (String item : list) {
    list.add("C++"); // Allowed
}
```

------------------
-----------------

## 11. What is Load Factor?

**Answer:**

The **load factor** determines when a `HashMap` should resize (increase its capacity).

It represents the percentage of the capacity that can be filled before the `HashMap` is expanded and the entries are rehashed.

### Default Load Factor

```
0.75
```

### Formula

```
Threshold = Capacity × Load Factor
```

### Example

```java
HashMap<Integer, String> map = new HashMap<>();
```

Default:

- Initial Capacity = `16`
- Load Factor = `0.75`

```
Threshold = 16 × 0.75 = 12
```

When the number of entries reaches **12**, the `HashMap` increases its capacity and rehashes the existing entries.

### Why 0.75?

- Provides a good balance between memory usage and performance.
- Reduces collisions while avoiding unnecessary resizing.


-----------
----------


## 12. What is Initial Capacity?

**Answer:**

The **initial capacity** is the number of buckets created when a `HashMap` is initialized.

### Default Initial Capacity of `HashMap`

```
16
```

### Example

```java
HashMap<Integer, String> map = new HashMap<>();
```

By default:

- Initial Capacity = `16`
- Load Factor = `0.75`
- Resize Threshold = `16 × 0.75 = 12`

When the number of entries exceeds the threshold, the `HashMap` increases its capacity and rehashes the existing entries.

### Custom Initial Capacity Example

```java
HashMap<Integer, String> map = new HashMap<>(32);
```

Here, the initial capacity is set to `32`.

---------
-------------


## 13. What happens if two keys have the same hash code?

**Answer:**

When two keys generate the same hash code, it is called a **hash collision**.

`HashMap` handles collisions by storing both entries in the same bucket and uses the **`equals()`** method to distinguish between the keys.

### How HashMap Handles Collision

1. `hashCode()` is used to find the bucket location.
2. If multiple keys are mapped to the same bucket, `equals()` is used to compare the keys.
3. If keys are different, both entries are stored in the same bucket.

### Example

```java
HashMap<Employee, String> map = new HashMap<>();

map.put(emp1, "Developer");
map.put(emp2, "Tester");
```

If `emp1` and `emp2` have the same hash code, `HashMap` stores them in the same bucket and uses `equals()` to identify the correct object.

### Key Points

- Same `hashCode()` does not mean objects are equal.
- If `equals()` returns `true`, the existing value is replaced.
- If `equals()` returns `false`, both entries are stored.


--------------
--------------


## 14. Why should `equals()` and `hashCode()` be overridden together?

**Answer:**

`equals()` and `hashCode()` should always be overridden together because they follow a contract in Java.

If two objects are considered equal according to the **`equals()`** method, they **must return the same hash code** using the **`hashCode()`** method.

Otherwise, collections like `HashMap` and `HashSet` may not work correctly because they use `hashCode()` to locate objects and `equals()` to compare them.

### Example

```java
class Employee {
    int id;
    String name;

    @Override
    public boolean equals(Object obj) {
        Employee emp = (Employee) obj;
        return this.id == emp.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
```

### Key Points

- `HashMap` uses `hashCode()` to find the bucket.
- `equals()` is used to compare keys within the bucket.
- If `equals()` is overridden but `hashCode()` is not, equal objects may be stored in different buckets.
- This can cause incorrect behavior in `HashMap` and `HashSet`.


----------------
---------------


## 15. Can `HashMap` have duplicate keys?

**Answer:**

No, `HashMap` **does not allow duplicate keys**.

If a new value is added with an existing key, the old value is replaced by the new value.

### Example

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "A");
map.put(1, "B");

System.out.println(map);
```

### Output

```text
{1=B}
```

### Key Points

- Each key in a `HashMap` must be unique.
- Duplicate keys replace the existing value.
- Multiple keys can have the same value.
- `HashMap` allows one `null` key and multiple `null` values.


----------------
----------------



## 17. Difference between `Iterator` and `ListIterator`

| `Iterator` | `ListIterator` |
|------------|----------------|
| Supports forward traversal only | Supports both forward and backward traversal |
| Works with all collection classes (`List`, `Set`, `Queue`, etc.) | Works only with `List` implementations |
| Cannot add elements during iteration | Can add elements during iteration |
| Can remove elements using `remove()` | Can use `add()`, `remove()`, and `set()` methods |
| Provides `hasNext()` and `next()` methods | Provides `hasNext()`, `next()`, `hasPrevious()`, and `previous()` methods |

### Example

#### Iterator

```java
List<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");

Iterator<String> iterator = list.iterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

#### ListIterator

```java
List<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");

ListIterator<String> iterator = list.listIterator();

while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

while (iterator.hasPrevious()) {
    System.out.println(iterator.previous());
}
```


----------------
---------------



## 18. Difference between `Comparable` and `Comparator`

| `Comparable` | `Comparator` |
|--------------|--------------|
| Used for natural sorting | Used for custom sorting |
| Uses the `compareTo()` method | Uses the `compare()` method |
| Implemented inside the class whose objects are being sorted | Implemented in a separate class or using a lambda expression |
| Allows only one default sorting logic | Allows multiple sorting strategies |

### Comparable Example

```java
class Employee implements Comparable<Employee> {

    int id;

    Employee(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.id - emp.id;
    }
}
```

### Comparator Example

```java
Comparator<Employee> comparator = (e1, e2) -> e1.id - e2.id;

Collections.sort(employeeList, comparator);
```

### Key Points

- Use **`Comparable`** when a class has a natural/default sorting order.
- Use **`Comparator`** when you need different sorting criteria, such as sorting by name, salary, or ID.


---------------
----------------


## 19. What is `CopyOnWriteArrayList`?

**Answer:**

`CopyOnWriteArrayList` is a **thread-safe implementation of the `List` interface** from the `java.util.concurrent` package.

In this collection, every **write operation** (`add()`, `set()`, `remove()`) creates a new copy of the underlying array instead of modifying the existing array directly.

It is ideal for scenarios where **read operations are frequent and write operations are rare**.

### Key Features

- Thread-safe without explicit synchronization.
- Provides safe iteration without `ConcurrentModificationException`.
- Best suited for read-heavy applications.
- Write operations are slower because a new array copy is created.

### Example

```java
CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

list.add("Java");
list.add("Spring");

for (String item : list) {
    System.out.println(item);
}
```

### Common Use Cases

- Configuration lists
- Listener collections
- Read-heavy multi-threaded applications

### Drawback

- Higher memory usage because a new copy of the array is created during every write operation.


----------------
------------------


## 20. Which Collection Should You Use?

| Requirement | Collection |
|-------------|------------|
| Ordered elements with duplicates | `ArrayList` |
| Frequent insertions and deletions | `LinkedList` |
| Unique elements | `HashSet` |
| Sorted unique elements | `TreeSet` |
| Key-value pairs | `HashMap` |
| Sorted key-value pairs | `TreeMap` |
| Thread-safe map | `ConcurrentHashMap` |
| Thread-safe list | `CopyOnWriteArrayList` |

### Quick Selection Guide

- Use **`ArrayList`** when you need fast access by index and insertion order.
- Use **`LinkedList`** when frequent additions and removals are required.
- Use **`HashSet`** when you need unique elements without ordering.
- Use **`TreeSet`** when unique elements must be sorted.
- Use **`HashMap`** for fast key-value storage and retrieval.
- Use **`TreeMap`** when keys need to be sorted.
- Use **`ConcurrentHashMap`** for thread-safe key-value operations in multi-threaded applications.
- Use **`CopyOnWriteArrayList`** for thread-safe lists with many reads and fewer writes.



-----------------
----------------



# Frequently Asked Interview Questions (Java Collections)

## Explain the hierarchy of the Collection Framework

**Answer:**

The **Java Collection Framework hierarchy** represents the relationship between different interfaces and classes used to store and manipulate groups of objects.

The main hierarchy starts with the **`Iterable`** interface, which is the parent of the **`Collection`** interface.

### Collection Framework Hierarchy

```
Iterable
   |
Collection
   |
   +-------------------+-------------------+
   |                   |                   |
  List                Set                Queue
   |                   |                   |
   |                   |                   |
ArrayList          HashSet            PriorityQueue
LinkedList         LinkedHashSet      ArrayDeque
Vector             TreeSet            LinkedList
Stack
```

### Map Hierarchy (Separate from Collection)

`Map` is part of the Java Collection Framework but does **not extend the `Collection` interface`.

```
Map
 |
 +-------------------+----------------+
 |                   |                |
HashMap          SortedMap        Hashtable
LinkedHashMap       |
                  TreeMap
ConcurrentHashMap
```

### Main Interfaces

### 1. `List`
- Maintains insertion order.
- Allows duplicate elements.
- Supports index-based access.

Examples:
- `ArrayList`
- `LinkedList`
- `Vector`
- `Stack`

### 2. `Set`
- Does not allow duplicate elements.
- Does not support index-based access.

Examples:
- `HashSet`
- `LinkedHashSet`
- `TreeSet`

### 3. `Queue`
- Used for processing elements in a specific order (usually FIFO).
- Mainly used for scheduling and buffering.

Examples:
- `PriorityQueue`
- `ArrayDeque`

### 4. `Map`
- Stores data in key-value pairs.
- Keys must be unique.

Examples:
- `HashMap`
- `LinkedHashMap`
- `TreeMap`
- `ConcurrentHashMap`

### Key Points

- `Collection` is the root interface for `List`, `Set`, and `Queue`.
- `Map` is separate and does not inherit from `Collection`.
- Classes like `ArrayList`, `HashSet`, and `HashMap` provide concrete implementations of these interfaces.

------------------------
-------------------------



## Explain the Internal Working of `HashMap`

**Answer:**

`HashMap` stores data in the form of **key-value pairs**. Internally, it uses an **array of buckets** and a hashing mechanism to store and retrieve entries efficiently.

### Internal Structure

`HashMap` contains:

- **Bucket array** - Stores references to nodes.
- **Hash value** - Determines the bucket location.
- **Node** - Stores key, value, hash, and reference to the next node.

Each entry internally looks like:

```
Node<K,V>
{
    int hash;
    K key;
    V value;
    Node next;
}
```

### How `put()` Works

When we add a key-value pair:

```java
map.put("Java", 100);
```

Steps:

1. **Calculate hash code**

```java
hash = key.hashCode();
```

2. **Calculate bucket index**

```
index = (n - 1) & hash
```

where `n` is the size of the bucket array.

3. **Store the entry**
   - If the bucket is empty, a new node is created.
   - If the bucket already contains entries, a collision occurs.

4. **Handle collision**
   - `HashMap` compares keys using `equals()`.
   - If the key already exists, the old value is replaced.
   - If the key is different, the new entry is stored in the same bucket.

### How `get()` Works

When retrieving a value:

```java
map.get("Java");
```

Steps:

1. Calculate the hash code of the key.
2. Find the corresponding bucket.
3. Compare keys using `equals()`.
4. Return the matching value.

### Hash Collision Handling

Before Java 8:

```
Bucket
 |
Node -> Node -> Node
```

Entries were stored as a linked list.

After Java 8:

- If collisions increase beyond a threshold (`8` nodes), the linked list is converted into a **balanced tree (Red-Black Tree)**.
- This improves searching performance.

### Resizing

`HashMap` resizes when:

```
Size > Capacity × Load Factor
```

Default values:

- Initial Capacity = `16`
- Load Factor = `0.75`
- Resize threshold = `16 × 0.75 = 12`

When resizing happens:
- A larger bucket array is created.
- Existing entries are rehashed and moved.

### Time Complexity

| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| `put()` | O(1) | O(log n) |
| `get()` | O(1) | O(log n) |
| `remove()` | O(1) | O(log n) |

### Example

```java
HashMap<Integer, String> map = new HashMap<>();

map.put(1, "Java");
map.put(2, "Spring");

System.out.println(map.get(1));
```

Output:

```text
Java
```

### Key Points

- `HashMap` uses `hashCode()` to find the bucket.
- `equals()` is used to compare keys.
- Duplicate keys replace existing values.
- It allows one `null` key and multiple `null` values.
- It provides average O(1) performance for insertion, retrieval, and deletion.


---------------------
----------------------


## What is Hashing?

**Answer:**

**Hashing** is a technique used to convert an object (usually a key) into a fixed-size integer value called a **hash code** using a hash function.

In Java, hashing is mainly used in collections like **`HashMap`**, **`HashSet`**, and **`Hashtable`** to store and retrieve data quickly.

### How Hashing Works

1. An object is passed to the `hashCode()` method.
2. The method generates an integer hash value.
3. The hash value is used to determine the storage location (bucket).
4. The object is stored or retrieved from that bucket.

### Example

```java
String key = "Java";

int hashCode = key.hashCode();

System.out.println(hashCode);
```

### Hashing in `HashMap`

When storing data:

```java
map.put("Java", 100);
```

Process:

```
Key
 |
hashCode()
 |
Hash Value
 |
Bucket Index
 |
Store Value
```

When retrieving data:

```java
map.get("Java");
```

Process:

```
Key
 |
hashCode()
 |
Find Bucket
 |
equals()
 |
Return Value
```

### Advantages of Hashing

- Provides fast data access.
- Average search, insertion, and deletion complexity is **O(1)**.
- Avoids searching through all elements.

### Key Points

- `hashCode()` generates the hash value.
- Multiple objects can have the same hash value, causing a **hash collision**.
- `equals()` is used to distinguish objects when collisions occur.
- Hashing is the core mechanism behind `HashMap` and `HashSet`.

---------------------
--------------------

## What is a Hash Collision?

**Answer:**

A **hash collision** occurs when two different keys generate the same hash value using the `hashCode()` method.

Since multiple keys can have the same hash value, `HashMap` stores them in the same bucket and uses the **`equals()`** method to identify the correct key.

### Example

```java
HashMap<Employee, String> map = new HashMap<>();

map.put(emp1, "Developer");
map.put(emp2, "Tester");
```

If `emp1` and `emp2` produce the same hash code:

```
Hash Code
    |
    v
+---------+
| Bucket  |
+---------+
    |
    +--> emp1 -> Developer
    |
    +--> emp2 -> Tester
```

`HashMap` uses `equals()` to compare the keys and find the exact entry.

### How HashMap Handles Collision

1. Calculate the key's `hashCode()`.
2. Find the bucket using the hash value.
3. If the bucket already contains entries, compare keys using `equals()`.
4. Store the new entry if the keys are different.

### Key Points

- Same `hashCode()` does **not** mean objects are equal.
- Different objects can have the same hash value.
- `equals()` and `hashCode()` should be overridden together.
- Java 8+ converts a heavily-collided bucket from a linked list to a **Red-Black Tree** to improve performance.
