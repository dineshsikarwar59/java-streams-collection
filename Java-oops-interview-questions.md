# Java OOPs Interview Questions and Answers

## 1. What is OOP in Java?

**Answer:**

OOP (Object-Oriented Programming) is a programming approach based on objects and classes. It allows developers to create reusable, maintainable, and modular code.

### The four main principles of OOP are:

1. **Encapsulation**
2. **Inheritance**
3. **Polymorphism**
4. **Abstraction**

------------------
------------------

## 2. What are the main features of OOP?

**Answer:**

The main features of OOP are:

1. **Encapsulation**
   
   Wrapping data and methods into a single unit (class).

2. **Inheritance**
   
   Acquiring properties and behavior from another class.

3. **Polymorphism**
   
   Ability to perform one action in different ways.

5. **Abstraction**
   
   Hiding implementation details and showing only essential features.

------------------
------------------


## 3. What is a class in Java?

**Answer:**

A class is a blueprint or template used to create objects.

### Example:

```java
class Student {
    int id;
    String name;

    void display() {
        System.out.println(name);
    }
}
```

---------------------------
----------------------------


## 4. What is an object in Java?

**Answer:**

An **object** is an instance of a class that represents a real-world entity. It contains data and behavior defined by the class.

An object has three main characteristics:

1. **State**
   - Represents the data or properties of an object.
   - Stored using variables.

2. **Behavior**
   - Represents the actions an object can perform.
   - Defined using methods.

3. **Identity**
   - Represents the unique reference of an object in memory.

### Example

```java
class Employee {
    String name;  // State

    void work() {  // Behavior
        System.out.println("Employee is working");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee(); // Object creation

        emp.name = "John";
        emp.work();
    }
}
```

### Key Points

- A class is a blueprint, while an object is the actual instance created from that blueprint.
- Multiple objects can be created from a single class.
- Objects are created using the `new` keyword.
- Each object has its own state but shares the same class behavior.


-----------------------
-----------------------


## 5. What is the difference between Class and Object?

| `Class` | `Object` |
|---------|----------|
| A blueprint or template used to create objects | An instance of a class |
| A logical entity | A physical entity |
| Does not occupy memory for instance data | Occupies memory when created |
| Defines properties and behaviors | Represents actual data and behavior |
| Example: Car design | Example: Actual car |

### Example

```java
class Car {
    String color;

    void drive() {
        System.out.println("Car is driving");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car(); // Object creation
        car.color = "Red";
        car.drive();
    }
}
```

### Key Points

- A **class** defines the structure and behavior.
- An **object** is the real-world entity created from the class.
- One class can create multiple objects.
- Each object can have its own state.

------------------------
-------------------------


## 6. What is encapsulation?

**Answer:**

Encapsulation means binding data and methods together inside a class and restricting direct access to data.

It is achieved using:

1. **Private variables**
2. **Public getter and setter methods**

### Example:

```java
class Account {

    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
```

-------------------
-------------------

## 7. What are the advantages of encapsulation?

**Answer:**

**Encapsulation** is the process of wrapping data (variables) and methods that operate on the data into a single unit (class) and restricting direct access to the internal state of an object.

### Advantages of Encapsulation

1. **Provides data security**
   - Prevents direct access to class variables by making them `private`.
   - Protects data from unauthorized modification.

2. **Improves maintainability**
   - Changes in internal implementation do not affect other parts of the application.
   - Makes code easier to manage and debug.

3. **Allows controlled access**
   - Provides access to data through getter and setter methods.
   - Allows validation before modifying values.

4. **Makes code flexible**
   - Internal implementation can be changed without affecting external code.
   - Supports better code reusability and scalability.

### Example

```java
class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }
}
```

### Key Points

- Use `private` variables to achieve data hiding.
- Use getter and setter methods for controlled access.
- Encapsulation improves security, flexibility, and maintainability.

------------
------------


## 8. What is Inheritance in Java?

**Answer:**

**Inheritance** is an Object-Oriented Programming (OOP) feature that allows one class to acquire the properties (variables) and behaviors (methods) of another class.

It promotes **code reusability** and allows a child class to use or extend the functionality of a parent class.

Inheritance is achieved using the **`extends`** keyword.

### Syntax

```java
class Parent {
    // variables and methods
}

class Child extends Parent {
    // additional variables and methods
}
```

### Example

```java
class Animal {

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();  // Inherited method
        dog.bark();
    }
}
```

### Output

