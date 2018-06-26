package com.anjian.ui.record;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentCompanylistBinding;
import com.lm.base.library.adapters.recyclerview.CommonAdapter;
import com.lm.base.library.adapters.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class CompanyListFragment extends BaseFragment<BaseFragmentPresenter, FragmentCompanylistBinding> {
    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mCommonAdapter;
    private int mType = 0;  //0 企业  1三小

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_companylist;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        mType = getArguments().getInt("type", 0);
        mBinding.tvHint.setText(mType == 0 ? "在您附近的企业" : "在您附近的三小场所");
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
                        if (mType == 0) {//企业
                            startActivity(QiYeActivity.class);
                        } else {
                            startActivity(SanXiaoActivity.class);
                        }
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);

    }
}
