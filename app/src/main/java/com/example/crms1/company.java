package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class company extends AppCompatActivity implements View.OnClickListener{

    private CardView card1, card2, card3, card4, card5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        card1 = findViewById(R.id.viewprofileCard);
        card2 = findViewById(R.id.addjobCard);
        card3 = findViewById(R.id.viewjobCard);
        card4 = findViewById(R.id.viewstudentCard);
        card5 = findViewById(R.id.logoutCard);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        int viewId = v.getId();

        if (viewId == R.id.viewprofileCard) {
            i = new Intent(this, viewprofile.class);
        } else if (viewId == R.id.addjobCard) {
            i = new Intent(this, addjob.class);
        } else if (viewId == R.id.viewjobCard) {
            i = new Intent(this, viewjob.class);
        } else if (viewId == R.id.viewstudentCard) {
            i = new Intent(this, viewstudent.class);
        } else if (viewId == R.id.logoutCard) {
            i = new Intent(this, logout.class);
        } else {
            return; // Do nothing if the clicked view does not match any case
        }

        startActivity(i);

    }
}