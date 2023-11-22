package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.EventAdd;

public class EventTabController implements View.OnClickListener{
    EventTabActivity eventTabActivity;
    AssetManager assetManager;

    static ArrayList<Event> events;

    public EventTabController(EventTabActivity eventTabActivity){
        this.eventTabActivity = eventTabActivity;
        assetManager = eventTabActivity.getAssets();

        {
            try {
                events = EventAdd.addEvents(assetManager);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public EventTabActivity getEventTabActivity() {
        return eventTabActivity;
    }

    public void setEventTabActivity(EventTabActivity eventTabActivity) {
        this.eventTabActivity = eventTabActivity;
    }

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public void setAssetManager(AssetManager assetManager) {
        this.assetManager = assetManager;
    }

    public static ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public void onClick(View v){
        int idOfButtonPressed = v.getId();
        Context context = v.getContext();

        if (idOfButtonPressed == R.id.imageButton1) {

            Toast.makeText(v.getContext(), "Home!", Toast.LENGTH_SHORT).show();

            //Intent intent = new Intent(eventTabActivity, EventTabActivity.class);
            //eventTabActivity.startActivity(intent);

        } else if (idOfButtonPressed == R.id.imageButton2) {

            Toast.makeText(v.getContext(), "Add!", Toast.LENGTH_SHORT).show();

            //Intent intent = new Intent(eventTabActivity, EventTabActivity.class);
            //eventTabActivity.startActivity(intent);

        } else {
            // User clicked an unknown button.
            Toast.makeText(v.getContext(), "Something strange happened!", Toast.LENGTH_LONG).show();
        }
    }

}
