package ru.askhad.apishev.model

import com.google.gson.annotations.SerializedName

data class Content(
        @SerializedName("resultCode")
        val mResultCode: String,
        @SerializedName("payload")
        val mPayload: Payload,
        @SerializedName("trackingId")
        val mTrackingId: String
)