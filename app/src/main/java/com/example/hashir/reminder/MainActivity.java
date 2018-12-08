package com.example.hashir.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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

        Fragment fragment = new listview();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        ImageView img = findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

    }


//    public void showSchedule(View view)
//    {
//        Spinner spinner = findViewById(R.id.spinner);
//        String day = String.valueOf(spinner.getSelectedItem());
//
//        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
//
//        String data  = sharedPreferences.getString(day, "");
//
//        txt_main.setText(data);
//
//        final TextView txt = findViewById(R.id.txt_main);
//        txt.setText(data);
//    }
//
//    public void addSchedule(View view)
//    {
//        Spinner spinner = findViewById(R.id.spinner);
//        String day = String.valueOf(spinner.getSelectedItem());
//
//        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//
//        String data = txt_input.getText().toString();
//        if(!data.isEmpty())
//        {
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append(sharedPreferences.getString(day, ""));
//            stringBuilder.append('\n');
//
//            stringBuilder.append(data);
//
//            editor.putString(day, String.valueOf(stringBuilder));
//
//            editor.apply();
//
//            Toast.makeText(this, "Agenda Added", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(this, "first add some text", Toast.LENGTH_SHORT).show();
//        }
//    }

}