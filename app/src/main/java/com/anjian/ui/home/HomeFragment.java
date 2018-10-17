package com.anjian.ui.home;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.anjian.R;
import com.anjian.base.BaseFragment;
import com.anjian.base.BaseFragmentPresenter;
import com.anjian.base.BaseNetListener;
import com.anjian.common.Api;
import com.anjian.common.Link;
import com.anjian.common.MyApplication;
import com.anjian.databinding.FragmentHomeBinding;
import com.anjian.databinding.ItemHomeNewsLayoutBinding;
import com.anjian.model.home.HomeBannerModel;
import com.anjian.model.home.HomeNewsModel;
import com.anjian.model.request.AddListRequest;
import com.anjian.ui.common.DocumentActivity;
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


/**
 * Created by LiMing on 2018/6/25.
 */

public class HomeFragment extends BaseFragment<BaseFragmentPresenter, FragmentHomeBinding> {
    private List<HomeNewsModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<HomeNewsModel.DataBean> mAdapter;
    private int mPosition = 1;
    private int mSize = 10;
    private int mIndex = -1;

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
        mTitleBarLayout.setTitle("首页");
        mTitleBarLayout.setLeftImg(R.drawable.record_search_icon);
        mTitleBarLayout.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(DocumentActivity.class);
            }
        });
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.home_message_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MessageActivity.class);
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.llyMoreNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(HomeNewsActivity.class);
            }
        });
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


        getHomeBanner();
        getHomeNews();
    }

    private void getHomeBanner() {
        Api.getApi().getHomeBanner(MyApplication.getInstance().getToken())
                .compose(callbackOnIOToMainThread())
                .subscribe(new BaseNetListener<HomeBannerModel>(this, true) {
                    @Override
                    public void onSuccess(HomeBannerModel baseBean) {
                        List<HomeBannerModel.DataBean> data = baseBean.getData();
                        if (data != null && data.size() > 0) {
                            mBinding.tvTitle.setVisibility(View.VISIBLE);
                            List<String> list = new ArrayList<>();
                            for (HomeBannerModel.DataBean dataBean : data) {
                                list.add(DemoUtils.getUrl(dataBean.getImageUrl()));
                            }
                            mBinding.fbHead.setImagesUrl(list);
                            mIndex = 0;
                            mBinding.tvTitle.setText(data.get(0).getTitle());
                            mBinding.tvTitle.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(aty, WebViewActivity.class);
                                    intent.putExtra("url", Link.SEREVE + "/cms/news.html?id=" + data.get(mIndex).getId());
                                    startActivity(intent);
                                }
                            });
                            mBinding.fbHead.setOnItemClickListener(new FlyBanner.OnItemClickListener() {
                                @Override
                                public void onItemClick(int position) {
                                    Intent intent = new Intent(aty, WebViewActivity.class);
                                    intent.putExtra("url", Link.SEREVE + "/cms/news.html?id=" + data.get(position).getId());
                                    startActivity(intent);
                                }

                                @Override
                                public void onItemChange(int position) {
                                    mIndex = position;
                                    mBinding.tvTitle.setText(data.get(position).getTitle());
                                }
                            });
                        } else {
                            mBinding.tvTitle.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFail(String errMsg) {

                    }
                });
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

                        List<HomeNewsModel.DataBean> data = baseBean.getData();

                        mDataList.clear();

                        if (data != null && data.size() > 0) {
                            mDataList.addAll(data);

                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFail(String errMsg) {
                    }
                });
    }


}
