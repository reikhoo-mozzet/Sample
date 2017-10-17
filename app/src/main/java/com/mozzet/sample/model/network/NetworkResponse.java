package com.mozzet.sample.model.network;

import java.util.List;

/**
 * Created by reikhoo on 2017. 10. 17..
 */

public class NetworkResponse {
    private int ret_code;
    private String message;
    private Data data;

    public int getRet_code() {
        return ret_code;
    }

    public void setRet_code(int ret_code) {
        this.ret_code = ret_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }






}
