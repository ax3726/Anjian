package com.anjian.ui.home;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.databinding.FragmentHomeBinding;
import com.anjian.databinding.FragmentManageBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by LiMing on 2018/6/25.
 */

public class HomeFragment extends BaseFragment<BaseFragmentPresenter, FragmentHomeBinding> {

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
        return R.layout.fragment_home;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("安评信息");
        mTitleBarLayout.setLeftImg(R.drawable.record_search_icon);
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.home_message_icon);
    }

    @Override
    protected void initData() {
        super.initData();
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.home);
        list.add(R.drawable.home);
        list.add(R.drawable.home);
        list.add(R.drawable.home);
        list.add(R.drawable.home);
        mBinding.fbHead.setImages(list);

    }
}
