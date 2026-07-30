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



### 9. Why do we need synchronization?

**Answer:**

Synchronization is needed to prevent race conditions when multiple threads access and modify shared data at the same time. It ensures that only one thread can execute a critical section at a time, maintaining data consistency.

**Example Problem:**

```java
count++;
```

When multiple threads execute this statement simultaneously, the value of `count` may be updated incorrectly because the operation involves multiple steps:

1. Read the current value of `count`
2. Increment the value
3. Write the updated value back

Without synchronization, multiple threads may overwrite each other's changes.

**Example with synchronization:**

```java
synchronized void increment() {
    count++;
}
```

**Key Points:**

- Prevents race conditions.
- Ensures thread-safe access to shared resources.
- Maintains data consistency in multithreaded applications.
- Helps avoid unexpected results caused by concurrent execution.


-------------------
-----------------


### 10. What is a race condition?

**Answer:**

A race condition occurs when multiple threads access and modify shared data simultaneously, causing unexpected or inconsistent results. The final output depends on the order in which threads execute.

**Example:**

```java
count++;
```

If two threads increment the same counter at the same time, both threads may read the same old value and update it incorrectly.

**Example Scenario:**

```text
Initial count = 0

Thread 1 reads count = 0
Thread 2 reads count = 0

Thread 1 updates count = 1
Thread 2 updates count = 1

Expected result: 2
Actual result: 1
```

**Prevention:**

- Use synchronization.
- Use atomic classes like `AtomicInteger`.
- Use thread-safe collections.

**Key Point:**

Race conditions occur when threads compete to access shared resources without proper synchronization.


-----------
------------


### 11. What is a synchronized block?

**Answer:**

A synchronized block is a section of code that is locked using the `synchronized` keyword. It allows only one thread at a time to execute that specific section instead of locking the entire method.

**Example:**

```java
public void update() {
    synchronized(this) {
        count++;
    }
}
```

**Key Points:**

- Provides thread safety for critical sections of code.
- Improves performance compared to synchronizing the entire method because only the required code is locked.
- Uses an object lock (monitor) to control thread access.
- Other threads can execute non-synchronized parts of the method simultaneously.

**Example with a shared resource:**

```java
class Counter {
    int count = 0;

    public void increment() {
        synchronized(this) {
            count++;
        }
    }
}
```


-----------
----------

### 12. Difference between synchronized method and synchronized block

**Answer:**

| Synchronized Method | Synchronized Block |
|---------------------|--------------------|
| Locks the entire method | Locks only the specific section of code |
| Less flexible because the whole method is synchronized | More flexible because only required code is synchronized |
| Easier to implement | Provides better performance by reducing lock scope |
| May reduce performance due to longer lock duration | Improves efficiency by minimizing thread waiting |

**Example:**

**Synchronized Method:**

```java
synchronized void display() {
    // Entire method is locked
}
```

**Synchronized Block:**

```java
void display() {
    synchronized(this) {
        // Only this block is locked
    }
}
```

**Key Point:**

Use a synchronized method when the entire method requires thread safety. Use a synchronized block when only a specific critical section needs protection.

-------------------
------------------


### 13. What is a daemon thread?

**Answer:**

A daemon thread is a background thread that provides services to user threads. The JVM automatically terminates daemon threads when all user threads have completed execution.

**Examples:**

- Garbage Collector thread
- Background monitoring tasks
- Automatic cleanup tasks

**Example:**

```java
Thread thread = new Thread(() -> {
    System.out.println("Daemon thread running");
});

thread.setDaemon(true);
thread.start();
```

**Key Points:**

- Daemon threads run in the background.
- They do not prevent the JVM from exiting.
- `setDaemon(true)` must be called before `start()`.
- Commonly used for background services and maintenance tasks.



---------------
----------------


### 14. Difference between User Thread and Daemon Thread

**Answer:**

| User Thread | Daemon Thread |
|-------------|---------------|
| Performs application tasks | Performs background tasks |
| JVM waits for user threads to complete before terminating | JVM does not wait for daemon threads to complete |
| Used for core application functionality | Used for supporting background services |
| Example: `main` thread | Example: Garbage Collector (GC) thread |

**Example:**

**User Thread:**

```java
public static void main(String[] args) {
    System.out.println("Main thread");
}
```

**Daemon Thread:**

```java
Thread t = new Thread(() -> {
    System.out.println("Background task");
});

t.setDaemon(true);
t.start();
```

