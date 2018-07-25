package com.anjian.ui.record;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddFengXianBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.FengXianListModel;
import com.anjian.model.request.AddFengXianRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddFengXianActivity extends PhotoActivity<BasePresenter, ActivityAddFengXianBinding> {

    private String mImgPath = "";//图片路径
    private FengXianListModel.DataBean mDataBean = null;
    private String mId = "";
    private String mTypeShe = "";

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_feng_xian;
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
        mTitleBarLayout.setTitle("新增风险");
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

    @Override
    protected void initData() {
        super.initData();
        mDataBean = (FengXianListModel.DataBean) getIntent().getSerializableExtra("data");
        mId = getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mTitleBarLayout.setRightTxt("");

        mBinding.tvAddTimg.setVisibility(View.GONE);
        mBinding.img.setVisibility(View.VISIBLE);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);
        mBinding.etName.setText(mDataBean.getDangerName());

        mBinding.etName.setFocusable(false);
        mBinding.etName.setFocusableInTouchMode(false);

        mBinding.tvAddress.setText(mDataBean.getDetailPosition());
        mBinding.tvFengxian.setText(mDataBean.getDangerLevel());

        if (!TextUtils.isEmpty(mDataBean.getEasyHappenCaseType())) {
            String[] split = mDataBean.getEasyHappenCaseType().split(",");

            if (split.length > 0) {

                String txts = "";
                for (String str : split) {
                    int i = Integer.valueOf(str);
                    if (TextUtils.isEmpty(txts)) {//
                        txts = items[i - 1];
                    } else {
                        txts = txts + "、" + items[i - 1];

                    }
                }
                mBinding.tvShigu.setText(txts);
            }

        }





      /*  mBinding.tvSuoshi.setText(mDataBean.getLossPrediction());
        mBinding.tvZhengai.setText(mDataBean.getModifyStep());*/


        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class, DemoUtils.getUrl(mDataBean.getLocaleImg()));
            }
        });
    }

    private String items[] = {"火药爆炸", "物体打击", "车辆伤害", "机械伤害", "起重伤害", "触电", "淹溺", "灼烫", "高处坠落",
            "坍塌", "冒顶片帮", "透水", "锅炉爆炸", "容器爆炸", "其他爆炸", "中毒和窒息", "其他伤害"};

    /**
     * 多选
     */
    private void dialogMoreChoice() {

        final boolean selected[] = {false, false, false, false, false, false, false, false, false, false, false, false, false
                , false, false, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("选择易引发事故的类型");

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

                mBinding.tvShigu.setText(txt);
            }
        });
        builder.create().show();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        if (mDataBean != null) {
            return;
        }
        mBinding.tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "详细位置");
                startActivityForResult(intent, 1001);
            }
        });
        mBinding.tvShigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogMoreChoice();
            }
        });
      /*  mBinding.tvSuoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "伤亡/财产损失预测");
                startActivityForResult(intent, 1003);
            }
        });
        mBinding.tvZhengai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "整改措施");
                startActivityForResult(intent, 1004);
            }
        });*/
        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        mBinding.tvFengxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionPicker picker = new OptionPicker(aty, new String[]{
                        "A", "B", "C", "D"
                });

                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvFengxian.setText(s);
                    }
                });
                picker.show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001:
                    mBinding.tvAddress.setText(result);
                    break;
                case 1002://数量
                    mBinding.tvShigu.setText(result);
                    break;
              /*  case 1003://车间位置
                    mBinding.tvSuoshi.setText(result);
                    break;
                case 1004://车间位置
                    mBinding.tvZhengai.setText(result);
                    break;*/
            }

        }
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            mImgPath = path;
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.img.setVisibility(View.VISIBLE);
            Glide.with(aty).load(file).into(mBinding.img);
        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }


    private void submitMessage() {
        String Name = mBinding.etName.getText().toString().trim();
        String Address = mBinding.tvAddress.getText().toString().trim();
        String Fengxian = mBinding.tvFengxian.getText().toString().trim();
        String Shigu = mBinding.tvShigu.getText().toString().trim();
     /*   String Suoshi = mBinding.tvSuoshi.getText().toString().trim();
        String Zhengai = mBinding.tvZhengai.getText().toString().trim();*/
        if (TextUtils.isEmpty(mImgPath)) {
            showToast("请添加现场图片!");
            return;
        }
        if (TextUtils.isEmpty(Name)) {
            showToast("风险点名称不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Address)) {
            showToast("详细地址不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Fengxian)) {
            showToast("请选择风险等级!");
            return;
        }

        if (TextUtils.isEmpty(mTypeShe)) {
            showToast("易引发事故的类型不能为空!");
            return;
        }
     /*   if (TextUtils.isEmpty(Suoshi)) {
            showToast("伤亡/财产损失预测不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Zhengai)) {
            showToast("整改措施不能为空!");
            return;
        }*/
        AddFengXianRequest addFengXianRequest = new AddFengXianRequest();

        addFengXianRequest.setDangerName(Name);
        addFengXianRequest.setDetailPosition(Address);
        addFengXianRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        addFengXianRequest.setEasyHappenCaseType(mTypeShe);
        //   addFengXianRequest.setLossPrediction(Suoshi);
        addFengXianRequest.setDangerLevel(Fengxian);
        //   addFengXianRequest.setModifyStep(Zhengai);
        if (mUType == 0) {
            addFengXianRequest.setEnterpriseId(mId);
            Api.getApi().addFengXian(getRequestBody(addFengXianRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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

        } else if (mUType == 1) {
            addFengXianRequest.setPdpId(mId);
            Api.getApi().addFengXian1(getRequestBody(addFengXianRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
