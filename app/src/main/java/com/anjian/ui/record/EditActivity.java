package com.anjian.ui.record;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddFengXianBinding;
import com.anjian.databinding.ActivityEditBinding;

public class EditActivity extends BaseActivity<BasePresenter, ActivityEditBinding> {


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit;
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
        String txt = getIntent().getStringExtra("txt");
        mTitleBarLayout.setTitle(txt);
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String trim = mBinding.etBody.getText().toString().trim();
                if (!TextUtils.isEmpty(trim)) {
                    Intent intent = new Intent();
                    intent.putExtra("result",trim);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    showToast("请输入内容!");
                }

            }
        });
        mBinding.etBody.setHint("请输入" + txt);
    }

}
