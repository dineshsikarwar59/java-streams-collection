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
