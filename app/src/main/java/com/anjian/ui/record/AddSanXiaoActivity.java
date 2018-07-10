package com.anjian.ui.record;

import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddSanXiaoBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.record.SanXiaoInfoModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.request.AddSanXiaoRequest;
import com.anjian.model.request.UpdateSanXiaoRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddSanXiaoActivity extends PhotoActivity<BasePresenter, ActivityAddSanXiaoBinding> implements View.OnClickListener {
    private String[] mTypeList = new String[]{
            "小档口", "小作坊", "小娱乐场所"
    };
    private String mImgHead = "";//门头照片
    private String mImgZhi = "";//执照照片
    private int type = 0;
    private int mTypeIndex = 0;//1:"小档口",2:"小作坊",3:"小娱乐场所）
    private SanXiaoInfoModel.DataBean mDataBean = null;

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_san_xiao;
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

        mTitleBarLayout.setTitle("三小场所信息");
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
    }

    @Override
    protected void initData() {
        super.initData();
        mDataBean = (SanXiaoInfoModel.DataBean) getIntent().getSerializableExtra("data");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mBinding.tvAddTou.setVisibility(View.GONE);
        mBinding.imgTou.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getTspDoorHeadImg())).into(mBinding.imgTou);

        mBinding.tvAddZhi.setVisibility(View.GONE);
        mBinding.imgZhi.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getBusinessLicenceImg())).into(mBinding.imgZhi);


        mBinding.etName.setText(mDataBean.getTspName());
        mBinding.tvJiedao.setText(mDataBean.getAreaName());
        mBinding.etZhizhao.setText(mDataBean.getBusinessLicenceCode());
        mBinding.etContactName.setText(mDataBean.getContactName());
        mBinding.etContactPhone.setText(mDataBean.getContactPhone());
        mBinding.etMail.setText(mDataBean.getEmail());

        mTypeIndex = mDataBean.getIndustry();
        mBinding.tvType.setText(mTypeList[mTypeIndex == 0 ? 2 : mTypeIndex--]);


        mBinding.etNum.setText(mDataBean.getEmployeeNum() + "");

        fourId = mDataBean.getAreaId();
        areaId = mDataBean.getAreaId();

        threeId = mDataBean.getAreaRelation();
        fourName = mDataBean.getAreaName();

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvType.setOnClickListener(this);
        mBinding.tvJiedao.setOnClickListener(this);
        mBinding.flyHeadImg.setOnClickListener(this);
        mBinding.flyImgZhi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_type://所属类别
                OptionPicker picker1 = new OptionPicker(this, mTypeList);
                picker1.setOffset(2);
                picker1.setSelectedIndex(1);
                picker1.setTextSize(16);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        if (i < 2) {
                            i++;
                        } else {
                            i = 0;
                        }
                        mTypeIndex = i;
                        mBinding.tvType.setText(s);
                    }
                });
                picker1.show();
                break;
            case R.id.tv_jiedao://街道
                selectJieDao();
                break;
            case R.id.fly_head_img://
                type = 1;
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
            case R.id.fly_img_zhi://
                type = 2;
                SelectPhotopopuwindow selectPhotopopuwindow1 = new SelectPhotopopuwindow(aty);
                selectPhotopopuwindow1.setSelectPhotoListener(new SelectPhotopopuwindow.SelectPhotoListener() {
                    @Override
                    public void onAlbum() {
                        pickphoto();
                    }

                    @Override
                    public void onCamera() {
                        doPhoto();
                    }
                });
                selectPhotopopuwindow1.showPopupWindow();
                break;
        }
    }

    private void submitMessage() {
        String name = mBinding.etName.getText().toString().trim();
        String jiedao = mBinding.tvJiedao.getText().toString().trim();
        String zhizhao = mBinding.etZhizhao.getText().toString().trim();
        String ContactsName = mBinding.etContactName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactPhone.getText().toString().trim();
        String Mail = mBinding.etMail.getText().toString().trim();
        String Num = mBinding.etNum.getText().toString().trim();

        AddSanXiaoRequest addSanXiaoRequest = new AddSanXiaoRequest();
        addSanXiaoRequest.setTspName(name);
        addSanXiaoRequest.setTspDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
        addSanXiaoRequest.setAreaId(fourId);
        addSanXiaoRequest.setAreaRelation(threeId);
        addSanXiaoRequest.setAreaName(fourName);
        addSanXiaoRequest.setPosition(DemoUtils.getLatitudeAndLongitude(aty));
        addSanXiaoRequest.setBusinessLicenceImg(DemoUtils.imageToBase64(mImgZhi));
        addSanXiaoRequest.setBusinessLicenceCode(zhizhao);
        addSanXiaoRequest.setEmployeeNum(Num);
        addSanXiaoRequest.setContactName(ContactsName);
        addSanXiaoRequest.setContactPhone(ContactsPhone);
        addSanXiaoRequest.setEmail(Mail);
        addSanXiaoRequest.setIndustry(String.valueOf(mTypeIndex));


        Api.getApi().addSanXiao(getRequestBody(addSanXiaoRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
                EventBus.getDefault().post("刷新三小");
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
        String zhizhao = mBinding.etZhizhao.getText().toString().trim();
        String ContactsName = mBinding.etContactName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactPhone.getText().toString().trim();
        String Mail = mBinding.etMail.getText().toString().trim();
        String Num = mBinding.etNum.getText().toString().trim();

        UpdateSanXiaoRequest addSanXiaoRequest = new UpdateSanXiaoRequest();
        addSanXiaoRequest.setId(mDataBean.getId());
        addSanXiaoRequest.setTspName(name);
        if (!TextUtils.isEmpty(mImgHead)) {
            addSanXiaoRequest.setTspDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
        }
        addSanXiaoRequest.setAreaId(fourId);
        addSanXiaoRequest.setAreaRelation(threeId);
        addSanXiaoRequest.setAreaName(fourName);
        addSanXiaoRequest.setPosition(DemoUtils.getLatitudeAndLongitude(aty));
        if (!TextUtils.isEmpty(mImgZhi)) {
            addSanXiaoRequest.setBusinessLicenceImg(DemoUtils.imageToBase64(mImgZhi));
        }
        addSanXiaoRequest.setBusinessLicenceCode(zhizhao);
        addSanXiaoRequest.setEmployeeNum(Num);
        addSanXiaoRequest.setContactName(ContactsName);
        addSanXiaoRequest.setContactPhone(ContactsPhone);
        addSanXiaoRequest.setEmail(Mail);
        addSanXiaoRequest.setIndustry(String.valueOf(mTypeIndex));


        Api.getApi().updateSanXiao(getRequestBody(addSanXiaoRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
                EventBus.getDefault().post("刷新三小");
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
                        }

                        if (index < 3) {
                            index++;
                            getAreadata();
                        } else if (index == 3) {
                            index = 0;
                            mBinding.tvJiedao.setText(fourName);
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
            if (type == 1) {
                mImgHead = path;
                mBinding.tvAddTou.setVisibility(View.GONE);
                mBinding.imgTou.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.imgTou);
            } else if (type == 2) {
                mImgZhi = path;
                mBinding.tvAddZhi.setVisibility(View.GONE);
                mBinding.imgZhi.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.imgZhi);
            }

        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }
}
