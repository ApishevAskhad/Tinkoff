package ru.askhad.apishev.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Titles {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("payload")
    private List<Title> mTitles;
    @SerializedName("trackingId")
    private String mTrackingId;

    public String getResultCode() {
        return mResultCode;
    }

    public void setResultCode(String resultCode) {
        mResultCode = resultCode;
    }

    public String getTrackingId() {
        return mTrackingId;
    }

    public void setTrackingId(String trackingId) {
        mTrackingId = trackingId;
    }

    public List<Title> getTitles() {
        return mTitles;
    }

    public void setTitles(List<Title> mTitle) {
        this.mTitles = mTitle;
    }
}
