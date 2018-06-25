package com.anjian.ui.manage;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentManageBinding;

/**
 * Created by LiMing on 2018/6/25.
 */

public class ManageFragment extends BaseFragment<BaseFragmentPresenter,FragmentManageBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_manage;
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
