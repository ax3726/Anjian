package com.anjian.ui.record;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentRecordBinding;
import com.anjian.ui.CommonPagerAdapter;
import com.anjian.utils.DemoUtils;
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
    private CompanyListFragment mRenKouFragment;//人口
    private CompanyListFragment mLetFragment;//出租屋
    private CompanyListFragment mOtherFragment;//其他
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

                    @Override
                    public void onPhp() {
                        Intent intent = new Intent(aty, AddQiyeActivity.class);
                        intent.putExtra("utype", 1);
                        startActivity(intent);

                    }

                    @Override
                    public void onLet() {
                        Intent intent = new Intent(aty, AddSanXiaoActivity.class);
                        intent.putExtra("utype", 1);
                        startActivity(intent);
                    }

                    @Override
                    public void onOther() {
                        startActivity(AddOtherActivity.class);
                    }
                });
                selectCompanywindow.showPopupWindow();

            }
        });
        mTitleBarLayout.setTitle("众点安全");
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
        title.add("生产企业");
        title.add("三小场所");
        title.add("人口密集场所");
        title.add("出租屋");
        title.add("其他场所");

        mQiYeFragment = new CompanyListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        mQiYeFragment.setArguments(bundle);

        mSanXiaoFragment = new CompanyListFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("type", 1);
        mSanXiaoFragment.setArguments(bundle1);


        mRenKouFragment = new CompanyListFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt("type", 2);
        mRenKouFragment.setArguments(bundle2);


        mLetFragment = new CompanyListFragment();
        Bundle bundle3 = new Bundle();
        bundle3.putInt("type", 3);
        mLetFragment.setArguments(bundle3);

        mOtherFragment = new CompanyListFragment();
        Bundle bundle4 = new Bundle();
        bundle4.putInt("type", 4);
        mOtherFragment.setArguments(bundle4);

        fragments.add(mQiYeFragment);
        fragments.add(mSanXiaoFragment);
        fragments.add(mRenKouFragment);
        fragments.add(mLetFragment);
        fragments.add(mOtherFragment);
        initTablayout();
        checkLocation();

    }

    private void initTablayout() {
        mMyPagerAdapter = new CommonPagerAdapter(getFragmentManager(), title, fragments);

        mBinding.viewPager.setAdapter(mMyPagerAdapter);
        mBinding.viewPager.setOffscreenPageLimit(5);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
    }

    /**
     * 检测权限是否被禁止
     */
    private void checkLocation() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            LocationManager lm = (LocationManager) aty.getSystemService(aty.LOCATION_SERVICE);
            //  boolean ok=lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);//2.通过网络定位，对定位精度度不高或省点情况可考
            if (lm.getProvider(LocationManager.NETWORK_PROVIDER) == null) {
                new AlertDialog.Builder(aty)
                        .setTitle("温馨提示")
                        .setMessage("无法定位，请打开定位服务")
                        .setNegativeButton("稍后再说", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DemoUtils.getAppDetailSettingIntent(aty);
                                dialog.dismiss();
                            }
                        })
                        .create().show();


            }
        }

    }
}
