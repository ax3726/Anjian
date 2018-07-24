package com.anjian.ui.record;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddTeZhongBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.TeZhongListModel;
import com.anjian.model.request.AddTeZhongRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

public class AddTeZhongActivity extends PhotoActivity<BasePresenter, ActivityAddTeZhongBinding> {

    private String mImgPath = "";
    private String mImgUsePmsPath = "";
    private TeZhongListModel.DataBean mDataBean = null;
    private String mId = "";
    private long mStartTime = 0;
    private long mEndTime = 0;
    private int mType = 0;//

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_te_zhong;
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

        mDataBean = (TeZhongListModel.DataBean) getIntent().getSerializableExtra("data");
        mId = getIntent().getStringExtra("id");
        initView();
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("特种设备情况");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean != null) {
                    return;
                }
                submitMessage();
            }
        });
    }


    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mTitleBarLayout.setRightTxt("");

        mBinding.tvAddTimg.setVisibility(View.GONE);
        mBinding.img.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);

        mBinding.tvAddTimg1.setVisibility(View.GONE);
        mBinding.img1.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getUsePms())).into(mBinding.img1);

        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getLocaleImg()));
            }
        });
        mBinding.flyImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getUsePms()));
            }
        });


        mBinding.tvName.setText(mDataBean.getSpecialDeviceName());
        mBinding.tvNum.setText(String.valueOf(mDataBean.getSpecialDeviceNum()));
        mBinding.tvAddress.setText(mDataBean.getWorkPosition());

        if (!TextUtils.isEmpty(mDataBean.getExamineBeginDate())) {
            String[] split = mDataBean.getExamineBeginDate().split(" ");
            if (split.length>0) {
                mBinding.tvStartTime.setText(split[0]);
            }
        }
        if (!TextUtils.isEmpty(mDataBean.getExamineEndDate())) {
            String[] split = mDataBean.getExamineEndDate().split(" ");
            if (split.length>0) {
                mBinding.tvEndTime.setText(split[0]);
            }

        }

        int licensedWork = mDataBean.getLicensedWork();

        if (licensedWork == 0) {
            mBinding.rbYou.setChecked(true);
        } else {
            mBinding.rbNo.setChecked(true);
        }

    }

    @Override
    protected void initEvent() {
        super.initEvent();

        if (mDataBean != null) {
            return;
        }
        mBinding.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "名称");
                startActivityForResult(intent, 1001);
            }
        });
        mBinding.tvNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "数量");
                startActivityForResult(intent, 1002);
            }
        });
        mBinding.tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "车间位置");
                startActivityForResult(intent, 1003);
            }
        });
        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mType = 1;
                SelectPhotopopuwindow selectPhotopopuwindow = new SelectPhotopopuwindow(aty);
                selectPhotopopuwindow.setSelectPhotoListener(new SelectPhotopopuwindow.SelectPhotoListener() {
                    @Override
                    public void onAlbum() {
                        pickphoto();
                    }

                    @Override
                    public void onCamera() {
                        doPhoto();
                    }
                });
                selectPhotopopuwindow.showPopupWindow();

            }
        });
        mBinding.flyImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mType = 2;
                SelectPhotopopuwindow selectPhotopopuwindow = new SelectPhotopopuwindow(aty);
                selectPhotopopuwindow.setSelectPhotoListener(new SelectPhotopopuwindow.SelectPhotoListener() {
                    @Override
                    public void onAlbum() {
                        pickphoto();
                    }

                    @Override
                    public void onCamera() {
                        doPhoto();
                    }
                });
                selectPhotopopuwindow.showPopupWindow();

            }
        });
        mBinding.llyTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTimeType = 1;
                selectTime();
            }
        });
    }

    /**
     * 选择时间
     */
    private void selectTime() {
        TimePickerDialog dialogYearMonthDay = new TimePickerDialog.Builder()
                .setTitleStringId(mTimeType == 1 ? "开始时间" : "结束时间")
                .setThemeColor(getResources().getColor(R.color.colorTheme))
                .setType(Type.YEAR_MONTH_DAY)

                .setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerDialog, long time) {
                        if (mTimeType == 1) {
                            mStartTime = time;
                            mTimeType = 2;
                            selectTime();
                        } else {
                            mTimeType = 0;
                            mEndTime = time;
                            mBinding.tvStartTime.setText(DemoUtils.getTimeFormat(mStartTime, "yyyy-MM-dd"));
                            mBinding.tvEndTime.setText(DemoUtils.getTimeFormat(mEndTime, "yyyy-MM-dd"));
                        }
                    }
                })
                .build();
        dialogYearMonthDay.show(getSupportFragmentManager(), "YEAR_MONTH_DAY");
    }

    private int mTimeType = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001://名称
                    mBinding.tvName.setText(result);
                    break;
                case 1002://数量
                    mBinding.tvNum.setText(result);
                    break;
                case 1003://车间位置
                    mBinding.tvAddress.setText(result);
                    break;
            }

        }
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            if (mType == 1) {
                mImgPath = path;
                mBinding.tvAddTimg.setVisibility(View.GONE);
                mBinding.img.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.img);
            } else {
                mImgUsePmsPath = path;
                mBinding.tvAddTimg1.setVisibility(View.GONE);
                mBinding.img1.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.img1);
            }


        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }


    private void submitMessage() {
        String Name = mBinding.tvName.getText().toString().trim();
        String Num = mBinding.tvNum.getText().toString().trim();
        String Address = mBinding.tvAddress.getText().toString().trim();
        String starttime = mBinding.tvStartTime.getText().toString().trim();
        String endtime = mBinding.tvEndTime.getText().toString().trim();
        if (TextUtils.isEmpty(mImgPath)) {
            showToast("请添加设备图片!");
            return;
        }
        if (TextUtils.isEmpty(mImgUsePmsPath)) {
            showToast("请添加设备许可证图片!");
            return;
        }
        if (TextUtils.isEmpty(Name)) {
            showToast("名称不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Num)) {
            showToast("数量不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Address)) {
            showToast("车间位置不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Address)) {
            showToast("车间位置不能为空!");
            return;
        }

        int chi = -1;
        if (mBinding.rbYou.isChecked()) {
            chi = 0;
        } else if (mBinding.rbNo.isChecked()) {
            chi = 1;
        }
        if (chi == -1) {
            showToast("请选择是否持证上岗!");
            return;
        }
        if (mStartTime == 0) {
            showToast("请选择开始时间!");
            return;
        }
        if (mEndTime == 0) {
            showToast("请选择结束时间!");
            return;
        }

        AddTeZhongRequest addTeZhongRequest = new AddTeZhongRequest();

        addTeZhongRequest.setSpecialDeviceName(Name);
        addTeZhongRequest.setSpecialDeviceNum(Num);
        addTeZhongRequest.setWorkPosition(Address);
        addTeZhongRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        addTeZhongRequest.setUsePms(DemoUtils.imageToBase64(mImgUsePmsPath));
        addTeZhongRequest.setLicensedWork(chi);
        addTeZhongRequest.setExamineBeginDate(starttime);
        addTeZhongRequest.setExamineEndDate(endtime);
        if (mUType==0) {
            addTeZhongRequest.setEnterpriseId(mId);
            Api.getApi().addTeZhong(getRequestBody(addTeZhongRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
                @Override
                public void onSuccess(BaseBean baseBean) {
                    showToast(baseBean.getMessage());
                    EventBus.getDefault().post("刷新");
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
            addTeZhongRequest.setPdpId(mId);
            Api.getApi().addTeZhong1(getRequestBody(addTeZhongRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
                @Override
                public void onSuccess(BaseBean baseBean) {
                    showToast(baseBean.getMessage());
                    EventBus.getDefault().post("刷新");
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
