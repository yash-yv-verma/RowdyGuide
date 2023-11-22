package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class NavigationController<T extends AppCompatActivity> implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private T currentActivity;

    public NavigationController(T activity) {
        currentActivity = activity;
    }

    public T getCurrentActivity() {
        return currentActivity;
    }

    public void setCurrentActivity(T currentActivity) {
        this.currentActivity = currentActivity;
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("LISTENR HIT");

        int itemId = item.getItemId();
        Class<?> targetActivityClass = null;

        if (itemId == R.id.navigation_events) {
            targetActivityClass = EventTabActivity.class;
        } else if (itemId == R.id.navigation_profile) {
            targetActivityClass = ProfileActivity.class;
        } else if (itemId == R.id.navigation_calendar) {
            targetActivityClass = CalendarActivity.class;
        } else if (itemId == R.id.navigation_map) {
            targetActivityClass = MapActivity.class;
        }

        if (targetActivityClass != null) {
            Intent intent = new Intent( currentActivity, targetActivityClass );
            currentActivity.startActivity(intent);
            currentActivity.overridePendingTransition(0,0);
            return true;
        }

        return false;
    }

}
