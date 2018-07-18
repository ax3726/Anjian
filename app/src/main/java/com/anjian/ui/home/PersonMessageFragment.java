package com.anjian.ui.home;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentPersonManageBinding;

/**
 * Created by LiMing on 2018/6/25.
 */

public class PersonMessageFragment extends BaseFragment<BaseFragmentPresenter,FragmentPersonManageBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person_manage;
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
