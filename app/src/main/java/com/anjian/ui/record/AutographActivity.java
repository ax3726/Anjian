package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAutographBinding;
import com.anjian.databinding.ActivityQiYeBinding;

import java.io.IOException;

public class AutographActivity extends BaseActivity<BasePresenter, ActivityAutographBinding> {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_autograph;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void save(View view) {
        if (mBinding.lvBody.getTouched()) {
            try {
                mBinding.lvBody.save(MyApplication.getBase_Path() + "/test.png", true, 10);
                mBinding.lvBody.clear();
                finish();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showToast("您没有签名~");
        }
    }

    public void clear(View view) {
        mBinding.lvBody.clear();
    }
}
