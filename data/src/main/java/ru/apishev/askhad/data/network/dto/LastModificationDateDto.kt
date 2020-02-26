package ru.apishev.askhad.data.network.dto

import com.google.gson.annotations.SerializedName

data class LastModificationDateDto(

	@field:SerializedName("milliseconds")
	val milliseconds: Long? = null
)