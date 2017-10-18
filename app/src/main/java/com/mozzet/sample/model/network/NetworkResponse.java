package com.mozzet.sample.model.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by reikhoo on 2017. 10. 17..
 */

public class NetworkResponse {
    @SerializedName("ret_code")
    private int retCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    public int getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }
}
