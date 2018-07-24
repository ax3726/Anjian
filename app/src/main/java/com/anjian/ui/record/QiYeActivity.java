package com.anjian.ui.record;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityQiYeBinding;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.request.JingWeiRequest;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.ChooseMapPopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class QiYeActivity extends BaseActivity<BasePresenter, ActivityQiYeBinding> implements View.OnClickListener {
    private String mId = "";
    private QiYeInfoModel.DataBean mDataBean = null;

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
        EventBus.getDefault().register(this);
        mId = getIntent().getStringExtra("id");

        getData();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.imgAddress.setOnClickListener(this);
        mBinding.rlyBack.setOnClickListener(this);
        mBinding.imgXiugai.setOnClickListener(this);
        mBinding.imgXianchang.setOnClickListener(this);
        mBinding.imgJiaoliu.setOnClickListener(this);
        mBinding.imgPaicha.setOnClickListener(this);
        mBinding.imgWeihua.setOnClickListener(this);
        mBinding.imgTezhong.setOnClickListener(this);
        mBinding.imgFengxian.setOnClickListener(this);
        mBinding.imgYouxian.setOnClickListener(this);
        mBinding.imgFencheng.setOnClickListener(this);


    }

    private void getData() {
        if (mUType == 0) {
            getQiyeInfo();
        } else if (mUType == 1) {
            getPdpInfo();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rly_back:
                finish();
                break;
            case R.id.img_address:
                if (mDataBean != null&& !TextUtils.isEmpty(mDataBean.getPosition())) {
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
                Intent intent = new Intent(aty, AddQiyeActivity.class);
                intent.putExtra("data", mDataBean);
                intent.putExtra("utype", mUType);
                startActivity(intent);
                break;
            case R.id.img_xianchang:
                startActivity(QiYeSelectActivity.class, mId, mUType);
                break;
            case R.id.img_jiaoliu:
                startActivity(JiaoLiuActivity.class, mId, mUType);
                break;
            case R.id.img_paicha:
                startActivity(QiYeCheckActivity.class, mId,mUType);
                break;
            case R.id.img_weihua:
                startActivity(WeiHuaActivity.class, mId,mUType);
                break;
            case R.id.img_tezhong:
                startActivity(TeZhongActivity.class, mId,mUType);
                break;
            case R.id.img_fengxian:
                Intent intent1 = new Intent(aty, GuanKongActivity.class);
                intent1.putExtra("data", mDataBean);
                intent1.putExtra("utype", mUType);
                startActivity(intent1);
                break;
            case R.id.img_youxian:
                startActivity(YouXianActivity.class, mId,mUType);
                break;
            case R.id.img_fencheng:
                startActivity(FenChengActivity.class, mId,mUType);
                break;
        }
    }

    private void getQiyeInfo() {
        Api.getApi().qiYeInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<QiYeInfoModel>(this, true) {
            @Override
            public void onSuccess(QiYeInfoModel baseBean) {
                initView(baseBean.getData());
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    private void getPdpInfo() {
        Api.getApi().pdpInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<QiYeInfoModel>(this, true) {
            @Override
            public void onSuccess(QiYeInfoModel baseBean) {
                initView(baseBean.getData());
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }


    private void initView(QiYeInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }
        mDataBean = dataBean;
        if (mUType == 0) {
            mBinding.tvName.setText(dataBean.getEnterpriseName());
            Glide.with(aty).load(DemoUtils.getUrl(dataBean.getEnterpriseDoorHeadImg())).into(mBinding.img);
        } else if (mUType == 1) {
            mBinding.tvName.setText(dataBean.getPdpName());
            Glide.with(aty).load(DemoUtils.getUrl(dataBean.getPdpDoorHeadImg())).into(mBinding.img);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新企业".equals(messageEvent)) {
            getQiyeInfo();
        } else if ("刷新人口密集".equals(messageEvent)) {
            getPdpInfo();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
