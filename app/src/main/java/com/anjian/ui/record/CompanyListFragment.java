package com.anjian.ui.record;

import android.location.Location;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.base.BaseNetListener;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.FragmentCompanylistBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.request.JingWeiRequest;
import com.anjian.utils.DemoUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

/**
 * Created by Administrator on 2018/6/26.
 */

public class CompanyListFragment extends BaseFragment<BaseFragmentPresenter, FragmentCompanylistBinding> {
    private List<String> mDataList = new ArrayList<>();
    private CommonAdapter<String> mCommonAdapter;
    private int mType = 0;  //0 企业  1三小

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_companylist;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
        mType = getArguments().getInt("type", 0);
        mBinding.tvHint.setText(mType == 0 ? "在您附近的企业" : "在您附近的三小场所");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mCommonAdapter = new CommonAdapter<String>(aty, R.layout.item_company_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mType == 0) {//企业
                            startActivity(QiYeActivity.class);
                        } else {
                            startActivity(SanXiaoActivity.class);
                        }
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);

        mBinding.srlBodyList.setEnableLoadmore(false);
        mBinding.srlBodyList.setRefreshHeader(new ClassicsHeader(aty));
        mBinding.srlBodyList.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                getdata();
            }
        });

        getdata();
    }

    private void getdata() {
        if (mType == 0) {//企业
            getQiYeList();
        } else {
            getSanXiaoList();
        }
    }

    private void finishRefersh() {
        mBinding.srlBodyList.finishRefresh();
    }

    private void getQiYeList() {
        JingWeiRequest jingWeiRequest = new JingWeiRequest();
        Location location = DemoUtils.getLocation(aty);
        if (location != null) {
            jingWeiRequest.setLatitude(String.valueOf(location.getLatitude()));
            jingWeiRequest.setLongitude(String.valueOf(location.getLongitude()));
        }

        Api.getApi().qiYeList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                finishRefersh();
                showToast(baseBean.getMessage());
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }

    private void getSanXiaoList() {
        JingWeiRequest jingWeiRequest = new JingWeiRequest();
        Location location = DemoUtils.getLocation(aty);
        if (location != null) {
            jingWeiRequest.setLatitude(String.valueOf(location.getLatitude()));
            jingWeiRequest.setLongitude(String.valueOf(location.getLongitude()));
        }

        Api.getApi().sanXiaoList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                finishRefersh();
                showToast(baseBean.getMessage());
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }
}
