package com.anjian.ui.main;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity<BasePresenter, ActivityWelcomeBinding> {

    @Override
    protected void initData() {
        super.initData();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                startActivity(LoginActivity.class);
                finish();
            }
        }.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }
}
