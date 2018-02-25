package com.lym.apps.workouttimer.cache;


import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lym.apps.workouttimer.R;
import com.lym.apps.workouttimer.model.User;

import java.util.ArrayList;
import java.util.List;

public class Preferences {

    private static final String USER_LIST_KEY = "UserListKey";
    private final SharedPreferences sharedPreferences;
    private final Gson gson;

    public Preferences(Context context) {
        this.sharedPreferences = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        this.gson = new Gson();
    }

    public void saveUsers(List<User> users) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jsonUser = gson.toJson(users);
        editor.putString(USER_LIST_KEY, jsonUser);
        editor.apply();
    }

    public List<User> getUsers() {
        List<User> users;
        String json = sharedPreferences.getString(USER_LIST_KEY, "");
        users = gson.fromJson(json, new TypeToken<List<User>>() {}.getType());
        return (users == null ? new ArrayList<User>() : users);
    }

}
