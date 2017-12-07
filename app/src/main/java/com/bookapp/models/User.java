package com.bookapp.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Malwina on 2017-12-03.
 */

public class User {

    public String userUid;
    public String username;
    public String name;
    public String surname;
    public int birthYear;

    public User(String userUid, String username) {
        this.userUid = userUid;
        this.username = username;
    }

    public String getUserUid() {
        return userUid;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}

