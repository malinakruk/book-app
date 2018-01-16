package com.bookapp.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Malwina on 2017-12-17.
 */

public class Book implements Serializable {
    private String id;
    private String title;
    private List<String> authorsIds;
    private int year;
    private Genre genre;
    private String userUid;
    private int averageGrade;

    public Book() {
    }

    public Book(String title, List<String> authorsIds, int year, Genre genre, String userUid) {
        this.title = title;
        this.authorsIds = authorsIds;
        this.year = year;
        this.genre = genre;
        this.userUid = userUid;
        this.averageGrade = 0;
    }

    public List<String> getAuthorsIds() {
        return authorsIds;
    }

    public void setAuthorsIds(List<String> authorsIds) {
        this.authorsIds = authorsIds;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        StringBuilder book = new StringBuilder();
        book.append(title);
        return book.toString();
    }
}
