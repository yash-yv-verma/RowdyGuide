package edu.utsa.cs3443.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class NewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_account);

        NewAccountController newAccountController = new NewAccountController( this );
        Button button = findViewById(R.id.createButton);
        button.setOnClickListener( newAccountController );


    }
}