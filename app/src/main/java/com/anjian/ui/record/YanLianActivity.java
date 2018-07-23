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
import com.anjian.model.record.YanLianListModel;
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

public class YanLianActivity extends BaseActivity<BasePresenter, ActivityWeiHuaBinding> {


    private List<YanLianListModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<YanLianListModel.DataBean> mCommonAdapter;
    private String mId = "";

    private int mPosition = 1;
    private int mSize = 10;

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
        mTitleBarLayout.setTitle("培训演练");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightImg(R.drawable.record_add_icon);
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddYanLianActivity.class, mId,mUType);
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        EventBus.getDefault().register(aty);
        mId = getIntent().getStringExtra("id");
        mCommonAdapter = new CommonAdapter<YanLianListModel.DataBean>(aty, R.layout.item_yan_lian, mDataList) {
            @Override
            protected void convert(ViewHolder holder, YanLianListModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getLocaleActImg()), 0);
                holder.setText(R.id.tv_name, item.getTitle());
                holder.setText(R.id.tv_time, DemoUtils.getTime(item.getCreateTime()));
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(aty, AddYanLianActivity.class);
                        intent.putExtra("data", item);
                        intent.putExtra("utype", mUType);
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
                getYanLianList();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPosition = 1;
                mBinding.srlBodyList.resetNoMoreData();
                getYanLianList();
            }
        });
        getYanLianList();
    }

    private void getYanLianList() {
        AddListRequest addListRequest = new AddListRequest();
        addListRequest.setCurrent(mPosition);
        addListRequest.setSize(mSize);
        addListRequest.getCondition().setId(mId);
        if (mUType == 0) {
            Api.getApi().getYanLianList(getRequestBody(addListRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<YanLianListModel>(this, true) {
                @Override
                public void onSuccess(YanLianListModel baseBean) {

                    finishRefersh();
                    if (mPosition == 1) {
                        mDataList.clear();
                    }
                    List<YanLianListModel.DataBean> data = baseBean.getData();
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
        } else if (mUType == 1) {
            Api.getApi().getYanLianList1(getRequestBody(addListRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<YanLianListModel>(this, true) {
                @Override
                public void onSuccess(YanLianListModel baseBean) {

                    finishRefersh();
                    if (mPosition == 1) {
                        mDataList.clear();
                    }
                    List<YanLianListModel.DataBean> data = baseBean.getData();
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
            getYanLianList();
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(aty);
        super.onDestroy();

    }
}
