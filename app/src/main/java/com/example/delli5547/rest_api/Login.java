package com.example.delli5547.rest_api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by DELL I5547 on 26-01-2016.
 */




public class Login extends ActionBarActivity {


    EditText username;
    EditText password;
    RestAPI send;
    boolean x;
    Button btn;
    String password1;
    String user;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        btn = (Button) findViewById(R.id.btn);
        username = (EditText) findViewById(R.id.text_1);

        password = (EditText) findViewById(R.id.text_2);

        System.out.println("Rajanp"+user+"   "+ password);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  send1 = (LoginListener) new LoginListener(getApplicationContext(), user,password1).execute();
                // x=send1.loggedIn;
                user=username.getText().toString();
                password1 = password.getText().toString();
                send = new RestAPI(user, password1, context);
                boolean x = send.logIn();
                Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_SHORT).show();
                if (x == true) {


                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {

                    Toast.makeText(getApplicationContext(), "cancel", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



