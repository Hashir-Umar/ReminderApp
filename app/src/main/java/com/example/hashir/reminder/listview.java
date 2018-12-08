package com.example.hashir.reminder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class listview extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_listview, container, false);

        ListView mylist = (ListView) view.findViewById(R.id.myList);

        ArrayAdapter<CharSequence> myAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.Days,
                android.R.layout.simple_list_item_1);

        mylist.setAdapter(myAdapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String day = String.valueOf(parent.getItemAtPosition(position));

                Fragment fragmentB = new Add();
                Bundle bundle = new Bundle();
                bundle.putString("day", day);
                fragmentB.setArguments(bundle);
                getFragmentManager().beginTransaction()
                        .replace(R.id.fLayout, fragmentB )
                        .commit();
            }
        });

        return view;
    }

}
