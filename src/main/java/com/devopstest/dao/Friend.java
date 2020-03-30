package com.devopstest.dao;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devops")
public class Friend {

    @Id
    private long id;
    private String name;

    public boolean isAuthorised() {
        return this.isAuthorised;
    }

    public Friend(long id, String name, boolean isAuthorised) {
        this.id = id;
        this.name = name;
        this.isAuthorised = isAuthorised;
    }

    public void setAuthorised(boolean authorised) {
        this.isAuthorised = authorised;
    }

    private boolean isAuthorised =false;

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isAuthorised=" + isAuthorised +
                '}';
    }

    public Friend() {

    }

    public Friend(long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Friend(String name, boolean isAuthorised) {
        this.name = name;
        this.isAuthorised = isAuthorised;
        id = 0;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


}
