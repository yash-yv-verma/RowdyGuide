package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;

public class EventController{
    private EventActivity eventActivity;
    private Event event;

    public EventController(EventActivity activity){
        this.eventActivity = activity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean onNavigationItemSelected(MenuItem item) {
            if(item.getItemId() == R.id.navigation_events){
                return true;
            }
            else if(item.getItemId() == R.id.navigation_home){
                Intent intent = new Intent(eventActivity.getApplicationContext(), MainActivity.class);

                eventActivity.startActivity(intent);

                eventActivity.overridePendingTransition(0,0);
            }
            else if(item.getItemId() == R.id.navigation_profile){
                Intent intent = new Intent(eventActivity.getApplicationContext(), ProfileActivity.class);

                eventActivity.startActivity(intent);

                eventActivity.overridePendingTransition(0,0);
            }
            else if(item.getItemId() == R.id.navigation_calendar){
                Intent intent = new Intent(eventActivity.getApplicationContext(), CalendarActivity.class);

                eventActivity.startActivity(intent);

                eventActivity.overridePendingTransition(0,0);
            }
            else if(item.getItemId() == R.id.navigation_map){
                Intent intent = new Intent(eventActivity.getApplicationContext(), MapActivity.class);

                eventActivity.startActivity(intent);

                eventActivity.overridePendingTransition(0,0);
            }
            return true;

        }


}
