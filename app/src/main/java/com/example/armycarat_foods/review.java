package com.example.armycarat_foods;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class review extends Activity {

    private RatingBar ratingBar;
    private TextView txtRatingValue;
    private Button btnSubmit;
    EditText reet;
    databasehelper_review dbr;
    DatabaseHelper db;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        dbr = new databasehelper_review (this);
        db = new DatabaseHelper(this);

        addListenerOnRatingBar();
        addListenerOnButton();

    }

    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));

            }
        });
    }

    public void addListenerOnButton() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
       reet = (EditText) findViewById(R.id.ret);

        //if click on me, then display the current rating value.
        btnSubmit.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String rating=  String.valueOf(ratingBar.getRating());

                String name=db.getuser("0");
                String review = reet.getText().toString().trim();
                long val = dbr.addreview(name,rating,review);
                if(val > 0)
                {
                    Toast.makeText(review.this, "review is saved ", Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new Intent(review.this, finish.class);
                    startActivity(moveToLogin);
                }
                else
                    {
                    Toast.makeText(review.this, "error ", Toast.LENGTH_SHORT).show();

                    }

            }

        });

    }
}