**Key Point:**

The JVM terminates automatically when all user threads finish execution, even if daemon threads are still running.

----------------
----------------


### 15. What is thread priority?

**Answer:**

Thread priority determines the importance of a thread for scheduling by the JVM. A thread with higher priority may get preference for execution compared to lower-priority threads.

**Priority Range:**

```java
MIN_PRIORITY = 1
NORM_PRIORITY = 5
MAX_PRIORITY = 10
```

**Example:**

```java
Thread thread = new Thread(() -> {
    System.out.println("Thread running");
});

thread.setPriority(10);
thread.start();
```

**Key Points:**

- Default thread priority is `NORM_PRIORITY` (5).
- Thread priority values range from 1 to 10.
- Higher priority does not guarantee that a thread will execute first; it is only a scheduling hint to the JVM.
- Priority can be set using the `setPriority()` method.


-----------
----------


### 16. What is the difference between `notify()` and `notifyAll()`?

**Answer:**

Both `notify()` and `notifyAll()` are methods of the `Object` class used for inter-thread communication. They wake up threads that are waiting on the same object's monitor.

| `notify()` | `notifyAll()` |
|------------|---------------|
| Wakes up one waiting thread | Wakes up all waiting threads |
| Has less overhead | Has more overhead |
| JVM selects one thread randomly from waiting threads | All waiting threads are moved to the ready state |
| Useful when only one waiting thread needs to continue | Useful when multiple threads need to be notified |

**Example:**

**Using `notify()`:**

```java
synchronized(obj) {
    obj.notify();
}
```

**Using `notifyAll()`:**

```java
synchronized(obj) {
    obj.notifyAll();
}
```

**Key Points:**

- `notify()` and `notifyAll()` must be called inside a synchronized block or method.
- The thread that receives notification must reacquire the lock before continuing execution.
- Use `notifyAll()` when multiple threads may be waiting for a shared resource.


----------------
----------------


### 17. What is inter-thread communication?

**Answer:**

Inter-thread communication is a mechanism that allows threads to communicate and coordinate with each other while working on shared resources. It helps threads cooperate by waiting for certain conditions and notifying other threads when tasks are completed.

**Methods used for inter-thread communication:**

- `wait()` — Makes a thread wait until another thread sends a notification.
- `notify()` — Wakes up one waiting thread.
- `notifyAll()` — Wakes up all waiting threads.

**Example:**

```java
synchronized(obj) {
    obj.wait();
}
```

**Key Points:**

- These methods are defined in the `Object` class.
- They must be called inside a synchronized block or synchronized method.
- They help avoid unnecessary CPU usage by allowing threads to wait efficiently.
- Commonly used in producer-consumer problems.


-----------
-----------



### 18. What is deadlock?

**Answer:**

Deadlock is a situation where two or more threads wait indefinitely for each other to release resources. As a result, none of the threads can continue execution.

**Example:**

```text
Thread 1 locks Resource A and waits for Resource B

Thread 2 locks Resource B and waits for Resource A

Both threads are blocked forever
```

**Example Code:**

```java
class Resource {
}

public class DeadlockExample {

    static Resource A = new Resource();
    static Resource B = new Resource();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (A) {
                synchronized (B) {
                    System.out.println("Thread 1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("Thread 2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

**Conditions for Deadlock:**

- **Mutual Exclusion:** A resource can be held by only one thread at a time.
- **Hold and Wait:** A thread holds one resource while waiting for another.
- **No Preemption:** A resource cannot be forcibly taken from a thread.
- **Circular Wait:** Threads wait for resources held by each other.

**Prevention:**

- Acquire locks in a fixed order.
- Avoid unnecessary locking.
- Use timeout-based locks like `tryLock()`.


-----------
------------



### 19. How can you prevent deadlock?

**Answer:**

Deadlock can be prevented by managing resource locking carefully and avoiding situations where threads wait indefinitely for each other's resources.

**Ways to prevent deadlock:**

- **Avoid nested locks:** Minimize locking multiple resources at the same time.
- **Lock resources in the same order:** Ensure all threads acquire locks in a consistent order to prevent circular waiting.
- **Use timeout locks:** Use mechanisms like `tryLock()` to avoid waiting forever for a lock.
- **Reduce synchronization:** Synchronize only the required sections of code to minimize lock contention.

**Example:**

```java
if (lock1.tryLock()) {
    try {
        if (lock2.tryLock()) {
            // Critical section
        }
    } finally {
        lock1.unlock();
    }
}
```

**Key Point:**

Proper lock management and reducing unnecessary synchronization help avoid deadlock situations in multithreaded applications.

------------
------------



### 20. What is a livelock?

**Answer:**

A livelock is a situation where multiple threads are active and keep changing their state in response to each other, but they are unable to make any progress. Unlike deadlock, threads are not blocked; they continue executing but fail to complete their tasks.

**Example:**

```text
Thread 1: Releases a resource to allow Thread 2 to proceed

