package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.utsa.cs3443.rowdyguidefinal.controller.NavigationController;


public class EventTabActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_tab2);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.navigation_events);
        NavigationController<EventTabActivity2> navigationController = new NavigationController<>(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> { // using lamda
            navigationController.onNavigationItemSelected(item); //call here
            return true;
        });

        ImageButton button = findViewById(R.id.imageButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = new ScaleAnimation(1.0f, 0.8f, 1.0f, 0.8f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(200);
                animation.setInterpolator(new OvershootInterpolator());
                v.startAnimation(animation);
            }
        });

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
        eDate.setText(date);
        eTime.setText(time);
        ePrice.setText("Price: " + price);
        eType.setText("Event Type: " + type);
        eLocation.setText(location);

        //eName.setMaxLines(3);
        //eName.setEllipsize(TextUtils.TruncateAt.END);

    }
}