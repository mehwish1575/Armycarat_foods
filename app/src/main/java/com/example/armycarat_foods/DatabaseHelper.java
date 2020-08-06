package com.example.armycarat_foods;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
public static final String DATABASE_NAME ="register.db";
public static final String TABLE_NAME ="registeruser";
public static final String Col_1="ID";
public static final String Col_2 ="username";
public static final String Col_3 ="password";
    private static String u;
    public static  String name="";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE registeruser ( ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
onCreate(db);
    }
    public long adduser(String user, String password)
    {

        SQLiteDatabase db= this. getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("registeruser",null,contentValues);
        db.close();
        return res;
    }
    public boolean checkUser(String username, String password)
    {
        String e= getuser(username);
        String [] columns = {Col_1};
        SQLiteDatabase s = getReadableDatabase();
        String selection = Col_2 + "=?" + " and " + Col_3 + "=?";
        String [] selectionArgs = {username, password};
        Cursor cursor;
        cursor = s.query(TABLE_NAME, columns ,selection , selectionArgs , null,null,null);
        int count = cursor.getCount();
        u= username;
        cursor.close();
s.close();
        if(count>0) {
            return true;
        }
else {
            return false;

        }
    }


    public String getuser(String user)
    {


        if(user != "0")
        {
            name = user;
        }
        return name;
    }
}