Thread 2: Releases another resource to allow Thread 1 to proceed

Both threads keep responding to each other but no work is completed
```

**Difference between Deadlock and Livelock:**

| Deadlock | Livelock |
|----------|----------|
| Threads are blocked and waiting forever | Threads are active but make no progress |
| Threads do not execute | Threads continue executing |
| Caused by circular resource waiting | Caused by continuous response between threads |

**Prevention:**

- Avoid unnecessary thread coordination.
- Use proper retry mechanisms with limits.
- Add random delays when retrying operations.


------------
------------


### 21. What is a thread pool?

**Answer:**

A thread pool is a collection of reusable threads managed by the Executor Framework. It improves performance by creating a fixed number of threads and reusing them to execute multiple tasks efficiently.

**Example:**

```java
ExecutorService executor =
        Executors.newFixedThreadPool(5);

executor.submit(() -> {
    System.out.println("Task executed");
});

executor.shutdown();
```

**Key Points:**

- Reduces the overhead of creating and destroying threads repeatedly.
- Manages thread lifecycle automatically.
- Improves application performance and resource utilization.
- Commonly used for handling multiple tasks in server applications.

**Common Thread Pool Types:**

- `newFixedThreadPool()` — Creates a fixed number of threads.
- `newCachedThreadPool()` — Creates threads as needed and reuses available threads.
- `newSingleThreadExecutor()` — Uses a single worker thread.
- `newScheduledThreadPool()` — Executes tasks after delays or periodically.


---------------
---------------



### 22. What is Executor Framework?

**Answer:**

Executor Framework is a Java API that provides a higher-level approach for managing and executing threads efficiently. It separates task submission from thread management, making multithreaded programming easier and more scalable.

**Main Interfaces:**

1. **`Executor`**
   - Provides a simple interface for executing tasks asynchronously.

2. **`ExecutorService`**
   - Extends `Executor` and provides methods for managing thread pools, task submission, and controlling thread execution.

3. **`ScheduledExecutorService`**
   - Used for scheduling tasks to execute after a delay or periodically.

**Example:**

```java
ExecutorService executor = Executors.newFixedThreadPool(3);

executor.submit(() -> {
    System.out.println("Task executed");
});

executor.shutdown();
```

**Key Points:**

- Manages thread creation and lifecycle automatically.
- Improves performance by reusing threads through thread pools.
- Reduces the complexity of manual thread management.
- Supports task scheduling and asynchronous execution.


--------------
--------------


### 23. Difference between `Runnable` and `Callable`

**Answer:**

| `Runnable` | `Callable` |
|------------|------------|
| Does not return any value | Returns a value |
| Cannot throw checked exceptions | Can throw checked exceptions |
| Uses the `run()` method | Uses the `call()` method |
| Introduced before Java 5 | Introduced in Java 5 with Executor Framework |
| Used for tasks that do not need a result | Used for tasks that need a result after execution |

**Example:**

**Runnable:**

```java
Runnable task = () -> {
    System.out.println("Task executed");
};
```

**Callable:**

```java
Callable<Integer> task = () -> 10;
```

**Using Callable with ExecutorService:**

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<Integer> result = executor.submit(task);

System.out.println(result.get());

executor.shutdown();
```

**Key Points:**

- `Runnable` is suitable for fire-and-forget tasks.
- `Callable` is used when a task needs to return a result.
- `Future` is used to retrieve the value returned by a `Callable` task.


-------------------
-----------


### 24. What is Future in Java?

**Answer:**

`Future` represents the result of an asynchronous computation. It allows a program to submit a task for execution and retrieve the result later when it becomes available.

**Example:**

```java
Future<Integer> result =
        executor.submit(task);

System.out.println(result.get());
```

**Key Points:**

