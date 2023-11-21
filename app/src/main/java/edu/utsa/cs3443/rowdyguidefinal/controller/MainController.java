package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class MainController implements BottomNavigationView.OnNavigationItemSelectedListener {
    private MainActivity mainActivity;
    public MainController(MainActivity activity) {
        mainActivity = activity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("LISTENR HIT");
        if(item.getItemId() == R.id.navigation_events){
            Intent intent = new Intent(mainActivity.getApplicationContext(), EventTabActivity.class);

            mainActivity.startActivity(intent);

            mainActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_home){
            Intent intent = new Intent(mainActivity.getApplicationContext(), MainActivity.class);

            mainActivity.startActivity(intent);

            mainActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_profile){
            Intent intent = new Intent(mainActivity.getApplicationContext(), ProfileActivity.class);

            mainActivity.startActivity(intent);

            mainActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_calendar){
            Intent intent = new Intent(mainActivity.getApplicationContext(), CalendarActivity.class);

            mainActivity.startActivity(intent);

            mainActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_map){
            Intent intent = new Intent(mainActivity.getApplicationContext(), MapActivity.class);

            mainActivity.startActivity(intent);

            mainActivity.overridePendingTransition(0,0);
        }

        return true;
    }



}
