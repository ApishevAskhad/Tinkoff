package ru.askhad.apishev.model;


import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class Date {
    @SerializedName("milliseconds")
    @ColumnInfo(name = "milliseconds")
    private long mMilliseconds;

    public long getMilliseconds() {
        return mMilliseconds;
    }

    public void setMilliseconds(long mMilliseconds) {
        this.mMilliseconds = mMilliseconds;
    }
}
