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
import com.anjian.model.record.SearchModel;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.adapters.recyclerview.base.ViewHolder;

public class SearchActivity extends BaseActivity<BasePresenter, ActivitySearchBinding> {
    private List<SearchModel.DataBean> mDataList = new ArrayList<>();
    private CommonAdapter<SearchModel.DataBean> mCommonAdapter;

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
                    seatch();
                }
                return false;
            }
        });

        mCommonAdapter = new CommonAdapter<SearchModel.DataBean>(aty, R.layout.item_company_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, SearchModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);
                holder.setText(R.id.tv_name,item.getEnterpriseName());
               holder.setImageurl(R.id.img,item.getEnterpriseDoorHeadImg(),0);
                lly_item.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            startActivity(QiYeActivity.class);
                    }
                });

            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);
    }



    private void seatch() {
        String content = mBinding.etSearch.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            showToast("请输入关键字");
            return;
        }
        Api.getApi().search(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this,true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData()!=null&&baseBean.getData().size()>0) {
                    mDataList.addAll(baseBean.getData());
                }
                mCommonAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }
}
