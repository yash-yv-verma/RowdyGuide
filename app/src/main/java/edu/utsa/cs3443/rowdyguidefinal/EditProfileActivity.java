package edu.utsa.cs3443.rowdyguidefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import edu.utsa.cs3443.rowdyguidefinal.controller.EditProfileController;

public class EditProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        getSupportActionBar().hide();

        Button editProfileButton = findViewById(R.id.editProfileButton);
        Intent intent = getIntent();
        if ( intent.getBooleanExtra("saveChanges", false) ){
            editProfileButton.setText("Save changes");
        }

        EditProfileController editProfileController = new EditProfileController( this );
        editProfileButton.setOnClickListener( editProfileController );

    }
}