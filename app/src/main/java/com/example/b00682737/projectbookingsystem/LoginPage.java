package com.example.b00682737.projectbookingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginPage extends AppCompatActivity {
    private EditText Username;
    private EditText Password;
    private TextView Attempts, registerHere;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Username = (EditText) findViewById(R.id.loginUsername);
        Password = (EditText) findViewById(R.id.loginPassword);
        Attempts = (TextView) findViewById(R.id.Attempts);
        registerHere = (TextView) findViewById(R.id.registerHere);
        Login = (Button) findViewById(R.id.loginButton);

        Attempts.setText("Attempts remaining: 3 ");

        registerHere.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerOpen = new Intent(LoginPage.this, RegisterPage.class);
                LoginPage.this.startActivity(registerOpen);
            }
        }); //this will open the register page once selected

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Username.getText().toString(), Password.getText().toString());
            }
        }); //this will open login page if username & password are correct

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("Leanne")) && (userPassword.equals("Project"))) {
            Intent intent = new Intent(LoginPage.this, ProfilePage.class);
            startActivity(intent);
        } else {
            counter--;

            Attempts.setText("Attempts left " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
            }
            //will carry out validation to ensure username and password are correct before signing user in
            //Attempts will decrease from 3 if the username and password arent correct.
        }

    }


}

