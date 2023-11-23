package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.utsa.cs3443.rowdyguidefinal.controller.EventTabController;
import edu.utsa.cs3443.rowdyguidefinal.model.Event;

public class EventTabActivity extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<Event> events = new ArrayList<Event>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tab);

        // Create an instance of the MainController to handle button clicks.
        EventTabController controller = new EventTabController(this);

        // Find and configure the "button1" in the layout.
        //ImageButton button1 = findViewById(R.id.imageButton1);
        //button1.setOnClickListener(controller);// Assign the MainController as the click listener.

        // Find and configure the "button2" in the layout.
        //ImageButton button2 = findViewById(R.id.imageButton2);
        //button2.setOnClickListener(controller);// Assign the MainController as the click listener.

        ///THIS IS FOR THE RECYCLER VIEWWW>>>>>>>>>>>
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        events = EventTabController.getEvents();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, events, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_events);
        NavigationController<EventTabActivity> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            navigationController.onNavigationItemSelected(item); //call here
            return true;
        });
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(EventTabActivity.this, EventTabActivity2.class);
        intent.putExtra("NAME", events.get(position).getEventName());
        intent.putExtra("DATE", events.get(position).getEventDate());
        intent.putExtra("TIME", events.get(position).getEventTime());
        intent.putExtra("LOCATION", events.get(position).getEventLocation());
        intent.putExtra("DESCRIPTION", events.get(position).getEventDescription());
        intent.putExtra("TYPE", events.get(position).getEventType());
        intent.putExtra("PRICE", events.get(position).getEventTicketPrice());

        startActivity(intent);

    }
}