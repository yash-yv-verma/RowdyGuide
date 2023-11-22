package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.NewAccountActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class ProfileController implements View.OnClickListener {
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

    public void onClick(View v){

        int id = v.getId();
        if ( id == R.id.logoutButton){
            Intent intent = new Intent(profileActivity, MainActivity.class);
            intent.putExtra("logout", true);
            v.getContext().startActivity(intent);
        }

    }
}
