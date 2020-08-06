package com.example.armycarat_foods;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class orderreport extends ListActivity {
    databasehelper_order myDb;
    SQLiteDatabase dd;
    String str;
    public String[] order_list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new databasehelper_order(this);
        dd = myDb.getReadableDatabase();
        int i = databasehelper_order.getI(0);
        if (i == 1) {
        Cursor res = dd.rawQuery("Select ID,username,gotorder,gottable  from user_orders", null);
        int b = res.getCount();
        order_list = new String[b];
        StringBuffer buffer = new StringBuffer();
        // StringBuffer in java is used to create modifiable String objects.
        // This means that we can use StringBuffer to append, reverse, replace, concatenate and manipulate Strings
        // or sequence of characters
        int j = 0;
        if (res != null) {
            res.moveToFirst();
        }
        do {
            buffer.delete(0, buffer.length());
          //  buffer.append("ID :" + res.getString(0) + "\n");
            buffer.append("username :" + res.getString(1) + "\n");
            buffer.append("gotorder :" + res.getString(2) + "\n");
            buffer.append("gottable :" + res.getString(3) + "\n");
            order_list[j] = buffer.toString();
            // item_list[j]=res.getString(1);
            Log.v("Cursor Object", res.getString(0));
            j++;
            res.moveToNext();

        } while (res != null && j < b);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, order_list));

        ListView listView = getListView();
        listView.setTextFilterEnabled(true);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                String s1 = (String) ((TextView) view).getText();
                //replacing all alphabets with blank spaces so to get id only
                str = s1.replaceAll("[^\\d.]", "");
                Log.v("Cursor Object", str);

            }
        });
        }
        else
        {
            Toast.makeText(orderreport.this, "no orders yet", Toast.LENGTH_SHORT).show();
            Intent menu= new Intent(this,MainActivity.class);
            startActivity(menu);
        }

    }
}
