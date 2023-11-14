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
import edu.utsa.cs3443.rowdyguidefinal.model.Calendar;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;
import edu.utsa.cs3443.rowdyguidefinal.model.StaticEvent;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendar;
    TextView date_view;
    CalendarController calendarController;
    String Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        calendarController = new CalendarController(this);
        Calendar cal = new Calendar();
        Event e = cal.makeCalendarEvent("name","date","time");
        StaticEvent.event = e;
        cal.addEventToList(cal.makeCalendarEvent("test","22-11-2023","8am"));
        cal.addEventToList(e);
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
        calendar
                .setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    @NonNull CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth) {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;
                                System.out.println(Date);

                                StaticEvent.eventListStatic = (calendarController.getEventsForDay(Date, cal));
                                String text = calendarController.getCalendarEvent(StaticEvent.eventListStatic);
                                calendarEvent.setText(text);


                                // set this date in TextView for Display
                                date_view.setText(Date);
                            }
                        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_calendar);



        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            calendarController.onNavigationItemSelected(item); //call here
            return true;
        });




    }
}