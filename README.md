skeleton-mvc-java
=================

General description
-------------

This projects provides a very simple structure showing the usage of several frameworks.

The idea is that you can use this simple project as a base for your own projects, the current implementation provides a
single Controller, Service, Model and DAO which is enough to start.

Usage
-------------

By default, the project uses a simple MySQL database, this can be easily changed by modified jdbc.properties, in any
case, you will need a table called "gods". If you want to use the default database config, then execute the following
commands into your MySQL instance.

```
create database gods;
use gods;
CREATE TABLE `gods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1

INSERT INTO gods (name, age) VALUES ( 'Odin', 50);
INSERT INTO gods (name, age) VALUES ( 'Thor', 25);
INSERT INTO gods (name, age) VALUES ( 'Loki', 28);
```

Make sure that your database user is "root" and you use an empty password, if you wish to change that, you will need to
edit the jdbc.properties files.

Once the database is ready, you can just clone the project and run it.

```
git clone https://github.com/moriano/skeleton-mvc-java.git
cd skeleton-mvc-java
mvn install
mvn jetty:run
```

Open a browser and point it to

```
http://localhost:8080/skeleton/god/list
```

This will show you a list of the gods we just created (Thor, Odin, Loki).

Limitations
-------------

As this project is an Skeleton, not much logic is provided. Also, as I intent to use this for personal usages, it does
not uses JPA, instead of that it uses Spring-JDBC, however nothing in the DAO interfaces forces you to use any
particular framework/technology, so using JPA to implement data access should not be complex.