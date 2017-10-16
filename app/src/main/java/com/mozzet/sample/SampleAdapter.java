package com.mozzet.sample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.mozzet.sample.model.BaseModel;
import com.mozzet.sample.viewholder.BaseViewHolder;
import com.mozzet.sample.viewholder.TypeAViewHolder;

import java.util.List;

/**
 * Created by reikhoo on 2017. 10. 16..
 */

public class SampleAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int TYPE_A = 1;
    private List<BaseModel> mModelList;

    public SampleAdapter(@NonNull List<BaseModel> modelList) {
        mModelList = modelList;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        if(viewType==TYPE_A)...
        return new TypeAViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindView(mModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return mModelList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mModelList.get(position).getType();
    }
}
