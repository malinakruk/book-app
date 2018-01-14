package com.bookapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.bookapp.models.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    List<Integer> grades;

    public BookFragment() {
        // Required empty public constructor
        grades = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            grades.add(i);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);

        Spinner gradeSpinner = ((Spinner) view.findViewById(R.id.gradeSpinner));

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

        return view;
    }

}
