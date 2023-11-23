package edu.utsa.cs3443.rowdyguidefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.controller.CalendarController;
import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;
import edu.utsa.cs3443.rowdyguidefinal.model.Calendar;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.StaticEvent;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;
    CalendarController calendarController;
    String Date;
    ArrayList<Event> listOfEvents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        calendarController = new CalendarController(this);
        Calendar cal = new Calendar();
        listOfEvents = new ArrayList<>();
        listOfEvents.add(cal.makeCalendarEvent("Science Test","22-11-2023","8am"));
        listOfEvents.add(cal.makeCalendarEvent("Game night","22-11-2023","7pm"));
        listOfEvents.add(cal.makeCalendarEvent("Baseball Game","30-11-2023","2pm"));
        listOfEvents.add(cal.makeCalendarEvent("Fall Music Festival","12-11-2023","4pm"));

        cal.addListOfEventsToList(listOfEvents);
        cal.setEventList(listOfEvents);
        TextView calendarEvent = findViewById(R.id.eventListText);



        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calendar = (CalendarView)
                findViewById(R.id.calendar);
        date_view = (TextView)
                findViewById(R.id.date_view);

        // Add Listener in calendar
        // In this Listener have one method
// and in this method we will
// get the value of DAYS, MONTH, YEARS
        calendar
                .setOnDateChangeListener(
                        (view, year, month, dayOfMonth) -> {

                            // Store the value of date with
                            // format in String type Variable
                            // Add 1 in month because month
                            // index is start with 0
                            Date
                                    = dayOfMonth + "-"
                                    + (month + 1) + "-" + year;
                            System.out.println(Date);

                            //StaticEvent.eventListStatic = cal.getDateToEventList().get(Date);

                            String text = calendarController.getCalendarEvent(cal.getDateToEventList().get(Date));
                            calendarEvent.setText(text);


                            // set this date in TextView for Display
                            date_view.setText(Date);
                        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_calendar);
        NavigationController<CalendarActivity> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            navigationController.onNavigationItemSelected(item); //call here
            return true;
        });




    }
}