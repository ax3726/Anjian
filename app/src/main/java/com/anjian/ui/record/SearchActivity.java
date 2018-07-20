package com.anjian.ui.record;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivitySearchBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.SearchModel;
import com.anjian.model.record.SearchSanXiaoModel;
import com.anjian.utils.DemoUtils;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

public class SearchActivity extends BaseActivity<BasePresenter, ActivitySearchBinding> {
    private List<SearchModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<SearchModel.DataBean> mCommonAdapter;

    private List<SearchSanXiaoModel.DataBean> mDataList1 = new ArrayList<>();
    private CommonAdapter<SearchSanXiaoModel.DataBean> mCommonAdapter1;

    private List<SearchSanXiaoModel.DataBean> mDataList2 = new ArrayList<>();
    private CommonAdapter<SearchSanXiaoModel.DataBean> mCommonAdapter2;

    private List<SearchSanXiaoModel.DataBean> mDataList3= new ArrayList<>();
    private CommonAdapter<SearchSanXiaoModel.DataBean> mCommonAdapter3;

    private List<SearchSanXiaoModel.DataBean> mDataList4 = new ArrayList<>();
    private CommonAdapter<SearchSanXiaoModel.DataBean> mCommonAdapter4;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mBinding.llyLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        mBinding.etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    if (mBinding.rbQiye.isChecked()) {
                        seatchQiye();
                    } else if (mBinding.rbSanxiao.isChecked()) {
                        seatchSanxiao();
                    }else if (mBinding.rbRenkou.isChecked()) {
                        seatchRenKou();
                    }else if (mBinding.rbChuzu.isChecked()) {
                        seatchChuZu();
                    }else if (mBinding.rbRenkou.isChecked()) {
                        seatchOther();
                    }

                }
                return false;
            }
        });


    }

    private void setQiyeAdapter()
    {
        mCommonAdapter = new CommonAdapter<SearchModel.DataBean>(aty, R.layout.item_company_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, SearchModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getEnterpriseName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getEnterpriseDoorHeadImg()), 0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(QiYeActivity.class, item.getId());
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);
    }
    private void setSanXiaoAdapter()
    {
        mCommonAdapter1 = new CommonAdapter<SearchSanXiaoModel.DataBean>(aty, R.layout.item_company_list, mDataList1) {
            @Override
            protected void convert(ViewHolder holder, SearchSanXiaoModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getTspName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getTspDoorHeadImg()), 0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(SanXiaoActivity.class, item.getId());
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter1);
    }

    private void setRenkouAdapter()
    {
        mCommonAdapter2 = new CommonAdapter<SearchSanXiaoModel.DataBean>(aty, R.layout.item_company_list, mDataList2) {
            @Override
            protected void convert(ViewHolder holder, SearchSanXiaoModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getTspName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getTspDoorHeadImg()), 0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(SanXiaoActivity.class, item.getId());
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter2);
    }


    private void setChuZuAdapter()
    {
        mCommonAdapter3 = new CommonAdapter<SearchSanXiaoModel.DataBean>(aty, R.layout.item_company_list, mDataList3) {
            @Override
            protected void convert(ViewHolder holder, SearchSanXiaoModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getTspName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getTspDoorHeadImg()), 0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(SanXiaoActivity.class, item.getId());
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter3);
    }


    private void setOtherAdapter()
    {
        mCommonAdapter4 = new CommonAdapter<SearchSanXiaoModel.DataBean>(aty, R.layout.item_company_list, mDataList4) {
            @Override
            protected void convert(ViewHolder holder, SearchSanXiaoModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name, item.getTspName());
                holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getTspDoorHeadImg()), 0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(SanXiaoActivity.class, item.getId());
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter4);
    }


    private void seatchQiye() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().qiYeSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this, true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList.addAll(baseBean.getData());
                }
                setQiyeAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    private void seatchSanxiao() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().sanXiaoSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchSanXiaoModel>(this, true) {
            @Override
            public void onSuccess(SearchSanXiaoModel baseBean) {
                mDataList1.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList1.addAll(baseBean.getData());
                }
                setSanXiaoAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    private void seatchRenKou() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().renKouSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchSanXiaoModel>(this, true) {
            @Override
            public void onSuccess(SearchSanXiaoModel baseBean) {
                mDataList2.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList2.addAll(baseBean.getData());
                }
                setRenkouAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    private void seatchChuZu() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().chuZuSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchSanXiaoModel>(this, true) {
            @Override
            public void onSuccess(SearchSanXiaoModel baseBean) {
                mDataList3.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList3.addAll(baseBean.getData());
                }
                setChuZuAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
    private void seatchOther() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().otherSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchSanXiaoModel>(this, true) {
            @Override
            public void onSuccess(SearchSanXiaoModel baseBean) {
                mDataList4.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList4.addAll(baseBean.getData());
                }
                setOtherAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

}
