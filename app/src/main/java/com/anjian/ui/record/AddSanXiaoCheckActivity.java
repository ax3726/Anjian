package com.anjian.ui.record;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityAddQiyeCheckBinding;

public class AddSanXiaoCheckActivity extends BaseActivity<BasePresenter, ActivityAddQiyeCheckBinding> {


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_qiye_check;
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
        mTitleBarLayout.setTitle("三小场所隐患检查");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("新增");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(aty)
                        .setTitle("提示")
                        .setMessage("是否添加签名？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(AutographActivity.class);
                                dialog.dismiss();
                            }
                        })
                        .create().show();
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvYinhuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","隐患描述");
                startActivityForResult(intent,1001);
            }
        });
        mBinding.tvCuoshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","整改措施");
                startActivityForResult(intent,1002);
            }
        });
        mBinding.tvFalv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(aty, EditActivity.class);
                intent.putExtra("txt","法律依据");
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
                    mBinding.tvYinhuan.setText(result);
                    break;
                case 1002://数量
                    mBinding.tvCuoshi.setText(result);
                    break;
                case 1003://车间位置
                    mBinding.tvFalv.setText(result);
                    break;
            }

        }
    }
}
