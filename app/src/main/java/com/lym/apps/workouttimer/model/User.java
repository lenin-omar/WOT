package com.lym.apps.workouttimer.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Map;


public class User implements Parcelable {

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private int id;
    private String name;
    private String userImage;
    private int color;
    private Map<String, ArrayList<Routine>> routineList;

    private User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        userImage = in.readString();
        color = in.readInt();
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Map<String, ArrayList<Routine>> getRoutineList() {
        return routineList;
    }

    public void setRoutineList(Map<String, ArrayList<Routine>> routineList) {
        this.routineList = routineList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(userImage);
        dest.writeInt(color);
    }
}
