package ru.apishev.askhad.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.INTEGER
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "titles")
data class TitleEntity(
        @PrimaryKey
        @ColumnInfo(name = "content_id", typeAffinity = TEXT)
        val contentId: String,

        @ColumnInfo(typeAffinity = TEXT)
        val name: String,

        @ColumnInfo(typeAffinity = TEXT)
        val text: String,

        @ColumnInfo(name = "publication_date", typeAffinity = INTEGER)
        val publicationDate: Long,

        @ColumnInfo(name = "bank_info_type_id", typeAffinity = INTEGER)
        val bankInfoTypeId: Int
)
