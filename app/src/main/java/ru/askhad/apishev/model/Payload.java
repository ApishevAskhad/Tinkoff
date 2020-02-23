package ru.askhad.apishev.model;



import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "contents")
public class Payload {
    @SerializedName("title")
    @Ignore
    private Title title;

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("creationDate")
    @Embedded(prefix = "creation_date")
    private Date creationDate;

    @SerializedName("lastModificationDate")
    @Embedded(prefix = "last_modification_date")
    private Date lastModificationDate;

    @SerializedName("content")
    @ColumnInfo(name = "content")
    private String content;

    @SerializedName("bankInfoTypeId")
    @ColumnInfo(name = "bank_info_type_id")
    private int bankInfoTypeId;

    @SerializedName("typeId")
    @ColumnInfo(name = "type_id")
    private String typeId;

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = getTitle().getRoomId();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBankInfoTypeId() {
        return bankInfoTypeId;
    }

    public void setBankInfoTypeId(int bankInfoTypeId) {
        this.bankInfoTypeId = bankInfoTypeId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
}
