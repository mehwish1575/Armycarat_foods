package com.example.armycarat_foods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    EditText etusername;
    EditText etpassword;
    EditText cnfpassword;
    Button bregistration;
    TextView tvlogin;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        etusername= (EditText) findViewById(R.id.un);
        etpassword = (EditText) findViewById(R.id.pas);
        cnfpassword = (EditText) findViewById(R.id.cnfpas);
        bregistration =(Button) findViewById(R.id.bu_register);
        tvlogin= (TextView) findViewById(R.id.tv_login);
        tvlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(register.this,userlogin.class);
                startActivity(loginintent);

            }
        });
        bregistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String user = etusername.getText().toString().trim();
              String pass = etpassword.getText().toString().trim();
             String cnf_pass = cnfpassword.getText().toString().trim();

if(pass.equals(cnf_pass))
{
   long val = db.adduser(user,pass);
   if(val > 0) {
       Toast.makeText(register.this, "you have registered ", Toast.LENGTH_SHORT).show();
       Intent moveToLogin = new Intent(register.this, userlogin.class);
       startActivity(moveToLogin);
   }
   else{
       Toast.makeText(register.this, "registration error ", Toast.LENGTH_SHORT).show();

   }
}
else
{
    Toast.makeText(register.this, "password is not matching ", Toast.LENGTH_SHORT).show();
 }

            }
        });
    }

}
