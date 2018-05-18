package com.lym.apps.workouttimer;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.lym.apps.workouttimer.adapter.ProfileAdapter;
import com.lym.apps.workouttimer.cache.Preferences;
import com.lym.apps.workouttimer.model.User;

import java.util.List;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private Preferences preferences;
    private List<User> userList;
    private ProfileAdapter profileAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //Get saved profiles
        preferences = new Preferences(this);
        userList = preferences.getUsers();
        //Setup add profile button
        FloatingActionButton addProfileButton = findViewById(R.id.add_profile_button);
        addProfileButton.setOnClickListener(this);
        //Setup bottom navigation
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        setupProfileRecyclerView();
    }

    private void setupProfileRecyclerView() {
        RecyclerView profileRecyclerView = findViewById(R.id.profile_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        profileRecyclerView.setLayoutManager(linearLayoutManager);
        profileAdapter = new ProfileAdapter(this);
        profileAdapter.setUserList(userList);
        profileRecyclerView.setAdapter(profileAdapter);
        profileAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        User user = new User();
        user.setId(userList == null ? 1 : userList.size() + 1);
        user.setName("User " + user.getId());
        userList.add(user);
        profileAdapter.setUserList(userList);
        profileAdapter.notifyDataSetChanged();
        preferences.saveUsers(userList);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                //TODO: Show Profile screen. Change header to "Profile"
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                return true;
            case R.id.navigation_dashboard:
                //TODO: Show Routine/Interval screen. Change header to "Routine"
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                return true;
            case R.id.navigation_notifications:
                //TODO: Show Timer screen. Change header to "Timer"
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                return true;
        }
        return false;
    }
}
