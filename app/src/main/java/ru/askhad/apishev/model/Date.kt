package ru.askhad.apishev.model


import androidx.room.ColumnInfo

import com.google.gson.annotations.SerializedName

class Date {
    @SerializedName("milliseconds")
    @ColumnInfo(name = "milliseconds")
    var milliseconds: Long = 0
}
