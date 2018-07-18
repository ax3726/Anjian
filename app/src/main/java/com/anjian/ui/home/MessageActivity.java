package com.anjian.ui.home;

import android.support.v4.app.Fragment;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityMessageBinding;
import com.anjian.ui.CommonPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends BaseActivity<BasePresenter,ActivityMessageBinding> {
    private List<String> title = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private SysMessageFragment mSysMessageFragment;//系统消息
    private PersonMessageFragment mPersonMessageFragment;//个人消息
    private CommonPagerAdapter mMyPagerAdapter;
    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("消息");
    }
    @Override
    protected void initData() {
        super.initData();
        title.add("系统消息");
        title.add("个人消息");

        mSysMessageFragment=new SysMessageFragment();
        mPersonMessageFragment=new PersonMessageFragment();

        fragments.add(mSysMessageFragment);
        fragments.add(mPersonMessageFragment);
        initTablayout();


    }

    private void initTablayout() {
        mMyPagerAdapter = new CommonPagerAdapter(getSupportFragmentManager(), title, fragments);

        mBinding.viewPager.setAdapter(mMyPagerAdapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
    }

}
