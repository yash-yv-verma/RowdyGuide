/**
 * The CalendarActivity class represents the activity responsible for displaying a calendar
 * and managing calendar events in the Rowdy Guide application.
 *
 * This class extends AppCompatActivity and includes functionality for handling date selection,
 * displaying events, and navigating through the bottom navigation menu.
 *
 *
 * @author KingKong
 */
package edu.utsa.cs3443.rowdyguidefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Date;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.controller.CalendarController;
import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;
import edu.utsa.cs3443.rowdyguidefinal.model.Calendar;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.StaticEvent;

/**
 * The CalendarActivity class is responsible for managing the calendar functionality
 * in the Rowdy Guide application. It handles date selection, event display, and navigation
 * through the bottom navigation menu.
 */
public class CalendarActivity extends AppCompatActivity {

    // Calendar components
    CalendarView calendar;
    TextView date_view;

    // Controller for managing calendar events
    CalendarController calendarController;

    // Date in string format
    String Date;

    // List to store calendar events
    ArrayList<Event> listOfEvents;

    /**
     * Called when the activity is starting. Hides the action bar, initializes the activity layout,
     * sets up the calendarController, and adds demo events to the list of events.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state.
     * @return void
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        // Initialize calendarController
        calendarController = new CalendarController(this);

        // Initialize Calendar model
        Calendar cal = new Calendar();

        // Demo: Add events for demonstration purposes
        listOfEvents = new ArrayList<>();
        listOfEvents.add(cal.makeCalendarEvent("Science Test", "22-11-2023", "8am"));
        listOfEvents.add(cal.makeCalendarEvent("Game night", "22-11-2023", "7pm"));
        listOfEvents.add(cal.makeCalendarEvent("Baseball Game", "30-11-2023", "2pm"));
        listOfEvents.add(cal.makeCalendarEvent("Fall Music Festival", "12-11-2023", "4pm"));

        // Retrieve event details from Intent and add to the list of events
        String name = getIntent().getStringExtra("NAME");
        String date = getIntent().getStringExtra("DATE");
        String time = getIntent().getStringExtra("TIME");
        String outputDateStr = "";

        if (name != null && date != null && time != null) {
            // Reformat date and add to the list of events
            SimpleDateFormat outputFormat = new SimpleDateFormat("d-MM-yyyy");
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MMM-yy");
            try {
                Date inputDate = inputFormat.parse(date);
                outputDateStr = outputFormat.format(inputDate);
                listOfEvents.add(cal.makeCalendarEvent(name, outputDateStr, time));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        // Add the list of events to the Calendar model
        cal.addListOfEventsToList(listOfEvents);
        cal.setEventList(listOfEvents);

        // Set up TextView for displaying calendar events
        TextView calendarEvent = findViewById(R.id.eventListText);

        // Set up CalendarView and TextView
        calendar = findViewById(R.id.calendar);
        date_view = findViewById(R.id.date_view);

        // Add a listener to the CalendarView for date selection
        calendar.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            Date = dayOfMonth + "-" + (month + 1) + "-" + year;
            System.out.println(Date);

            // Display calendar events for the selected date
            String text = calendarController.getCalendarEvent(cal.getDateToEventList().get(Date));
            calendarEvent.setText(text);

            // Set the selected date in the TextView
            date_view.setText(Date);
        });

        // Set up bottom navigation menu
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setSelectedItemId(R.id.navigation_calendar);

        // Set up navigation controller for handling bottom navigation events
        NavigationController<CalendarActivity> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            navigationController.onNavigationItemSelected(item);
            return true;
        });
    }
}
