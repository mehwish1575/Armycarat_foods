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

public class databasehelper_review extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME ="review.db";
    public static final String TABLE_NAME ="user_review";
    public static final String Col_1="ID";
    public static final String Col_2 ="username";
    public static final String Col_3 ="rating";
    public static final String Col_4 ="review";
public static int i=0;


String name;

    public databasehelper_review(@Nullable Context context) {
        super(context,DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE user_review ( ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT,rating TEXT, review TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long addreview(String user, String rating,String review)
    {
        i=1;
       int u=getI(i);
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("rating",rating);
        contentValues.put("review", review);
        long res = db.insert("user_review",null,contentValues);
        db.close();
        return res;

    }

    public static int getI(int o) {
        if(o==1)
        {
            i=1;
        }
        return i;
    }
}

