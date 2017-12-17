package com.bookapp.models;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Malwina on 2017-12-03.
 */

@IgnoreExtraProperties
public class User {

    private String userUid;
    private String username;
    private String name;
    private String surname;
    private int birthYear;

    public User() {
        //Empty constructor required for DataSnapshot
    }

    public User(String userUid, String username) {
        this.userUid = userUid;
        this.username = username;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("userUid", userUid);
        result.put("username", username);
        result.put("name", name);
        result.put("surname", surname);
        result.put("birthYear", birthYear);

        return result;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}

