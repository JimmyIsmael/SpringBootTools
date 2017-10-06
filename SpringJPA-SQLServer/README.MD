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

