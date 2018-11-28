package com.example.b00682737.projectbookingsystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="ID";
    public static final String COL_2="Username";
    public static final String COL_3="Email";
    public static final String COL_4="Password";
    public static final String COL_5="Phone";
    public static final String COL_6="POST";
    public Databasehelper(Context context){
        super (context, DATABASE_NAME, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase myDb) {
        myDb.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name TEXT,Email TEXT,Password TEXT,Phone TEXT,Post TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDb, int oldVersion, int newVersion) {
        myDb.execSQL(" DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(myDb);

    }
}
