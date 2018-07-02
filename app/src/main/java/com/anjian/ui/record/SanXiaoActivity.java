package com.anjian.ui.record;

import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivitySanXiaoBinding;
import com.anjian.model.BaseBean;

public class SanXiaoActivity extends BaseActivity<BasePresenter, ActivitySanXiaoBinding> implements View.OnClickListener {
    private String mId = "";

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
        mBinding.imgBack.setOnClickListener(this);
        mBinding.imgXiugai.setOnClickListener(this);
        mBinding.imgXianchang.setOnClickListener(this);
        mBinding.imgYanlian.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        mId = getIntent().getStringExtra("id");
        getSanXiaoInfo();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_xiugai:
                startActivity(AddSanXiaoActivity.class, mId);
                break;
            case R.id.img_xianchang:
                startActivity(SanxiaoSelectActivity.class, mId);
                break;
            case R.id.img_yanlian:
                startActivity(YanLianActivity.class, mId);
                break;

        }
    }

    private void getSanXiaoInfo() {
        Api.getApi().sanXiaoInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {

            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}
