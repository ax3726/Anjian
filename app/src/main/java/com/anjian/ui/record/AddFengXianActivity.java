package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddFengXianBinding;
import com.anjian.databinding.ActivityFengXianBinding;

public class AddFengXianActivity extends BaseActivity<BasePresenter, ActivityAddFengXianBinding> {


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

            }
        });
    }
}