```text
Animal is eating
Dog is barking
```

### Advantages of Inheritance

1. **Code reusability** - Avoids duplicate code.
2. **Method overriding** - Allows child classes to provide their own implementation.
3. **Improves maintainability** - Makes code easier to manage and extend.

### Types of Inheritance Supported in Java

- Single inheritance
- Multilevel inheritance
- Hierarchical inheritance

> Java does not support multiple inheritance with classes to avoid ambiguity, but it can be achieved using interfaces.

----------------------
-----------------------


## 9. What are the types of Inheritance in Java?

**Answer:**

Inheritance allows a class to acquire properties and methods from another class. Java supports different types of inheritance through classes and interfaces.

### Types of Inheritance Supported in Java

### 1. Single Inheritance

A single child class inherits from a single parent class.

```
Parent
  |
Child
```

Example:

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}
```

---

### 2. Multilevel Inheritance

A class inherits from another derived class, creating a chain of inheritance.

```
Grandparent
     |
 Parent
     |
 Child
```

Example:

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Barking");
    }
}

class Puppy extends Dog {
    void play() {
        System.out.println("Playing");
    }
}
```

---

### 3. Hierarchical Inheritance

Multiple child classes inherit from a single parent class.

```
       Parent
       /    \
   Child1  Child2
```

Example:

```java
class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
}

class Cat extends Animal {
}
```

---

### Multiple Inheritance

Java **does not support multiple inheritance through classes**.

Example (Not allowed):

```
     A       B
      \     /
       \   /
        C
```

If both parent classes have the same method, it can create ambiguity (the **diamond problem**).

However, Java supports multiple inheritance using **interfaces**.

### Key Points

- Supported through classes:
  - Single inheritance
  - Multilevel inheritance
  - Hierarchical inheritance

- Not supported through classes:
  - Multiple inheritance

- Multiple inheritance can be achieved using interfaces.



-------------------------------
-------------------------------

## 10. Why does Java not support multiple inheritance with classes?

**Answer:**

Java does not support **multiple inheritance through classes** because it can create the **Diamond Problem**, which leads to ambiguity.

### Diamond Problem

The diamond problem occurs when a class inherits from two parent classes that have the same method. The child class becomes confused about which parent's method implementation it should use.

### Example

```
       A
      / \
     B   C
      \ /
       D
```

If both `B` and `C` inherit a method from `A` or override the same method, class `D` may not know which implementation to execute.

### Why Java Avoids It

To prevent this ambiguity, Java does not allow a class to extend multiple classes.

Example (Not Allowed):

```java
class A {
    void show() {
        System.out.println("A");
    }
}

class B extends A {
}

class C extends A {
}

// Not allowed in Java
class D extends B, C {
}
```

### Alternative Solution

Java supports multiple inheritance through **interfaces** because a class can implement multiple interfaces and provide its own method implementation.

```java
interface A {
    void show();
}

interface B {
    void display();
}

class C implements A, B {

    public void show() {
        System.out.println("Show");
    }

    public void display() {
        System.out.println("Display");
    }
}
```

### Key Point

- Multiple inheritance with classes is not supported due to the **Diamond Problem**.
- Multiple inheritance can be achieved using **interfaces** in Java.


---------------
--------------


## 11. What is Polymorphism?

**Answer:**

**Polymorphism** means **"many forms"**.

It is an Object-Oriented Programming (OOP) concept where a single action can behave differently depending on the object or situation.

In Java, polymorphism allows the same method name to perform different operations.

### Types of Polymorphism in Java

### 1. Compile-Time Polymorphism (Method Overloading)

- Achieved through **method overloading**.
- The method call is resolved at compile time.
- Same method name with different parameters.

Example:

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

---

### 2. Runtime Polymorphism (Method Overriding)

- Achieved through **method overriding**.
- The method call is resolved at runtime.
- A child class provides its own implementation of a parent class method.

Example:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Barking");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.sound();
    }
}
```

### Output

```text
Barking
```

### Key Points

- Polymorphism improves flexibility and code reusability.
- **Compile-time polymorphism** → Method overloading.
- **Runtime polymorphism** → Method overriding.
- Runtime polymorphism is achieved using inheritance and method overriding.


---------------
--------------

## 12. What is Method Overloading?

**Answer:**

**Method overloading** means having multiple methods with the **same name but different parameters** within the same class.

The difference can be based on:

- Number of parameters
- Type of parameters
- Order of parameters

Method overloading is an example of **compile-time polymorphism** because the compiler decides which method to execute during compilation.

### Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        System.out.println(calc.add(10, 20));
        System.out.println(calc.add(10, 20, 30));
        System.out.println(calc.add(10.5, 20.5));
    }
}
```

