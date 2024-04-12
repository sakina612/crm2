package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ViewStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter2 adapter; // Changed adapter name to MyAdapter2
    List<HelperClass2> jobList; // Changed HelperClass to HelperClass2

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewjob2); // Adjusted layout name

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jobList = new ArrayList<>();
        adapter = new MyAdapter2(this, jobList); // Changed adapter name to MyAdapter2
        recyclerView.setAdapter(adapter); // Set adapter

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("new Job");

        // Retrieve data from Firebase Realtime Database
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jobList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    HelperClass2 helperClass = snapshot.getValue(HelperClass2.class); // Changed HelperClass to HelperClass2
                    if (helperClass != null) {
                        jobList.add(helperClass);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ViewStudent.this, "Failed to read data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
