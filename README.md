[![Build Status][travis-badge]][travis-badge-url]

Spring Boot with MongoDB Example
===============================================================
This is an example of Spring Boot with embedded MongoDB.

### Project Description
1. `MongoConfiguration` to configure embedded MongoDB.

1. `CustomMongoRepository` and `CustomSimpleMongoRepository` creates a custom
Mongo repository. It's responsible for generating and setting entoy/document
id field during insertion if the id is null.

1. `BookRepository` responsible for CRUD operations on `Book` entity/document.

### Dependency Requirements

#### Spring Boot MongoDB Starter

The `spring-boot-starter-data-mongodb.jar` provides all Spring related MongoDB
classes included `MongoRepository`.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```

#### Embedded MongoDB Library
The `de.flapdoodle.embed.mongo.jar` downloads and starts a MongoDB instance.

```xml
<dependency>
    <groupId>de.flapdoodle.embed</groupId>
    <artifactId>de.flapdoodle.embed.mongo</artifactId>
    <version>2.0.1-SNAPSHOT</version>
</dependency>
```

#### Spring Factory Bean for Embedded Mongo Library
The `embedmongo-spring.jar` provides Spring Factory Bean for 
Embedded MongoDB.

```xml
<dependency>
    <groupId>cz.jirutka.spring</groupId>
    <artifactId>embedmongo-spring</artifactId>
    <version>1.3.1</version>
</dependency>
```

### Build
To build the JAR, execute the following command from the parent directory:

```
mvn clean install
```

### Run
Run the executable jar from the command to start the application,

```
java -jar springboot-mongodb-example-1.0.0.jar
```

### Usage
Once the application starts up at port `8080`, you can access the swagger UI at 
`http://localhost:8080/swagger-ui.html`. From the UI, you can create and retrieve
book entities.


[travis-badge]: https://travis-ci.org/indrabasak/springboot-mongodb-example.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/springboot-mongodb-example/