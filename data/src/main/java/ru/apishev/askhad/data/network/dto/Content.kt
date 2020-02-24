package ru.apishev.askhad.data.network.dto

import com.google.gson.annotations.SerializedName

data class Content(

	@field:SerializedName("lastModificationDate")
	val lastModificationDate: LastModificationDate? = null,

	@field:SerializedName("typeId")
	val typeId: String? = null,

	@field:SerializedName("title")
	val title: Title? = null,

	@field:SerializedName("creationDate")
	val creationDate: CreationDate? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("bankInfoTypeId")
	val bankInfoTypeId: Int? = null
)