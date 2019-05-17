package ru.askhad.apishev.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class News {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("trackingId")
    private String mTrackingId;
    @SerializedName("payload")
    private List<PayloadBean> mPayload;

    public String getResultCode() {
        return mResultCode;
    }

    public void setResultCode(String resultCode) {
        mResultCode = resultCode;
    }

    public String getTrackingId() {
        return mTrackingId;
    }

    public void setTrackingId(String trackingId) {
        mTrackingId = trackingId;
    }

    public List<PayloadBean> getPayload() {
        return mPayload;
    }

    public void setPayload(List<PayloadBean> payload) {
        mPayload = payload;
    }

    public static class PayloadBean {
        @SerializedName("id")
        private String mId;
        @SerializedName("name")
        private String mName;
        @SerializedName("text")
        private String mText;
        @SerializedName("publicationDate")
        private PublicationDateBean mPublicationDate;
        @SerializedName("bankInfoTypeId")
        private int mBankInfoTypeId;

        public String getId() {
            return mId;
        }

        public void setId(String id) {
            mId = id;
        }

        public String getName() {
            return mName;
        }

        public void setName(String name) {
            mName = name;
        }

        public String getText() {
            return mText;
        }

        public void setText(String text) {
            mText = text;
        }

        public PublicationDateBean getPublicationDate() {
            return mPublicationDate;
        }

        public void setPublicationDate(PublicationDateBean publicationDate) {
            mPublicationDate = publicationDate;
        }

        public int getBankInfoTypeId() {
            return mBankInfoTypeId;
        }

        public void setBankInfoTypeId(int bankInfoTypeId) {
            mBankInfoTypeId = bankInfoTypeId;
        }

        public static class PublicationDateBean {
            @SerializedName("milliseconds")
            private long mMilliseconds;

            public long getMilliseconds() {
                return mMilliseconds;
            }

            public void setMilliseconds(long milliseconds) {
                mMilliseconds = milliseconds;
            }
        }
    }
}
