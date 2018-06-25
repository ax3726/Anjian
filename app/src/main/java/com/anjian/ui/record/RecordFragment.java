package com.anjian.ui.record;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentRecordBinding;

/**
 * Created by LiMing on 2018/6/25.
 */

public class RecordFragment extends BaseFragment<BaseFragmentPresenter, FragmentRecordBinding> {

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
}
