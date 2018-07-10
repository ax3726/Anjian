package com.anjian.ui.common;

import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityPhotoPreviewBinding;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class PhotoPreviewActivity extends BaseActivity<BasePresenter,ActivityPhotoPreviewBinding> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_preview;

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.llyLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        String url = getIntent().getStringExtra("url");

        mBinding.img.enable();

        DrawableTypeRequest<String> load =  Glide.with(aty).load(url);
        load.listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String s, Target<GlideDrawable> target, boolean b) {
              showToast("图片加载失败！");

                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable glideDrawable, String s, Target<GlideDrawable> target, boolean b, boolean b1) {


                return false;
            }
        }).thumbnail(0.9f)
                .into(mBinding.img);



    }
}