### Output

```text
30
60
31.0
```

### Key Points

- Same method name with different parameter lists.
- Return type alone cannot be used for method overloading.
- Improves code readability by using the same method name for similar operations.
- It is resolved at **compile time**.


-------------------------------
--------------------------------

## 13. What is Method Overriding?

**Answer:**

**Method overriding** occurs when a **child class provides its own implementation** of a method that is already defined in its parent class.

It is used to achieve **runtime polymorphism** because the method that gets executed is decided at runtime based on the actual object type.

### Example

```java
class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();
    }
}
```

### Output

```text
Dog barks
```

### Rules for Method Overriding

- Method name must be the same as the parent class method.
- Parameters must be the same.
- Return type must be the same or a covariant type.
- Access level cannot be more restrictive than the parent method.
- `final`, `static`, and `private` methods cannot be overridden.

### Key Points

- Achieved through inheritance.
- Provides a specific implementation in the child class.
- Resolved at **runtime**.
- It is an example of **runtime polymorphism**.


-------------------
--------------------


## 14. Difference between Method Overloading and Method Overriding

| Method Overloading | Method Overriding |
|--------------------|-------------------|
| Compile-time polymorphism | Runtime polymorphism |
| Occurs within the same class | Occurs between parent and child classes |
| Methods have the same name but different parameters | Methods have the same name and same parameters |
| Increases code readability | Provides a specific implementation of a parent method |
| Resolved by the compiler | Resolved at runtime |

### Key Difference

- **Overloading** → Same method name, different parameters, same class.
- **Overriding** → Same method signature, child class provides a new implementation.

------------
------------

## 15. What is Abstraction?

**Answer:**

**Abstraction** is an Object-Oriented Programming (OOP) concept that hides the **internal implementation details** and exposes only the required functionality to the user.

It focuses on **what an object does** rather than **how it does it**.

### Ways to Achieve Abstraction in Java

1. **Abstract Classes**
   - A class declared with the `abstract` keyword.
   - Can contain abstract methods (without implementation) and concrete methods (with implementation).
   - Cannot be instantiated directly.

2. **Interfaces**
   - Define a contract that classes must implement.
   - Supports full abstraction by hiding implementation details.

### Example Using Abstract Class

```java
abstract class Vehicle {

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}
```

### Example Using Interface

```java
interface Payment {

    void pay();
}

class CreditCard implements Payment {

    public void pay() {
        System.out.println("Payment completed using credit card");
    }
}
```

### Advantages of Abstraction

1. Hides unnecessary implementation details.
2. Improves security by exposing only required features.
3. Reduces code complexity.
4. Improves flexibility and maintainability.

### Key Points

- Abstraction focuses on **what an object does**.
- Achieved using **abstract classes and interfaces**.
- Helps create loosely coupled and maintainable applications.


------------------
------------------

## 16. What is an Abstract Class?

**Answer:**

An **abstract class** is a class that is declared using the **`abstract`** keyword.

It is used to provide a common base class where some methods can have implementation and some methods can be left for child classes to implement.

### Features of Abstract Class

1. **Can have abstract methods**
   - Methods without a body.
   - Must be implemented by the child class.

2. **Can have concrete methods**
   - Methods with complete implementation.

3. **Cannot create objects directly**
   - An abstract class cannot be instantiated using the `new` keyword.

### Example

```java
abstract class Animal {

    abstract void sound(); // Abstract method

    void eat() {           // Concrete method
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

### Object Creation

```java
// Not allowed
Animal animal = new Animal();

// Allowed
Animal animal = new Dog();
```

### Key Points

- Declared using the `abstract` keyword.
- Can contain both abstract and non-abstract methods.
- Provides partial abstraction.
- Child classes must implement all abstract methods.
- Cannot be instantiated directly.


----------------------
----------------------


## 17. What is an Interface in Java?

**Answer:**

An **interface** is a blueprint of a class that defines a set of methods that implementing classes must provide.

It is used to achieve **abstraction** and supports **multiple inheritance** in Java.

### Features of Interface

1. **Contains method declarations**
   - Classes that implement the interface must provide implementations for its methods.

2. **Supports multiple inheritance**
   - A class can implement multiple interfaces.

3. **Provides abstraction**
   - Hides implementation details and defines only required behavior.

4. **Cannot be instantiated**
   - Objects cannot be created directly from an interface.

### Example

```java
interface Animal {

