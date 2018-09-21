package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddOtherBinding;
import com.anjian.databinding.ActivityAddSanXiaoBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.OcrModel;
import com.anjian.model.record.OtherInfoModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.request.AddOtherRequest;
import com.anjian.model.request.AddSanXiaoRequest;
import com.anjian.model.request.UpdateOtherRequest;
import com.anjian.model.request.UpdateSanXiaoRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.utils.LocationHelper;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.OcrRequestParams;
import com.baidu.ocr.sdk.model.OcrResponseResult;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.OptionPicker;
import ml.gsy.com.library.utils.ParseJsonUtils;

import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddSanXiaoBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.OcrModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.request.AddSanXiaoRequest;
import com.anjian.model.request.UpdateSanXiaoRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.baidu.ocr.sdk.OCR;
import com.baidu.ocr.sdk.OnResultListener;
import com.baidu.ocr.sdk.exception.OCRError;
import com.baidu.ocr.sdk.model.OcrRequestParams;
import com.baidu.ocr.sdk.model.OcrResponseResult;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.OptionPicker;
import ml.gsy.com.library.utils.ParseJsonUtils;

public class AddOtherActivity extends PhotoActivity<BasePresenter, ActivityAddOtherBinding> implements View.OnClickListener {


    private String mImgHead = "";//门头照片

    private OtherInfoModel.DataBean mDataBean = null;

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_other;
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
    protected void initTitleBar() {
        super.initTitleBar();

        mTitleBarLayout.setTitle("其他场所信息");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean != null) {
                    updateMessage();
                } else {
                    submitMessage();
                }
            }
        });
        mBinding.tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean != null) {
                    updateMessage();
                } else {
                    submitMessage();
                }
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        LocationHelper.getInstance().startLocation(aty);
        mDataBean = (OtherInfoModel.DataBean) getIntent().getSerializableExtra("data");

        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mBinding.tvAddTou.setVisibility(View.GONE);
        mBinding.imgTou.setVisibility(View.VISIBLE);

        mBinding.etName.setText(mDataBean.getOtpName());
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getOtpImg())).into(mBinding.imgTou);


        mBinding.tvJiedao.setText(mDataBean.getAreaName());
        mBinding.etContactName.setText(mDataBean.getContactName());
        mBinding.etContactPhone.setText(mDataBean.getContactPhone());
        mBinding.tvManager.setText(mDataBean.getManager());


        fiveId = mDataBean.getAreaId();
        areaId = mDataBean.getAreaId();

        fourId = mDataBean.getAreaRelation();
        fiveName = mDataBean.getAreaName();

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvJiedao.setOnClickListener(this);
        mBinding.flyHeadImg.setOnClickListener(this);
        mBinding.tvManager.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tv_jiedao://街道
                selectJieDao();
                break;
            case R.id.fly_head_img://

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
                break;
            case R.id.tv_manager://场所类别
                String[] list = new String[]{"居民", "其他"};
                OptionPicker picker1 = new OptionPicker(this, list);
                picker1.setOffset(2);
                picker1.setSelectedIndex(1);
                picker1.setTextSize(16);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvManager.setText(s);
                    }
                });
                picker1.show();
                break;

        }
    }

    private void submitMessage() {
        String name = mBinding.etName.getText().toString().trim();
        String jiedao = mBinding.tvJiedao.getText().toString().trim();
        String ContactsName = mBinding.etContactName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactPhone.getText().toString().trim();
        String Manager = mBinding.tvManager.getText().toString().trim();

        AddOtherRequest addSanXiaoRequest = new AddOtherRequest();

        addSanXiaoRequest.setAreaId(fiveId);
        addSanXiaoRequest.setAreaRelation(fourId);
        addSanXiaoRequest.setAreaName(fiveName);
        addSanXiaoRequest.setPosition(DemoUtils.getLatitudeAndLongitude(aty));

        addSanXiaoRequest.setOtpName(name);
        addSanXiaoRequest.setManager(Manager);
        addSanXiaoRequest.setOtpImg(DemoUtils.imageToBase64(mImgHead));
        addSanXiaoRequest.setContactName(ContactsName);
        addSanXiaoRequest.setContactPhone(ContactsPhone);

        Api.getApi().addOther(getRequestBody(addSanXiaoRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
                EventBus.getDefault().post("刷新其他");
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

    private void updateMessage() {
        String name = mBinding.etName.getText().toString().trim();
        String jiedao = mBinding.tvJiedao.getText().toString().trim();
        String ContactsName = mBinding.etContactName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactPhone.getText().toString().trim();
        String Manager = mBinding.tvManager.getText().toString().trim();


        UpdateOtherRequest addSanXiaoRequest = new UpdateOtherRequest();
        addSanXiaoRequest.setId(mDataBean.getId());
        addSanXiaoRequest.setAreaId(fiveId);
        addSanXiaoRequest.setAreaRelation(fourId);
        addSanXiaoRequest.setAreaName(fiveName);
        addSanXiaoRequest.setManager(Manager);
        addSanXiaoRequest.setPosition(DemoUtils.getLatitudeAndLongitude(aty));

        addSanXiaoRequest.setOtpName(name);
        if (!TextUtils.isEmpty(mImgHead)) {
            addSanXiaoRequest.setOtpImg(DemoUtils.imageToBase64(mImgHead));
        }
        addSanXiaoRequest.setContactName(ContactsName);
        addSanXiaoRequest.setContactPhone(ContactsPhone);
        Api.getApi().updateOther(getRequestBody(addSanXiaoRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
                EventBus.getDefault().post("刷新其他");
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

    private void selectJieDao() {
        index = 0;
        getAreadata();
    }

    private String oneName = "";
    private String twoName = "";
    private String threeName = "";
    private String threeId = "";
    private String fourName = "";
    private String fourId = "";
    private String fiveId = "";
    private String fiveName = "";

    private String areaId = "";
    private int index = 0;

    private void getAreadata() {
        Api.getApi().sysArea(index == 0 ? "0" : areaId, MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SysAreaModel>(this, true) {
            @Override
            public void onSuccess(SysAreaModel sysAreaModel) {
                List<String> list = new ArrayList<>();
                for (SysAreaModel.DataBean dataBean : sysAreaModel.getData()) {
                    list.add(dataBean.getName());
                }
                OptionPicker picker = new OptionPicker(aty, list);
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        if (index == 0) {
                            oneName = s;
                            areaId = sysAreaModel.getData().get(i).getId();
                        } else if (index == 1) {
                            twoName = s;
                            areaId = sysAreaModel.getData().get(i).getId();
                        } else if (index == 2) {
                            threeName = s;
                            areaId = sysAreaModel.getData().get(i).getId();
                            threeId = sysAreaModel.getData().get(i).getId();
                        } else if (index == 3) {
                            fourName = s;
                            areaId = sysAreaModel.getData().get(i).getId();
                            fourId = sysAreaModel.getData().get(i).getId();
                        } else if (index == 4) {
                            fiveName = s;
                            areaId = sysAreaModel.getData().get(i).getId();
                            fiveId = sysAreaModel.getData().get(i).getId();
                        }

                        if (index < 4) {
                            index++;
                            getAreadata();
                        } else if (index == 4) {
                            index = 0;
                            mBinding.tvJiedao.setText(fiveName);
                        }

                    }
                });
                picker.show();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            mImgHead = path;
            mBinding.tvAddTou.setVisibility(View.GONE);
            mBinding.imgTou.setVisibility(View.VISIBLE);
            Glide.with(aty).load(file).into(mBinding.imgTou);

        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }


}
