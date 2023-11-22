package edu.utsa.cs3443.rowdyguidefinal.controller;

import edu.utsa.cs3443.rowdyguidefinal.NewAccountActivity;
import edu.utsa.cs3443.rowdyguidefinal.MainActivity;
import edu.utsa.cs3443.rowdyguidefinal.ProfileActivity;
import edu.utsa.cs3443.rowdyguidefinal.R;
import edu.utsa.cs3443.rowdyguidefinal.model.User;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainController implements View.OnClickListener {
    private MainActivity mainActivity;
    public MainController(MainActivity activity) {
        mainActivity = activity;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    private User validate(String username, String password) throws IOException {
        String filename = "userLoginInformation.csv";
        File readFrom = new File(mainActivity.getApplicationContext().getFilesDir(), filename);
        try {
            byte[] content = new byte[(int) readFrom.length()];

            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(content);

            ArrayList<String> userInfo= new ArrayList<>(Arrays.asList(new String(content).split("\n")));

            for (String userLine : userInfo) {
                String[] userTokens = userLine.split(",");
                if (userTokens[0].equals(username) & userTokens[1].equals(password)) {
                    User user = new User( username, password, userTokens[2], userTokens[3], userTokens[4], userTokens[5]);
                    return user;
                }
            }
            return new User();
        } catch (FileNotFoundException e){
            readFrom.createNewFile();
            return new User();
        }
    }

    private void onClickLogIn(View v){
        EditText usernameEditText = mainActivity.findViewById(R.id.username);
        String username = usernameEditText.getText().toString();
        if ( username.trim().equals("") ){
            Toast.makeText(this.mainActivity, "Username required.", Toast.LENGTH_LONG).show();
            return;
        }

        EditText passwordEditText = mainActivity.findViewById(R.id.password);
        String password = passwordEditText.getText().toString();
        if ( password.trim().equals("") ){
            Toast.makeText(this.mainActivity, "Password required.", Toast.LENGTH_LONG).show();
            return;
        }


        try {
            User user = validate(username,password);
            if ( !user.getUsername().equals("") ) {
                Intent intent = new Intent(mainActivity, ProfileActivity.class);
                usernameEditText.setText("");
                passwordEditText.setText("");
                intent.putExtra("user", user);
                v.getContext().startActivity(intent);
            } else {
                String toastText = "Invalid username or password.";
                Toast.makeText(this.mainActivity, toastText, Toast.LENGTH_LONG).show();
                passwordEditText.setText("");
            }
        } catch (IOException e) {
            Toast.makeText(this.mainActivity, "User file cannot be accessed.", Toast.LENGTH_LONG).show();
        }

    }

    private void onClickCreateAccount(View v){
        Intent intent = new Intent(mainActivity, NewAccountActivity.class);
        v.getContext().startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        int buttonId = view.getId();

        if ( buttonId == R.id.loginButton ) {
            onClickLogIn(view);
        } else if ( buttonId == R.id.createAccountButton ){
            onClickCreateAccount(view);
        }
    }
}
