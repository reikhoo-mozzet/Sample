package com.mozzet.sample.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mozzet.sample.model.BaseModel;

public abstract class BaseViewHolder<T extends BaseModel> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindView(T model);
}