- `Future` is part of the `java.util.concurrent` package.
- It is commonly used with `Callable` tasks submitted to an `ExecutorService`.
- The `get()` method retrieves the result and waits if the computation is not completed.
- It provides methods to check task status and control execution.

**Common Methods:**

| Method | Purpose |
|--------|---------|
| `get()` | Retrieves the result of the computation |
| `isDone()` | Checks whether the task is completed |
| `cancel()` | Attempts to cancel the task |
| `isCancelled()` | Checks whether the task was cancelled |


----------
---------


### 25. What is the `volatile` keyword?

**Answer:**

The `volatile` keyword in Java ensures that changes made to a variable by one thread are immediately visible to other threads. It helps maintain visibility of shared data in a multithreaded environment.

**Example:**

```java
volatile boolean flag = true;
```

**Example Usage:**

```java
class Task {
    volatile boolean running = true;

    public void stop() {
        running = false;
    }

    public void execute() {
        while (running) {
            // Task execution
        }
    }
}
```

**Key Points:**

- Ensures visibility of changes across threads.
- Prevents threads from using cached copies of a variable.
- Does not provide atomicity for compound operations like `count++`.
- Useful for flags and simple state variables shared between threads.


-------------
-----------



### 26. Difference between `volatile` and `synchronized`

**Answer:**

| `volatile` | `synchronized` |
|------------|----------------|
| Provides visibility of changes across threads | Provides visibility and atomicity |
| Does not use locking | Uses locking mechanism |
| Faster because there is no lock overhead | Slower due to lock acquisition and release |
| Suitable for simple shared variables like flags | Suitable for protecting critical sections and shared resources |
| Does not make compound operations thread-safe | Makes compound operations thread-safe |

**Example of `volatile`:**

```java
volatile boolean flag = true;
```

**Example of `synchronized`:**

```java
synchronized void increment() {
    count++;
}
```

**Key Points:**

- Use `volatile` when only visibility is required.
- Use `synchronized` when multiple threads need controlled access to shared data.
- `volatile` does not prevent race conditions for operations like incrementing a counter.


--------
---------

### 27. What is Atomic class in Java?

**Answer:**

Atomic classes in Java provide lock-free, thread-safe operations on single variables. They use low-level atomic operations like **CAS (Compare-And-Set)** to perform updates safely without using explicit synchronization.

**Example:**

```java
AtomicInteger count = new AtomicInteger(0);

count.incrementAndGet();
```

**Common Atomic Classes:**

- `AtomicInteger`
- `AtomicLong`
- `AtomicBoolean`

**Example Usage:**

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }
}
```

**Key Points:**

- Provides thread-safe operations without explicit locks.
- Improves performance compared to synchronized blocks in many cases.
- Useful for counters, sequence generators, and shared numeric values.
- Supports atomic operations like increment, decrement, compare-and-set, and update.



----------------
-------------



### 28. What is ThreadLocal?

**Answer:**

`ThreadLocal` provides separate copies of a variable for each thread. Each thread gets its own independent instance of the variable, so changes made by one thread are not visible to other threads.

**Example:**

```java
ThreadLocal<Integer> value =
        new ThreadLocal<>();
```

**Example Usage:**

```java
ThreadLocal<String> user = new ThreadLocal<>();

user.set("John");

System.out.println(user.get());

user.remove();
```

**Key Points:**

- Each thread maintains its own copy of the variable.
- Helps avoid synchronization when data is not shared between threads.
- Commonly used for storing thread-specific data like user sessions, database connections, and request context.
- Use `remove()` to clean up ThreadLocal values and prevent memory leaks, especially in thread pools.



-----------
-----------



### 29. What is ReentrantLock?

**Answer:**

`ReentrantLock` is a class from the `java.util.concurrent.locks` package that provides advanced locking features compared to the `synchronized` keyword. It allows a thread to acquire the same lock multiple times without causing a deadlock.

**Example:**

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    // critical section
}
finally {
    lock.unlock();
}
```

**Features of `ReentrantLock`:**

- **Try lock:** Allows a thread to attempt acquiring a lock without waiting indefinitely.

```java
if (lock.tryLock()) {
    try {
        // critical section
    }
    finally {
        lock.unlock();
    }
}
```

- **Fair locking:** Allows locks to be granted in the order threads requested them.

```java
Lock lock = new ReentrantLock(true);
```

- **Interruptible locking:** Allows a waiting thread to be interrupted while waiting for a lock.

**Key Points:**

