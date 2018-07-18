package com.anjian.ui.home;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentSysManageBinding;

/**
 * Created by LiMing on 2018/6/25.
 */

public class SysMessageFragment extends BaseFragment<BaseFragmentPresenter,FragmentSysManageBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_sys_manage;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }
}
