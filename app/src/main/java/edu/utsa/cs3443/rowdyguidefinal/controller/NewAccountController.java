package edu.utsa.cs3443.rowdyguidefinal.controller;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import edu.utsa.cs3443.rowdyguidefinal.NewAccountActivity;

public class NewAccountController implements View.OnClickListener {

    private NewAccountActivity newAccountActivity;

    public NewAccountController(NewAccountActivity newAccountActivity) {
        this.newAccountActivity = newAccountActivity;
    }

    public NewAccountActivity getNewAccountActivity() {
        return newAccountActivity;
    }

    public void setNewAccountActivity(NewAccountActivity newAccountActivity) {
        this.newAccountActivity = newAccountActivity;
    }

    private boolean validNewUsername( String username ) throws IOException {
        String filename = "userLoginInformation.csv";
        File readFrom = new File(newAccountActivity.getApplicationContext().getFilesDir(),filename);
        try {
            byte[] content = new byte[(int) readFrom.length()];

            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);

            ArrayList<String> userInfo = new ArrayList<>(Arrays.asList(new String(content).split("\n")));

            for (String user : userInfo) {
                String[] userTokens = user.split(",");
                if (userTokens[0].equals(username)) {
                    return false;
                }
            }

            return true;
        } catch ( FileNotFoundException e){
            readFrom.createNewFile();
            return true;
        }
    }

    void createAccount(String username, String password) throws IOException {
        String filename = "userLoginInformation.csv";
        File writeTo = new File(newAccountActivity.getApplicationContext().getFilesDir(), filename);
        try{
            FileOutputStream writer = new FileOutputStream( writeTo );
            String loginInfo = username + "," + password + "\n";
            writer.write( loginInfo.getBytes() );
            writer.close();
        } catch(FileNotFoundException e){
            writeTo.createNewFile();
        }


    }

    @Override
    public void onClick(View v) {
        EditText usernameEditText = newAccountActivity.findViewById(R.id.username);
        String username = usernameEditText.getText().toString();
        if ( username.trim().equals("") ){
            Toast.makeText(this.newAccountActivity, "Username required.", Toast.LENGTH_LONG).show();
            return;
        }

        EditText passwordEditText = newAccountActivity.findViewById(R.id.password);
        String password = passwordEditText.getText().toString();
        if ( password.trim().equals("") ){
            Toast.makeText(this.newAccountActivity, "Password required.", Toast.LENGTH_LONG).show();
            return;
        }

        try {
            if (validNewUsername(username)) {
                createAccount(username, password);
                Intent intent = new Intent(newAccountActivity, MainActivity.class);
                intent.putExtra("newAccountCreated", true);
                v.getContext().startActivity(intent);
            } else {
                Toast.makeText(this.newAccountActivity, "Username Taken.", Toast.LENGTH_LONG).show();
            }
        }catch( IOException e ){
            Toast.makeText(this.newAccountActivity, "Unable to create account at this time.", Toast.LENGTH_LONG).show();
        }
    }
}

