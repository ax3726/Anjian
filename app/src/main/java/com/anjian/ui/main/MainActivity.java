package com.anjian.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.databinding.ActivityMainBinding;
import com.anjian.prestener.main.MainPrestener;
import com.anjian.ui.manage.ManageFragment;
import com.anjian.ui.home.HomeFragment;
import com.anjian.ui.mine.MineFragment;
import com.anjian.ui.record.RecordFragment;
import com.anjian.utils.DemoUtils;
import com.anjian.utils.DoubleClickExitHelper;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MainPrestener, ActivityMainBinding> {

    private HomeFragment mHomeFragment;
    private RecordFragment mRecordFragment;
    private ManageFragment mManageFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFm;
    private FragmentTransaction mTransaction;
    private List<Fragment> mFragments = new ArrayList<>();
    private DoubleClickExitHelper mDoubleClickExit;//

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
        mBinding.tvRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.rbRecord.setChecked(true);
                if (currentFragmentPosition != 1) {
                    changeFragment(1);
                }
            }
        });
        initFragment();
        DemoUtils.getLocation(aty);
        inintVersion();
    }

    @Override
    protected MainPrestener createPresenter() {
        return new MainPrestener();
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mDoubleClickExit = new DoubleClickExitHelper(this);
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mRecordFragment = new RecordFragment();
        // mManageFragment = new ManageFragment();
        mMineFragment = new MineFragment();

        mFragments.add(mHomeFragment);
        mFragments.add(mRecordFragment);
        mFragments.add(mManageFragment);
        mFragments.add(mMineFragment);

        mFm = getSupportFragmentManager();
        mTransaction = mFm.beginTransaction();
        mTransaction.add(R.id.fly_contain, mHomeFragment);
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return mDoubleClickExit.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    private void inintVersion() {

        PgyUpdateManager.setIsForced(true); //设置是否强制更新。true为强制更新；false为不强制更新（默认值）。
        PgyUpdateManager.register(this, new UpdateManagerListener() {
            @Override
            public void onNoUpdateAvailable() {

            }

            @Override
            public void onUpdateAvailable(String result) {
                // 将新版本信息封装到AppBean中
                final AppBean appBean = getAppBeanFromString(result);
                new AlertDialog.Builder(aty)
                        .setTitle("检测到有版本更新")
                        .setMessage(appBean.getReleaseNote())
                        .setNegativeButton(
                                "确定",
                                new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(
                                            DialogInterface dialog,
                                            int which) {
                                        startDownloadTask(
                                                aty,
                                                appBean.getDownloadURL());
                                    }
                                }).show();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PgyUpdateManager.unregister();
    }
}
