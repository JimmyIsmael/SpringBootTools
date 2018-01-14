# Custom Querys using Spring Data JPA

In this project you will find examples of how to use custom querys with Spring Data JPA, either static querys or
querys that can be modified on the run time.

## To use this project:

In order to use this project you need to add the following dependency to your POM.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
        
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

### Where can you find the examples?
Static Custom Query: 
Within the UserRepository interface you will find an static custom query example.

TypedQuery Example: 
Within the UserServiceImpl interface you will find a TypedQuery example.

Enjoy it!
