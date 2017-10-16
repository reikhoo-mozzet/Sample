package com.mozzet.sample;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by reikhoo on 2017. 10. 16..
 */

public class NetworkModule {
    private OkHttpClient mClient;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public static NetworkModule getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final NetworkModule INSTANCE = new NetworkModule();
    }

    private NetworkModule() {
        mClient = new OkHttpClient();
    }

    public String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = mClient.newCall(request).execute();
        return response.body().string();
    }

    public OkHttpClient getClient() {
        return mClient;
    }

    public void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }


}
