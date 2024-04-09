package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class qa extends AppCompatActivity implements View.OnClickListener{

    private CardView card1, card2, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);


            card1 = findViewById(R.id.resumeCard);
            card2 = findViewById(R.id.linkedinCard);
            card5 = findViewById(R.id.bodylanguageCard);
            card6 = findViewById(R.id.logoutCard);

            card1.setOnClickListener(this);
            card2.setOnClickListener(this);
            card5.setOnClickListener(this);
            card6.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i;

            int viewId = v.getId();

            if (viewId == R.id.resumeCard) {
                i = new Intent(this, resume.class);
            } else if (viewId == R.id.linkedinCard) {
                i = new Intent(this, linkedin.class);
            } else if (viewId == R.id.bodylanguageCard) {
                i = new Intent(this, bodylanguage.class);
            } else if (viewId == R.id.logoutCard) {
                i = new Intent(this, logout.class);
            } else {
                return; // Do nothing if the clicked view does not match any case
            }

            startActivity(i);
    }
}