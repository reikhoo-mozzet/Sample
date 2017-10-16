package com.mozzet.sample.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mozzet.sample.model.BaseModel;

/**
 * Created by reikhoo on 2017. 10. 16..
 */

public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(T model);
}
