package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class student extends AppCompatActivity implements View.OnClickListener{

    private CardView card1, card2, card3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        btn = (Button) findViewById(R.id.viewprofitName);
        card1 = findViewById(R.id.viewprofileCard);
        card2 = findViewById(R.id.viewjobCard);
        card3 = findViewById(R.id.logoutCard);

       card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://docs.google.com/forms/d/e/1FAIpQLSebUdPr7Ym_pGFWJ9XFFsm3g8vY9ZySxzF8nsnPVhRvttFlxg/viewform?usp=sf_link");
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void onClick(View v) {
        Intent i;

        int viewId = v.getId();

        if (viewId == R.id.viewjobCard) {
            i = new Intent(this, ViewStudent.class);
        } else if (viewId == R.id.logoutCard) {
            i = new Intent(this,MainActivity.class);
        } else {
            return; // Do nothing if the clicked view does not match any case
        }

        startActivity(i);
    }

}