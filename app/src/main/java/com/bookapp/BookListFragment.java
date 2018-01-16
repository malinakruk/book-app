package com.bookapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bookapp.adapters.ListViewAdapter;
import com.bookapp.models.Book;
import com.bookapp.services.DataBaseService;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends Fragment {


    public BookListFragment() {
        // Required empty public constructor
    }

    private OnFragmentInteractionListener mListener;

    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
    final private DatabaseReference dbReference = database.getReference();
    final private DatabaseReference booksRef = dbReference.child("books");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        final ListView listview = (ListView) view.findViewById(R.id.listview);
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                "Android", "iPhone", "WindowsMobile" };
        
        final ArrayList<Book> list = new ArrayList<>();
//        for (int i = 0; i < values.length; ++i) {
//            list.add(values[i]);
//        }

        booksRef.addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dst : dataSnapshot.getChildren()) {
                    list.add(dst.getValue(Book.class));
                    System.out.println(dataSnapshot.getValue(Book.class).getTitle());
                }
                final ListViewAdapter adapter = new ListViewAdapter(getActivity(), android.R.layout.simple_list_item_1, list);
                listview.setAdapter(adapter);
                booksRef.removeEventListener(this);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Book book = (Book) parent.getItemAtPosition(position);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("fragment", "BookFragment");
                intent.putExtra("book", book);
                startActivity(intent);


//                final String item = (String) parent.getItemAtPosition(position);
//                view.animate().setDuration(2000).alpha(0)
//                        .withEndAction(new Runnable() {
//                            @Override
//                            public void run() {
//                                list.remove(item);
//                                adapter.notifyDataSetChanged();
//                                view.setAlpha(1);
//                            }
//                        });
            }

        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void messageFromChildFragment(Uri uri);
    }

}