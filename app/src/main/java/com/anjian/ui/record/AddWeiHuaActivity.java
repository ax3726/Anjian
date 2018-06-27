package com.anjian.ui.record;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddFengXianBinding;
import com.anjian.databinding.ActivityAddWeiHuaBinding;

public class AddWeiHuaActivity extends BaseActivity<BasePresenter, ActivityAddWeiHuaBinding> {


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_wei_hua;
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
        mTitleBarLayout.setTitle("危化品情况");
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
        mBinding.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","名称");
                startActivityForResult(intent,1001);
            }
        });
        mBinding.tvNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","数量");
                startActivityForResult(intent,1002);
            }
        });
        mBinding.tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","车间位置");
                startActivityForResult(intent,1003);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null&&resultCode==RESULT_OK) {
            String result = data.getStringExtra("result");
            switch (requestCode) {
                case 1001://名称
                    mBinding.tvName.setText(result);
                    break;
                case 1002://数量
                    mBinding.tvNum.setText(result);
                    break;
                case 1003://车间位置
                    mBinding.tvAddress.setText(result);
                    break;
            }

        }
    }
}