    void sound(); // Abstract method
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

### Using Interface

```java
public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.sound();
    }
}
```

### Output

```text
Dog barks
```

### Key Points

- Declared using the `interface` keyword.
- Implemented using the `implements` keyword.
- Supports abstraction and loose coupling.
- A class can implement multiple interfaces.
- Interface methods are `public` and `abstract` by default (except `default` and `static` methods).


-------------------
------------------


## 18. Difference between Abstract Class and Interface

| Abstract Class | Interface |
|----------------|-----------|
| Can have constructors | Cannot have constructors |
| Can have instance variables | Variables are `public static final` by default (constants) |
| Supports partial abstraction | Supports full abstraction |
| Can have both abstract and concrete methods | Mainly defines a contract that implementing classes must follow |
| A class can extend only one abstract class | A class can implement multiple interfaces |
| Uses the `extends` keyword | Uses the `implements` keyword |

### Example: Abstract Class

```java
abstract class Vehicle {

    String color; // Instance variable

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("Car starts");
    }
}
```

### Example: Interface

```java
interface Vehicle {

    int wheels = 4; // public static final

    void start();
}

class Car implements Vehicle {

    public void start() {
        System.out.println("Car starts");
    }
}
```

### Key Differences

- Use an **abstract class** when classes share common behavior and state.
- Use an **interface** when you want to define a common contract for unrelated classes.
- Abstract classes provide **partial abstraction**.
- Interfaces provide **abstraction and multiple inheritance support**.


------------
--------------


## 19. What is a Constructor?

**Answer:**

A **constructor** is a special method in Java that is used to **initialize objects**.

It is automatically called when an object is created using the `new` keyword.

### Rules of Constructor

1. **Same name as the class**
   - Constructor name must exactly match the class name.

2. **No return type**
   - Constructors do not have any return type, not even `void`.

3. **Called automatically**
   - It is invoked automatically when an object is created.

### Example

```java
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee("John");

        emp.display();
    }
}
```

### Output

```text
John
```

### Types of Constructors

1. **Default Constructor**
   - A constructor with no parameters.
   - If no constructor is defined, Java provides a default constructor automatically.

2. **Parameterized Constructor**
   - A constructor that accepts parameters to initialize objects with specific values.

### Key Points

- Constructors are used for object initialization.
- They are called automatically during object creation.
- They cannot be inherited or overridden.
- A class can have multiple constructors using constructor overloading.


------------------
-----------------


## 20. Types of Constructors in Java

**Answer:**

Java mainly has two types of constructors:

### 1. Default Constructor

A **default constructor** is a constructor that does not have any parameters.

If no constructor is defined in a class, Java provides a default constructor automatically.

### Example

```java
class Employee {

    Employee() {
        System.out.println("Default constructor called");
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();
    }
}
```

### Output

```text
Default constructor called
```

---

### 2. Parameterized Constructor

A **parameterized constructor** is a constructor that accepts parameters to initialize objects with specific values.

### Example

```java
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(name);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee("John");

        emp.display();
    }
}
```

### Output

```text
John
```

### Key Points

- Constructors have the same name as the class.
- Constructors do not have a return type.
- Default constructor initializes objects with default values.
- Parameterized constructor initializes objects with user-provided values.
- Multiple constructors can be created using constructor overloading.



---------------
---------------

## 21. What is the use of the `this` keyword?

**Answer:**

The **`this`** keyword in Java refers to the **current object** of the class.

It is used to access current class variables, methods, and constructors.

### Uses of `this` Keyword

### 1. Access Current Class Variables

Used to differentiate between instance variables and local variables with the same name.

```java
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }
}
```

Here:
- `this.name` refers to the instance variable.
- `name` refers to the constructor parameter.

---

### 2. Call Current Class Methods

`this` can be used to call methods of the current class.

```java
class Employee {

    void display() {
        System.out.println("Employee details");
    }

    void show() {
        this.display();
    }
}
```

---

### 3. Call Current Class Constructor

`this()` is used to call another constructor of the same class.

```java
class Employee {

    Employee() {
        this("John");
    }

    Employee(String name) {
        System.out.println(name);
    }
}
```

### Key Points

- `this` refers to the current object.
- Used to access current class variables and methods.
- `this()` is used for constructor chaining.
- Cannot be used in a static method because static methods do not belong to an object.

----------------------
----------------------

## 21. What is the difference between `this` and `this()`?

**Answer:**

Both `this` and `this()` are related to the current class, but they are used for different purposes.

| `this` | `this()` |
|--------|----------|
| Refers to the current object | Calls another constructor of the same class |
| Used to access current class variables and methods | Used for constructor chaining |
| Used inside methods and constructors | Used only inside constructors |
| Does not call a constructor | Calls another constructor |

### Example of `this`

```java
class Employee {

    String name;

    Employee(String name) {
        this.name = name;
    }

    void display() {
        System.out.println(this.name);
    }
}
```

Here, `this.name` refers to the current object's instance variable.

---

### Example of `this()`

```java
class Employee {

    Employee() {
        this("John");
    }

    Employee(String name) {
        System.out.println(name);
    }
}
```

Here, `this()` calls another constructor of the same class.

### Key Points

- `this` → Refers to the current object.
- `this()` → Calls another constructor in the same class.
- `this()` must be the first statement inside a constructor.
- A constructor can use either `this()` or `super()`, but not both in the same constructor.


----------------------
-------------------------



## 22. What is the use of the `super` keyword?

**Answer:**

The **`super`** keyword in Java refers to the **immediate parent class object**.

It is used to access parent class variables, methods, and constructors from a child class.

### Uses of `super` Keyword

### 1. Access Parent Class Variables

Used when parent and child classes have variables with the same name.

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {
        System.out.println(super.name);
        System.out.println(name);
    }
}
```

Output:

```text
Animal
Dog
```

---

### 2. Call Parent Class Methods

Used to call a parent class method that has been overridden by the child class.

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barking");
    }
}
```

