package com.bookapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class UserSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

//        final EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
//        final EditText nameInput = (EditText) findViewById(R.id.nameInput);
//        final EditText surnameInput = (EditText) findViewById(R.id.surnameInput);
//        final EditText ageInput = (EditText) findViewById(R.id.ageInput);
//        final EditText emailInput = (EditText) findViewById(R.id.emailInput);
//        final EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
//
//        Intent intent = getIntent();
//        int userUid = intent.getIntExtra("userUid", 0);
//        String username = intent.getStringExtra("username");
//        String name = intent.getStringExtra("name");
//        String surname = intent.getStringExtra("surname");
//        int age = intent.getIntExtra("age", 0);
//        String email = intent.getStringExtra("email");
//        String password = intent.getStringExtra("password");
//
//        usernameInput.setText(username);
//        nameInput.setText(name);
//        surnameInput.setText(surname);
//        ageInput.setText(age + "");
//        emailInput.setText(email);
//        passwordInput.setText(password);
    }
}
