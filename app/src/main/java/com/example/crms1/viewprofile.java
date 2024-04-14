package com.example.crms1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.List;

// viewprofile.java
public class viewprofile extends AppCompatActivity {
    TextView profile_Name, profile_Email, profile_Username, profile_Password;
    TextView titleName, titleUsername;
    Button editProfile;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        profile_Name = findViewById(R.id.profileName);
        profile_Email = findViewById(R.id.profileEmail);
        profile_Username = findViewById(R.id.profileUsername);
        profile_Password = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        editProfile = findViewById(R.id.editButton);

        // Retrieve the username passed from the previous activity
        String userUsername = getIntent().getStringExtra("username");

        // Initialize Firebase database reference with the correct path
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        reference = database.child("users");

        // Query to retrieve user data based on the username
        Query query = reference.orderByChild("username").equalTo(userUsername);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Check if data exists for the given username
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        // Get user data from the snapshot
                        HelperClass helperClass = snapshot.getValue(HelperClass.class);
                        if (helperClass != null) {
                            // Log retrieved data
                            Log.d("viewprofile", "Name: " + helperClass.getName());
                            Log.d("viewprofile", "Email: " + helperClass.getEmail());
                            Log.d("viewprofile", "Username: " + helperClass.getUsername());
                            Log.d("viewprofile", "Password: " + helperClass.getPassword());

                            // Update TextViews with retrieved data
                            profile_Name.setText(helperClass.getName());
                            profile_Email.setText(helperClass.getEmail());
                            profile_Username.setText(helperClass.getUsername());
                            profile_Password.setText(helperClass.getPassword());

                            // Show a toast indicating successful retrieval
                            Toast.makeText(viewprofile.this, "Data retrieved successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.d("viewprofile", "HelperClass object is null");
                        }
                    }
                } else {
                    // Handle case when no data is found for the given username
                    Log.d("viewprofile", "No data found for username: " + userUsername);
                    Toast.makeText(viewprofile.this, "Might have lost some data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle database error
                Log.e("viewprofile", "Database error: " + databaseError.getMessage());
            }
        });
    }
}
