package com.example.hashir.reminder;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt_input;
    TextView txt_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_main = findViewById(R.id.txt_main);
        txt_input = findViewById(R.id.txt_input);
    }

    public void showSchedule(View view)
    {
        Spinner spinner = findViewById(R.id.spinner);
        String day = String.valueOf(spinner.getSelectedItem());

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);

        String data  = sharedPreferences.getString(day, "");

        txt_main.setText(data);

        final TextView txt = findViewById(R.id.txt_main);
        txt.setText(data);
    }

    public void addSchedule(View view)
    {
        Spinner spinner = findViewById(R.id.spinner);
        String day = String.valueOf(spinner.getSelectedItem());

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String data = txt_input.getText().toString();
        if(!data.isEmpty())
        {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(sharedPreferences.getString(day, ""));
            stringBuilder.append('\n');

            stringBuilder.append(data);

            editor.putString(day, String.valueOf(stringBuilder));

            editor.apply();

            Toast.makeText(this, "Agenda Added", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "first add some text", Toast.LENGTH_SHORT).show();
        }
    }

}