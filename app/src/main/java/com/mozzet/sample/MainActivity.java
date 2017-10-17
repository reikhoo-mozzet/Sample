package com.mozzet.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.mozzet.sample.databinding.ActivityMainBinding;
import com.mozzet.sample.model.BaseModel;
import com.mozzet.sample.model.TypeAModel;
import com.mozzet.sample.model.network.Card;
import com.mozzet.sample.model.network.NetworkResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import okhttp3.FormBody;

public class MainActivity extends Activity {
    private ActivityMainBinding mBinding;
    private SampleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataBinding();
        initRecyclerView();
        requestModel();
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
    private void initRecyclerView(){
        mBinding.rvSample.setLayoutManager(new GridLayoutManager(MainActivity.this, 3, LinearLayoutManager.VERTICAL,false));
        mBinding.rvSample.addItemDecoration(new GridSpacingItemDecoration(3,20,true));
    }

    private void setAdapter(List<BaseModel> modelList) {
        if (mAdapter == null) {
            mAdapter = new SampleAdapter(modelList);
        } else {
            mAdapter.changeModels(modelList);
        }
        mBinding.rvSample.setAdapter(mAdapter);
    }

    private FormBody makeFormBody(String key, String value) {
        return new FormBody.Builder().add(key, value).build();
    }

    private void requestModel() {
        NetworkModule.getInstance()
                .post(SecretData.SAMPLE_URL, makeFormBody(SecretData.TOKEN_KEY, SecretData.TOKEN)
                        , (singleResponse,throwable) -> {
                            if(throwable!=null){
                                processNetworkFail(throwable);
                                return;
                            }
                            refineToBaseModels(singleResponse, MainActivity.this::setAdapter);
                        });
    }

    private void processNetworkFail(Throwable throwable){
        Toast.makeText(this, "Error : " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
    private void refineToBaseModels(Single<NetworkResponse> response, Consumer<List<BaseModel>> consumer) {
        response.map(MainActivity.this::refineNetworkResponseToCards)
                .map(MainActivity.this::refineCardsToTypeAModels)
                .subscribe(consumer);
    }

    private List<Card> refineNetworkResponseToCards(NetworkResponse response) {
        return response.getData().getSections().get(0).getCards();
    }

    private List<BaseModel> refineCardsToTypeAModels(List<Card> cardList) {
        List<BaseModel> baseModels = new ArrayList<>();
        for (Card card : cardList) {
            baseModels.add(new TypeAModel(card.getNickname(), card.getPhoto_url()));
        }
        return baseModels;
    }


}
