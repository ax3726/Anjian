package com.anjian.ui.record;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivityWeiHuaBinding;
import com.anjian.model.record.YouXianListModel;
import com.anjian.model.record.YouXianListModel;
import com.anjian.model.request.AddListRequest;
import com.anjian.utils.DemoUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

public class YouXianActivity extends BaseActivity<BasePresenter, ActivityWeiHuaBinding> {


    private List<YouXianListModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<YouXianListModel.DataBean> mCommonAdapter;

    private int mPosition = 1;
    private int mSize = 10;
    private String mId="";
    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_wei_hua;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("有限空间");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.record_add_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddYouXianActivity.class,mId,mUType);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(aty);
        mId=getIntent().getStringExtra("id");
        mCommonAdapter = new CommonAdapter<YouXianListModel.DataBean>(aty, R.layout.item_wei_hua, mDataList) {
            @Override
            protected void convert(ViewHolder holder, YouXianListModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getSpaceName());
                holder.setText(R.id.tv_num, "数量:" + item.getSpaceNum());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getLocaleImg()),0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(aty, AddYouXianActivity.class);
                        intent.putExtra("data",item);
                        intent.putExtra("utype",mUType);
                        startActivity(intent);
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);

        mBinding.srlBodyList.setRefreshHeader(new ClassicsHeader(aty));
        mBinding.srlBodyList.setRefreshFooter(new ClassicsFooter(aty));
        mBinding.srlBodyList.setOnRefreshListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPosition++;
                getWeiHuaList();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPosition = 1;
                mBinding.srlBodyList.resetNoMoreData();
                getWeiHuaList();
            }
        });
        getWeiHuaList();
    }

    private void getWeiHuaList() {
        AddListRequest addListRequest = new AddListRequest();
        addListRequest.setCurrent(mPosition);
        addListRequest.setSize(mSize);
        addListRequest.getCondition().setId(mId);
        if (mUType==0) {
            Api.getApi().getYouXianList(getRequestBody(addListRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<YouXianListModel>(this, true) {
                @Override
                public void onSuccess(YouXianListModel baseBean) {

                    finishRefersh();
                    if (mPosition == 1) {
                        mDataList.clear();
                    }
                    List<YouXianListModel.DataBean> data = baseBean.getData();
                    if (data != null & data.size() > 0) {
                        mDataList.addAll(data);
                        if (data.size() < mSize) {
                            mBinding.srlBodyList.finishLoadmoreWithNoMoreData();
                        }
                    }
                    if (mPosition == 1 && mDataList.size() == 0) {
                        mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                    } else {
                        mBinding.rcBody.setBackground(null);
                    }
                    mCommonAdapter.notifyDataSetChanged();


                }

                @Override
                public void onFail(String errMsg) {
                    finishRefersh();
                }
            });

        } else if (mUType==1) {
            Api.getApi().getYouXianList1(getRequestBody(addListRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<YouXianListModel>(this, true) {
                @Override
                public void onSuccess(YouXianListModel baseBean) {

                    finishRefersh();
                    if (mPosition == 1) {
                        mDataList.clear();
                    }
                    List<YouXianListModel.DataBean> data = baseBean.getData();
                    if (data != null & data.size() > 0) {
                        mDataList.addAll(data);
                        if (data.size() < mSize) {
                            mBinding.srlBodyList.finishLoadmoreWithNoMoreData();
                        }
                    }
                    if (mPosition == 1 && mDataList.size() == 0) {
                        mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                    } else {
                        mBinding.rcBody.setBackground(null);
                    }
                    mCommonAdapter.notifyDataSetChanged();


                }

                @Override
                public void onFail(String errMsg) {
                    finishRefersh();
                }
            });

        }

    }

    private void finishRefersh() {
        mBinding.srlBodyList.finishLoadmore();
        mBinding.srlBodyList.finishRefresh();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新".equals(messageEvent)) {
            mPosition = 1;
            getWeiHuaList();
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(aty);
        super.onDestroy();

    }
}
