package com.anjian.ui.record;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivitySanxiaoSelectBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.OptionItemsModel;
import com.anjian.model.record.QiyeSelectListModel;
import com.anjian.model.request.AddListSelectRequest;
import com.anjian.model.request.AddQiyeSelectRequest;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.adapters.recyclerview.CommonAdapter;
import ml.gsy.com.library.utils.ParseJsonUtils;

public class QiYeSelectActivity extends BaseActivity<BasePresenter, ActivitySanxiaoSelectBinding> {
    private String mId = "";
    private List<OptionItemsModel> mDataList = new ArrayList<>();
    private Adapter mAdapter;
    private QiyeSelectListModel.DataBean mDataBean = null;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sanxiao_select;
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
        mTitleBarLayout.setTitle("企业安全生产主体责任对照表");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumitMessage();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mId = getIntent().getStringExtra("id");


        mAdapter = new Adapter();
        mBinding.elvBody.setAdapter(mAdapter);
        getDataList();
    }

    private void getDataList() {
        AddListSelectRequest addListRequest = new AddListSelectRequest();
        // addListRequest.getCondition().setId(mId);
        addListRequest.getCondition().setId("1016600357733539841");
        Api.getApi().getQiYeSelectList(getRequestBody(addListRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<QiyeSelectListModel>(this, true) {
            @Override
            public void onSuccess(QiyeSelectListModel baseBean) {

                List<QiyeSelectListModel.DataBean> data = baseBean.getData();
                if (data != null & data.size() > 0) {

                    mDataBean = data.get(0);
                    String optionItems = data.get(0).getOptionItems();

                    if (!TextUtils.isEmpty(optionItems)) {
                        List<OptionItemsModel> OptionItemsModel = ParseJsonUtils.getBeanList(optionItems, new TypeToken<List<OptionItemsModel>>() {
                        }.getType());
                        mDataList.addAll(OptionItemsModel);
                        mAdapter.notifyDataSetChanged();
                    }
                }

            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    private CommonAdapter<OptionItemsModel.ItemListBean> adapter = null;

    class Adapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return mDataList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mDataList.get(groupPosition).getItemList().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mDataList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mDataList.get(groupPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(aty).inflate(R.layout.item_sanxiao_select_group, null);
            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            tv_title.setText(mDataList.get(groupPosition).getTypeName());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(aty).inflate(R.layout.item_qiye_select_child1, null);

            RadioGroup rg_options = (RadioGroup) convertView.findViewById(R.id.rg_options);
            RadioButton rb_1 = (RadioButton) convertView.findViewById(R.id.rb_1);
            RadioButton rb_2 = (RadioButton) convertView.findViewById(R.id.rb_2);
            RadioButton rb_3 = (RadioButton) convertView.findViewById(R.id.rb_3);
            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            OptionItemsModel.ItemListBean itemListBean = mDataList.get(groupPosition).getItemList().get(childPosition);
            tv_title.setText(itemListBean.getItemName());

            if (itemListBean.getStatus() == 0) {//0是 1否 2不全
                rb_1.setChecked(true);
            } else if (itemListBean.getStatus() == 1) {
                rb_2.setChecked(true);
            } else {
                rb_3.setChecked(true);
            }
            rg_options.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int status = 0;
                    if (rb_1.isChecked()) {
                        status = 0;
                    } else if (rb_2.isChecked()) {
                        status = 1;
                    } else {
                        status = 2;
                    }
                    mDataList.get(groupPosition).getItemList().get(childPosition).setStatus(status);
                    Adapter.this.notifyDataSetChanged();
                }
            });


            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    private void sumitMessage() {
        if (mDataBean == null) {
            showToast("数据有误!");
            return;
        }

        AddQiyeSelectRequest addQiyeSelectRequest = new AddQiyeSelectRequest();
        addQiyeSelectRequest.setId(mDataBean.getId());
        addQiyeSelectRequest.setOptionItems(ParseJsonUtils.getjsonStr(mDataList));

        Api.getApi().updateQiYeSelectList(getRequestBody(addQiyeSelectRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<BaseBean>(this, true) {
            @Override
            public void onSuccess(BaseBean baseBean) {
                showToast(baseBean.getMessage());

                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1500);
                            startActivity(QiYeCheckActivity.class, mId);
                            finish();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            @Override
            public void onFail(String errMsg) {

            }
        });

    }
}
