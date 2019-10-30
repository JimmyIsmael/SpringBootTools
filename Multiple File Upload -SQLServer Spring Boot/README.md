# Multiple File Upload -SQLServer Spring Boot

This project will show an example of how to use upload and save multiple files on a SQLServer Database. It is applicable for other databases too since it uses JPA and Hibernate.

## What do you need. 
In order to use this project you will need to add the following dependencies to yor POM file:

### SQLServer Driver Dependency:
This dependency will allow you to connect to a SQLServer database using JPA and Hibernate.
```
<dependency>
  <groupId>com.microsoft.sqlserver</groupId>
  <artifactId>mssql-jdbc</artifactId>
  <scope>runtime</scope>
</dependency>
```

## How to Run this project
The connection properties to the database are managed as environment variables. You can either remove the environment variables from the properties file and type your credentials or you can add the following variables to your environment:
```
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

After that, just run it as any other Spring Boot application.

I hope you find this example very helpfull. 
