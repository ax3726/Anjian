package com.anjian.ui.record;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentRecordBinding;
import com.anjian.ui.CommonPagerAdapter;
import com.anjian.widget.popupwindow.SelectCompanywindow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiMing on 2018/6/25.
 */

public class RecordFragment extends BaseFragment<BaseFragmentPresenter, FragmentRecordBinding> {
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private CompanyListFragment mQiYeFragment;//企业
    private CompanyListFragment mSanXiaoFragment;//三小
    private CommonPagerAdapter mMyPagerAdapter;

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_record;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setLeftImg(R.drawable.record_add_icon);
        mTitleBarLayout.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectCompanywindow selectCompanywindow = new SelectCompanywindow(aty);
                selectCompanywindow.setSelectCompanyListener(new SelectCompanywindow.SelectCompanyListener() {
                    @Override
                    public void onQiye() {
                        startActivity(AddQiyeActivity.class);
                    }

                    @Override
                    public void onSanXiao() {
                        startActivity(AddSanXiaoActivity.class);
                    }
                });
                selectCompanywindow.showPopupWindow();

            }
        });
        mTitleBarLayout.setTitle("记录");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.record_search_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(SearchActivity.class);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        title.add("看企业");
        title.add("三小场所");

        mQiYeFragment = new CompanyListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        mQiYeFragment.setArguments(bundle);

        mSanXiaoFragment = new CompanyListFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("type", 1);
        mSanXiaoFragment.setArguments(bundle1);

        fragments.add(mQiYeFragment);
        fragments.add(mSanXiaoFragment);
        initTablayout();
    }

    private void initTablayout() {
        mMyPagerAdapter = new CommonPagerAdapter(getFragmentManager(), title, fragments);

        mBinding.viewPager.setAdapter(mMyPagerAdapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
    }
}
