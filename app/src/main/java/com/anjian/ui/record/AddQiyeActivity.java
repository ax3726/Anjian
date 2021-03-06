package com.anjian.ui.record;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddQiyeBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.OcrModel;
import com.anjian.model.record.QiYeInfoModel;
import com.anjian.model.record.SysAreaModel;
import com.anjian.model.request.AddQiYeRequset;
import com.anjian.model.request.UpdateQiYeRequset;
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

public class AddQiyeActivity extends PhotoActivity<BasePresenter, ActivityAddQiyeBinding> implements View.OnClickListener {
    private String[] mHangye = new String[]{
            "冶金", "有色金属", "机械", "纺织", "轻工", "化工", "医药", "建材", "烟草", "烟草爆竹", "其他"
    };
    private String[] mHangye1 = new String[]{
            "宾馆", "经营场所", "娱乐场所", "学校", "寄宿场所", "公共聚集", "其他"
    };

    private String items[] = {"粉尘涉爆", "有限空间", "特种设备", "涉氨"};
    private String mImgHead = "";//门头照片
    private String mImgZhi = "";//执照照片
    private int type = 0;
    private int mTypeIndex = 1;//企业规模(1规上企业 2小微企业 3三小场所)
    private int mHnagyeindex = 0;
    private QiYeInfoModel.DataBean mDataBean = null;
    private String mTypeShe = "";//涉及类型

    private String[] itmes = new String[]{
            "规模企业", "一般企业", "小微企业"};
    private String[] itmes1 = new String[]{
            "大", "小", "中"};

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_qiye;
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
        if (mUType == 0) {
            mTitleBarLayout.setTitle("企业信息");
        } else if (mUType == 1) {
            mTitleBarLayout.setTitle("人口密集场所信息");
        }

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
        mDataBean = (QiYeInfoModel.DataBean) getIntent().getSerializableExtra("data");
        if (mUType == 1) {
            mBinding.tvNameHint.setText("单位名称");
            mBinding.tvAddressHint.setText("单位地址");
            mBinding.tvGuimoHint.setText("单位规模");
        }
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mBinding.tvAddTou.setVisibility(View.GONE);
        mBinding.imgTou.setVisibility(View.VISIBLE);


