package com.anjian.ui.record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityOtherBinding;
import com.anjian.databinding.ActivitySanXiaoBinding;
import com.anjian.model.record.OtherInfoModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.request.JingWeiRequest;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.ChooseMapPopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class OtherActivity extends BaseActivity<BasePresenter, ActivityOtherBinding> implements View.OnClickListener {
    private String mId = "";
    private OtherInfoModel.DataBean mDataBean;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_other;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initEvent() {
        super.initEvent();

        mBinding.rlyBack.setOnClickListener(this);
        mBinding.imgAddress.setOnClickListener(this);
        mBinding.imgXiugai.setOnClickListener(this);

        mBinding.imgPaicha.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(this);
        mId = getIntent().getStringExtra("id");

        loadData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rly_back:
                finish();
                break;
            case R.id.img_address:
                if (mDataBean != null && !TextUtils.isEmpty(mDataBean.getPosition())) {
                    JingWeiRequest jingWeiRequest = new JingWeiRequest();
                    String[] split = mDataBean.getPosition().split(",");
                    if (split.length > 0) {
                        jingWeiRequest.setLatitude(split[0]);
                        jingWeiRequest.setLongitude(split[1]);
                    }
                    ChooseMapPopuwindow chooseMapPopuwindow = new ChooseMapPopuwindow(aty, jingWeiRequest);
                    chooseMapPopuwindow.showPopupWindow();
                } else {
                    showToast("数据有误!");
                }

                break;
            case R.id.img_xiugai:
                Intent intent = new Intent(aty, AddOtherActivity.class);
                intent.putExtra("data", mDataBean);
                startActivity(intent);
                break;
            case R.id.img_paicha:
                startActivity(SanXiaoCheckActivity.class, mId, 2);

                break;

        }
    }

    private void loadData() {

        getOtherInfo();

    }

    private void getOtherInfo() {
        Api.getApi().otherInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<OtherInfoModel>(this, true) {
            @Override
            public void onSuccess(OtherInfoModel baseBean) {
                initView(baseBean.getData());
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }


    private void initView(OtherInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }
        mDataBean = dataBean;

        mBinding.tvName.setText(dataBean.getOtpName());
        Glide.with(aty).load(DemoUtils.getUrl(dataBean.getOtpImg())).into(mBinding.img);


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新其他".equals(messageEvent)) {
            loadData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}