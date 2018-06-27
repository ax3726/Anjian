package com.anjian.ui.record;

import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddQiyeBinding;

import cn.qqtheme.framework.picker.OptionPicker;

public class AddQiyeActivity extends BaseActivity<BasePresenter,ActivityAddQiyeBinding> implements View.OnClickListener{


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

        mTitleBarLayout.setTitle("企业信息");
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
        mBinding.tvGuimo.setOnClickListener(this);
        mBinding.tvHangye.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_guimo://企业规模
                OptionPicker picker = new OptionPicker(this, new String[]{
                        "上规企业", "下规企业"
                });
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(16);
                picker.setCycleDisable(true); //选项不循环滚动
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvGuimo.setText(s);
                    }
                });
                picker.show();
                break;
            case R.id.tv_hangye://所属行业
                OptionPicker picker1 = new OptionPicker(this, new String[]{
                        "冶金", "有色金属", "机械", "纺织", "轻工", "化工", "医药", "建材", "烟草", "烟草爆竹", "其他"
                });
                picker1.setOffset(2);
                picker1.setSelectedIndex(1);
                picker1.setTextSize(16);
                picker1.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int i, String s) {
                        mBinding.tvHangye.setText(s);
                    }
                });
                picker1.show();
                break;
        }
    }
}
