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
import com.anjian.databinding.ActivityAddYanLianBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.YanLianListModel;
import com.anjian.model.request.AddYanLianRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

public class AddYanLianActivity extends PhotoActivity<BasePresenter, ActivityAddYanLianBinding> {

    private String mImgPei="";//培训照片
    private String mImgYan="";//演练照片
    private String mImgQianMin="";//
    private int type = 0;
    private String mId="";
    private YanLianListModel.DataBean mDataBean=null;
    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_yan_lian;
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
        mTitleBarLayout.setTitle("培训演练");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
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
                                submitMessage();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivityForResult(AutographActivity.class, 100);
                                dialog.dismiss();
                            }
                        })
                        .create().show();

            }
        });
    }
    @Override
    protected void initData() {
        super.initData();
        mDataBean = (YanLianListModel.DataBean) getIntent().getSerializableExtra("data");
        mId= getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mTitleBarLayout.setRightTxt("");

        mBinding.tvAddTimg.setVisibility(View.GONE);
        mBinding.img.setVisibility(View.VISIBLE);

        mBinding.tvAddTimg1.setVisibility(View.GONE);
        mBinding.img1.setVisibility(View.VISIBLE);

        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleTeachImg())).into(mBinding.img);
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleActImg())).into(mBinding.img1);
        mBinding.etName.setText(mDataBean.getTitle());

        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getLocaleTeachImg()));
            }
        });


        mBinding.flyImg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getLocaleActImg()));
            }
        });
    }
    @Override
    protected void initEvent() {
        super.initEvent();
        if (mDataBean != null) {
            return;
        }
        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type=1;
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
                type=2;
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
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            if (type == 1) {
                mImgPei = path;
                mBinding.tvAddTimg.setVisibility(View.GONE);
                mBinding.img.setVisibility(View.VISIBLE);
                Glide.with(aty).load(file).into(mBinding.img);
            } else if (type == 2) {
                mImgYan = path;
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
        String Name = mBinding.etName.getText().toString().trim();
        if (TextUtils.isEmpty(Name)) {
            showToast("请添加标题!");
            return;
        }
        if (TextUtils.isEmpty(mImgPei)) {
            showToast("请添加现场培训照片!");
            return;
        }
        if (TextUtils.isEmpty(mImgYan)) {
            showToast("请添加现场演练照片!");
            return;
        }
        AddYanLianRequest addYanLianRequest=new AddYanLianRequest();

        addYanLianRequest.setTitle(Name);
        addYanLianRequest.setLocaleTeachImg(DemoUtils.imageToBase64(mImgPei));
        addYanLianRequest.setLocale_act_img(DemoUtils.imageToBase64(mImgYan));
        if (!TextUtils.isEmpty(mImgQianMin)) {
            addYanLianRequest.setSelfer_sign(DemoUtils.imageToBase64(mImgQianMin));
        }
        if (mUType==0) {
            addYanLianRequest.setTspId(mId);
            Api.getApi().addYanLian(getRequestBody(addYanLianRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
            addYanLianRequest.setLetId(mId);
            Api.getApi().addYanLian1(getRequestBody(addYanLianRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == 200) {
            mImgQianMin = data.getStringExtra("img_path");
            submitMessage();
        }
    }
}
