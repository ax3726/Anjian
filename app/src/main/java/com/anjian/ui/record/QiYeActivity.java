package com.anjian.ui.record;

import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityQiYeBinding;
import com.anjian.model.BaseBean;

public class QiYeActivity extends BaseActivity<BasePresenter, ActivityQiYeBinding> implements View.OnClickListener {
    private String mId = "";

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
    protected void initData() {
        super.initData();
        mId = getIntent().getStringExtra("id");
        getQiyeInfo();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.imgBack.setOnClickListener(this);
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
            case R.id.img_back:
                finish();
                break;
            case R.id.img_xiugai:
                startActivity(AddQiyeActivity.class, mId);
                break;
            case R.id.img_xianchang:
                startActivity(QiYeCheckActivity.class, mId);
                break;
            case R.id.img_jiaoliu:
                startActivity(JiaoLiuActivity.class, mId);
                break;
            case R.id.img_fengxian:
                startActivity(FengXianActivity.class, mId);
                break;
            case R.id.img_weihua:
                startActivity(WeiHuaActivity.class, mId);
                break;
            case R.id.img_tezhong:
                startActivity(TeZhongActivity.class, mId);
                break;
            case R.id.img_xiaofang:
                startActivity(XiaoFangActivity.class, mId);
                break;
        }
    }
    private void getQiyeInfo()
    {
        Api.getApi().qiYeInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this,true) {
            @Override
            public void onSuccess(BaseBean baseBean) {

            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}
