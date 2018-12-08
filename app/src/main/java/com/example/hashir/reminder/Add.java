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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class Add extends Fragment {

    SharedPreferences sharedPreferences;
    EditText etxt;
    String day;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        Bundle args = getArguments();
        TextView txt = view.findViewById(R.id.txt_dayName);
        day = args.getString("day");
        txt.setText("Selected Day: "+ day);

        etxt = view.findViewById(R.id.etxt_add);
        Button btn = view.findViewById(R.id.btn_add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSchedule(v);
            }
        });

        return view;
    }

    public void addSchedule(View view)
    {
        sharedPreferences = getActivity().getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String data = etxt.getText().toString();
        if(!data.isEmpty())
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sharedPreferences.getString(day, ""));
            stringBuilder.append('\n');

            stringBuilder.append(data);

            editor.putString(day, String.valueOf(stringBuilder));

            editor.apply();

            Toast.makeText(getContext(), "Agenda Added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getContext(), "first add some text", Toast.LENGTH_SHORT).show();
        }
    }

}
