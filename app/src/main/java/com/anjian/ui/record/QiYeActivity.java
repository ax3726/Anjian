package com.anjian.ui.record;

import android.content.Intent;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityQiYeBinding;
import com.anjian.model.BaseBean;
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
        getQiyeInfo();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.imgAddress.setOnClickListener(this);
        mBinding.rlyBack.setOnClickListener(this);
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
            case R.id.rly_back:
                finish();
                break;
            case R.id.img_address:
                if (mDataBean != null) {
                    JingWeiRequest jingWeiRequest = new JingWeiRequest();
                    String[] split = mDataBean.getPosition().split(",");
                    if (split.length>0) {
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
                startActivity(intent);
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

    private void initView(QiYeInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }
        mDataBean = dataBean;
        mBinding.tvName.setText(dataBean.getEnterpriseName());
        Glide.with(aty).load(DemoUtils.getUrl(dataBean.getEnterpriseDoorHeadImg())).into(mBinding.img);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新企业".equals(messageEvent)) {
            getQiyeInfo();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
