package com.anjian.ui.record;

import android.app.Dialog;
import android.content.DialogInterface;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
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
import com.anjian.model.record.CompanyLisyModel;
import com.anjian.model.request.JingWeiRequest;
import com.anjian.utils.DemoUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

/**
 * Created by Administrator on 2018/6/26.
 */

public class CompanyListFragment extends BaseFragment<BaseFragmentPresenter, FragmentCompanylistBinding> {
    private List<CompanyLisyModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<CompanyLisyModel.DataBean> mCommonAdapter;
    private int mType = 0;  //0 企业  1三小 2 密集 3,出租屋  4其他
    private boolean mIsFirst = false;
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
        if (!mIsFirst) {
            EventBus.getDefault().register(this);
        }

        mType = getArguments().getInt("type", 0);
        if (mType==0) {
            mBinding.tvHint.setText("在您附近的企业");
        } else if (mType==1) {
            mBinding.tvHint.setText("在您附近的三小场所");
        } else if (mType==2) {
            mBinding.tvHint.setText("在您附近的人口密集场所");
        } else if (mType==3) {
            mBinding.tvHint.setText("在您附近的出租屋");
        } else if (mType==4) {
            mBinding.tvHint.setText("在您附近的其他场所");
        }



        mCommonAdapter = new CommonAdapter<CompanyLisyModel.DataBean>(aty, R.layout.item_company_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, CompanyLisyModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getDoorHeadImg()), 0);

                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mType==0) {
                            startActivity(QiYeActivity.class, item.getKey());
                        } else if (mType==1) {
                            startActivity(SanXiaoActivity.class, item.getKey());
                        } else if (mType==2) {
                            startActivity(QiYeActivity.class, item.getKey(),1);
                        } else if (mType==3) {
                            startActivity(SanXiaoActivity.class, item.getKey(),1);

                        } else if (mType==4) {

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
        if (!mIsFirst) {
            getdata();
            mIsFirst = true;
        }

    }


    private void getdata() {
        if (mType==0) {
            getQiYeList();
        } else if (mType==1) {
            getSanXiaoList();
        } else if (mType==2) {
            getrenKouList();
        } else if (mType==3) {
            getletList();
        } else if (mType==4) {
            getotherList();
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

        Api.getApi().qiYeList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<CompanyLisyModel>(this) {
            @Override
            public void onSuccess(CompanyLisyModel baseBean) {
                finishRefersh();
                mDataList.clear();
                List<CompanyLisyModel.DataBean> data = baseBean.getData();
                if (data != null && data.size() > 0) {
                    mBinding.rcBody.setBackground(null);
                    mDataList.addAll(data);
                } else {
                    mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                }
                mCommonAdapter.notifyDataSetChanged();
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

        Api.getApi().sanXiaoList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<CompanyLisyModel>(this) {
            @Override
            public void onSuccess(CompanyLisyModel baseBean) {
                finishRefersh();
                mDataList.clear();
                List<CompanyLisyModel.DataBean> data = baseBean.getData();
                if (data != null && data.size() > 0) {
                    mBinding.rcBody.setBackground(null);
                    mDataList.addAll(data);
                } else {
                    mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                }
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }

    private void getrenKouList() {
        JingWeiRequest jingWeiRequest = new JingWeiRequest();
        Location location = DemoUtils.getLocation(aty);
        if (location != null) {
            jingWeiRequest.setLatitude(String.valueOf(location.getLatitude()));
            jingWeiRequest.setLongitude(String.valueOf(location.getLongitude()));
        }

        Api.getApi().renKouList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<CompanyLisyModel>(this) {
            @Override
            public void onSuccess(CompanyLisyModel baseBean) {
                finishRefersh();
                mDataList.clear();
                List<CompanyLisyModel.DataBean> data = baseBean.getData();
                if (data != null && data.size() > 0) {
                    mBinding.rcBody.setBackground(null);
                    mDataList.addAll(data);
                } else {
                    mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                }
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }

    private void getletList() {
        JingWeiRequest jingWeiRequest = new JingWeiRequest();
        Location location = DemoUtils.getLocation(aty);
        if (location != null) {
            jingWeiRequest.setLatitude(String.valueOf(location.getLatitude()));
            jingWeiRequest.setLongitude(String.valueOf(location.getLongitude()));
        }

        Api.getApi().letList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<CompanyLisyModel>(this) {
            @Override
            public void onSuccess(CompanyLisyModel baseBean) {
                finishRefersh();
                mDataList.clear();
                List<CompanyLisyModel.DataBean> data = baseBean.getData();
                if (data != null && data.size() > 0) {
                    mBinding.rcBody.setBackground(null);
                    mDataList.addAll(data);
                } else {
                    mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                }
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }
    private void getotherList() {
        JingWeiRequest jingWeiRequest = new JingWeiRequest();
        Location location = DemoUtils.getLocation(aty);
        if (location != null) {
            jingWeiRequest.setLatitude(String.valueOf(location.getLatitude()));
            jingWeiRequest.setLongitude(String.valueOf(location.getLongitude()));
        }

        Api.getApi().otherList(getRequestBody(jingWeiRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<CompanyLisyModel>(this) {
            @Override
            public void onSuccess(CompanyLisyModel baseBean) {
                finishRefersh();
                mDataList.clear();
                List<CompanyLisyModel.DataBean> data = baseBean.getData();
                if (data != null && data.size() > 0) {
                    mBinding.rcBody.setBackground(null);
                    mDataList.addAll(data);
                } else {
                    mBinding.rcBody.setBackgroundResource(R.drawable.img_deafault_icon);
                }
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {
                finishRefersh();
            }
        });

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void refersh(String messageEvent) {
        if ("刷新企业".equals(messageEvent)&&mType == 0) {
            getQiYeList();
        } else if ("刷新三小".equals(messageEvent)&&mType == 1) {
            getSanXiaoList();
        } else if ("刷新人口密集".equals(messageEvent)&&mType == 2) {
            getrenKouList();
        } else if ("刷新出租屋".equals(messageEvent)&&mType == 3) {
            getletList();
        } else if ("刷新其他".equals(messageEvent)&&mType == 4) {
            getotherList();
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
