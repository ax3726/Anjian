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
import com.anjian.databinding.ActivityAddQiyeCheckBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.SanXiaoCheckListModel;
import com.anjian.model.request.AddSanXiaoCheckRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddSanXiaoCheckActivity extends PhotoActivity<BasePresenter, ActivityAddQiyeCheckBinding> {
    private String mImgPath = "";
    private String mId = "";

    private String mImgPath1 = "";
    private String mImgPath2 = "";
    private String mImgPath3 = "";
    private SanXiaoCheckListModel.DataBean mDataBean = null;
    private int mDay = -1;

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_qiye_check;
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
        mId = getIntent().getStringExtra("id");

        mDataBean = (SanXiaoCheckListModel.DataBean) getIntent().getSerializableExtra("data");
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
        mBinding.tvYinhuan.setText(mDataBean.getDangerDesc());
        mBinding.tvZhenggai.setText(mDataBean.getModifyExpire()+"天");
      /*  mBinding.tvCuoshi.setText(mDataBean.getModifyStep());
        mBinding.tvFalv.setText(mDataBean.getLawReason());*/

        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class, DemoUtils.getUrl(mDataBean.getLocaleImg()));
            }
        });

    }

    private void save() {
        submitMessage();
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("隐患排查");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("新增");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataBean != null) {
                    return;
                }
                new AlertDialog.Builder(aty)
                        .setTitle("提示")
                        .setMessage("是否添加签名？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                save();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(aty, AutographActivity.class);
                                intent.putExtra("type", 1);
                                startActivityForResult(intent, 100);
                                dialog.dismiss();
                            }
                        })
                        .create().show();
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        if (mDataBean != null) {
            return;
        }
        mBinding.tvYinhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "隐患描述");
                startActivityForResult(intent, 1001);
            }
        });
     /*   mBinding.tvCuoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "整改措施");
                startActivityForResult(intent, 1002);
            }
        });
        mBinding.tvFalv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "法律依据");
                startActivityForResult(intent, 1003);
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
        mBinding.tvZhenggai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = new String[15];
                for (int i = 0; i < 15; i++) {
                    strings[i] = (i + 1) + "天";
                }

                OptionPicker picker = new OptionPicker(aty, strings);

                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mDay = i + 1;
                        mBinding.tvZhenggai.setText(s);
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
                case 1001://名称
                    mBinding.tvYinhuan.setText(result);
                    break;
             /*   case 1002://数量
                    mBinding.tvCuoshi.setText(result);
                    break;
                case 1003://车间位置
                    mBinding.tvFalv.setText(result);
                    break;*/
            }

        }
        if (data != null && resultCode == 200) {
            mImgPath1 = data.getStringExtra("img_path1");
            mImgPath2 = data.getStringExtra("img_path2");
            mImgPath3 = data.getStringExtra("img_path3");
            save();
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
        String Yinhuan = mBinding.tvYinhuan.getText().toString().trim();
   /*     String Cuoshi = mBinding.tvCuoshi.getText().toString().trim();
        String Falv = mBinding.tvFalv.getText().toString().trim();*/
        if (TextUtils.isEmpty(mImgPath)) {
            showToast("请添加隐患图片!");
            return;
        }
        if (TextUtils.isEmpty(Yinhuan)) {
            showToast("隐患描述不能为空!");
            return;
        }
        if (mDay == -1) {
            showToast("请选择期限!");
            return;
        }
      /*  if (TextUtils.isEmpty(Cuoshi)) {
            showToast("整改措施不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Falv)) {
            showToast("法律依据不能为空!");
            return;
        }*/

        AddSanXiaoCheckRequest addSanXiaoCheckRequest = new AddSanXiaoCheckRequest();

        addSanXiaoCheckRequest.setDangerDesc(Yinhuan);
        addSanXiaoCheckRequest.setModifyExpire(mDay);
     /*   addSanXiaoCheckRequest.setModifyStep(Cuoshi);
        addSanXiaoCheckRequest.setLawReason(Falv);*/
        addSanXiaoCheckRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        if (!TextUtils.isEmpty(mImgPath1)) {
            addSanXiaoCheckRequest.setSaferSign(DemoUtils.imageToBase64(mImgPath1));
        }
        if (!TextUtils.isEmpty(mImgPath2)) {
            addSanXiaoCheckRequest.setBusinesserSign(DemoUtils.imageToBase64(mImgPath2));
        }
        if (!TextUtils.isEmpty(mImgPath3)) {
            addSanXiaoCheckRequest.setWitherSign(DemoUtils.imageToBase64(mImgPath3));
        }

        if (mUType==0) {
            addSanXiaoCheckRequest.setTspId(mId);
            Api.getApi().addSanXiaoCheck(getRequestBody(addSanXiaoCheckRequest), MyApplication.getInstance().getToken())
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<BaseBean>(this, true) {
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
            addSanXiaoCheckRequest.setLetId(mId);
            Api.getApi().addSanXiaoCheck1(getRequestBody(addSanXiaoCheckRequest), MyApplication.getInstance().getToken())
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<BaseBean>(this, true) {
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
        } else if (mUType==2) {
            addSanXiaoCheckRequest.setOtpId(mId);
            Api.getApi().addSanXiaoCheck2(getRequestBody(addSanXiaoCheckRequest), MyApplication.getInstance().getToken())
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<BaseBean>(this, true) {
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
