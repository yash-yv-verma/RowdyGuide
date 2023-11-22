package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.NonNull;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;
import edu.utsa.cs3443.rowdyguidefinal.controller.ProfileController;
import edu.utsa.cs3443.rowdyguidefinal.model.User;

public class ProfileActivity extends AppCompatActivity {

    ProfileController profileController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

        User user = (User) getIntent().getSerializableExtra("user");

        TextView nameText = findViewById(R.id.Name);
        TextView classificationText = findViewById(R.id.Classification);
        TextView emailText = findViewById(R.id.Email);
        TextView contactText = findViewById(R.id.Contact);


        //check it loaded properly
        if ( !user.getUsername().equals("") ) {
            nameText.setText(user.getName());
            classificationText.setText(user.getClassification());
            emailText.setText(user.getEmail());
            contactText.setText(user.getContact());
        } else{
            nameText.setText("");
            classificationText.setText("");
            emailText.setText("");
            contactText.setText("");
            Toast.makeText(this, "Error loading profile.", Toast.LENGTH_LONG).show();
        }


        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
        NavigationController<ProfileActivity> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            navigationController.onNavigationItemSelected(item); //call here
            return true;
        });

        ProfileController profileController = new ProfileController(this);
        Button logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(profileController);

        Button editProfileButton = findViewById(R.id.editButton);
        editProfileButton.setOnClickListener(profileController);

    }
}