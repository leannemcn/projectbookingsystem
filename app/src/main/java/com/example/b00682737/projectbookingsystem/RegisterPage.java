package com.example.b00682737.projectbookingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
    private EditText registerName, registerPassword, registerEmail, registerPhone, registerPost;
    private Button registerButton;
    private TextView loginAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        setupUIViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate());
            }
        });

        loginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterPage.this, LoginPage.class));
            }
        });
    }
    private void setupUIViews() {
        registerName = (EditText) findViewById(R.id.registerName);
        registerPassword = (EditText) findViewById(R.id.loginPassword);
        registerEmail = (EditText) findViewById(R.id.registerEmail);
        registerPhone = (EditText) findViewById(R.id.registerPhone);
        registerPost = (EditText) findViewById(R.id.registerPostal);
        registerButton = (Button) findViewById(R.id.registerButton);
        loginAccount = (TextView) findViewById(R.id.loginAccount);
    }


    private Boolean validate() {
        Boolean result = false;

        String Name = registerName.getText().toString();
        String Password = registerPassword.getText().toString();
        String Email = registerEmail.getText().toString();
        String Phone = registerPhone.getText().toString();
        String Post = registerPost.getText().toString();



        if (Name.isEmpty() && Password.isEmpty() && Email.isEmpty() && Phone.isEmpty() && Post.isEmpty()) {
            Toast.makeText(this, "Please fill in all empty spaces", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        } //makes sure all required spaces are filled in

        return result;
    }
}

