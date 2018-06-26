package com.anjian.ui.record;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityQiYeBinding;

public class QiYeActivity extends BaseActivity<BasePresenter, ActivityQiYeBinding> implements View.OnClickListener {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qi_ye;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.imgXiugai.setOnClickListener(this);
        mBinding.imgXianchang.setOnClickListener(this);
        mBinding.imgJiaoliu.setOnClickListener(this);
        mBinding.imgFengxian.setOnClickListener(this);
        mBinding.imgWeihua.setOnClickListener(this);
        mBinding.imgTezhong.setOnClickListener(this);
        mBinding.imgXiaofang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_xiugai:
                startActivity(AutographActivity.class);
                break;
            case R.id.img_xianchang:
                break;
            case R.id.img_jiaoliu:
                break;
            case R.id.img_fengxian:
                startActivity(FengXianActivity.class);
                break;
            case R.id.img_weihua:
                break;
            case R.id.img_tezhong:
                break;
            case R.id.img_xiaofang:
                break;
        }
    }
}
