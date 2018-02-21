package com.autocompletedemo.POJO;

/**
 * Created by jpena on 2/21/2018.
 */
public class Tag {

    public Tag(int id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public int id;
    public String tagName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }



}
