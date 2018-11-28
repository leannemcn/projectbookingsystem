package com.example.b00682737.projectbookingsystem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

public class RegisterPage extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase myDb;
    Button registerButton, loginAccount;
    EditText _txtname, _txtpass, _txtemail, _txtphone, _txtpost;

    // private EditText registerName, registerPassword, registerEmail, registerPhone, registerPost;
    // private Button registerButton;
    //private TextView loginAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        setContentView(R.layout.activity_register_page);
        openHelper = new Databasehelper(this);
        setupUIViews();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb = openHelper.getWritableDatabase();
                String name = _txtname.getText().toString();
                String password = _txtpass.getText().toString();
                String Email = _txtemail.getText().toString();
                String Phone = _txtphone.getText().toString();
                String Post = _txtpost.getText().toString();
                insertdata(name, password, Email, Phone, Post);
                Toast.makeText(getApplicationContext(), "registration successful", Toast.LENGTH_LONG).show();
                //   if (validate());
            }
        });

        loginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (RegisterPage.this, LoginPage.class);
                startActivity(intent);
            }
        });
    }

    public void insertdata(String Name, String Password, String Email, String Phone, String Post) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Databasehelper.COL_2, Name);
        contentValues.put(Databasehelper.COL_3, Email);
        contentValues.put(Databasehelper.COL_4, Password);
        contentValues.put(Databasehelper.COL_5, Phone);
        contentValues.put(Databasehelper.COL_6, Post);
        long id = myDb.insert(Databasehelper.TABLE_NAME, null, contentValues);
    }


    private void setupUIViews() {
        _txtname = (EditText) findViewById(R.id.registerName);
        _txtpass = (EditText) findViewById(R.id.registerPassword);
        _txtemail = (EditText) findViewById(R.id.registerEmail);
        _txtphone = (EditText) findViewById(R.id.registerPhone);
        _txtpost = (EditText) findViewById(R.id.registerPostal);
        loginAccount = (Button) findViewById(R.id.loginAccount);
        registerButton = (Button) findViewById(R.id.registerButton);
    }


  //  private Boolean validate() {
      //  Boolean result = false;

       // String Name = _txtfname.getText().toString();
       // String Password = _txtpass.getText().toString();
       // String Email = _txtemail.getText().toString();
       // String Phone = _txtphone.getText().toString();
       // String Post = _txtpost.getText().toString();



       // if (Name.isEmpty() && Password.isEmpty() && Email.isEmpty() && Phone.isEmpty() && Post.isEmpty()) {
       //     Toast.makeText(this, "Please fill in all empty spaces", Toast.LENGTH_SHORT).show();
       // } else {
      //      result = true;
      //  } //makes sure all required spaces are filled in

      //  return result;
  //  }
}

