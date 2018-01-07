package com.bookapp.models;

import java.util.List;

/**
 * Created by Malwina on 2017-12-17.
 */

public class Book {
    private String id;
    private String title;
    private List<Author> authors;
    private int year;
    private Genre genre;

    public Book() {
    }

    public Book(String title, List authors) {
        this.authors = authors;
        this.title = title;
    }

    public Book(String title, List authors, int year, Genre genre) {
        this.authors = authors;
        this.title = title;
        this.year = year;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
