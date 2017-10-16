package com.mozzet.sample;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.mozzet.sample.databinding.ActivityMainBinding;
import com.mozzet.sample.model.BaseModel;
import com.mozzet.sample.model.TypeAModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDataBinding();
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.rvSample.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
        mBinding.rvSample.setAdapter(makeAdapter());
    }

    private SampleAdapter makeAdapter() {
        return new SampleAdapter(makeDummy());
    }

    public List<BaseModel> makeDummy() {
        List<BaseModel> list = new ArrayList<>();
        String imageUrl = "https://i.ytimg.com/vi/-QmtkGqxo-Q/hqdefault.jpg";
        list.add(new TypeAModel("Lake", imageUrl));
        list.add(new TypeAModel("Lake", imageUrl));
        list.add(new TypeAModel("Lake", imageUrl));
        list.add(new TypeAModel("Lake", imageUrl));
        list.add(new TypeAModel("Lake", imageUrl));
        list.add(new TypeAModel("Lake", imageUrl));
        return list;
    }
}
