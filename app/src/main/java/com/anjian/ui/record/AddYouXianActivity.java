package com.anjian.ui.record;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAddWeiHuaBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.YouXianListModel;
import com.anjian.model.request.AddYouXianRequest;
import com.anjian.ui.common.PhotoActivity;
import com.anjian.ui.common.PhotoPreviewActivity;
import com.anjian.utils.DemoUtils;
import com.anjian.widget.popupwindow.SelectPhotopopuwindow;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

public class AddYouXianActivity extends PhotoActivity<BasePresenter, ActivityAddWeiHuaBinding> {

    private String mImgPath = "";
    private YouXianListModel.DataBean mDataBean = null;
    private String mId="";
    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_wei_hua;
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
        mBinding.tvAddTimg.setText("点击添加有限空间照片");
        mTitleBarLayout.setTitle("有限空间");
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
        mDataBean = (YouXianListModel.DataBean) getIntent().getSerializableExtra("data");
        mId=getIntent().getStringExtra("id");
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
        mBinding.tvName.setText(mDataBean.getSpaceName());
        mBinding.tvNum.setText(String.valueOf(mDataBean.getSpaceNum()));
        mBinding.tvAddress.setText(mDataBean.getWorkPosition());

        mBinding.flyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityUrl(PhotoPreviewActivity.class,DemoUtils.getUrl(mDataBean.getLocaleImg()));
            }
        });
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
        String Name = mBinding.tvName.getText().toString().trim();
        String Num = mBinding.tvNum.getText().toString().trim();
        String Address = mBinding.tvAddress.getText().toString().trim();
        if (TextUtils.isEmpty(mImgPath)) {
            showToast("请添加现场图片!");
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
        AddYouXianRequest addWeiHuaRequest = new AddYouXianRequest();

        addWeiHuaRequest.setEnterpriseId(mId);
        addWeiHuaRequest.setSpaceName(Name);
        addWeiHuaRequest.setSpaceNum(Num);
        addWeiHuaRequest.setWorkPosition(Address);
        addWeiHuaRequest.setLocaleImg(DemoUtils.imageToBase64(mImgPath));
        Api.getApi().addYouXian(getRequestBody(addWeiHuaRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
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
