package com.example.b00682737.projectbookingsystem;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    SQLiteDatabase myDb;
    SQLiteOpenHelper openHelper;
    Button loginButton;
    EditText loginUsername, loginPassword;
    Cursor cursor;
    TextView registerHere;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        openHelper = new Databasehelper(this);
        myDb = openHelper.getReadableDatabase();
        loginButton = (Button) findViewById(R.id.loginButton);
        loginUsername = (EditText) findViewById(R.id.loginUsername);
        loginPassword = (EditText) findViewById(R.id.loginPassword);

        registerHere = (TextView) findViewById(R.id.registerHere);


        //Attempts.setText("Attempts remaining: 3 ");

       registerHere.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Intent registerOpen = new Intent(LoginPage.this, RegisterPage.class);
               LoginPage.this.startActivity(registerOpen);
            }
       }); //this will open the register page once selected

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                String username = loginUsername.getText().toString();
                String password = loginPassword.getText().toString();
                cursor = myDb.rawQuery("SELECT * FROM " + Databasehelper.TABLE_NAME + " WHERE " + Databasehelper.COL_2 + "=? AND " + Databasehelper.COL_4 + "=?", new String[]{username, password});
                if
                        (cursor!=null){
                   if (cursor.getCount()>0){
                       cursor.moveToNext();
                       Intent profileOpen = new Intent (LoginPage.this, ProfilePage.class);
                       LoginPage.this.startActivity(profileOpen);

                    //  Toast.makeText(getApplicationContext(), "successful login", Toast.LENGTH_LONG).show();
                 //  }else {
                      // Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_SHORT).show();
                    }

                }
            }
              //  validate(Username.getText().toString(), Password.getText().toString());
         //   }
        }); //this will open login page if username & password are corrects

    }

   // private void validate(String userName, String userPassword) {
        //if ((userName.equals("Leanne")) && (userPassword.equals("Project"))) {
         //   Intent intent = new Intent(LoginPage.this, ProfilePage.class);
         //   startActivity(intent);
      //  } else {
        //    counter--;

        //    Attempts.setText("Attempts left " + String.valueOf(counter));

         //   if (counter == 0) {
          //      Login.setEnabled(false);
          //  }
            //will carry out validation to ensure username and password are correct before signing user in
            //Attempts will decrease from 3 if the username and password arent correct.
      //  }

   // }


}

