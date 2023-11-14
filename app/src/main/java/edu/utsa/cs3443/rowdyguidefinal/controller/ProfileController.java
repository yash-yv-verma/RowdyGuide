package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class ProfileController {
    private ProfileActivity profileActivity;

    public ProfileController(ProfileActivity activity) {
        profileActivity = activity;
    }

    public ProfileActivity getProfileActivity() {

        return profileActivity;
    }

    public void setProfileActivity(ProfileActivity profileActivity) {
        this.profileActivity = profileActivity;
    }


    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.navigation_events) {
            Intent intent = new Intent(profileActivity.getApplicationContext(), EventActivity.class);

            profileActivity.startActivity(intent);

            profileActivity.overridePendingTransition(0,0);
        } else if (item.getItemId() == R.id.navigation_home) {
            Intent intent = new Intent(profileActivity.getApplicationContext(), MainActivity.class);

            profileActivity.startActivity(intent);

            profileActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_profile) {
            Intent intent = new Intent(profileActivity.getApplicationContext(), ProfileActivity.class);

            profileActivity.startActivity(intent);

            profileActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_calendar) {
            Intent intent = new Intent(profileActivity.getApplicationContext(), CalendarActivity.class);

            profileActivity.startActivity(intent);

            profileActivity.overridePendingTransition(0, 0);
        } else if (item.getItemId() == R.id.navigation_map) {
            Intent intent = new Intent(profileActivity.getApplicationContext(), MapActivity.class);

            profileActivity.startActivity(intent);

            profileActivity.overridePendingTransition(0, 0);
        }

        return true;
    }
}
