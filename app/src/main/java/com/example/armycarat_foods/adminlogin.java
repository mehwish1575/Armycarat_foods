package com.example.armycarat_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {


    EditText un,pass;
    Button b1;
    String user1="mehwish";
    String pass1="mehwish123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        un=(EditText)findViewById(R.id.un);
        pass=(EditText)findViewById(R.id.pas);
        b1=(Button)findViewById(R.id.lo);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = un.getText().toString().trim();
                String pas = pass.getText().toString().trim();
                if(user.equals(user1) ) {
                    if (pas.equals(pass1))
                    {
                        Intent homep1 = new Intent(adminlogin.this, orderreport.class);
                        startActivity(homep1);
                    }
                    else
                    {
                        Toast.makeText(adminlogin.this, "login error ", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(adminlogin.this, "login error ", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}
