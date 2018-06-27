package com.anjian.ui.record;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityWeiHuaBinding;
import com.lm.base.library.adapters.recyclerview.CommonAdapter;
import com.lm.base.library.adapters.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TeZhongActivity extends BaseActivity<BasePresenter, ActivityWeiHuaBinding> {


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
        mTitleBarLayout.setTitle("特种设备");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.record_add_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(AddWeiHuaActivity.class);
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
        mCommonAdapter = new CommonAdapter<String>(aty, R.layout.item_wei_hua, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);

    }
}
