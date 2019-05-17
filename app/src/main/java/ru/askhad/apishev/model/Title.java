package ru.askhad.apishev.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "titles")
public class Title {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int roomId;

    @SerializedName("id")
    private String jsonId;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String mName;

    @SerializedName("text")
    @ColumnInfo(name = "text")
    private String mText;


    @SerializedName("publicationDate")
    @Embedded
    private Date mPublicationDate;

    @SerializedName("bankInfoTypeId")
    @ColumnInfo(name = "bank_info_type_id")
    private int mBankInfoTypeId;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int value) {
        this.roomId = value;
    }

    public String getJsonId() {
        return jsonId;
    }

    public void setJsonId(String value) {
        this.jsonId = value;
        setRoomId(Integer.valueOf(jsonId));
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public Date getPublicationDate() {
        return mPublicationDate;
    }

    public void setPublicationDate(Date mPublicationDate) {
        this.mPublicationDate = mPublicationDate;
    }

    public int getBankInfoTypeId() {
        return mBankInfoTypeId;
    }

    public void setBankInfoTypeId(int mBankInfoTypeId) {
        this.mBankInfoTypeId = mBankInfoTypeId;
    }
}
