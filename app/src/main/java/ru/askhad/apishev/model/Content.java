package ru.askhad.apishev.model;

import com.google.gson.annotations.SerializedName;


public class Content {
    @SerializedName("resultCode")
    private String mResultCode;
    @SerializedName("payload")
    private PayloadBean mPayload;
    @SerializedName("trackingId")
    private String mTrackingId;

    public String getResultCode() {
        return mResultCode;
    }

    public void setResultCode(String resultCode) {
        mResultCode = resultCode;
    }

    public PayloadBean getPayload() {
        return mPayload;
    }

    public void setPayload(PayloadBean payload) {
        mPayload = payload;
    }

    public String getTrackingId() {
        return mTrackingId;
    }

    public void setTrackingId(String trackingId) {
        mTrackingId = trackingId;
    }

    public static class PayloadBean {
        @SerializedName("title")
        private TitleBean mTitle;
        @SerializedName("creationDate")
        private CreationDateBean mCreationDate;
        @SerializedName("lastModificationDate")
        private LastModificationDateBean mLastModificationDate;
        @SerializedName("content")
        private String mContent;
        @SerializedName("bankInfoTypeId")
        private int mBankInfoTypeId;
        @SerializedName("typeId")
        private String mTypeId;

        public TitleBean getTitle() {
            return mTitle;
        }

        public void setTitle(TitleBean title) {
            mTitle = title;
        }

        public CreationDateBean getCreationDate() {
            return mCreationDate;
        }

        public void setCreationDate(CreationDateBean creationDate) {
            mCreationDate = creationDate;
        }

        public LastModificationDateBean getLastModificationDate() {
            return mLastModificationDate;
        }

        public void setLastModificationDate(LastModificationDateBean lastModificationDate) {
            mLastModificationDate = lastModificationDate;
        }

        public String getContent() {
            return mContent;
        }

        public void setContent(String content) {
            mContent = content;
        }

        public int getBankInfoTypeId() {
            return mBankInfoTypeId;
        }

        public void setBankInfoTypeId(int bankInfoTypeId) {
            mBankInfoTypeId = bankInfoTypeId;
        }

        public String getTypeId() {
            return mTypeId;
        }

        public void setTypeId(String typeId) {
            mTypeId = typeId;
        }

        public static class TitleBean {
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

        public static class CreationDateBean {
            @SerializedName("milliseconds")
            private long mMilliseconds;

            public long getMilliseconds() {
                return mMilliseconds;
            }

            public void setMilliseconds(long milliseconds) {
                mMilliseconds = milliseconds;
            }
        }

        public static class LastModificationDateBean {
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
