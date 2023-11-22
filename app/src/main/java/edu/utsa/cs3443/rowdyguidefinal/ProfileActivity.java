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

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;
import edu.utsa.cs3443.rowdyguidefinal.controller.ProfileController;

public class ProfileActivity extends AppCompatActivity {

    ProfileController profileController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);

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

    }
}