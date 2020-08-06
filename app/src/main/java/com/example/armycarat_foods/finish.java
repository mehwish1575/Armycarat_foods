package com.example.armycarat_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finish extends AppCompatActivity {
TextView tv;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        tv = (TextView)findViewById(R.id.ftv);
        b=(Button)findViewById(R.id.fbu);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(finish.this,MainActivity.class);
                startActivity(i);
            }
        });
    }

}
