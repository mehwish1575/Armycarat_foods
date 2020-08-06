package com.example.armycarat_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Button cus, ad;
    Button blogin,ho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ho =(Button) findViewById(R.id.hom);
        cus = (Button)findViewById(R.id.cus);
        ad= (Button)findViewById(R.id.ad);
        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,userlogin.class);
                startActivity(i);
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 =new Intent(MainActivity.this,adminlogin.class);
                startActivity(i2);
            }
        });
        ho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cr = new Intent(MainActivity.this,p_reviews.class);
                startActivity(cr);
            }
        });

    }
}
