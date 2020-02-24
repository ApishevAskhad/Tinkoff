package ru.apishev.askhad.data.network.dto

import com.google.gson.annotations.SerializedName

data class TinkoffResponse<T>(
        @field:SerializedName("resultCode")
        val resultCode: String? = null,

        @field:SerializedName("payload")
        val payload: T? = null,

        @field:SerializedName("trackingId")
        val trackingId: String? = null
)
