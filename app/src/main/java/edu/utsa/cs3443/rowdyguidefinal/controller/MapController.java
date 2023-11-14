package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class MapController{
    private MapActivity mapActivity;

    public MapController(MapActivity activity) {
        mapActivity = activity;
    }

    public MapActivity getMapActivity() {
        return mapActivity;
    }

    public void setMapActivity(MapActivity mapActivity) {
        this.mapActivity = mapActivity;
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_events) {
            Intent intent = new Intent(mapActivity.getApplicationContext(), EventActivity.class);

            mapActivity.startActivity(intent);

            mapActivity.overridePendingTransition(0,0);
        } else if (item.getItemId() == R.id.navigation_home) {
            Intent intent = new Intent(mapActivity.getApplicationContext(), MainActivity.class);

            mapActivity.startActivity(intent);

            mapActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_profile) {
            Intent intent = new Intent(mapActivity.getApplicationContext(), ProfileActivity.class);

            mapActivity.startActivity(intent);

            mapActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_calendar) {
            Intent intent = new Intent(mapActivity.getApplicationContext(), CalendarActivity.class);

            mapActivity.startActivity(intent);

            mapActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_map) {
            Intent intent = new Intent(mapActivity.getApplicationContext(), MapActivity.class);

            mapActivity.startActivity(intent);

            mapActivity.overridePendingTransition(0, 0);
        }
        return true;

    }
}
