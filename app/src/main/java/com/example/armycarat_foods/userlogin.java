package com.example.armycarat_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userlogin extends AppCompatActivity {

    EditText etusername;
    EditText etpassword;
    Button blogin;
    TextView tvregistration;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(this);
        setContentView(R.layout.activity_userlogin);
        etusername= (EditText) findViewById(R.id.un);
        etpassword = (EditText) findViewById(R.id.pas);
        blogin =(Button) findViewById(R.id.lo);


        tvregistration= (TextView) findViewById(R.id.tvr);
        tvregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerintent = new Intent(userlogin.this,register.class);
                startActivity(registerintent);
            }
        });

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etusername.getText().toString().trim();
                String pass = etpassword.getText().toString().trim();

                boolean res = db.checkUser(user,pass);

                if(res == true)
                {
                    Intent homep1 = new Intent(userlogin.this,home.class);
                    startActivity(homep1);
                }
                else
                {
                    Toast.makeText(userlogin.this, "login error ", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }

}
