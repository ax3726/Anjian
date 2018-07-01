package com.anjian.ui.record;

import android.content.Intent;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityAutographBinding;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AutographActivity extends BaseActivity<BasePresenter, ActivityAutographBinding> {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_autograph;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void save(View view) {
        if (mBinding.lvBody.getTouched()) {
            try {
                SimpleDateFormat t = new SimpleDateFormat("yyyyMMddssSSS");
                String filename = "QM" + (t.format(new Date())) + ".jpg";
                mBinding.lvBody.save(MyApplication.getBase_Path() + "/" + filename, true, 10);
                mBinding.lvBody.clear();
                Intent intent = new Intent();
                intent.putExtra("img_path", MyApplication.getBase_Path() + "/" + filename);
                setResult(200, intent);
                finish();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showToast("您没有签名~");
        }
    }

    public void clear(View view) {
        mBinding.lvBody.clear();
    }
}
