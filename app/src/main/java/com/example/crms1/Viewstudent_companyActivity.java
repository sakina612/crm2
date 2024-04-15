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

public class Viewstudent_companyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter4 adapter; // Changed adapter name to MyAdapter2
    List<String> users; // List to store paths under "new job"

    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent_company); // Adjusted layout name

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        users = new ArrayList<>();
        adapter = new MyAdapter4(this, users); // Use adapter for paths
        recyclerView.setAdapter(adapter); // Set adapter

        // Initialize Firebase database reference
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        // Retrieve paths from Firebase Realtime Database
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                collectPaths((ArrayList<String>) users, dataSnapshot, "users");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Viewstudent_companyActivity.this, "Failed to read data: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Recursive function to collect all paths under "new Job"
    private void collectPaths(ArrayList<String> paths, DataSnapshot dataSnapshot, String currentPath) {
        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
            String newPath = currentPath + "/" + snapshot.getKey();
            paths.add(newPath);
            collectPaths(paths, snapshot, newPath);
        }
    }
}
