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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Signup extends Fragment {


    EditText username, email, password, confirm;

    public Signup() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        username = (EditText) view.findViewById(R.id.etxt_signup_username);
        email = (EditText) view.findViewById(R.id.etxt_signup_email);
        password = (EditText) view.findViewById(R.id.etxt_signup_password);
        confirm = (EditText) view.findViewById(R.id.etxt_signup_confirmPassword);

        Button btn = view.findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString();
                String password_txt = password.getText().toString();
                String username_txt = username.getText().toString();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("username", username_txt);
                editor.putString("email", email_txt);
                editor.putString("password", password_txt);
                editor.apply();

            }
        });

        return view;
    }
}
