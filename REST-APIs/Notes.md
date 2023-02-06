* REST - Representational State Transfer
* API - Application Programming Interface

************************************** REST ****************************************************
REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other.

REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

** Separation of Client and Server

- In REST architectural style implementation of client side and server side can be done independently 
    that means without knowing about the other.
- This means that the code on the client side can be changed at any time without affecting the operation of the server, and the code on the server side can be changed without affecting the operation of the client.

- By using a REST interface, different clients hit the same REST endpoints, perform the same actions, and receive the same responses.

** Statelessness

Systems that follow the REST paradigm are stateless, meaning that the server does not need to know anything about what state the client is in and vice versa. In this way, both the server and the client can understand any message received, even without seeing previous messages.

These constraints help RESTful applications achieve reliability, quick performance, and scalability, as components that can be managed, updated, and reused without affecting the system as a whole, even during operation of the system.


** Communication Between Client and Server

* Making Requests

REST requires that a client make a request to the server in order to retrieve or modify data on the server. A request generally consists of:

-an HTTP verb, which defines what kind of operation to perform
-a header, which allows the client to pass along information about the request
-a path to a resource
-an optional message body containing data.

*HTTP Verbs
There are 4 basic HTTP verbs we use in requests to interact with resources in a REST system:

GET — retrieve a specific resource (by id) or a collection of resources
POST — create a new resource
PUT — update a specific resource (by id)
DELETE — remove a specific resource by id



