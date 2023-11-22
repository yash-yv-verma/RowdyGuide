package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import edu.utsa.cs3443.rowdyguidefinal.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        getSupportActionBar().hide();

        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);

                // Close the loading activity
                finish();
            }
        }, 2000);



    }
}