package com.example.hashir.reminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class Show extends Fragment {

    String day;
    TextView txt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show, container, false);

        ImageView img_hide = getActivity().findViewById(R.id.imageView);
        img_hide.setVisibility(View.GONE);

        Bundle args = getArguments();
        TextView txt = view.findViewById(R.id.txt_dayName);
        day = args.getString("day");
        txt.setText("Selected Day: " + day);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("data", MODE_PRIVATE);

        String data = sharedPreferences.getString(day, "");
        txt = view.findViewById(R.id.txt_show);

        if(!data.isEmpty()) {
            txt.setText(data);
        }
        else {
            txt.setText("No Schedule For " + day);
        }

        ImageView img = view.findViewById(R.id.img_back1);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentB = new listview();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fLayout, fragmentB)
                        .commit();
            }
        });

        return view;
    }

}