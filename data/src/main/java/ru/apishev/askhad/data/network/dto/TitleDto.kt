package ru.apishev.askhad.data.network.dto

import com.google.gson.annotations.SerializedName

data class TitleDto(

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("id")
        val id: String? = null,

        @field:SerializedName("text")
        val text: String? = null,

        @field:SerializedName("publicationDate")
        val publicationDate: PublicationDateDto? = null,

        @field:SerializedName("bankInfoTypeId")
        val bankInfoTypeId: Int? = null
)