- Provides more control than `synchronized`.
- The lock must always be released using `unlock()` inside a `finally` block.
- Supports advanced locking mechanisms required in complex multithreaded applications.



----------
---------



### 30. Difference between `synchronized` and `ReentrantLock`

**Answer:**

| `synchronized` | `ReentrantLock` |
|----------------|-----------------|
| A Java keyword | A class from `java.util.concurrent.locks` package |
| Lock is released automatically when the block/method exits | Lock must be released manually using `unlock()` |
| Simple and easier to use | Provides more advanced locking features |
| Does not support `tryLock()` | Supports `tryLock()` |
| Does not provide configurable fairness | Supports fair locking |
| Cannot interrupt a thread waiting for a lock | Supports interruptible lock acquisition |

**Example:**

**Using `synchronized`:**

```java
synchronized void update() {
    count++;
}
```

**Using `ReentrantLock`:**

```java
Lock lock = new ReentrantLock();

lock.lock();
try {
    count++;
}
finally {
    lock.unlock();
}
```

**Key Points:**

- Use `synchronized` for simple locking requirements.
- Use `ReentrantLock` when advanced features like timeout locking, fairness, or interruptible locks are needed.
- Always release `ReentrantLock` in a `finally` block to avoid lock leaks.


--------
-------


# Advanced Multithreading Interview Questions

### 31. Can a thread be started twice?

**Answer:**

No, a thread cannot be started more than once. If we try to start the same thread again, Java throws `IllegalThreadStateException`.

**Example:**

```java
Thread thread = new Thread(() -> {
    System.out.println("Thread running");
});

thread.start();
thread.start(); // IllegalThreadStateException
```

**Key Point:**

- A thread can be started only once in its lifecycle.
- After a thread completes execution, it cannot be restarted.

---

### 32. Can we call `run()` directly?

**Answer:**

Yes, we can call the `run()` method directly, but it will execute like a normal method in the current thread. It will not create a new thread.

**Example:**

```java
Thread thread = new Thread(() -> {
    System.out.println(Thread.currentThread().getName());
});

thread.run();
```

**Key Point:**

- `start()` creates a new thread and internally calls `run()`.
- Directly calling `run()` does not provide multithreading.

---

### 33. What happens when an exception occurs in a thread?

**Answer:**

When an exception occurs inside a thread and is not handled, the thread terminates. The exception can be handled using an uncaught exception handler.

**Example:**

```java
Thread thread = new Thread(() -> {
    throw new RuntimeException("Error occurred");
});

thread.setUncaughtExceptionHandler((t, e) -> {
    System.out.println(e.getMessage());
});

thread.start();
```

**Key Point:**

- An exception in one thread does not directly terminate other threads.
- The affected thread stops execution.

---

### 34. What is a Blocking Queue?

**Answer:**

A Blocking Queue is a thread-safe queue that automatically blocks operations when the queue is full or empty.

**Examples:**

- `ArrayBlockingQueue`
- `LinkedBlockingQueue`

**Example:**

```java
BlockingQueue<Integer> queue =
        new ArrayBlockingQueue<>(10);

queue.put(100);
queue.take();
```

**Key Points:**

- Used for communication between producer and consumer threads.
- `put()` waits if the queue is full.
- `take()` waits if the queue is empty.

---

### 35. What is the Fork/Join Framework?

**Answer:**

Fork/Join Framework is a framework introduced in Java 7 for parallel processing. It divides a large task into smaller subtasks, executes them in parallel, and combines the results.

**Key Concepts:**

- **Fork:** Splits a task into smaller subtasks.
- **Join:** Combines the results after subtasks complete.

**Example Classes:**

- `ForkJoinPool`
- `RecursiveTask`
- `RecursiveAction`

**Key Point:**

Fork/Join Framework is useful for CPU-intensive tasks that can be divided into independent smaller tasks.

---

# Quick Interview One-Liners

- **Thread** → Lightweight execution unit.
- **Multithreading** → Running multiple threads concurrently.
- **Synchronization** → Controls shared resource access.
- **Race condition** → Incorrect result due to concurrent access.
- **Deadlock** → Threads waiting forever for each other.
- **volatile** → Ensures visibility of changes.
- **Thread pool** → Reuses threads for task execution.
- **Callable** → Returns result from a thread.
- **Future** → Represents asynchronous result.
- **ExecutorService** → Manages thread execution.
- **Atomic classes** → Lock-free thread-safe operations.