        mBinding.tvAddZhi.setVisibility(View.GONE);
        mBinding.imgZhi.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getBusinessLicenceImg())).into(mBinding.imgZhi);

        if (mUType == 0) {
            Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getEnterpriseDoorHeadImg())).into(mBinding.imgTou);
            mBinding.etName.setText(mDataBean.getEnterpriseName());
        } else if (mUType == 1) {
            Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getPdpDoorHeadImg())).into(mBinding.imgTou);
            mBinding.etName.setText(mDataBean.getPdpName());
        }


        mBinding.tvJiedao.setText(mDataBean.getDetailAddress());
        mBinding.etZhizhao.setText(mDataBean.getBusinessLicenceCode());
        mBinding.etContactsName.setText(mDataBean.getContactName());
        mBinding.etContactsPhone.setText(mDataBean.getContactPhone());
        mBinding.etMail.setText(mDataBean.getEmail());

        mTypeIndex = mDataBean.getEnterpriseScale();

        if (mUType == 0) {
            mBinding.tvGuimo.setText(itmes[mTypeIndex - 1]);
        } else if (mUType == 1) {
            mBinding.tvGuimo.setText(itmes1[mTypeIndex - 1]);
        }


        mHnagyeindex = mDataBean.getIndustry();

        if (mUType == 0) {
            mBinding.tvHangye.setText(mHangye[mHnagyeindex == 0 ? 10 : mHnagyeindex--]);
        } else if (mUType == 1) {
            mBinding.tvHangye.setText(mHangye1[mHnagyeindex == 0 ? 6 : mHnagyeindex--]);
        }


        mBinding.etMianji.setText(mDataBean.getFloorArea() + "");
        mBinding.etNum.setText(mDataBean.getEmployeeNum() + "");

        fiveId = mDataBean.getAreaId();
        areaId = mDataBean.getAreaId();

        fourId = mDataBean.getAreaRelation();
        fiveName = mDataBean.getAreaName();


        if (!TextUtils.isEmpty(mDataBean.getReferType())) {
            mTypeShe = mDataBean.getReferType();
            String[] split = mTypeShe.split(",");

            if (split.length > 0) {
                String txt = "";
                for (int i = 0; i < split.length; i++) {
                    if (TextUtils.isEmpty(txt)) {
                        txt = items[i];
                    } else {
                        txt = txt + "、" + items[i];
                    }
                }
                mBinding.tvSheType.setText(txt);

            }
        }


    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvJiedao.setOnClickListener(this);
        mBinding.tvGuimo.setOnClickListener(this);
        mBinding.tvHangye.setOnClickListener(this);
        mBinding.flyImgTou.setOnClickListener(this);
        mBinding.flyImgZhi.setOnClickListener(this);
        mBinding.tvSheType.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jiedao://街道
                selectJieDao();

                break;
            case R.id.tv_guimo://企业规模
                OptionPicker picker = new OptionPicker(this, mUType == 0 ? itmes : itmes1);

                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
              //  picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvGuimo.setText(s);
                        mTypeIndex = i + 1;  //企业规模(1规上企业 2小微企业 3三小场所)

                    }
                });
                picker.show();
                break;
            case R.id.tv_hangye://所属行业
                OptionPicker picker1 = new OptionPicker(this, mUType == 0 ? mHangye : mHangye1);
                picker1.setOffset(2);
                picker1.setSelectedIndex(1);
                picker1.setTextSize(16);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        if (i < 10) {
                            i++;
                        } else {
                            i = 0;
                        }
                        mHnagyeindex = i;
                        mBinding.tvHangye.setText(s);
                    }
                });
                picker1.show();
                break;
            case R.id.fly_img_tou:
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
            case R.id.fly_img_zhi:
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
            case R.id.tv_she_type://涉及类别
                dialogMoreChoice();
                break;
        }
    }

    /**
     * 多选
     */
    private void dialogMoreChoice() {

        final boolean selected[] = {false, false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择涉及类别");

        builder.setMultiChoiceItems(items, selected,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which,
                                        boolean isChecked) {
                    }
                });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                String txt = "";
                mTypeShe = "";
                for (int i = 0; i < selected.length; i++) {
                    if (selected[i]) {

                        if (TextUtils.isEmpty(txt)) {//
                            txt = items[i];
                            mTypeShe = String.valueOf(i + 1);
                        } else {
                            txt = txt + "、" + items[i];
                            mTypeShe = mTypeShe + "," + String.valueOf(i + 1);
                        }
                    }
                }

                mBinding.tvSheType.setText(txt);
            }
        });
        builder.create().show();
    }

    private void submitMessage() {
        String name = mBinding.etName.getText().toString().trim();
        String jiedao = mBinding.tvJiedao.getText().toString().trim();
        String zhizhao = mBinding.etZhizhao.getText().toString().trim();
        String ContactsName = mBinding.etContactsName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactsPhone.getText().toString().trim();
        String Mail = mBinding.etMail.getText().toString().trim();
        String Guimo = mBinding.tvGuimo.getText().toString().trim();
        String Hangye = mBinding.tvHangye.getText().toString().trim();
        String Mianji = mBinding.etMianji.getText().toString().trim();
        String Num = mBinding.etNum.getText().toString().trim();

        AddQiYeRequset addQiYeRequset = new AddQiYeRequset();

        addQiYeRequset.setBusinessLicenceCode(zhizhao);
        addQiYeRequset.setContactName(ContactsName);
        addQiYeRequset.setContactPhone(ContactsPhone);
        addQiYeRequset.setEmail(Mail);
        addQiYeRequset.setEnterpriseScale(String.valueOf(mTypeIndex));
        addQiYeRequset.setAreaId(fiveId);
        addQiYeRequset.setAreaRelation(fourId);
        addQiYeRequset.setDetailAddress(jiedao);
        addQiYeRequset.setAreaName(fiveName);
        addQiYeRequset.setFloorArea(Mianji);
        addQiYeRequset.setEmployeeNum(Num);
        addQiYeRequset.setPosition(DemoUtils.getLatitudeAndLongitude(aty));

        addQiYeRequset.setBusinessLicenceImg(DemoUtils.imageToBase64(mImgZhi));
        addQiYeRequset.setIndustry(String.valueOf(mHnagyeindex));
        addQiYeRequset.setReferType(String.valueOf(mTypeShe));

        if (mUType == 0) {
            addQiYeRequset.setEnterpriseName(name);
            addQiYeRequset.setEnterpriseDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
            Api.getApi().addQiYe(getRequestBody(addQiYeRequset), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
        } else if (mUType == 1) {
            addQiYeRequset.setPdpName(name);
            addQiYeRequset.setPdpDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
            Api.getApi().addPdp(getRequestBody(addQiYeRequset), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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

    private void updateMessage() {
        String name = mBinding.etName.getText().toString().trim();
        String jiedao = mBinding.tvJiedao.getText().toString().trim();
        String zhizhao = mBinding.etZhizhao.getText().toString().trim();
        String ContactsName = mBinding.etContactsName.getText().toString().trim();
        String ContactsPhone = mBinding.etContactsPhone.getText().toString().trim();
        String Mail = mBinding.etMail.getText().toString().trim();
        String Guimo = mBinding.tvGuimo.getText().toString().trim();
        String Hangye = mBinding.tvHangye.getText().toString().trim();
        String Mianji = mBinding.etMianji.getText().toString().trim();
        String Num = mBinding.etNum.getText().toString().trim();

        UpdateQiYeRequset addQiYeRequset = new UpdateQiYeRequset();
        addQiYeRequset.setId(mDataBean.getId());

        addQiYeRequset.setBusinessLicenceCode(zhizhao);
        addQiYeRequset.setContactName(ContactsName);
        addQiYeRequset.setContactPhone(ContactsPhone);
        addQiYeRequset.setEmail(Mail);
        addQiYeRequset.setEnterpriseScale(String.valueOf(mTypeIndex));
        addQiYeRequset.setAreaId(fiveId);
        addQiYeRequset.setAreaRelation(fourId);
        addQiYeRequset.setDetailAddress(jiedao);
        addQiYeRequset.setAreaName(fiveName);
        addQiYeRequset.setFloorArea(Mianji);
        addQiYeRequset.setEmployeeNum(Num);
        addQiYeRequset.setPosition(DemoUtils.getLatitudeAndLongitude(aty));
        addQiYeRequset.setReferType(String.valueOf(mTypeShe));


        if (!TextUtils.isEmpty(mImgZhi)) {
            addQiYeRequset.setBusinessLicenceImg(DemoUtils.imageToBase64(mImgZhi));
        }


        addQiYeRequset.setIndustry(String.valueOf(mHnagyeindex));
        if (mUType == 0) {
            addQiYeRequset.setEnterpriseName(name);
            if (!TextUtils.isEmpty(mImgHead)) {
                addQiYeRequset.setEnterpriseDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
            }
            Api.getApi().updateQiYe(getRequestBody(addQiYeRequset), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
        } else if (mUType == 1) {
            addQiYeRequset.setPdpName(name);
            if (!TextUtils.isEmpty(mImgHead)) {
                addQiYeRequset.setPdpDoorHeadImg(DemoUtils.imageToBase64(mImgHead));
            }
            Api.getApi().updatePdp(getRequestBody(addQiYeRequset), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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

    private String fiveName = "";
    private String fiveId = "";

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
            if (type == 1) {
                mImgHead = path;
                mBinding.tvAddTou.setVisibility(View.GONE);
                mBinding.imgTou.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.imgTou);
            } else if (type == 2) {

                LoadOcr(path);
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

    private void LoadOcr(String path) {
        showWaitDialog("正在识别中...");

        // 营业执照识别参数设置
        OcrRequestParams param = new OcrRequestParams();

        // 设置image参数
        param.setImageFile(new File(path));

        // 调用营业执照识别服务
        OCR.getInstance(aty).recognizeBusinessLicense(param, new OnResultListener<OcrResponseResult>() {
            @Override
            public void onResult(OcrResponseResult result) {
                hideWaitDialog();
                OcrModel model = null;
                try {
                    model = ParseJsonUtils.getBean(result.getJsonRes(), OcrModel.class);

                    String name = model.getWords_result().get单位名称().getWords();
                    String people = model.getWords_result().get法人().getWords();
                    String adddress = model.getWords_result().get地址().getWords();
                    mBinding.etName.setText("无".equals(name) ? "" : name);
                    mBinding.etContactsName.setText("无".equals(people) ? "" : people);
                    mBinding.etZhizhao.setText("无".equals(adddress) ? "" : adddress);

                } catch (Exception ex) {

                }

            }

            @Override
            public void onError(OCRError error) {
                hideWaitDialog();
                showToast(error.getMessage());
            }
        });
    }
}
