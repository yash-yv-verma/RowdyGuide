package edu.utsa.cs3443.rowdyguidefinal;

import edu.utsa.cs3443.rowdyguidefinal.controller.MainController;
import edu.utsa.cs3443.rowdyguidefinal.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if ( intent.getBooleanExtra( "logout", false ) ){
            String toastText = "Successfully logged out.";
            Toast.makeText( this, toastText, Toast.LENGTH_LONG ).show();
        }
        if ( intent.getBooleanExtra( "newAccountCreated", false ) ){
            String toastText = "Successfully created account. Please log in.";
            Toast.makeText( this, toastText, Toast.LENGTH_LONG ).show();
        }

        MainController mainController = new MainController(this);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener( mainController );


        Button createAccountButton = findViewById(R.id.createAccountButton);
        createAccountButton.setOnClickListener( mainController );

    }
}
