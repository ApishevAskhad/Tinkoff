package ru.askhad.apishev.model;

import com.google.gson.annotations.SerializedName;

public class Content {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("payload")
    private Payload mPayload;
    @SerializedName("trackingId")
    private String mTrackingId;

    public String getResultCode() {
        return mResultCode;
    }

    public void setResultCode(String resultCode) {
        mResultCode = resultCode;
    }

    public Payload getPayload() {
        return mPayload;
    }

    public void setPayload(Payload payload) {
        mPayload = payload;
    }

    public String getTrackingId() {
        return mTrackingId;
    }

    public void setTrackingId(String trackingId) {
        mTrackingId = trackingId;
    }
}
