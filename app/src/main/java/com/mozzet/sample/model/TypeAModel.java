package com.mozzet.sample.model;

import com.mozzet.sample.SampleAdapter;

public class TypeAModel extends BaseModel {

    private String userName;
    private String userImageUrl;

    public TypeAModel(String userName, String userImageUrl) {
        this.userName = userName;
        this.userImageUrl = userImageUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    @Override
    public int getType() {
        return SampleAdapter.TYPE_A;
    }

}