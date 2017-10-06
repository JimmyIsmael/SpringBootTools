# How to create a XLSX and download it from Spring Controller.

This project will give an example of how to create an XLSX file and download it from your spring controller.

## What you need to run this project?

First of all you need to run this SQL command on your SQLServer:
```
CREATE TABLE dbo.EMPLOYEES (
  ZRT char(4) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  AREA char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  ZONE char(2) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  REGION char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  TERRITORY char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  FULL_NAME varchar(26) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  LAST_NAME varchar(13) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  FIRST_NAME varchar(11) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MIDDLE_INITIAL char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  NICKNAME varchar(7) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOME_PHONE char(12) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  CELL_PHONE char(12) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILADDRESS1 varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILADDRESS2 varchar(13) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILADDRESS3 char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILCITY varchar(17) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILSTATE char(2) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  MAILZIPCODE varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMEADDRESS1 varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMEADDRESS2 varchar(9) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMEADDRESS3 char(1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMECITY varchar(17) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMESTATE char(2) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HOMEZIPCODE varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPADDRESS1 varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPADDRESS2 varchar(30) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPADDRESS3 varchar(50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPCITY varchar(19) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPSTATE char(2) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  SHIPZIPCODE varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  HIREDATE date NOT NULL,
  EMPLOYEENUMBER char(6) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
  CONSTRAINT SalesRoster_pk PRIMARY KEY CLUSTERED (ZRT)
    WITH (
      IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF)
)
GO
``

## How to Add the SQLServer Dependency to POM file

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

### Add the Apache POI dependendy to your POM
Apache POI is a tool that allow you to create XLSX files in a simple and fast way.

Just add this to your pom:
```
<dependency>
	<groupId>org.apache.poi</groupId>
	<artifactId>poi-ooxml</artifactId>
	<version>3.15</version>
</dependency>
```
