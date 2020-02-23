package ru.askhad.apishev.model


import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "contents")
class Payload {
    @SerializedName("title")
    @Ignore
    var title: Title? = null

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0
        set(id) {
            field = title!!.roomId
        }

    @SerializedName("creationDate")
    @Embedded(prefix = "creation_date")
    var creationDate: Date? = null

    @SerializedName("lastModificationDate")
    @Embedded(prefix = "last_modification_date")
    var lastModificationDate: Date? = null

    @SerializedName("content")
    @ColumnInfo(name = "content")
    var content: String? = null

    @SerializedName("bankInfoTypeId")
    @ColumnInfo(name = "bank_info_type_id")
    var bankInfoTypeId: Int = 0

    @SerializedName("typeId")
    @ColumnInfo(name = "type_id")
    var typeId: String? = null
}
