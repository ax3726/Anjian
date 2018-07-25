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
import com.anjian.model.record.SearchModel;
import com.anjian.utils.DemoUtils;

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
                    if (mBinding.rbQiye.isChecked()) {
                        seatchQiye();
                    } else if (mBinding.rbSanxiao.isChecked()) {
                        seatchSanxiao();
                    }else if (mBinding.rbRenkou.isChecked()) {
                        seatchRenKou();
                    }else if (mBinding.rbChuzu.isChecked()) {
                        seatchChuZu();
                    }else if (mBinding.rbOther.isChecked()) {
                        seatchOther();
                    }

                }
                return false;
            }
        });


    }

    private void setAdapter()
    {
        mCommonAdapter = new CommonAdapter<SearchModel.DataBean>(aty, R.layout.item_company_list, mDataList) {
            @Override
            protected void convert(ViewHolder holder, SearchModel.DataBean item, int position) {
                LinearLayout lly_item = holder.getView(R.id.lly_item);

                if (mBinding.rbQiye.isChecked()) {
                    holder.setText(R.id.tv_name, item.getEnterpriseName());
                    holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getEnterpriseDoorHeadImg()), 0);
                    lly_item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(QiYeActivity.class, item.getId());
                        }
                    });
                } else if (mBinding.rbSanxiao.isChecked()) {
                    holder.setText(R.id.tv_name, item.getTspName());
                    holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getTspDoorHeadImg()), 0);
                    lly_item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(SanXiaoActivity.class, item.getId());
                        }
                    });
                }else if (mBinding.rbRenkou.isChecked()) {
                    holder.setText(R.id.tv_name, item.getPdpName());
                    holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getPdpDoorHeadImg()), 0);
                    lly_item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(QiYeActivity.class, item.getId(),1);
                        }
                    });
                }else if (mBinding.rbChuzu.isChecked()) {
                    holder.setText(R.id.tv_name, item.getLetName());
                    holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getLetDoorHeadImg()), 0);
                    lly_item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(SanXiaoActivity.class, item.getId(),1);
                        }
                    });
                }else if (mBinding.rbOther.isChecked()) {
                    holder.setText(R.id.tv_name, item.getOtpName());
                    holder.setImageurl(R.id.img, DemoUtils.getUrl(item.getOtpImg()), 0);
                    lly_item.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(OtherActivity.class, item.getId());
                        }
                    });
                }



            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setAdapter(mCommonAdapter);
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
                setAdapter();
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
        Api.getApi().sanXiaoSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this, true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList.addAll(baseBean.getData());
                }
                setAdapter();
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
        Api.getApi().renKouSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this, true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList.addAll(baseBean.getData());
                }
                setAdapter();
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
        Api.getApi().chuZuSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this, true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList.addAll(baseBean.getData());
                }
                setAdapter();
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
        Api.getApi().otherSearch(MyApplication.getInstance().getToken(), content).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SearchModel>(this, true) {
            @Override
            public void onSuccess(SearchModel baseBean) {
                mDataList.clear();
                if (baseBean.getData() != null && baseBean.getData().size() > 0) {
                    mDataList.addAll(baseBean.getData());
                }
                setAdapter();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

}
