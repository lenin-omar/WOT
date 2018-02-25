package com.lym.apps.workouttimer.model;


import android.os.Parcel;
import android.os.Parcelable;


class Interval implements Parcelable {

    public static final Creator<Interval> CREATOR = new Creator<Interval>() {
        @Override
        public Interval createFromParcel(Parcel in) {
            return new Interval(in);
        }

        @Override
        public Interval[] newArray(int size) {
            return new Interval[size];
        }
    };
    private int id;
    private String name;
    private double time;
    private int color;

    private Interval(Parcel in) {
        id = in.readInt();
        name = in.readString();
        time = in.readDouble();
        color = in.readInt();
    }

    public Interval() {}

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

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeDouble(time);
        dest.writeInt(color);
    }
}
