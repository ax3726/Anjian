package com.anjian.ui.record;

import android.content.Intent;
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
    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","详细位置");
                startActivityForResult(intent,1001);
            }
        });
        mBinding.tvShigu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","易引发事故的类型");
                startActivityForResult(intent,1002);
            }
        });
        mBinding.tvSuoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","伤亡/财产损失预测");
                startActivityForResult(intent,1003);
            }
        });
        mBinding.tvZhengai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","整改措施");
                startActivityForResult(intent,1004);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null&&resultCode==RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001:
                    mBinding.tvAddress.setText(result);
                    break;
                case 1002://数量
                    mBinding.tvShigu.setText(result);
                    break;
                case 1003://车间位置
                    mBinding.tvSuoshi.setText(result);
                    break;
                case 1004://车间位置
                    mBinding.tvZhengai.setText(result);
                    break;
            }

        }
    }
}
