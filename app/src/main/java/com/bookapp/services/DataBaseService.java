package com.bookapp.services;

import android.util.Log;

import com.bookapp.models.Author;
import com.bookapp.models.Book;
import com.bookapp.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Malwina on 2018-01-05.
 */

public class DataBaseService {

    /**
     * Available tables in db:
     * users
     * books
     * authors
     */

    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    final private DatabaseReference dbReference = database.getReference();
    final private DatabaseReference booksRef = dbReference.child("books");

    public boolean writeToDb(String table, Object obj) {
        Task task = dbReference.child(table).push().setValue(obj);

        if (!task.isSuccessful()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean writeUserInfoToDb(User user) {
        Task task = dbReference.child("users").child(user.getUserUid()).setValue(user);

        if (!task.isSuccessful()) {
            return true;
        } else {
            return false;
        }
    }

//    // not tested
//    public Book readBookFromDbById(int id) {
//        final Book[] book = new Book[1];
//
//        ValueEventListener listener = dbReference.child("books").child(String.valueOf(id)).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    book[0] = dataSnapshot.getValue(Book.class);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d(String.valueOf(this.getClass()), "Failed to read book from database");
//            }
//        });
//        booksRef.removeEventListener(listener);
//        return book[0];
//    }
//
//    // not tested
//    public Author readAuthorFromDbByNameAndSurname(String name, String surname) {
//        final Author[] author = new Author[1];
//        ValueEventListener listener = dbReference.child("books").orderByChild("name").equalTo(name).orderByChild("surname").equalTo(surname).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    author[0] = dataSnapshot.getValue(Author.class);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d(String.valueOf(this.getClass()), "Failed to read book from database");
//            }
//        });
//        booksRef.removeEventListener(listener);
//        return author[0];
//    }

}
