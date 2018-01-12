package com.bookapp.models;

import java.util.List;

/**
 * Created by Malwina on 2017-12-17.
 */

public class Author {
    private String id;
    private String name;
    private String surname;
    private String lived;
    private String country;
    private List works;
    private String userUid;

    public Author() {
    }

    public Author(String name, String surname, String lived, String country, List works, String userUid) {
        this.name = name;
        this.surname = surname;
        this.lived = lived;
        this.country = country;
        this.works = works;
        this.userUid = userUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Author(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getLived() {
        return lived;
    }

    public void setLived(String lived) {
        this.lived = lived;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List getWorks() {
        return works;
    }

    public void setWorks(List works) {
        this.works = works;
    }
}
