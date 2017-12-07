package com.bookapp.services;

import com.bookapp.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Malwina on 2017-12-03.
 */

public class UserService {

    public boolean saveUserToDb(User user) {
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dbRef = database.getReference();
        String userUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        Task task = dbRef.child("users").child(userUid).setValue(user);

        if (!task.isSuccessful()) {
            return true;
        } else {
            return false;
        }
    }
}
