/**
 * @author Kailey Perrino
 */
package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

import edu.utsa.cs3443.rowdyguidefinal.CalendarActivity;
import edu.utsa.cs3443.rowdyguidefinal.EventTabActivity;
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
        if(events !=null) {
            for (Event e : events) {
                theText.append(e.getEventName() + " ");
                theText.append(e.getEventDate() + " ");
                theText.append(e.getEventTime() + "\n");
            }

        }
        else{
            return "";
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



}
