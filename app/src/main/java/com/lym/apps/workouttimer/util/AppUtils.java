package com.lym.apps.workouttimer.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lym.apps.workouttimer.R;


public class AppUtils {

    public static Fragment addFragmentToContent(AppCompatActivity activity, String tag, Bundle extras) { //Used to add fragment to screen when app is launched
        FragmentManager fm = activity.getSupportFragmentManager();
        Fragment fragment = null;
        if (fm.findFragmentByTag(tag) == null) {
            fragment = Fragment.instantiate(activity, tag, extras);
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.fragmentHolder, fragment, tag);
            ft.commit();
        }
        return fragment;
    }

    public static Fragment replaceFragmentToContent(AppCompatActivity activity, String tag, Bundle extras) {
        FragmentManager fm = activity.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = Fragment.instantiate(activity, tag, extras);
        ft.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);
        ft.replace(R.id.fragmentHolder, fragment, tag);
        ft.addToBackStack(null);
        ft.commit();
        return fragment;
    }

}
