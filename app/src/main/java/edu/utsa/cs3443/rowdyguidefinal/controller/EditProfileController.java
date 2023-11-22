package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import edu.utsa.cs3443.rowdyguidefinal.EditProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;

public class EditProfileController implements View.OnClickListener {



    private EditProfileActivity editProfileActivity;

    public EditProfileController(EditProfileActivity editProfileActivity) {
        this.editProfileActivity = editProfileActivity;
    }

    public EditProfileActivity getEditProfileActivity() {
        return editProfileActivity;
    }

    public void setEditProfileActivity(EditProfileActivity editProfileActivity) {
        this.editProfileActivity = editProfileActivity;
    }

    public void editProfileInformation(String username, String name, String classification, String email, String contact){
        String filename = "userLoginInformation.csv";
        File writeTo = new File(editProfileActivity.getApplicationContext().getFilesDir(), filename);

        try {
            // Read existing content
            BufferedReader bufferedReader = new BufferedReader(new FileReader(writeTo));
            StringBuilder stringBuilder = new StringBuilder();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                // Split the CSV line into fields
                String[] fields = line.split(",");

                if (fields.length > 0 && fields[0].equals(username)) {
                    if ( !name.equals("null")){ fields[2] = name; }     // Change name
                    if ( !name.equals("null")){ fields[3] = classification; } // Change classification
                    if ( !name.equals("null")){ fields[4] = email; }     // Change email
                    if ( !name.equals("null")){ fields[5] = contact; } // Change contact
                }

                // Reconstruct the modified line
                String modifiedLine = String.join(",", fields);
                stringBuilder.append(modifiedLine).append("\n");
            }

            bufferedReader.close();

            // Write the modified content back to the file
            FileOutputStream writer = new FileOutputStream(writeTo);
            writer.write(stringBuilder.toString().getBytes());
            writer.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(this.editProfileActivity, "Unable to edit profile.", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(this.editProfileActivity, "Unable to edit profile", Toast.LENGTH_LONG).show();
        }
    }

    private boolean validateEntry( int id , View view){
        String field = getText(id,view);
        if ( field.trim().equals("") ){
            return false;
        }
        return true;
    }

    public char getMode(View view){
        Button button = view.findViewById(R.id.editProfileButton);
        CharSequence text = button.getText();
        if ( text.equals("change") ){
            return 'e'; //e for edit
        } else{
            return 'c';//c for create
        }
    }

    public String getText (int id, View view){
        Button button = view.findViewById(R.id.editProfileButton);
        EditText fieldEditText = editProfileActivity.findViewById(id);
        return fieldEditText.getText().toString();
    }

    @Override
    public void onClick(View view) {


        char editMode = getMode(view);

        //all fields are required for creating an account
        if ( editMode == 'c') {
            if (!validateEntry(R.id.Name, view)) {
                Toast.makeText(this.editProfileActivity, "Name required", Toast.LENGTH_LONG).show();
                return;
            }
            if (!validateEntry(R.id.Classification, view)) {
                Toast.makeText(this.editProfileActivity, "Classification required", Toast.LENGTH_LONG).show();
                return;
            }
            if (!validateEntry(R.id.Email, view)) {
                Toast.makeText(this.editProfileActivity, "Email required", Toast.LENGTH_LONG).show();
                return;
            }
            if (!validateEntry(R.id.Contact, view)) {
                Toast.makeText(this.editProfileActivity, "Phone number required", Toast.LENGTH_LONG).show();
                return;
            }
        }

        String name = getText(R.id.Name, view);
        if ( name.trim().equals("") ){
            name = "null";
        }

        String classification = getText(R.id.Classification, view);
        if ( classification.trim().equals("") ){
            classification = "null";
        }

        String email = getText(R.id.Email, view);
        if ( email.trim().equals("") ){
            email = "null";
        }

        String contact = getText(R.id.Contact, view);
        if ( contact.trim().equals("") ){
            contact = "null";
        }


        Intent intent = editProfileActivity.getIntent();
        String username = intent.getStringExtra("username");
        editProfileInformation(username, name, classification, email, contact);

        if ( editMode == 'e') {
            Intent nextActivity = new Intent(editProfileActivity, ProfileActivity.class);
            Toast.makeText(this.editProfileActivity, "Edit was successful", Toast.LENGTH_LONG).show();
            view.getContext().startActivity(nextActivity);
        } else{
            Intent nextActivity = new Intent(editProfileActivity, MainActivity.class);
            intent.putExtra("newAccountCreated", true);
            view.getContext().startActivity(nextActivity);
        }

    }
}
