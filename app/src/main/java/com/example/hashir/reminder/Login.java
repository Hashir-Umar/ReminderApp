package com.example.hashir.reminder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Login extends Fragment {

    EditText email, password;

    public Login() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        email = (EditText) view.findViewById(R.id.etxt_login_email);
        password = (EditText) view.findViewById(R.id.etxt_login_password);

        Button btn = view.findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString();
                String password_txt = password.getText().toString();
                Toast.makeText(getContext(), email_txt+password_txt, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
