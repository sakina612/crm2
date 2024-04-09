package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView card1, card2, card3, card4, card5, card6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card1 = findViewById(R.id.students);
        card2 = findViewById(R.id.image_slider);
        card3 = findViewById(R.id.companyCard);
        card4 = findViewById(R.id.videoCard);
        card5 = findViewById(R.id.adminCard);
        card6 = findViewById(R.id.qaCard);

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

        if (viewId == R.id.students) {
            i = new Intent(this, LoginActivity.class);
        } else if (viewId == R.id.image_slider) {
            i = new Intent(this, cv.class);
        } else if (viewId == R.id.companyCard) {
            i = new Intent(this, LoginCompanyActivity.class);
        } else if (viewId == R.id.videoCard) {
            i = new Intent(this, video.class);
        } else if (viewId == R.id.adminCard) {
            i = new Intent(this, LoginAdminActivity.class);
        } else if (viewId == R.id.qaCard) {
            i = new Intent(this, qa.class);
        } else {
            return; // Do nothing if the clicked view does not match any case
        }

        startActivity(i);
    }

}
