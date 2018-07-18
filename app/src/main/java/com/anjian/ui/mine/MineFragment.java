package com.anjian.ui.mine;

import android.os.Bundle;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.base.BaseNetListener;
import com.anjian.common.Api;
import com.anjian.common.CacheService;
import com.anjian.common.MyApplication;
import com.anjian.databinding.FragmentMineBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.main.UserInfoModel;
import com.anjian.ui.main.LoginActivity;

/**
 * Created by LiMing on 2018/6/25.
 */

public class MineFragment extends BaseFragment<BaseFragmentPresenter, FragmentMineBinding> {

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBinding.btnTui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CacheService.getIntance().clearUser();
                startActivity(LoginActivity.class);
                aty.finish();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        getUserInfo();
    }

    private void getUserInfo() {
        Api.getApi().getUserInfo(MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<UserInfoModel>(this, true) {
                    @Override
                    public void onSuccess(UserInfoModel baseBean) {
                        setView(baseBean.getData());
                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
    }

    private void setView(UserInfoModel.DataBean dataBean) {
        if (dataBean == null) {
            return;
        }

        mBinding.tvName.setText(dataBean.getUserName());

    }
}
