package com.bookapp.services;

import com.bookapp.models.Book;
import com.bookapp.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Malwina on 2018-01-05.
 */

public class DataBaseService {

    /**
     *  Available tables in db:
     *      users
     *      books
     *      authors
     */

    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    final private DatabaseReference dbReference = database.getReference();

    public boolean addToDb(String table, Object obj) {
        Task task = dbReference.child(table).push().setValue(obj);

        if (!task.isSuccessful()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean saveUserInfoToDb(User user) {
        Task task = dbReference.child("users").child(user.getUserUid()).setValue(user);

        if (!task.isSuccessful()) {
            return true;
        } else {
            return false;
        }
    }


}
