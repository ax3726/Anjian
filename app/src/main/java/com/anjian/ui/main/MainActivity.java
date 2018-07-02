package com.anjian.ui.main;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.databinding.ActivityMainBinding;
import com.anjian.prestener.main.MainPrestener;
import com.anjian.ui.manage.ManageFragment;
import com.anjian.ui.message.MessageFragment;
import com.anjian.ui.mine.MineFragment;
import com.anjian.ui.record.RecordFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPrestener, ActivityMainBinding> {

    private MessageFragment mMessageFragment;
    private RecordFragment mRecordFragment;
    private ManageFragment mManageFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFm;
    private FragmentTransaction mTransaction;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initData() {
        super.initData();
        mBinding.rgButtom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.rb_message:
                        if (currentFragmentPosition != 0) {
                            changeFragment(0);
                        }
                        break;
                    case R.id.rb_record:
                        if (currentFragmentPosition != 1) {
                            changeFragment(1);
                        }
                        break;
                    case R.id.rb_manage:
                        if (currentFragmentPosition != 2) {
                            changeFragment(2);
                        }
                        break;
                    case R.id.rb_mine:
                        if (currentFragmentPosition != 3) {
                            changeFragment(3);
                        }
                        break;
                }
            }
        });
        initFragment();
    }

    @Override
    protected MainPrestener createPresenter() {
        return new MainPrestener();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

    }

    private void initFragment() {
        mMessageFragment = new MessageFragment();
        mRecordFragment = new RecordFragment();
        mManageFragment = new ManageFragment();
        mMineFragment = new MineFragment();

        mFragments.add(mMessageFragment);
        mFragments.add(mRecordFragment);
        mFragments.add(mManageFragment);
        mFragments.add(mMineFragment);

        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        mTransaction.add(R.id.fly_contain, mMessageFragment);
        mTransaction.show(mFragments.get(0));
        mTransaction.commitAllowingStateLoss();
    }

    private int currentFragmentPosition = 0;

    public void changeFragment(final int position) {
        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        if (position != currentFragmentPosition) {
            mTransaction.hide(mFragments.get(currentFragmentPosition));
            if (!mFragments.get(position).isAdded()) {
                mTransaction.add(R.id.fly_contain, mFragments.get(position));
            }
            mTransaction.show(mFragments.get(position));
            mTransaction.commitAllowingStateLoss();
        }
        currentFragmentPosition = position;
    }

}
