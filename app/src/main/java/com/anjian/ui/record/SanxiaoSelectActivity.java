package com.anjian.ui.record;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivitySanxiaoSelectBinding;
import com.anjian.model.record.SanXiaoSelectListModel;

import java.util.ArrayList;
import java.util.List;

public class SanxiaoSelectActivity extends BaseActivity<BasePresenter, ActivitySanxiaoSelectBinding> {

    private List<SanXiaoSelectListModel> mDataList = new ArrayList<>();
    private Adapter mAdapter;
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
        mTitleBarLayout.setTitle("三小场所隐患检查");
        mTitleBarLayout.setRightShow(true);
        mTitleBarLayout.setRightTxt("保存");
        mTitleBarLayout.setRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        SanXiaoSelectListModel model=new SanXiaoSelectListModel();
        model.setTitle("三合一问题");
        model.getOptions().add(new SanXiaoSelectListModel.DataBean("人员住宿与经营、存储场所合用"));

        SanXiaoSelectListModel model1=new SanXiaoSelectListModel();
        model1.setTitle("电器线路安全隐患");
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未接地线"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未使用漏电保护开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未使用过载保护开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("电控箱保护盖缺失"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("使用花胶线"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("电气线路敷设在可燃材料上"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("采用闸刀开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("线路乱拉乱接"));

        SanXiaoSelectListModel model2=new SanXiaoSelectListModel();
        model2.setTitle("消防隐患");
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("场所内设置影响疏散逃生的防盗窗、铁栅栏"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("夹层未设置独立的直通室外的疏散通道"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("通道堵塞"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("灭火器前堆放障碍物"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("5.灭火器材配置不足"));


        SanXiaoSelectListModel model3=new SanXiaoSelectListModel();
        model3.setTitle("火灾隐患");
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("液化气_KG_瓶"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("天然气"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("柴油"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("环保油"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("其他燃料燃具"));


        mDataList.add(model);
        mDataList.add(model1);
        mDataList.add(model2);
        mDataList.add(model3);

        mAdapter=new Adapter();
        mBinding.elvBody.setAdapter(mAdapter);

    }

    class Adapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return mDataList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return mDataList.get(groupPosition).getOptions().size();
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
            tv_title.setText(mDataList.get(groupPosition).getTitle());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(aty).inflate(R.layout.item_sanxiao_select_child, null);
            LinearLayout lly_option = (LinearLayout) convertView.findViewById(R.id.lly_option);
            TextView tv_title = (TextView) convertView.findViewById(R.id.tv_option);
            ImageView img = (ImageView) convertView.findViewById(R.id.img);
            tv_title.setText(mDataList.get(groupPosition).getOptions().get(childPosition).getContent());
            img.setSelected(mDataList.get(groupPosition).getOptions().get(childPosition).isselect());
            lly_option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isselect = mDataList.get(groupPosition).getOptions().get(childPosition).isselect();
                    mDataList.get(groupPosition).getOptions().get(childPosition).setIsselect(!isselect);
                    notifyDataSetChanged();
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
