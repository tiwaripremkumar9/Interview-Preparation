 * Collection Framework: Java’s Collection Framework defines classes and interfaces for representing groups of objects as a single entity. C++ developers can compare the Collection framework with STL (Standard Template Library) and Container Framework with the Collection Framework if they come from a C++ background.

* Collection Interface: A class’s interface specifies what it should do, not how. In other words, it is the blueprint for the class. This interface provides the most common methods for all collection objects that are part of the Collection Framework. Alternatively, it represents the individual object as a whole.

* Collections Class: A member of Collection Framework, it is part of java.util package. The collection object is provided with many utility methods in this class.

* All classes and interfaces required by the collection framework are contained in the utility package (java. util). Collection frameworks have an interface called an iterable interface, which allows the iterator to iterate over all collections. In addition to this interface, the main collection interface acts as a root for the collection framework. All the collections extend this collection interface thereby extending the properties of the iterator and the methods of this interface.

# Difference Between ArrayList and LinkedList

* ArrayList:

- it uses dynamic array to store the elements.
- removing an element is difficult relatively as after removing the bits
and indexes needs to be shifted.
- implemented by List, hence acts as a List.
- direct access to element is possible.
- preferable to use for storing elements and accessing.


* LinkedList

- uses doubly linked list to store the elements.
- removing an elements is relatively simpler as it involves removing the element 
and then just changing the reference.
- implemented by List and Deque, hence acts like both.
- direct access to an element is not possible, we have to follow the node references. same thing for storing elements
- preferable to manipulating with the elements.

# Difference Between List and Set

- List allows Duplicate, Set doesn't allows Duplicate.
- List is indexed sequence, Set is not indexed sequence.
- elment can be directly access, in set can't be.
- Multiple null elements can be stored, but, Set allows only 1 null.

# Best Practices while using Collection Framework.

* using the collection as per our need and reliability,
example if size is fixed then use Arrays instead of Array List,
using LinkedHashMap over map,
is manipulating elements is required using Linked List over Array List.

* usage of Generics, to avoid class cast exceptions.
* using pre-defined methods of the specific collection or of Collections class.

# Priority Queue.

* arrages elements in a queue based on a priority.
* the top most element (which can be peeked or polled) is the element with
highest priority.
* Priority Queue follows its own priority implementation internally, but we can customise it using creating a Comparator class and then passing the instance of that comparator class as constructor parameter while instantiating the Priority Queue.

# Blocking Queue

Blocking queue doesn't accept null values,
hence a thread trying to enqueue an element in Blocking queue, the enqueuing thread is blocked until some other thread makes space in the queue, either by dequeueing an element.
similarly for reverse operation, while dequeueing, a dequeuing thread is blocked 
until an another thread inserts an element into it.

when trying to insert null in BlockingQueue, we get NPE.

# Array List and Vector Difference.
- Array List is not thread Safe, hence multiple threads can access a list at the same time. While, Vector is Synchronized and Thread safe, means only one thread can access it at a time.

- Array list is faster compared to Vector  as Array List is not thread safe and synchronized. Vector is relatively slower.

- Array List can only be iterated through Iterable, while Vector can be iterated using both Iterator and Enumeration.

# Difference Between HashMap and HashTable

- both store data in key value pairs.
- both use hashing algorithm to storing the elements.

* HashMap
- Hash Map is non-synchronized.
- all methods are non synchronized (multiple threads can operate simultaneously hence not thread safe, )
- allows one null key and multiple null value.
- Threads are not required to wait and hence relatively performance is high.

* Hashtable

- Hashtable is synchronized
- relatively slower as threads have to wait.
- NO NULL KEYS AND NO NULL VALUES.


# Difference Between HashTable and Synchronized HashMap and Concurrent HashMap.

* Based on Locking Mechanism:
Hashtable and Sync HashMap performs object level locks, that means
while performing any opeartion Hashtable and Sync HashMap locks the whole map object.

Concurrent hashmap provides Segment locking/bucket level locking.
while trying to update in concurrent hashmap, a thread has to lock certain number of segments (this number can be passed during instantiation).

* Which Operations are synchronized ?
in Hashtable and Synch HashMap both read and write operations are synchronized.
that means while both read and write, whole map object is lock.

in concurrent hashmap, only update operations are synchronized where the threads locks the segment on which update needs to be done.

* How Many threads can enter at a time ?
in Hashtable and Synch HashMap only one thread can enter at a time for any operation.

in conc hash map, only one thread can enter for performing update operation but multiple threads can access the read operation.

* Nature of iterator:

Synchronized hash map is fail fast. 
Hashtable and concurrent hashmap are fail safe.

* Allowing Null Values.
Hashtable and Concurrent hashmap doesn't allow null values.

synchronized hash map allows one null key and multiple null values.


https://javaconceptoftheday.com/synchronized-hashmap-vs-hashtable-vs-concurrenthashmap-in-java/


# CopyOnWriteArrayList

* it is a thread-safe version of ArrayList
* during update operation, CopyOnWriteArrayList creates a copy of the undelying List. for every update operation at a certain point both will be synchronized automatically, which is taken care of by JVM. Therefore, there is no effect for threads that are performing read operation.

* CopyOnWriteArrayList is a costly affair when intending to update operation as everytime it creates a copy of the underlying List.

* should be preferable if read is our frequent operation.

* iterator can not perform remove operation on CopyOnWriteArrayList.otherwise we get Run-time exception saying UnsupportedOperationException. add() and set() methods on CopyOnWriteArrayList iterator also throws UnsupportedOperationException. Also Iterator of CopyOnWriteArrayList will never throw ConcurrentModificationException.










