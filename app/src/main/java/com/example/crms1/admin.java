package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class admin extends AppCompatActivity implements View.OnClickListener{

    private CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        card1 = findViewById(R.id.addstudentCard);
        card2 = findViewById(R.id.viewstudentCard);
        card3 = findViewById(R.id.addcompanyCard);
        card4 = findViewById(R.id.viewcompaniesCard);
        card5 = findViewById(R.id.viewjobCard);
        card6 = findViewById(R.id.logoutCard);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);
        card6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        int viewId = v.getId();

        if (viewId == R.id.addstudentCard) {
            i = new Intent(this, addstudent.class);
        } else if (viewId == R.id.viewstudentCard) {
            i = new Intent(this, viewstudent.class);
        } else if (viewId == R.id.addcompanyCard) {
            i = new Intent(this, addcompany.class);
        } else if (viewId == R.id.viewcompaniesCard) {
            i = new Intent(this, viewcompanies.class);
        } else if (viewId == R.id.viewjobCard) {
            i = new Intent(this, viewjob.class);
        } else if (viewId == R.id.logoutCard) {
            i = new Intent(this, logout.class);
        } else {
            return; // Do nothing if the clicked view does not match any case
        }

        startActivity(i);

    }
}