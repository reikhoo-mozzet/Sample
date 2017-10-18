package com.mozzet.sample.model.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("live_counts")
    private List<String> liveCounts;
    @SerializedName("sections")
    private List<Section> sections;
    @SerializedName("remain_time")
    private int remainTime;
    @SerializedName("is_live_on")
    private boolean isLiveOn;

    public List<String> getLiveCounts() {
        return liveCounts;
    }

    public List<Section> getSections() {
        return sections;
    }

    public int getRemainTime() {
        return remainTime;
    }

    public boolean isLiveOn() {
        return isLiveOn;
    }
}