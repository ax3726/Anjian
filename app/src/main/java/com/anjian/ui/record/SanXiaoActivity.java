package com.anjian.ui.record;

import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivitySanXiaoBinding;

public class SanXiaoActivity extends BaseActivity<BasePresenter, ActivitySanXiaoBinding> implements View.OnClickListener {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_san_xiao;
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
        mBinding.imgYanlian.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_xiugai:
                startActivity(AddSanXiaoActivity.class);
                break;
            case R.id.img_xianchang:
                startActivity(SanXiaoCheckActivity.class);
                break;
            case R.id.img_yanlian:
                startActivity(YanLianActivity.class);
                break;

        }
    }
}
