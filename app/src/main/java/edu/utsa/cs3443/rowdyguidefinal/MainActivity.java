package edu.utsa.cs3443.rowdyguidefinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rowdyguidefinal.controller.MainController;
import edu.utsa.cs3443.rowdyguidefinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_events, R.id.navigation_calendar,R.id.navigation_map,R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);*/
        // Initialize and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        mainController = new MainController(this);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            mainController.onNavigationItemSelected(item); //call here
            System.out.println("here");
            return true;
        });
//        nav.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = nav.OnNavigationItemSelectedListener();
        MenuItem item = bottomNavigationView.getMenu().findItem(bottomNavigationView.getSelectedItemId());


    }


}
