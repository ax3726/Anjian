package com.anjian.ui.record;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityFengXianBinding;
import com.lm.base.library.adapters.recyclerview.CommonAdapter;
import com.lm.base.library.adapters.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class FengXianActivity extends BaseActivity<BasePresenter, ActivityFengXianBinding> {


    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mCommonAdapter;


    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_feng_xian;
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
        mTitleBarLayout.setTitle("安全生产风险辨识");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.record_add_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(AddFengXianActivity.class);
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
        mCommonAdapter = new CommonAdapter<String>(aty, R.layout.item_company_list, mDataList) {
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
