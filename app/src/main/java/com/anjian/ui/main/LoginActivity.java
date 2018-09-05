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
import com.anjian.databinding.ActivityLoginBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.UserModel;
import com.anjian.model.main.LoginModel;
import com.anjian.model.request.LoginRequset;


import org.reactivestreams.Subscription;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import static okhttp3.MediaType.*;

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
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        String phone = mBinding.etPhone.getText().toString().trim();
        String password = mBinding.etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            showToast("用户名不能为空!");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空!");
            return;
        }

        Api.getApi().login(getRequestBody(new LoginRequset(phone, password))).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<LoginModel>(this, true) {
            @Override
            public void onSuccess(LoginModel baseBean) {
                if ("1".equals(baseBean.getData().getUserType())) {
                    MyApplication.getInstance().setToken(baseBean.getData().getToken());
                    CacheService.getIntance().setUser(new UserModel(phone, password));
                    startActivity(MainActivity.class);
                    finish();
                } else {
                    showToast("该用户无法登陆！");
                }


            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}