---

### 3. Call Parent Class Constructor

`super()` is used to call the parent class constructor.

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {
        super();
        System.out.println("Dog constructor");
    }
}
```

### Key Points

- `super` refers to the immediate parent class object.
- `super()` must be the first statement inside a child class constructor.
- Used for accessing parent class members.
- Helps achieve code reuse between parent and child classes.



--------------------------
-------------------------


## 23. What is the difference between `super` and `super()`?

**Answer:**

Both `super` and `super()` are used to access the parent class, but they have different purposes.

| `super` | `super()` |
|---------|-----------|
| Refers to the immediate parent class object | Calls the constructor of the immediate parent class |
| Used to access parent class variables and methods | Used to initialize the parent class part of an object |
| Used inside methods or constructors | Used only inside constructors |
| Does not call a constructor | Calls the parent constructor |

### Example of `super`

```java
class Animal {

    String name = "Animal";

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    String name = "Dog";

    void display() {
        System.out.println(super.name); // Access parent variable
        super.sound();                  // Call parent method
    }
}
```

---

### Example of `super()`

```java
class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }
}

class Dog extends Animal {

    Dog() {
        super(); // Calls parent constructor
        System.out.println("Dog constructor");
    }
}
```

### Output

```text
Animal constructor
Dog constructor
```

### Key Points

- `super` → Accesses parent class members.
- `super()` → Calls the parent class constructor.
- `super()` must be the first statement inside a child class constructor.
- If not written explicitly, Java automatically inserts `super()` as the first statement in a child constructor (if a no-argument parent constructor exists).



-------------------
------------------



## 23. Can we override static methods?

**Answer:**

No, **static methods cannot be overridden** because static methods belong to the **class**, not to objects.

They can be **hidden** by a child class, but they are not overridden.

### Example

```java
class Parent {

    static void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    static void display() {
        System.out.println("Child method");
    }
}
```

Here, the child class method hides the parent class static method.

### Key Points

- Static methods are resolved at compile time.
- Method overriding requires runtime polymorphism.
- Static methods belong to the class, so they cannot be overridden.

---

## 24. Can we override private methods?

**Answer:**

No, **private methods cannot be overridden** because they are not visible to child classes.

Private methods are accessible only within the same class.

### Example

```java
class Parent {

