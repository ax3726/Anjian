package com.anjian.ui.record;

import android.content.Intent;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddXiaoFangBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.request.AddXiaoFangRequest;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

public class GuanKongActivity extends BaseActivity<BasePresenter, ActivityAddXiaoFangBinding> {


    private QiYeInfoModel.DataBean mDataBean=null;

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_xiao_fang;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initData() {
        super.initData();

        mDataBean = (QiYeInfoModel.DataBean) getIntent().getSerializableExtra("data");

        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }


       mBinding.flyImg.setVisibility(View.VISIBLE);
        mBinding.img.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getDangerDistributeImg())).into(mBinding.img);

        int ControlStep = mDataBean.getControlStep();
        if (ControlStep == 0) {
            mBinding.rbGuanYou.setChecked(true);
        } else if (ControlStep==1){
            mBinding.rbGuanNo.setChecked(true);
        }

        int UrgentDevice = mDataBean.getUrgentDevice();
        if (UrgentDevice == 0) {
            mBinding.rbYingYou.setChecked(true);
        } else if (ControlStep==1){
            mBinding.rbYingNo.setChecked(true);
        }

        int ControlStandBook = mDataBean.getControlStandBook();
        if (ControlStandBook == 0) {
            mBinding.rbZhangYou.setChecked(true);
        } else if (ControlStep==1){
            mBinding.rbZhangNo.setChecked(true);
        }

        mBinding.tvQuestion.setText(mDataBean.getExistProblem());
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("风险管控情况");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitMessage();
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();

        mBinding.tvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "存在问题");
                startActivityForResult(intent, 1001);
            }
        });
        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean == null) {
                    return;
                }
                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getDangerDistributeImg()));
            }
        });
        mBinding.tvFengxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FengXianActivity.class, mDataBean.getId(),mUType);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001://存在问题
                    mBinding.tvQuestion.setText(result);
                    break;
            }

        }
    }



    private void submitMessage() {
        String question = mBinding.tvQuestion.getText().toString().trim();
        int guan=0;
        if (mBinding.rbGuanYou.isChecked()) {
            guan=0;
        } else {
            guan=1;
        }


        int ying=0;
        if (mBinding.rbYingYou.isChecked()) {
            ying=0;
        } else {
            ying=1;
        }

        int zhang=0;
        if (mBinding.rbZhangYou.isChecked()) {
            zhang=0;
        } else {
            zhang=1;
        }



        AddXiaoFangRequest addXiaoFangRequest=new AddXiaoFangRequest();

        addXiaoFangRequest.setId(mDataBean.getId());
        addXiaoFangRequest.setControlStep(guan);
        addXiaoFangRequest.setUrgentDevice(ying);
        addXiaoFangRequest.setControlStandBook(zhang);
        addXiaoFangRequest.setExistProblem(question);

        if (mUType==0) {
            addXiaoFangRequest.setEnterpriseName(mDataBean.getEnterpriseName());
            Api.getApi().addXiaoFang(getRequestBody(addXiaoFangRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
                @Override
                public void onSuccess(BaseBean baseBean) {
                    showToast(baseBean.getMessage());
                    EventBus.getDefault().post("刷新企业");
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                sleep(1500);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }

                @Override
                public void onFail(String errMsg) {

                }
            });

        } else if (mUType==1) {
            addXiaoFangRequest.setPdpName(mDataBean.getPdpName());
            Api.getApi().addXiaoFang1(getRequestBody(addXiaoFangRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
                @Override
                public void onSuccess(BaseBean baseBean) {
                    showToast(baseBean.getMessage());
                    EventBus.getDefault().post("刷新人口密集");
                    new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            try {
                                sleep(1500);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                }

                @Override
                public void onFail(String errMsg) {

                }
            });

        }

    }
}
