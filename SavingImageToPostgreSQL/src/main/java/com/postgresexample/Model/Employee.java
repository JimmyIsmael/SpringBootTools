package com.postgresexample.Model;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jpena on 3/12/2018.
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getPhotoBlob() {
        return photoBlob;
    }

    public void setPhotoBlob(byte[] photoBlob) {
        this.photoBlob = photoBlob;
    }

    public Integer getPhotoContentLength() {
        return photoContentLength;
    }

    public void setPhotoContentLength(Integer photoContentLength) {
        this.photoContentLength = photoContentLength;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

}
