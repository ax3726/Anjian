package com.anjian.ui.main;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.CacheService;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityWelcomeBinding;
import com.anjian.model.UserModel;
import com.anjian.model.main.LoginModel;
import com.anjian.model.request.LoginRequset;

public class WelcomeActivity extends BaseActivity<BasePresenter, ActivityWelcomeBinding> {

    @Override
    protected void initData() {
        super.initData();
        if (CacheService.getIntance().isLogin()) {
            Api.getApi().login(getRequestBody(new LoginRequset(CacheService.getIntance().getUser().getUser(), CacheService.getIntance().getUser().getPassword())))
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<LoginModel>(this, false) {
                        @Override
                        public void onSuccess(LoginModel baseBean) {
                            MyApplication.getInstance().setToken(baseBean.getData());
                            new Thread() {
                                @Override
                                public void run() {
                                    super.run();
                                    try {
                                        sleep(1500);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    startActivity(MainActivity.class);
                                    finish();
                                }
                            }.start();
                        }

                        @Override
                        public void onFail(String errMsg) {
                            toLogin();
                        }
                    });
        } else {
            toLogin();
        }


    }

    private void toLogin() {
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
