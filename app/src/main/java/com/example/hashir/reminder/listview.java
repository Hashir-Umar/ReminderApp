package com.example.hashir.reminder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listview extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listview, container, false);

        String [] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        ListView mylist = (ListView) view.findViewById(R.id.myList);

        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.Days,
                android.R.layout.simple_list_item_1);

        return view;
    }

}
