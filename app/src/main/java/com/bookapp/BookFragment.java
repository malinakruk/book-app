package com.bookapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bookapp.models.Book;
import com.bookapp.services.UserService;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    List<Integer> grades;
    Book book;

    public BookFragment() {
        // Required empty public constructor
        grades = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            grades.add(i);
        }
    }

    public static BookFragment newInstance(Book book) {
        BookFragment bookFragment = new BookFragment();

        Bundle args = new Bundle();
        args.putSerializable("book", book);
        bookFragment.setArguments(args);

        return bookFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        book = (Book) getArguments().getSerializable("book");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        Spinner gradeSpinner = (Spinner) view.findViewById(R.id.gradeSpinner);
        TextView titleText = (TextView) view.findViewById(R.id.titleText);
        TextView authorText = (TextView) view.findViewById(R.id.authorText);
        TextView yearText = (TextView) view.findViewById(R.id.yearText);
        TextView genreText = (TextView) view.findViewById(R.id.genreText);
        TextView addedByText = (TextView) view.findViewById(R.id.addedByText);
        TextView averageGradeText = (TextView) view.findViewById(R.id.averageGradeText);

        /*****************************   SPINNER   ********************************************/
        gradeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        // Creating adapter for spinner
        ArrayAdapter<Integer> dataAdapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_spinner_item, grades);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        gradeSpinner.setAdapter(dataAdapter);
        /*****************************   END SPINNER   ********************************************/

        /*****************************   SET BOOK PROPERTIES   ********************************************/
        titleText.setText(book.getTitle());
        //authorText.setText(book.getAuthorsIds().get(0));
        authorText.setText("Anonymous");
        yearText.setText(String.valueOf(book.getYear()));
        genreText.setText(book.getGenre().displayName());
        addedByText.setText(book.getUserUid());
        averageGradeText.setText(String.valueOf(book.getAverageGrade()));
        /*****************************   END SET BOOK PROPERTIES   ********************************************/

        return view;
    }

}
