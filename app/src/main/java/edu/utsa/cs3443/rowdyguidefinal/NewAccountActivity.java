package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import edu.utsa.cs3443.rowdyguidefinal.controller.NewAccountController;

public class NewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        NewAccountController newAccountController = new NewAccountController( this );
        Button button = findViewById(R.id.createButton);
        button.setOnClickListener( newAccountController );


    }
}