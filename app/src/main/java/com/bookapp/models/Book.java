package com.bookapp.models;

import java.util.List;

/**
 * Created by Malwina on 2017-12-17.
 */

public class Book {
    private String id;
    private List authors;
    private String title;
    private int year;
    private String publisher;
    private Genre genre;

    public Book() {
    }

    public Book(List authors, String title) {
        this.authors = authors;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
