
package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.MapActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;
import edu.utsa.cs3443.rowdyguidefinal.model.Calendar;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;

public class CalendarController {
    private CalendarActivity calendarActivity;
    private Event event;

    public CalendarController(CalendarActivity activity){
        this.calendarActivity = activity;
    }



    public String getCalendarEvent(ArrayList<Event> events){
        StringBuilder theText = new StringBuilder();
        if(!events.isEmpty()) {
            for (Event e : events) {
                theText.append(e.getName() + " ");
                theText.append(e.getDate() + " ");
                theText.append(e.getTime() + "\n");
            }
        }

        return theText.toString();
    }

    public CalendarActivity getCalendarActivity() {
        return calendarActivity;
    }

    public void setCalendarActivity(CalendarActivity calendarActivity) {
        this.calendarActivity = calendarActivity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }



    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_events){
            Intent intent = new Intent(calendarActivity.getApplicationContext(), EventActivity.class);

            calendarActivity.startActivity(intent);

            calendarActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_home){
            Intent intent = new Intent(calendarActivity.getApplicationContext(), MainActivity.class);

            calendarActivity.startActivity(intent);

            calendarActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_profile){
            Intent intent = new Intent(calendarActivity.getApplicationContext(), ProfileActivity.class);

            calendarActivity.startActivity(intent);

            calendarActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_calendar){
            Intent intent = new Intent(calendarActivity.getApplicationContext(), CalendarActivity.class);

            calendarActivity.startActivity(intent);

            calendarActivity.overridePendingTransition(0,0);
        }
        else if(item.getItemId() == R.id.navigation_map){
            Intent intent = new Intent(calendarActivity.getApplicationContext(), MapActivity.class);

            calendarActivity.startActivity(intent);

            calendarActivity.overridePendingTransition(0,0);
        }
        return true;

    }



}
