package com.bookapp.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.bookapp.models.Book;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Malwina on 2017-12-18.
 */

public class ListViewAdapter  extends ArrayAdapter<Book> {

    HashMap<Book, Integer> mIdMap = new HashMap<Book, Integer>();

    public ListViewAdapter(Context context, int textViewResourceId, List<Book> objects) {
        super(context, textViewResourceId, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        Book item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

}