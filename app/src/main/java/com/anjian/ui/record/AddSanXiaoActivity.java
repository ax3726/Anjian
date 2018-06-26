package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddQiyeBinding;
import com.anjian.databinding.ActivityAddSanXiaoBinding;

public class AddSanXiaoActivity extends BaseActivity<BasePresenter,ActivityAddSanXiaoBinding> {


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
}
