package ru.apishev.askhad.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.INTEGER
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = "contents",
        foreignKeys = [ForeignKey(
                entity = TitleEntity::class,
                parentColumns = ["id"],
                childColumns = ["title_id"],
                onDelete = CASCADE)])
data class ContentEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "title_id")
        val titleId: Long,

        @ColumnInfo(name = "creation_date", typeAffinity = INTEGER)
        val creationDate: Long,

        @ColumnInfo(name = "last_modification_date", typeAffinity = INTEGER)
        val lastModificationDate: Long,

        @ColumnInfo(typeAffinity = TEXT)
        val content: String,

        @ColumnInfo(name = "bank_info_type_id", typeAffinity = INTEGER)
        val bankInfoTypeId: Int,

        @ColumnInfo(name = "type_id", typeAffinity = TEXT)
        val typeId: String
)