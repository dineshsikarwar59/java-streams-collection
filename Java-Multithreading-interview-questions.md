# Java Multithreading Interview Questions and Answers

### 1. What is a Thread in Java?

**Answer:**

A thread is a lightweight sub-process that allows a program to perform multiple tasks concurrently. Threads enable multitasking by allowing different parts of a program to execute independently.

**Example:**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

**Key Points:**

- A thread is the smallest unit of execution within a process.
- Multiple threads can run concurrently within the same program.
- The `start()` method creates a new thread and internally calls the `run()` method.
- Threads are commonly used for improving application performance and responsiveness.

-------------------
------------------

### 2. What is Multithreading?

**Answer:**

Multithreading is a feature in Java that allows multiple threads to execute concurrently within a single program. It enables a program to perform multiple tasks at the same time, improving performance and responsiveness.

**Benefits of Multithreading:**

- **Better CPU utilization:** Makes efficient use of CPU resources by running multiple tasks.
- **Faster execution:** Allows independent tasks to execute concurrently.
- **Improved application responsiveness:** Keeps applications responsive while background tasks run.
- **Parallel task execution:** Enables multiple operations to progress simultaneously.

**Example:**

```java
class Task extends Thread {
    public void run() {
        System.out.println("Task is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Task t1 = new Task();
        Task t2 = new Task();

        t1.start();
        t2.start();
    }
}
```

------------------
--------------------



### 3. What are the ways to create a thread in Java?

**Answer:**

There are three common ways to create threads in Java:

### 1. Extending `Thread` class

A class can extend the `Thread` class and override the `run()` method.

**Example:**

```java
class Test extends Thread {
    public void run() {
        System.out.println("Thread started");
    }
}
```

**Creating and starting the thread:**

```java
Test t = new Test();
t.start();
```

---

### 2. Implementing `Runnable` interface

A class can implement the `Runnable` interface and provide the implementation of the `run()` method.

**Example:**

```java
class Test implements Runnable {
    public void run() {
        System.out.println("Thread started");
    }
}
```

**Creating and starting the thread:**

```java
Test obj = new Test();
Thread t = new Thread(obj);
t.start();
```

---

### 3. Using Executor Framework

The Executor Framework manages thread creation and execution using thread pools.

**Example:**

```java
ExecutorService service = Executors.newFixedThreadPool(2);

service.submit(() -> 
    System.out.println("Task")
);

service.shutdown();
```

**Key Points:**

- Extending `Thread` is simple but does not support multiple inheritance.
- Implementing `Runnable` is preferred because it separates the task from the thread.
- Executor Framework is commonly used in real-world applications for efficient thread management.

----------------
----------------


### 4. Difference between `start()` and `run()`

**Answer:**

| `start()` | `run()` |
|-----------|---------|
| Creates a new thread | Executes like a normal method |
| Calls the JVM thread scheduler | No new thread is created |
| Executes asynchronously | Executes synchronously |
| Internally calls the `run()` method | Contains the code executed by the thread |

**Example:**

```java
Thread thread = new Thread(() -> {
    System.out.println("Thread is running");
});

thread.start(); // Creates a new thread
thread.run();   // Executes in the same thread
```

**Key Points:**

- Always use `start()` to begin thread execution.
- Calling `run()` directly does not start a new thread; it executes in the current thread.
- The JVM creates a new call stack when `start()` is called.



--------------
--------------


### 5. What are the states of a thread in Java?

**Answer:**

A thread in Java goes through different states during its lifecycle. These states are defined in the `Thread.State` enum.

**Java Thread Lifecycle:**

```text
NEW
 |
RUNNABLE
 |
RUNNING
 |
BLOCKED / WAITING / TIMED_WAITING
 |
TERMINATED
```

**Thread States:**

| State | Description |
|-------|-------------|
| `NEW` | Thread is created but has not started yet. |
| `RUNNABLE` | Thread is ready to run and waiting for CPU time. |
| `RUNNING` | Thread is actively executing its `run()` method. |
| `BLOCKED` | Thread is waiting to acquire a lock held by another thread. |
| `WAITING` | Thread waits indefinitely until another thread performs a specific action. |
| `TIMED_WAITING` | Thread waits for a specified amount of time. |
| `TERMINATED` | Thread has completed execution or has stopped due to an exception. |

**Example:**

```java
Thread t = new Thread();

System.out.println(t.getState()); // NEW

t.start();

System.out.println(t.getState()); // RUNNABLE
```

**Key Point:**

Thread states in Java are managed by the JVM and can be checked using the `getState()` method.


------------------
----------------


### 6. Difference between Process and Thread

**Answer:**

| Process | Thread |
|---------|--------|
| An independent execution unit | A lightweight execution unit within a process |
| Has separate memory space | Shares memory with other threads of the same process |
| Requires more system resources | Requires fewer system resources |
| Communication between processes is slower | Communication between threads is faster |
| Creation and context switching are expensive | Creation and context switching are comparatively faster |

**Key Points:**

- A process can contain multiple threads.
- Threads within the same process share resources like memory and files.
- Multithreading improves application performance by allowing concurrent task execution.


----------------
---------------



### 7. What is the difference between `sleep()` and `wait()`?

**Answer:**

| `sleep()` | `wait()` |
|-----------|----------|
| Method of `Thread` class | Method of `Object` class |
| Does not release the lock | Releases the lock while waiting |
| Used for introducing a time delay | Used for thread communication |
| Can be called from any context | Must be called inside a synchronized context |
| After the sleep time completes, the thread resumes automatically | Resumes when `notify()` or `notifyAll()` is called |

**Example:**

**Using `sleep()`:**

```java
Thread.sleep(1000);
```

**Using `wait()`:**

```java
synchronized(obj) {
    obj.wait();
}
```

**Key Points:**

- `sleep()` pauses the current thread for a specified duration.
- `wait()` releases the object's lock and waits for another thread to notify it.
- `wait()`, `notify()`, and `notifyAll()` are used for inter-thread communication.


------------
------------


### 8. What is synchronization in Java?

**Answer:**

Synchronization is a mechanism in Java that controls access to shared resources by allowing only one thread at a time to execute a critical section. It helps prevent data inconsistency and race conditions in multithreaded programs.

**Example:**

```java
synchronized void display() {
    System.out.println("Hello");
}
```

**Types of Synchronization:**

1. **Synchronized Method**

```java
synchronized void method() {
    // critical section
}
```

2. **Synchronized Block**

```java
void method() {
    synchronized(this) {
        // critical section
    }
}
```

**Key Points:**

- Synchronization provides thread safety.
- It prevents multiple threads from modifying shared data at the same time.
- It uses an object's lock (monitor) to control access.
- Excessive synchronization can reduce performance due to thread waiting.



--------------
--------------
