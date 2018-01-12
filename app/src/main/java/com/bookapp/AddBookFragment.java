package com.bookapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bookapp.models.Book;
import com.bookapp.models.Genre;
import com.bookapp.services.DataBaseService;
import com.bookapp.services.UserService;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBookFragment extends Fragment {


    public AddBookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_book, container, false);

        EditText titleText = ((EditText) view.findViewById(R.id.titleText));
        EditText authorNameText = ((EditText) view.findViewById(R.id.authorNameText));
        EditText authorSurnameText = ((EditText) view.findViewById(R.id.authorSurnameText));
        EditText yearText = ((EditText) view.findViewById(R.id.yearText));
        Spinner spinner = ((Spinner) view.findViewById(R.id.spinner));


        /*****************************   SPINNER   ********************************************/
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
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, genres);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        /*****************************   END SPINNER   ********************************************/


        /*****************************   SAVE   ********************************************/
        Button saveButton = (Button) view.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(v -> {

            String title = titleText.getText().toString();
            String authorName = authorNameText.getText().toString();
            String authorSurname = authorSurnameText.getText().toString();
            String yearString = yearText.getText().toString();
            String genreString = spinner.getSelectedItem().toString();

            if (yearString.isEmpty()) {
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }
            int year = Integer.parseInt(yearString);

            if (genreString.equals("[Genre]")) {
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }
            Genre genre = (Genre.getEnumByValue(genreString));

            if (title == null || authorName == null || authorSurname == null) {
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.empty), Toast.LENGTH_SHORT).show();
                return;
            }


            DataBaseService dbService = new DataBaseService();
            List<String> authorsIds = new ArrayList<>();
            // not tested
            // authorsIds.add(Integer.parseInt(dbService.readAuthorFromDbByNameAndSurname(authorName, authorSurname).getId()));

            UserService userService = new UserService();
            String userUid = userService.getUserUid();

            if (dbService.writeToDb("books", new Book(title, authorsIds, year, genre, userUid))) {
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.book_succes), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragment", "BooksFragment"); //for example
                startActivity(intent);

            } else {
                Toast.makeText(getActivity().getApplicationContext(), getString(R.string.book_failed), Toast.LENGTH_SHORT).show();
            }


        });
        /*****************************   END SAVE   ********************************************/


        /*****************************   CANCEL   ********************************************/
        Button cancelButton = (Button) view.findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(v -> {
            titleText.getText().clear();
            authorNameText.getText().clear();
            authorSurnameText.getText().clear();
            yearText.getText().clear();
            spinner.setSelection(0);
        });
        /*****************************   END CANCEL   ********************************************/

        return view;
    }

}
