package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import edu.utsa.cs3443.rowdyguidefinal.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        getSupportActionBar().hide();

        Intent intent = getIntent();


        Intent intentSwitch = new Intent(LoadingActivity.this, MainActivity.class);
        startActivity(intentSwitch);

    }
}