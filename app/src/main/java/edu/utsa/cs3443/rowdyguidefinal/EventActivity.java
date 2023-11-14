package edu.utsa.cs3443.rowdyguidefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.utsa.cs3443.rowdyguidefinal.controller.EventController;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.StaticEvent;

public class EventActivity extends AppCompatActivity {
    EventController eventController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView=findViewById(R.id.nav_view);
        eventController = new EventController(this);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_events);

        // Perform item selected listener
       // MenuItem item = bottomNavigationView.getMenu().findItem(bottomNavigationView.getSelectedItemId());
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            eventController.onNavigationItemSelected(item); //call here
            System.out.println("here");
            return true;
        });
        Event theEvent = new Event("name", "date","time");
        StaticEvent.event = theEvent;
    }
}