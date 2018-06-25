package com.anjian.ui.main;

import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<BasePresenter, ActivityLoginBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        mBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MainActivity.class);
                finish();
            }
        });
    }
}
