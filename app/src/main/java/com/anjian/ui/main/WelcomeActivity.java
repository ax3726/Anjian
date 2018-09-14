package com.anjian.ui.main;

import android.text.TextUtils;
import android.view.View;

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
            UserModel user = CacheService.getIntance().getUser();
            String areaName = user.getAreaName();
            String title = "";
            if (!TextUtils.isEmpty(areaName) && areaName.length() > 1) {
                String sub = areaName.substring(0, 2);
                title = sub + "安全";
            } else {
                title = "金井安全";
            }
            mBinding.imgBg.setVisibility(View.GONE);
            mBinding.rlyBody.setVisibility(View.VISIBLE);
            mBinding.tvTitle.setText(title);
            Api.getApi().login(getRequestBody(new LoginRequset(CacheService.getIntance().getUser().getUser(), CacheService.getIntance().getUser().getPassword())))
                    .compose(callbackOnIOToMainThread())
                    .subscribe(new BaseNetListener<LoginModel>(this, false) {
                        @Override
                        public void onSuccess(LoginModel baseBean) {

                            if ("1".equals(baseBean.getData().getUserType())) {
                                MyApplication.getInstance().setToken(baseBean.getData().getToken());
                                user.setAreaName(baseBean.getData().getAreaName());
                                CacheService.getIntance().setUser(user);
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
                            } else {
                                showToast("该用户无法登陆！");
                                toLogin();
                            }

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
