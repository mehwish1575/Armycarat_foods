package com.example.armycarat_foods;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.String.valueOf;

/**
 * This is a simple Android mobile client
 * This application read any string massage typed on the text field and
 * send it to the server when the Send button is pressed
 * Author by Lak J Comspace
 */
public class home extends Activity {

   public int t[]= new int[25];
   int count=0;
    /*
    private Socket client;
    private PrintWriter printwriter;
    private EditText textField;
    private Button button;
    private String messsage;
    */
    static int tablex;
    public static int a[]=new int[25];
    public static int i=0;
    databasehelper_order db;
    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    db= new databasehelper_order(this);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void nextact(View view) {

        EditText table = (EditText) findViewById(R.id.table_no);
        if (table.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),
                    "Please,enter your table number", Toast.LENGTH_SHORT).show();
        }


        else {

            Editable newTxt = (Editable) table.getText();
            String tbl_no = newTxt.toString();
            tablex = Integer.parseInt(tbl_no); // get the text message on the text field
            //SendMessage sendMessageTask = new SendMessage();
            //sendMessageTask.execute();
            if (tablex<=25 && tablex!=0) {

               String tab= valueOf(tablex);

                boolean res = db.checktable(tab);

                if(res == false)
                {
                    Intent intent = new Intent(this, Order_type.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(this, home.class);
                    startActivity(intent);
                    Toast.makeText(home.this, "table is taken ", Toast.LENGTH_SHORT).show();

                }

            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Please,enter valid table number. eg (1-25)", Toast.LENGTH_SHORT).show();
            }
        }
    }

}


