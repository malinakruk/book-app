package com.bookapp.models;

import java.util.List;

/**
 * Created by Malwina on 2017-12-17.
 */

public class Author {
    private String id;
    private String name;
    private String lived;
    private String country;
    private List works;

    public Author() {
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
