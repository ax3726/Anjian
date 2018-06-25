package com.anjian.ui.main;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityMainBinding;
import com.anjian.prestener.main.MainPrestener;

import java.io.IOException;

public class MainActivity extends BaseActivity<MainPrestener,ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("安监");
    }

    @Override
    protected MainPrestener createPresenter() {
        return new MainPrestener();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mBinding.lvQianming.setBackColor(Color.WHITE);
    }

    public void save(View view)
    {
        if (mBinding.lvQianming.getTouched()) {
            try {
                mBinding.lvQianming.save(MyApplication.getBase_Path()+ "/test.png" , true, 10);
                mBinding.lvQianming.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showToast("您没有签名~");
        }
    }

    public void clear(View view)
    {
        mBinding.lvQianming.clear();
    }
}
