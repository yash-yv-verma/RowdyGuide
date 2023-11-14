package edu.utsa.cs3443.rowdyguidefinal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.rowdyguidefinal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Context context;

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
        BottomNavigationView bottomNavigationView= (BottomNavigationView) findViewById(R.id.nav_view);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.navigation_events){
                    startActivity(new Intent(getApplicationContext(), EventActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_home){
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_profile){
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_calendar){
                    startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                else if(item.getItemId() == R.id.navigation_map){
                    startActivity(new Intent(getApplicationContext(), MapActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }

                return false;
            }
        });
    }



    public boolean onNavigationItemSelectedListener(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_events){
            startActivity(new Intent(getApplicationContext(), EventActivity.class));
            overridePendingTransition(0, 0);
            return true;
        }
        else if(item.getItemId() == R.id.navigation_home){
            return true;
        }
        else if(item.getItemId() == R.id.navigation_profile){
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            overridePendingTransition(0, 0);
            return true;
        }
        else if(item.getItemId() == R.id.navigation_calendar){
            startActivity(new Intent(getApplicationContext(), CalendarActivity.class));
            overridePendingTransition(0, 0);
            return true;
        }
        else if(item.getItemId() == R.id.navigation_map){
            startActivity(new Intent(getApplicationContext(), MapActivity.class));
            overridePendingTransition(0, 0);
            return true;
        }

        return false;
    }
}