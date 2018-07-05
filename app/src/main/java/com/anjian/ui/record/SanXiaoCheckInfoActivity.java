package com.anjian.ui.record;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityQiyeCheckInfoBinding;
import com.anjian.databinding.ActivityWeiHuaBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.QiYeCheckListModel;
import com.anjian.model.record.SanXiaoCheckListModel;
import com.anjian.model.request.UpdateQiYeCheckRequest;
import com.anjian.model.request.UpdateSanXiaoCheckRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

public class SanXiaoCheckInfoActivity extends PhotoActivity<BasePresenter, ActivityQiyeCheckInfoBinding> {


    private String mImgPath = "";
    private SanXiaoCheckListModel.DataBean mDataBean = null;

    private String mImgPath1 = "";
    private String mImgPath2 = "";
    private String mImgPath3 = "";

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_qiye_check_info;
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
        mTitleBarLayout.setTitle("三小场所隐患检查");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    protected void initData() {
        super.initData();
        mDataBean = (SanXiaoCheckListModel.DataBean) getIntent().getSerializableExtra("data");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);
        mBinding.tvName.setText(mDataBean.getDangerDesc());
        mBinding.tvNum.setText(DemoUtils.getTime(mDataBean.getCreateTime()));

        if (mDataBean.getModifyStatus() == 1) {
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.imgZheng.setVisibility(View.VISIBLE);
            Glide.with(aty).load(DemoUtils.getUrl(mDataBean.getModifyImg())).into(mBinding.imgZheng);
            mBinding.flyZhengImg.setEnabled(false);
        }

    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.flyZhengImg.setOnClickListener(new View.OnClickListener() {
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
        mBinding.llyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, AddSanXiaoCheckActivity.class);
                intent.putExtra("data", mDataBean);
                startActivity(intent);
            }
        });
    }

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
            mImgPath = path;
            mBinding.tvAddTimg.setVisibility(View.GONE);
            mBinding.imgZheng.setVisibility(View.VISIBLE);
            Glide.with(aty).load(file).into(mBinding.imgZheng);
        }
    }

    @Override
    public void photoFaild() {
        showToast("图片加载失败!");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == 200) {
            mImgPath1 = data.getStringExtra("img_path1");
            mImgPath2 = data.getStringExtra("img_path2");
            mImgPath3 = data.getStringExtra("img_path3");
            submitMessage();
        }
    }

    private void submitMessage() {


        UpdateSanXiaoCheckRequest updateSanXiaoCheckRequest = new UpdateSanXiaoCheckRequest();
        updateSanXiaoCheckRequest.setId(mDataBean.getId());
        updateSanXiaoCheckRequest.setTspId(mDataBean.getTspId());
        updateSanXiaoCheckRequest.setOptionId(mDataBean.getOptionId());

        updateSanXiaoCheckRequest.setModifyImg(DemoUtils.imageToBase64(mImgPath));
        if (!TextUtils.isEmpty(mImgPath1)) {
            updateSanXiaoCheckRequest.setSaferSign(DemoUtils.imageToBase64(mImgPath1));
        }

        if (!TextUtils.isEmpty(mImgPath2)) {
            updateSanXiaoCheckRequest.setBusinesserSign(DemoUtils.imageToBase64(mImgPath2));
        }
        if (!TextUtils.isEmpty(mImgPath3)) {
            updateSanXiaoCheckRequest.setWitherSign(DemoUtils.imageToBase64(mImgPath3));
        }
        Api.getApi().updateSanXiaoCheck(getRequestBody(updateSanXiaoCheckRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
