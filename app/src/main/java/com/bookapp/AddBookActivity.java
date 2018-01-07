package com.bookapp;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bookapp.models.Author;
import com.bookapp.models.Book;
import com.bookapp.models.Genre;
import com.bookapp.services.DataBaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);


        /*****************************   SPINNER   ********************************************/
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        List<String> genres = Stream.of(Genre.values()).map(Genre::displayName).collect(Collectors.toList());
        genres.add(0, "[Genre]");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genres);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        /*****************************   END SPINNER   ********************************************/


        /*****************************   SAVE   ********************************************/
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {

            String title = ((EditText) findViewById(R.id.titleText)).getText().toString();
            String authorName = ((EditText) findViewById(R.id.authorNameText)).getText().toString();
            String authorSurname = ((EditText) findViewById(R.id.authorSurnameText)).getText().toString();
            String yearString = ((EditText) findViewById(R.id.yearText)).getText().toString();
            String genreString = ((Spinner) findViewById(R.id.spinner)).getSelectedItem().toString();

            if (yearString.isEmpty()) {
                Toast.makeText(getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }
            int year = Integer.parseInt(yearString);

            if (genreString.equals("[Genre]")) {
                Toast.makeText(getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }
            Genre genre = (Genre.getEnumByValue(genreString));

            if (title == null || authorName == null || authorSurname == null) {
                Toast.makeText(getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }

            List<Author> authors = new ArrayList<>();
            authors.add(new Author(authorName, authorSurname));

            DataBaseService dbService = new DataBaseService();
            if (dbService.addToDb("books", new Book(title, authors, year, genre))) {
                Toast.makeText(getApplicationContext(), getString(R.string.book_succes), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AddBookActivity.this, MainActivity.class);
                intent.putExtra("fragment", "BooksFragment"); //for example
                startActivity(intent);

            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.book_failed), Toast.LENGTH_SHORT).show();
            }


        });
        /*****************************   END SAVE   ********************************************/

        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {

        });

    }
}
