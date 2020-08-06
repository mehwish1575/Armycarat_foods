package com.example.armycarat_foods;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class databasehelper_order extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME ="order.db";
    public static final String TABLE_NAME ="user_orders";
    public static final String Col_1="ID";
    public static final String Col_2 ="username";
    public static final String Col_3 ="gotorder";
    public static final String Col_4 ="gottable";
    public static int i=0;



    String name;

    public databasehelper_order(@Nullable Context context) {
        super(context,DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user_orders ( ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,gotorder TEXT, gottable TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addorder(String user, String order,String table)
    {
        i=1;
        int u=getI(i);
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("gotorder",order);
        contentValues.put("gottable", table);
        long res = db.insert("user_orders",null,contentValues);
        db.close();
        return res;

    }
    public boolean checktable(String tab)
    {
        String [] columns = {Col_4};
        SQLiteDatabase s = getReadableDatabase();
        String selection = Col_4 + "=?" ;
        String [] selectionArgs = {tab};
        Cursor cursor;
        cursor = s.query(TABLE_NAME, columns ,selection , selectionArgs , null,null,null);
        int count = cursor.getCount();
        cursor.close();
        s.close();
        if(count>0) {
            return true;
        }
        else {
            return false;

        }
    }

    public static int getI(int o) {
        if(o==1)
        {
            i=1;
        }
        return i;
    }

}