    private void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    // This is a new method, not overriding
    private void display() {
        System.out.println("Child method");
    }
}
```

### Key Points

- Private methods are not inherited.
- A child class cannot access or override them.
- A method with the same name in a child class is treated as a separate method.

---

## 25. Can constructors be inherited?

**Answer:**

No, **constructors cannot be inherited**.

Constructors belong only to their own class and are used to initialize objects of that class.

### Example

```java
class Parent {

    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {

    Child() {
        System.out.println("Child constructor");
    }
}
```

When a child object is created, the parent constructor is called using `super()`, but it is not inherited.

### Key Points

- Constructors are not inherited.
- Constructors are not overridden.
- Parent constructors can be called using `super()`.
- Each class has its own constructors.



----------------
------------------


## 26. What is the difference between IS-A and HAS-A relationship?

**Answer:**

In Java, **IS-A** and **HAS-A** relationships describe how classes are related to each other in Object-Oriented Programming.

| IS-A Relationship | HAS-A Relationship |
|-------------------|-------------------|
| Represents inheritance | Represents composition or aggregation |
| Shows that one object is a type of another object | Shows that one object contains another object |
| Achieved using `extends` or `implements` | Achieved by creating an object reference inside a class |
| Represents an "is a" relationship | Represents a "has a" relationship |
| Provides code reuse through inheritance | Provides flexibility through object composition |

### IS-A Relationship Example

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}
```

Here:

```
Dog IS-A Animal
```

`Dog` inherits properties and methods from `Animal`.

---

### HAS-A Relationship Example

```java
class Engine {

    void start() {
        System.out.println("Engine starts");
    }
}

class Car {

    Engine engine = new Engine();

    void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}
```

Here:

```
Car HAS-A Engine
```

The `Car` class contains an `Engine` object.

### Key Points

- **IS-A** → Achieved through inheritance (`extends`, `implements`).
- **HAS-A** → Achieved through object composition.
- IS-A represents specialization.
- HAS-A represents ownership or dependency.
- Prefer HAS-A relationships when you want more flexibility and loose coupling.


-----------
----------



## 28. What is the difference between Association, Aggregation, and Composition?

**Answer:**

Association, aggregation, and composition describe relationships between objects in Object-Oriented Programming.

| Association | Aggregation | Composition |
|-------------|-------------|-------------|
| Objects are connected or interact with each other | Represents weak ownership | Represents strong ownership |
| Both objects can exist independently | Child object can exist without the parent object | Child object cannot exist without the parent object |
| No ownership relationship | Has-A relationship with weak dependency | Has-A relationship with strong dependency |
| Loose coupling | Less strong than composition | Strong coupling |

### 1. Association

**Meaning:** Objects are connected but have no ownership relationship.

Example:

```java
class Teacher {

    void teach(Student student) {
        System.out.println("Teaching student");
    }
}

class Student {
}
```

Here:

```
Teacher is associated with Student
```

Both objects can exist independently.

---

### 2. Aggregation

**Meaning:** Represents a weak "HAS-A" relationship where one object contains another object, but both can exist independently.

Example:

```java
class Department {

    List<Employee> employees;
}

class Employee {
}
```

Here:

```
Department HAS-A Employee
```

If the department is removed, employees can still exist.

---

### 3. Composition

**Meaning:** Represents a strong "HAS-A" relationship where the child object's lifecycle depends on the parent object.

Example:

```java
class House {

    private Room room = new Room();
}

class Room {
}
```

Here:

```
House HAS-A Room
```

If the house is destroyed, its rooms also cannot exist independently.

### Key Points

- **Association** → Objects are connected.
- **Aggregation** → Weak ownership; objects have independent lifecycles.
- **Composition** → Strong ownership; child lifecycle depends on parent.
- Composition provides stronger encapsulation than aggregation.



----------
---------


## 29. What are Access Modifiers in Java?

**Answer:**

**Access modifiers** in Java are keywords that control the visibility and accessibility of classes, methods, variables, and constructors.

Java provides **four types of access modifiers**:

| Modifier | Access Level |
|----------|--------------|
| `private` | Accessible within the same class only |
| `default` | Accessible within the same package |
| `protected` | Accessible within the same package and subclasses |
| `public` | Accessible from anywhere |

### 1. `private`

- Provides the highest level of restriction.
- Members can be accessed only inside the same class.

```java
class Employee {

    private int salary;
}
```

---

### 2. `default` (Package-Private)

- No keyword is used.
- Accessible only within the same package.

```java
class Employee {

    int id; // default access
}
```

---

### 3. `protected`

- Accessible:
  - Within the same package.
  - In subclasses outside the package.

```java
class Employee {

    protected String name;
}
```

---

### 4. `public`

- Provides the least restriction.
- Accessible from any class.

```java
public class Employee {

    public void display() {
        System.out.println("Employee details");
    }
}
```

### Access Level Summary

| Modifier | Same Class | Same Package | Subclass | Everywhere |
|----------|------------|--------------|----------|------------|
| `private` | ✅ | ❌ | ❌ | ❌ |
| `default` | ✅ | ✅ | ❌* | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

### Key Points

- `private` is used for data hiding and encapsulation.
- `public` allows access from anywhere.
- `protected` is mainly used with inheritance.
- Default access is applied when no modifier is specified.


---------------
--------------


## 30. Do Access Modifiers Play Any Role in Method Overriding in Java?

**Answer:**

Yes, **access modifiers play an important role in method overriding**.

When a child class overrides a parent class method, the access level of the overridden method **cannot be more restrictive** than the parent method.

### Rules for Access Modifiers in Overriding

| Parent Method Access | Child Method Access |
|----------------------|---------------------|
| `public` | Must be `public` |
| `protected` | Can be `protected` or `public` |
| `default` | Can be `default`, `protected`, or `public` |
| `private` | Cannot be overridden |

### Example

```java
class Parent {

    protected void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    @Override
    public void display() {
        System.out.println("Child method");
    }
}
```

Here, the child class increases the visibility from `protected` to `public`, which is allowed.

### Invalid Example

```java
class Parent {

    public void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    // Not allowed
    protected void display() {
        System.out.println("Child method");
    }
}
```

A `public` method cannot be reduced to `protected` because it would restrict access.

### Key Points

- Overridden methods cannot have weaker access than parent methods.
- Child classes can increase visibility but cannot decrease it.
- `private` methods cannot be overridden because they are not inherited.
- Access modifiers help maintain the contract between parent and child classes.

-------------------
-----------------

## 32. Do Access Modifiers Play Any Role in Method Overloading in Java?

**Answer:**

No, **access modifiers do not play any role in method overloading**.

Method overloading is based on the **method signature**, which includes:

- Method name
- Number of parameters
- Type of parameters
- Order of parameters

Access modifiers (`private`, `default`, `protected`, `public`) do not determine whether methods can be overloaded.

### Example

```java
class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    private int add(int a, int b, int c) {
        return a + b + c;
    }
}
```

Here, both methods have the same name but different parameters, so overloading is valid.

### Invalid Overloading Example

```java
class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    private double add(int a, int b) {
        return a + b;
    }
}
```

This is **not allowed** because only the return type and access modifier are different.

### Key Points

- Access modifiers do not affect method overloading.
- Return type alone cannot be used for overloading.
- Overloading happens at compile time.
- Methods can have different access modifiers while being overloaded.


---------------------
--------------------


## 33. Do Access Exceptions Play Any Role in Method Overriding in Java?

**Answer:**

Yes, **access modifiers and exceptions play an important role in method overriding**.

When a child class overrides a parent class method, it **cannot reduce the access level** of the method and **cannot throw broader checked exceptions** than the parent method.

### Rules for Exceptions in Method Overriding

1. **Child class can throw the same checked exception**

```java
class Parent {

    void display() throws IOException {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    @Override
    void display() throws IOException {
        System.out.println("Child method");
    }
}
```

---

2. **Child class can throw a subclass of the parent exception**

```java
class Parent {

    void display() throws Exception {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    @Override
    void display() throws IOException {
        System.out.println("Child method");
    }
}
```

`IOException` is a subclass of `Exception`, so this is allowed.

---

3. **Child class cannot throw a broader checked exception**

```java
class Parent {

    void display() throws IOException {
    }
}

class Child extends Parent {

    // Not allowed
    void display() throws Exception {
    }
}
```

`Exception` is broader than `IOException`, so this causes a compilation error.

---

4. **Unchecked exceptions are not restricted**

Runtime exceptions (`RuntimeException` and its subclasses) can be thrown freely.

```java
class Parent {

    void display() {
    }
}

class Child extends Parent {

    @Override
    void display() throws ArithmeticException {
    }
}
```

This is valid because `ArithmeticException` is an unchecked exception.

### Key Points

- Overridden methods cannot throw broader checked exceptions.
- They can throw the same or narrower checked exceptions.
- Unchecked exceptions have no such restriction.
- Access modifiers and exception handling maintain the contract between parent and child classes.



------------------
-----------------


## 34. Do Exceptions Play Any Role in Method Overloading in Java?

**Answer:**

No, **exceptions do not play any role in method overloading**.

Method overloading is determined by the **method signature**, which includes:

- Method name
- Number of parameters
- Type of parameters
- Order of parameters

The exception type thrown by a method is **not considered** while deciding method overloading.

### Invalid Example

```java
class Calculator {

    void calculate() throws IOException {
        System.out.println("Method 1");
    }

    void calculate() throws SQLException {
        System.out.println("Method 2");
    }
}
```

This is **not allowed** because both methods have the same signature.

### Valid Example

```java
class Calculator {

    void calculate() throws IOException {
        System.out.println("Method with no parameter");
    }

    void calculate(int value) throws SQLException {
        System.out.println("Method with parameter");
    }
}
```

Here, methods are overloaded because their parameters are different.

### Key Points

- Exceptions are ignored during method overloading.
- Return type alone cannot be used for overloading.
- Access modifiers do not affect overloading.
- Method overloading is resolved at **compile time**.

-----------------------
-----------------------


## 35. What is an Interface in Java? What are the New Enhancements in Interface till Java 21?

**Answer:**

An **interface** in Java is a blueprint of a class that defines a contract that implementing classes must follow.

It is used to achieve **abstraction**, **loose coupling**, and **multiple inheritance** in Java.

An interface is declared using the **`interface`** keyword and implemented using the **`implements`** keyword.

### Example

```java
interface Vehicle {

    void start();
}

class Car implements Vehicle {

    @Override
    public void start() {
        System.out.println("Car starts");
    }
}
```

### Features of Interface

- Cannot create objects directly.
- Methods are `public abstract` by default (except default, static, and private methods).
- Variables are `public static final` constants by default.
- A class can implement multiple interfaces.
- Supports abstraction and loose coupling.

---

# Interface Enhancements in Java Versions

## 1. Java 8 - Default Methods

Before Java 8, interfaces could contain only abstract methods.

Java 8 introduced **default methods**, allowing interfaces to have method implementations.

### Example

```java
interface Vehicle {

    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {
}
```

Benefits:
- Allows adding new methods to interfaces without breaking existing implementations.
- Supports backward compatibility.

---

## 2. Java 8 - Static Methods in Interfaces

Interfaces can contain static methods with implementation.

### Example

```java
interface Vehicle {

    static void info() {
        System.out.println("Vehicle information");
    }
}

class Main {

    public static void main(String[] args) {
        Vehicle.info();
    }
}
```

Static interface methods are called using the interface name.

---

## 3. Java 9 - Private Methods in Interfaces

Java 9 introduced private methods inside interfaces.

They are used to share common code between default and static methods.

### Example

```java
interface Vehicle {

    default void start() {
        checkEngine();
        System.out.println("Vehicle started");
    }

    private void checkEngine() {
        System.out.println("Engine checked");
    }
}
```

Benefits:
- Avoids duplicate code.
- Improves code organization.

---

## 4. Java 9 - Private Static Methods in Interfaces

Java 9 also allows private static methods inside interfaces.

```java
interface Vehicle {

    static void display() {
        calculate();
    }

    private static void calculate() {
        System.out.println("Calculation");
    }
}
```

---

## 5. Java 14 - Interface Improvements

Java 14 introduced improvements around language features, but there were **no major new interface-specific changes**.

Interfaces continued supporting:
- Abstract methods
- Default methods
- Static methods
- Private methods

---

## 6. Java 21 - Interface Support

Java 21 does **not introduce any new major interface features**.

Interfaces in Java 21 continue to support:

- Abstract methods
- Default methods
- Static methods
- Private methods
- Private static methods
- Sealed interfaces

---

## 7. Java 17 - Sealed Interfaces

Java 17 introduced **sealed interfaces** (finalized from preview).

A sealed interface restricts which classes or interfaces can implement it.

### Example

```java
sealed interface Shape
    permits Circle, Rectangle {
}

final class Circle implements Shape {
}

final class Rectangle implements Shape {
}
```

Benefits:
- Better control over inheritance.
- Improves maintainability and security.

---

# Interface Evolution Summary

| Java Version | Enhancement |
|--------------|-------------|
| Java 8 | Default methods |
| Java 8 | Static methods |
| Java 9 | Private methods |
| Java 9 | Private static methods |
| Java 17 | Sealed interfaces |
| Java 21 | No major new interface feature |

### Key Points

- Interface defines a contract for classes.
- Java 8 made interfaces more flexible by adding default and static methods.
- Java 9 added private helper methods.
- Java 17 added sealed interfaces.
- Java 21 continues these features without major interface changes.
