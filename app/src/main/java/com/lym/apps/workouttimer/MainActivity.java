package com.lym.apps.workouttimer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //TODO: Show Profile screen. Change header to "Profile"
                    mTextMessage.setText(R.string.title_profile);
                    return true;
                case R.id.navigation_dashboard:
                    //TODO: Show Routine/Interval screen. Change header to "Routine"
                    mTextMessage.setText(R.string.title_routine);
                    return true;
                case R.id.navigation_notifications:
                    //TODO: Show Timer screen. Change header to "Timer"
                    mTextMessage.setText(R.string.title_timer);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
