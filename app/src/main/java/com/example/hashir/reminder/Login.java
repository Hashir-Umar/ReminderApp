package com.example.hashir.reminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


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

//        Intent intent = new Intent(getActivity(), MainActivity.class);
//        startActivity(intent);

        Button btn = view.findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_txt = email.getText().toString();
                String password_txt = password.getText().toString();

                if(email_txt.length() == 0 )
                    email.setError( "Email required!");
                if(password_txt.length() == 0 )
                    password.setError( "Password required!" );

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("userData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String loginEmail = sharedPreferences.getString("email", "");
                String loginPassword = sharedPreferences.getString("password", "");

                Boolean email_flag = loginEmail.equals(email_txt);
                Boolean password_flag = loginPassword.equals(password_txt);

                if(!email_flag) {
                    email.setError( "Invalid Email" );
                }

                if(!password_flag) {
                    password.setError( "Invalid Password" );
                }

                if(email_flag && email_flag) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;
    }


}
