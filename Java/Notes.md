##### Concurrent Modification Exception

* Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException.

* how to avoid concurrent modification exception ?

    * Instead of iterating through collections classes, we can iterate through the arrays. This works perfectly fine for smaller lists what about the bigger list? It’s very basic we know that if the array size is huge then it affects the performance. Hence, this method is only effective for smaller size arrays.

    * The next method is the Synchronized block method, Here we actually lock the list in a synchronized block to avoid the exception. Isn’t that cool? but guess what this is also not an effective method to avoid Exception Why? Because the purpose of multithreading is not being used.

    * Create a Copy of collection (not recommended)

    * Use Java 8 Streams and filter()

    List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
    names = names.stream()
             .filter(name -> !name.equals("Bob"))
             .collect(Collectors.toList());

    * use concurrent collections- like -> concurrent Hash map, CopyOnWriteArrayList etc...

    * (come back to this after studying about Threads)

* Why to override hashCode() and equals() ?

https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/



*  What is the result of the below code and Why?

public class TestClass {
public static void main(String[] args) {
     someMethod(null);
}
public static void someMethod(Object o) {
 System.out.println("Object method Invoked");
}
public static void someMethod(String s) {
 System.out.println("String method Invoked");
}
}


The output of this code is “String method Invoked”. We know that null is a value that can be assigned to any kind of object reference type in Java. It is not an object in Java. Secondly, the Java compiler chooses the method with the most specific parameters in method overloading. this means that since the String class is more specific, the method with String input parameter is called.



* Can we use HashMap in a multi-threaded environment?

You can use the HashMap but the probability of working fine depends on the way we use it. For instance, consider the HashMap of configuration properties, if the HashMap initialization was done by using just one thread, and the remaining threads do the task of reading from the map, then HashMap would work perfectly well.

The problem arises when there is at least one thread that updates the Map by means of adding, updating, or deleting the map content. The put() method of the map resizes the map that can cause a deadlock or infinite loop while the threads operate. Hence, during such scenarios, we can use the HashTable or ConcurrentHashMap.

#### Singleton Method / Singleton Design Pattern

 a java singleton class is a class that can have only one object (an instance of the class) at a time. After the first time, if we try to instantiate the Java Singleton classes, the new variable also points to the first instance created. So whatever modifications we do to any variable inside the class through any instance, affects the variable of the single instance created and is visible if we access that variable through any variable of that class type defined.

 * purpose of singleton class

 - restricts the number of objects creation to only one.
 - This often ensures that there is access control to resources, for example, socket or database connection.
 - Memory space wastage does not occur with the use of the singleton class because it restricts instance creation. As the object creation will take place only once instead of creating it each time a new request is made.


#### String Constant Pool and String immutability

What is Java String Pool?
A Java String Pool is a place in heap memory where all the strings defined in the program are stored. A separate place in a stack is there where the variable storing the string is stored. Whenever we create a new string object, JVM checks for the presence of the object in the String pool, If String is available in the pool, the same object reference is shared with the variable, else a new object is created.

Example 1: 

// Program 1: Comparing two references to objects 
// created using literals. 
import java.util.*; 

