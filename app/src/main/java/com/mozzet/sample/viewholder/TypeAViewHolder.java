package com.mozzet.sample.viewholder;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mozzet.sample.NetworkModule;
import com.mozzet.sample.R;
import com.mozzet.sample.databinding.LayoutATypeBinding;
import com.mozzet.sample.model.TypeAModel;

public class TypeAViewHolder extends BaseViewHolder<TypeAModel> {

    private LayoutATypeBinding mBinding;

    public TypeAViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_a_type, parent, false));
        initDataBinding();
    }

    private void initDataBinding() {
        mBinding = DataBindingUtil.bind(itemView);
    }

    @Override
    public void bindView(TypeAModel model) {
        mBinding.setModel(model);
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        NetworkModule.loadImage(view, url);
    }
}