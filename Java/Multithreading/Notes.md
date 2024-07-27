# What are the benefits of multi-threaded programming?
In Multi-Threaded programming, multiple threads are executing concurrently that improves the performance because CPU is not idle incase some thread is waiting to get some resources. Multiple threads share the heap memory, so it’s good to create multiple threads to execute some task rather than creating multiple processes.

# Daemon Thread
* serves user thread, handling background tasks.
* low priority.
* stops execution after the execution of user threads.
* Some examples of daemon threads in Java include garbage collection (gc) and finalizer.

setDaemon(boolean)
isDaemon()

# Life Cycle of a Thread

* New - newly created thread ready for run/execution.
* runnable - thread is either running or waiting to be run but currently waiting for resource allocation
* blocked - waiting to acquire a object monitor lock to enter to re-enter into synchronized block.The thread will move from the blocked state to runnable state when it acquires the lock.
* waiting - waiting for an another thread to complete its execution, it will move to runnable state when other thread notifies or gets terminated.
* Timed Waiting - when the thread is called to wait for a specific time limit, then thread goes in timed waiting stage. even when the required executable blocked is free and not in exeuction by another thread.
* Terminated.

# Thread Scheduling and Slicing

# Context Switching

# Inter thread Communication

* wait()
* notify()
* notifyAll()

# Why sleep() and yeild() methods are static ?

* sleep()
Method Whenever Thread.sleep() functions to execute, it always pauses the current thread execution.
If any other thread interrupts when the thread is sleeping, then InterruptedException will be thrown.
If the system is busy, then the actual time the thread will sleep will be more as compared to that passed while calling the sleep method and if the system has less load, then the actual sleep time of the thread will be close to that passed while calling sleep() method.

* yeild()

This is because whenever you are calling these methods, those are applied on the same thread that is running. You can't tell another thread to perform some operation like, sleep() or wait. All the operation are performed on the thread which is being executed currently.

# Difference Between sleep(), yeild(), join()

# How to achieve Thread Safety in Java

1. Synchronization


2. Volatile keyword

volatile keyword is used as an access modifier to a variable.
this ensures that multiple thread can be modified by the volatile keyword
when one thread modifies the value of a volatile variable, the change will be reflected to all other threads.

when a variable is declared volatile, it ensures that the value of the volatile variable is always read from and written to the main memory, and not from the thread’s local cache. This ensures that the most recent value of the volatile variable is always visible to all threads, which is crucial for maintaining data consistency in multithreading.

3. Atolic Classes:


# What is Thread Pool ?


