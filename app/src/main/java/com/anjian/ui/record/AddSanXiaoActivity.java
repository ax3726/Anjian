package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddQiyeBinding;
import com.anjian.databinding.ActivityAddSanXiaoBinding;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddSanXiaoActivity extends BaseActivity<BasePresenter,ActivityAddSanXiaoBinding> implements View.OnClickListener{


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

            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvType.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_type://所属类别
                OptionPicker picker1 = new OptionPicker(this, new String[]{
                        "人员密集场所", "三小场所", "出租屋", "其他"
                });
                picker1.setOffset(2);
                picker1.setSelectedIndex(1);
                picker1.setTextSize(16);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvType.setText(s);
                    }
                });
                picker1.show();
                break;
        }
    }
}
