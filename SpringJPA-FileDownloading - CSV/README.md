# How to create a CSV and download it from Spring Controller.

This project will give an example of how to create a CSV file and download it from your spring controller.

## What you need to run this project?

First of all you need to run the SQL command that create the EMPLOYEE table, you can find it under the resources folder.


### Add the SQLServer Dependency to POM file

1.	To add the SQL dependency to POM file the first thing we need to do is download the driver from here:

https://docs.microsoft.com/en-us/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server

2.	After that copy the driver to the root of our project and then execute the following MVN command:

mvn install:install-file -Dfile=sqljdbc4.jar -Dpackaging=jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0

3.	Just left add this dependency to the POM:

<!-- https://mvnrepository.com/artifact/com.microsoft.sqlserver/sqljdbc4 -->
        <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>sqljdbc4</artifactId>
            <version>4.0</version>
        </dependency>

