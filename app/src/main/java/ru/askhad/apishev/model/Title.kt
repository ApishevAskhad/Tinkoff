package ru.askhad.apishev.model


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "titles")
class Title {
    @PrimaryKey
    @ColumnInfo(name = "id")
    var roomId: Int = 0

    @SerializedName("id")
    var jsonId: String? = null
        set(value) {
            field = value
            roomId = Integer.valueOf(this.jsonId!!)
        }

    @SerializedName("name")
    @ColumnInfo(name = "name")
    var name: String? = null

    @SerializedName("text")
    @ColumnInfo(name = "text")
    var text: String? = null


    @SerializedName("publicationDate")
    @Embedded
    var publicationDate: Date? = null

    @SerializedName("bankInfoTypeId")
    @ColumnInfo(name = "bank_info_type_id")
    var bankInfoTypeId: Int = 0
}
