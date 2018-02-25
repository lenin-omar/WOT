package com.lym.apps.workouttimer;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.lym.apps.workouttimer.cache.Preferences;
import com.lym.apps.workouttimer.model.User;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    TextView userLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        userLabel = findViewById(R.id.user_label);
        Preferences preferences = new Preferences(this);
        List<User> userList = preferences.getUsers();
        if (userList.isEmpty()) { //There are profiles stored in shared preferences
            userLabel.setText(R.string.create_user);
            userList.add(new User());
            preferences.saveUsers(userList);
        } else {    //User will create profile
            userLabel.setText(R.string.choose_user);
            preferences.saveUsers(new ArrayList<User>());
        }
    }

}