// Driver Class 
class GFG { 
	// main function 
	public static void main(String[] args) 
	{ 
		String s1 = "abc"; 
		String s2 = "abc"; 

		// Note that this == compares whether 
		// s1 and s2 refer to same object or not 
		if (s1 == s2) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
}


Output : Yes


Example 2:

// Program 2: Comparing two references to objects 
// created using new operator. 
import java.util.*; 

// Driver Class 
class GFG { 
	// main function 
	public static void main(String[] args) 
	{
		String s1 = new String("abc"); 
		String s2 = new String("abc"); 

		// Note that this == compares whether 
		// s1 and s2 refer to same object or not 
		if (s1 == s2) 
			System.out.println("Yes"); 
		else
			System.out.println("No"); 
	} 
}


Output: No


in example 1, s1 creates a new String object in String constant pool and when s2 is decalred, since the same String value is already exists in the String constant pool, s2 also refers to the same reference.
this is the reason s1 and s2 returns true.

but while creating String using new operator, everytime a new object is created even if the value of the String is same.





* immutable objects -> Immutable objects are objects whose elements cannot be modified once declared.

String class and all wrapper classes in Java that include Boolean, Character, Byte, Short, Integer, Long, Float, and Double are immutable

class GFG {
    public static void main (String[] args) {
    String str="Knowledge";
      String s=str;
      str=str.concat(" Base");
      System.out.println(str);
    }
}

Output : Knowledge Base
But wait, how is this possible, since String objects are immutable? Well to your surprise, it is.

When the above statement is executed, the VM takes the value of String str, i.e. “knowledge” and appends ” base”, giving us the value “knowledge base”. Now, since Strings are immutable, the VM can’t assign this value to str, so it creates a new String object, gives it a value “knowledge base”, and gives it reference str.

An important point to note here is that, while the String object is immutable, its reference variable is not. So that’s why, in the above example, the reference was made to refer to a newly formed String object.

At this point in the example above, we have two String objects: the first one we created with the value “knowledge”, pointed to by s, and the second one “knowledge base”, pointed to by str. But, technically, we have three String objects, the third one being the literal “base” in the concat statement.

* Why Strings are immutable in nature ?

- The String pool cannot be possible if String is not immutable in Java. A lot of heap space is saved by JRE. The same string variable can be referred to by more than one string variable in the pool. String interning can also not be possible if the String would not be immutable.

- If we don’t make the String immutable, it will pose a serious security threat to the application. For example, database usernames, and passwords are passed as strings to receive database connections. The socket programming host and port descriptions are also passed as strings. The String is immutable, so its value cannot be changed. If the String doesn’t remain immutable, any hacker can cause a security issue in the application by changing the reference value.
================================================================================================================


# Object Class in Java

The Object class provides multiple methods which are as follows:

* toString() method
* hashCode() method
* equals(Object obj) method
* finalize() method
* getClass() method
* clone() method
* wait(), notify() notifyAll() methods

1. toString()

toString method is used to represent an object in the form of String.
default implementation of toString() method returns the class name of the object with '@' appending with 
hexadecimal value of the hascode of the object.

public String toString()
{
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}

whenever we try to print an object reference, internally the toString() method is called.
ex: 
Employee emp = new Employee();

Sysout(s);
Sysout(s.toString());//both statements are equivalent.


2. hashCode() 

hashCode() returns the distinct and unique integer value for every distinct object in Java.
common misconception : hashCode() doesn't return the address of the object.

hashCode() is also used to put/get a value from hash based data structures, hash based data structures 
are used to search objects easily in a collection.

3. equals() 

to check if the state of the two objects are equal or not.

4. getClass()

It returns the Class objects that represent the runtime class of this object.

5. finalize() 

finalize() method is called by JVM before performing garbbage collection/ clan up activity, of any object.
clean up activity is said to closing the resources, de-allocating the resources. 
after finalize() is called, Garbbage Collector destroys the object.

we can also override the finalize() method in our class explicitly.
default implementation of finalize() is empty.

6. wait() .... notify()... notifyAll()...


###### Abstraction in Java

* Abstraction in java is the process of exposing only the required details/logic to user and to not show the 
irrelevant details.

* In Java Abstraction can be achieved using Abstract class and Interfaces.

* Abstraction Real-Life Example:

Consider a real-life example of a man driving a car. The man only knows that pressing the accelerators will increase the speed of a car or applying brakes will stop the car, but he does not know how on pressing the accelerator the speed is actually increasing, he does not know about the inner mechanism of the car or the implementation of the accelerator, brakes, etc in the car. This is what abstraction is. 

* When to use abstract classes and abstract methods?

There are situations in which we will want to define a superclass that declares the structure of a given abstraction without providing a complete implementation of every method. Sometimes we will want to create a superclass that only defines a generalization form that will be shared by all of its subclasses, leaving it to each subclass to fill in the details.

Consider a classic “shape” example, perhaps used in a computer-aided design system or game simulation. The base type is “shape” and each shape has a color, size, and so on. From this, specific types of shapes are derived(inherited)-circle, square, triangle, and so on — each of which may have additional characteristics and behaviours. For example, certain shapes can be flipped. Some behaviours may be different, such as when you want to calculate the area of a shape. The type hierarchy embodies both the similarities and differences between the shapes.


* why to use Abstraction ?

1. we can make our code more standardised and modular. Can define a set of rules (methods) that needs to be implemented by its subclasses.

2. Polymorphism:
Abstaction enables polymorphism. a method or variable defined in superclass should be implemnted in sub classes.
also the object of Abstract classes or interface can take the form of any instantiated sub class.

### Difference Between Abstract Class and Interface in Java.

Abstract Class

1. Abstract class can have abstract as well as concrete methods.
2. Abstract class doesn't support multiple inheritance.
3. Abstract classes can be extended and Abstract clas can IMPLEMENT interfaces.
4. Abstract classes can be private , protected.

Interface

1. Interfaces can't have concrete methods, only abstract methods.
2. Interface supports multiple inheritance.
3. Interfcae should be implemented by classes, and Interfaces can be extended from other interface.
4. Interfaces methods are pubic by default.


* main method can be used in abstract class.
* statics can be used in abstract class.
* object can't be create of Abstract class.

=============================================================================================================


###### Serialization and Deserialization in Java

* The process converting a java object into byte stream is called Serialization,
while the reverse process i.e converting a byte stream into a java object is called Deserialization.

* after serialization, the byte stream created is platform independent, hence a serialized byte stream created 
on one platform can be Deserialized on another platform.

* to make a java object Serializable, we must implement the class with Serializable interface.

ObjectOutputStream.writeObject() -> for serializing an object.
ObjectInputStream.readObject() -> for deserializing ab object.

Serializable is a Marker interface (having no data members or method), it is used to mark some
capilities for the implementing classes.

Advantages of Serialization 

* To save/persist state of an object. 
* To travel an object across a network.

Points to remember 

1. If a parent class has implemented Serializable interface then child class doesn’t need to implement it but vice-versa is not true.
2. Only non-static data members are saved via Serialization process. 
3. Static data members and transient data members are not saved via Serialization process. So, if you don’t want to save value of a non-static data member then make it transient. 
4. Constructor of object is never called when an object is deserialized.

* In case of transient variables:- A variable defined with transient keyword is not serialized during serialization process.This variable will be initialized with default value during deserialization. (e.g: for objects it is null, for int it is 0). 

* In case of static Variables:- A variable defined with static keyword is not serialized during serialization process.This variable will be loaded with current value defined in the class during deserialization.

* final variables will be participating in serialization, hence declaring a transient variable final will be
of no use.

# Object Graph in Serialization

for instance, if we Serialize an object which contains reference to another object/objects then will
they also get Serialized ? 

YES. They will get serialized.

an Object Graph is the set of Object which will get Serialized as part of parent object serialization.
In other words, we can say that when we serialize any object and if it contains any other object reference then JVM serializes the object and as well as its object references.

###### Shallow Copy & Deep Copy

* Shallow Copy: 

- when we want a copy an object such that changes done in one object
should reflect in other object as well, we do shallow copy.
- in shallow copy new memory is never allocated the new entity just startes pointing towards the reference of the original object.
- because of the reason, shallow copy is faster.
- default implmentation of clone() method follows shallow copy.


class ABC {
    int x = 100;
}

class ShallowCopyExample{
    public static void main(String[] args) {
        ABC obj1 = new ABC();
        System.out.println(obj1.x);
        ABC obj2 = obj1; //this copies the reference, not the value
        // doing change in copied object or the original object,
        // will  be visible/affect in both the objects.
        obj2.x = 200;
        System.out.println(obj1.x);

        obj1.x = 300;
        System.out.println(obj2.x);

    }
}


Output:

100
200
300






















