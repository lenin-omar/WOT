package com.lym.apps.workouttimer.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Map;


class Routine implements Parcelable {

    public static final Creator<Routine> CREATOR = new Creator<Routine>() {
        @Override
        public Routine createFromParcel(Parcel in) {
            return new Routine(in);
        }

        @Override
        public Routine[] newArray(int size) {
            return new Routine[size];
        }
    };
    private int id;
    private String name;
    private double totalTime;
    private int color;
    private Map<String, ArrayList<Interval>> intervalList;

    private Routine(Parcel in) {
        id = in.readInt();
        name = in.readString();
        totalTime = in.readDouble();
        color = in.readInt();
    }

    public Routine() {}

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

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Map<String, ArrayList<Interval>> getIntervalList() {
        return intervalList;
    }

    public void setIntervalList(Map<String, ArrayList<Interval>> intervalList) {
        this.intervalList = intervalList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(totalTime);
        dest.writeInt(color);
    }
}
