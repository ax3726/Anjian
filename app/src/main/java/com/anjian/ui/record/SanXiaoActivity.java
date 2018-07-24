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
import com.anjian.databinding.ActivitySanXiaoBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.request.JingWeiRequest;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.ChooseMapPopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SanXiaoActivity extends BaseActivity<BasePresenter, ActivitySanXiaoBinding> implements View.OnClickListener {
    private String mId = "";
    private SanXiaoInfoModel.DataBean mDataBean;

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

        mBinding.rlyBack.setOnClickListener(this);
        mBinding.imgAddress.setOnClickListener(this);
        mBinding.imgXiugai.setOnClickListener(this);
        mBinding.imgXianchang.setOnClickListener(this);
        mBinding.imgYanlian.setOnClickListener(this);
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
                Intent intent = new Intent(aty, AddSanXiaoActivity.class);
                intent.putExtra("data", mDataBean);
                intent.putExtra("utype", mUType);
                startActivity(intent);
                break;
            case R.id.img_xianchang:
                startActivity(SanxiaoSelectActivity.class, mId,mUType);
                break;
            case R.id.img_yanlian:
                startActivity(YanLianActivity.class, mId,mUType);
                break;
            case R.id.img_paicha:
                startActivity(SanXiaoCheckActivity.class, mId,mUType);

                break;

        }
    }
    private void loadData()
    {
        if (mUType == 0) {
            getSanXiaoInfo();
        } else if(mUType==1) {
            getLetInfo();
        }
    }
    private void getSanXiaoInfo() {
        Api.getApi().sanXiaoInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SanXiaoInfoModel>(this, true) {
            @Override
            public void onSuccess(SanXiaoInfoModel baseBean) {
                initView(baseBean.getData());
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    private void getLetInfo() {
        Api.getApi().letInfo(mId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SanXiaoInfoModel>(this, true) {
            @Override
            public void onSuccess(SanXiaoInfoModel baseBean) {
                initView(baseBean.getData());
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    private void initView(SanXiaoInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }
        mDataBean = dataBean;
        if (mUType == 0) {
            mBinding.tvName.setText(dataBean.getTspName());
            Glide.with(aty).load(DemoUtils.getUrl(dataBean.getTspDoorHeadImg())).into(mBinding.img);
        } else if(mUType==1) {
            mBinding.tvName.setText(dataBean.getLetName());
            Glide.with(aty).load(DemoUtils.getUrl(dataBean.getLetDoorHeadImg())).into(mBinding.img);
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新三小".equals(messageEvent)) {
            loadData();
        }else  if ("刷新人口密集".equals(messageEvent)) {
            loadData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
