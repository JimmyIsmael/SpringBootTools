# Image Uploading to PostgreSQL #
This project will show an example of how to upload and download images to your database using PostgreSQL with Spring Boot.

## What you need to run the project. 
in order to use this project you will need to add the following dependencies to yor POM file:

```
<!--Spring Data JPA Dependencies-->
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

```
<!--Thymeleaf-->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

```
<!--File Uploading-->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-io</artifactId>
    <version>1.3.2</version>
</dependency>
```
```
<!--PostgreSQL Dependencies-->
<dependency>
  <groupId>org.postgresql</groupId>
  <artifactId>postgresql</artifactId>
</dependency>
```

### Employee Model
For the Employee model (DAO) we need to have the following:
```
@Entity
@Table(name = "employees")
@TableGenerator(name="tab", initialValue=1, allocationSize=1)
public class Employee {
    public Employee(){}

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="tab")
    private Integer id;

    private String name;

    private String lastName;

    @Lob
    @Column(name="photo_blob")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] photoBlob;

    @Column(name = "photo_content_length")
    private Integer photoContentLength;

    @Column(name = "photo_content_type", length = 50)
    private String photoContentType;
}
```
