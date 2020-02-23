package ru.askhad.apishev.model

import com.google.gson.annotations.SerializedName

class Titles {
    @SerializedName("resultCode")
    var resultCode: String? = null
    @SerializedName("payload")
    var titles: List<Title>? = null
    @SerializedName("trackingId")
    var trackingId: String? = null
}
