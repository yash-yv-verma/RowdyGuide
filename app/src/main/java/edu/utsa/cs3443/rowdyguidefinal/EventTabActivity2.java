package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class EventTabActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tab2);

        String name = getIntent().getStringExtra("NAME");
        String date = getIntent().getStringExtra("DATE");
        String time = getIntent().getStringExtra("TIME");
        String location = getIntent().getStringExtra("LOCATION");
        String type = getIntent().getStringExtra("TYPE");
        String description = getIntent().getStringExtra("DESCRIPTION");
        String price = getIntent().getStringExtra("PRICE");

        TextView eName = findViewById(R.id.name);
        TextView eDate = findViewById(R.id.date);
        TextView eDescription = findViewById(R.id.description);
        TextView ePrice = findViewById(R.id.price);
        TextView eTime = findViewById(R.id.time);
        TextView eType = findViewById(R.id.type);
        TextView eLocation = findViewById(R.id.location);

        eName.setText(name);
        eDescription.setText(description);
        eDate.setText(date + " @ ");
        eTime.setText(time);
        ePrice.setText("Price: " + price);
        eType.setText("Event Type: " + type);
        eLocation.setText(location);


    }
}