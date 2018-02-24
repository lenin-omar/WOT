package com.lym.apps.workouttimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lym.apps.workouttimer.fragment.ExistingProfileFragment;
import com.lym.apps.workouttimer.fragment.NewProfileFragment;
import com.lym.apps.workouttimer.util.AppUtils;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //TODO: Use shared preferences for this
        if (true) { //There are profiles stored in shared preferences
            AppUtils.addFragmentToContent(this, ExistingProfileFragment.TAG, null);
        } else {    //User will create profile
            AppUtils.addFragmentToContent(this, NewProfileFragment.TAG, null);
        }
    }
}
