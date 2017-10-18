package com.mozzet.sample.model.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Section {
    @SerializedName("cards")
    private List<Card> cards;
    @SerializedName("created_time")
    private String createdTime;

    public List<Card> getCards() {
        return cards;
    }

    public String getCreatedTime() {
        return createdTime;
    }
}