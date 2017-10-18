package com.mozzet.sample.model.network;

import com.google.gson.annotations.SerializedName;

public class Card {
    @SerializedName("idx")
    private String idx;
    @SerializedName("last_access_minute")
    private int lastAccessMinute;
    @SerializedName("age_str")
    private String ageStr;
    @SerializedName("location_str")
    private String locationStr;
    @SerializedName("photo_url")
    private String photoUrl;
    @SerializedName("job")
    private String job;
    @SerializedName("matching_status")
    private int matchingStatus;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("modifier")
    private String modifier;

    public String getIdx() {
        return idx;
    }

    public int getLastAccessMinute() {
        return lastAccessMinute;
    }

    public String getAgeStr() {
        return ageStr;
    }

    public String getLocationStr() {
        return locationStr;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getJob() {
        return job;
    }

    public int getMatchingStatus() {
        return matchingStatus;
    }

    public String getNickname() {
        return nickname;
    }

    public String getModifier() {
        return modifier;
    }
}