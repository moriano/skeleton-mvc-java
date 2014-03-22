skeleton-mvc-java
=================

General description
-------------

This projects provides a very simple structure showing the usage of several frameworks.

The idea is that you can use this simple project as a base for your own projects, the current implementation provides a
single Controller, Service, Model and DAO which is enough to start.

Usage
-------------

```
git clone https://github.com/moriano/skeleton-mvc-java.git
cd skeleton-mvc-java.git
mvn install
mvn jetty:run
```

Open a browser and point it to

http://localhost/skeleton/god/list


Limitations
-------------

As this project is an Skeleton, not much logic is provided. Also, as I intent to use this for personal usages, it does
not uses JPA, instead of that it uses Spring-JDBC, however nothing in the DAO interfaces forces you to use any
particular framework/technology, so using JPA to implement data access should not be complex.