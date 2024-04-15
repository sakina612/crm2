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

public class Known_StudentActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter3 adapter; // Changed adapter name to MyAdapter2
    List<String> jobPaths; // List to store paths under "new job"

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_known_student); // Adjusted layout name

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        jobPaths = new ArrayList<>();
        adapter = new MyAdapter3(this, jobPaths); // Use adapter for paths
        recyclerView.setAdapter(adapter); // Set adapter

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("new Job");

        // Retrieve paths from Firebase Realtime Database
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectNodeNames((ArrayList<String>) jobPaths, dataSnapshot);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Known_StudentActivity.this, "Failed to read data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Function to collect node names
    private void collectNodeNames(ArrayList<String> paths, DataSnapshot dataSnapshot) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            paths.add(snapshot.getKey()); // Add only the node name
        }
    }
}
