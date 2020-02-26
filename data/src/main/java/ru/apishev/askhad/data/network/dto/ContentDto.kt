package ru.apishev.askhad.data.network.dto

import com.google.gson.annotations.SerializedName

data class ContentDto(

		@field:SerializedName("lastModificationDate")
        val lastModificationDate: LastModificationDateDto? = null,

		@field:SerializedName("typeId")
        val typeId: String? = null,

		@field:SerializedName("title")
        val title: TitleDto? = null,

		@field:SerializedName("creationDate")
        val creationDate: CreationDateDto? = null,

		@field:SerializedName("content")
        val content: String? = null,

		@field:SerializedName("bankInfoTypeId")
        val bankInfoTypeId: Int? = null
)