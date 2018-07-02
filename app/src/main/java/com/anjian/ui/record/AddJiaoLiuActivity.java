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
import com.anjian.databinding.ActivityAddJiaoLiuBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.JiaoLiuListModel;
import com.anjian.model.request.AddJiaoLiuRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

public class AddJiaoLiuActivity extends PhotoActivity<BasePresenter, ActivityAddJiaoLiuBinding> {
    private String mImgPath = "";
    private String mImgQianMin = "";
    private JiaoLiuListModel.DataBean mDataBean = null;
    private String mId="";
    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_jiao_liu;
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
        mTitleBarLayout.setTitle("现场交流");
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
                                save();
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

    /**
     * 提交数据
     */
    private void save() {
        submitMessage();
    }

    @Override
    protected void initData() {
        super.initData();
        mDataBean = (JiaoLiuListModel.DataBean) getIntent().getSerializableExtra("data");
        mId=getIntent().getStringExtra("id");
        initView();
    }

    private void initView() {
        if (mDataBean == null) {
            return;
        }
        mTitleBarLayout.setRightShow(false);
        mBinding.tvQiye.setText(mDataBean.getEnterpriseName());
        mBinding.tvAddTimg.setVisibility(View.GONE);
        mBinding.img.setVisibility(View.VISIBLE);
        Glide.with(aty).load( DemoUtils.getUrl(mDataBean.getLocaleImg())).into(mBinding.img);
        mBinding.etName.setText(mDataBean.getMeetingName());
        mBinding.tvPeople.setText(mDataBean.getMeetingUser());
        mBinding.tvContent.setText(mDataBean.getMeetingContent());
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "参会人员");
                startActivityForResult(intent, 1001);
            }
        });
        mBinding.tvContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt", "会议内容");
                startActivityForResult(intent, 1002);
            }
        });
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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001:
                    mBinding.tvPeople.setText(result);
                    break;
                case 1002://
                    mBinding.tvContent.setText(result);
                    break;

            }

        }
        if (data != null && resultCode == 200) {
            mImgQianMin = data.getStringExtra("img_path");
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
        String Name = mBinding.etName.getText().toString().trim();
        String Content = mBinding.tvContent.getText().toString().trim();
        String People = mBinding.tvPeople.getText().toString().trim();
        if (TextUtils.isEmpty(mImgPath)) {
            showToast("请添加现场图片!");
            return;
        }
        if (TextUtils.isEmpty(Name)) {
            showToast("会议名称不能为空!");
            return;
        }
        if (TextUtils.isEmpty(People)) {
            showToast("参会人员不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Content)) {
            showToast("会议内容不能为空!");
            return;
        }
        AddJiaoLiuRequest addJiaoLiuRequest = new AddJiaoLiuRequest();
        addJiaoLiuRequest.setEnterpriseId(mId);
        addJiaoLiuRequest.setMeetingName(Name);
        addJiaoLiuRequest.setMeetingUser(People);
        addJiaoLiuRequest.setMeetingContent(Content);
        addJiaoLiuRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        if (!TextUtils.isEmpty(mImgQianMin)) {
            addJiaoLiuRequest.setSelferSign(DemoUtils.imageToBase64(mImgQianMin));
        }
        Api.getApi().addJiaoLiu(getRequestBody(addJiaoLiuRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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

    private void updateMessage() {
        String Name = mBinding.etName.getText().toString().trim();
        String Content = mBinding.tvContent.getText().toString().trim();
        String People = mBinding.tvPeople.getText().toString().trim();

        if (TextUtils.isEmpty(Name)) {
            showToast("会议名称不能为空!");
            return;
        }
        if (TextUtils.isEmpty(People)) {
            showToast("参会人员不能为空!");
            return;
        }
        if (TextUtils.isEmpty(Content)) {
            showToast("会议内容不能为空!");
            return;
        }
        AddJiaoLiuRequest addJiaoLiuRequest = new AddJiaoLiuRequest();
        addJiaoLiuRequest.setEnterpriseId(mId);
        addJiaoLiuRequest.setMeetingName(Name);
        addJiaoLiuRequest.setMeetingUser(People);
        addJiaoLiuRequest.setMeetingContent(Content);
        if (!TextUtils.isEmpty(mImgPath)) {
            addJiaoLiuRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        }
        Api.getApi().updateJiaoLiu(getRequestBody(addJiaoLiuRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());
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
