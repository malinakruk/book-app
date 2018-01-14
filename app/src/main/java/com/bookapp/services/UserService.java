package com.bookapp.services;

import android.util.Log;

import com.bookapp.models.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Malwina on 2017-12-03.
 */

public class UserService {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference dbReference = database.getReference();
    FirebaseUser firebaseUser = null;
    User userData = null;

    public UserService() {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null)
            getUserInstanceFromDb();
    }

    public String getUsername() {
        String username = "";

        if (userData != null) {
            username = userData.getUsername();
        }

        return username;
    }

    public String getUserUid() {
        return firebaseUser.getUid();
    }

    public void getUserInstanceFromDb() {
        if (firebaseUser == null) {
            return;
        }

        String userUid = getUserUid();
        DatabaseReference usersRef = dbReference.child("users");
        ValueEventListener listener = usersRef.child(userUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    userData = dataSnapshot.getValue(User.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(String.valueOf(this.getClass()), "Failed to load user data from db");
            }
        });
        usersRef.removeEventListener(listener);
    }

}
