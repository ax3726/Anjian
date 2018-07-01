package com.anjian.ui.record;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityWeiHuaBinding;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

public class SanXiaoCheckInfoActivity extends BaseActivity<BasePresenter, ActivityWeiHuaBinding> {


    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mCommonAdapter;


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wei_hua;
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
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();

        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mCommonAdapter = new CommonAdapter<String>(aty, R.layout.item_qiye_check_info, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(AddSanXiaoCheckActivity.class);
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);

    }
}
