package com.anjian.ui.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.Link;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityHomeNewsBinding;
import com.anjian.databinding.ItemHomeNewsLayoutBinding;
import com.anjian.model.home.HomeBannerModel;
import com.anjian.model.home.HomeNewsModel;
import com.anjian.model.request.AddListRequest;
import com.anjian.ui.common.WebViewActivity;
import com.anjian.utils.DemoUtils;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;
import ml.gsy.com.library.widget.flybanner.FlyBanner;

public class HomeNewsActivity extends BaseActivity <BasePresenter,ActivityHomeNewsBinding>{
    private List<HomeNewsModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<HomeNewsModel.DataBean> mAdapter;
    private int mPosition = 1;
    private int mSize = 10;
    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("新闻");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_news;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected void initData() {
        super.initData();

        mAdapter = new CommonAdapter<HomeNewsModel.DataBean>(aty, R.layout.item_home_news_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, HomeNewsModel.DataBean dataBean, int position) {
                ItemHomeNewsLayoutBinding binding = holder.getBinding(ItemHomeNewsLayoutBinding.class);
                binding.tvTitle.setText(dataBean.getTitle());
                binding.tvContent.setText(dataBean.getSummary());
                Glide.with(aty).load(DemoUtils.getUrl(dataBean.getImageUrl())).into(binding.img);
                binding.llyItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(aty, WebViewActivity.class);
                        intent.putExtra("url", Link.SEREVE + "/cms/news.html?id=" + dataBean.getId());
                        startActivity(intent);
                    }
                });
            }
        };

        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mAdapter);
        mBinding.srlBody.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPosition++;
                getHomeNews();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPosition = 1;
                mBinding.srlBody.resetNoMoreData();
                getHomeNews();
            }
        });


        getHomeNews();
    }



    private void getHomeNews() {

        AddListRequest addListRequest = new AddListRequest();
        addListRequest.setCurrent(mPosition);
        addListRequest.setSize(mSize);

        Api.getApi().getHomeNews(getRequestBody(addListRequest), MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<HomeNewsModel>(this, true) {
                    @Override
                    public void onSuccess(HomeNewsModel baseBean) {
                        stopRefersh();
                        List<HomeNewsModel.DataBean> data = baseBean.getData();
                        if (mPosition == 1) {
                            mDataList.clear();
                        }
                        if (data != null && data.size() > 0) {
                            mDataList.addAll(data);
                            if (mSize > data.size()) {
                                mBinding.srlBody.finishLoadmoreWithNoMoreData();
                            }

                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFail(String errMsg) {
                        stopRefersh();
                    }
                });
    }


    private void stopRefersh() {
        mBinding.srlBody.finishRefresh();
        mBinding.srlBody.finishLoadmore();
    }
}
