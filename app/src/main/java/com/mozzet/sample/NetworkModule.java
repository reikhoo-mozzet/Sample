package com.mozzet.sample;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.mozzet.sample.model.network.NetworkResponse;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiConsumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by reikhoo on 2017. 10. 16..
 */

public class NetworkModule {
    private OkHttpClient mClient;
    private Gson mGson;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public static NetworkModule getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        public static final NetworkModule INSTANCE = new NetworkModule();
    }

    private NetworkModule() {
        mGson = new Gson();
        mClient = new OkHttpClient();
    }

    public void post(String url, FormBody body, BiConsumer<Single<NetworkResponse>, Throwable> consumer) {

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Single.defer(() -> {
            Response response = mClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException(new IOException("Unexpected code " + response));
            }
            String result = response.body().string();
            response.close();
            return Single.just(result);
        }).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(NetworkModule.this::refineToNetworkResponse)
                .map(Single::just)
                .subscribe(consumer);
    }

    private NetworkResponse refineToNetworkResponse(String jsonResponse) {
        return mGson.fromJson(jsonResponse, NetworkResponse.class);
    }

    public OkHttpClient getClient() {
        return mClient;
    }

    public static void loadImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

}
