package com.anjian.ui.record;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BaseNetListener;
import com.anjian.base.BasePresenter;
import com.anjian.common.Api;
import com.anjian.common.Constant;
import com.anjian.common.MyApplication;
import com.anjian.databinding.ActivitySanxiaoSelectBinding;
import com.anjian.model.BaseBean;
import com.anjian.model.record.SanXiaoSelectListModel;
import com.anjian.model.record.SanXiaoSelectModel;
import com.anjian.model.request.AddSanXiaoRequest;
import com.anjian.model.request.AddSanXiaoSelectRequest;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ml.gsy.com.library.utils.CacheUtils;

public class SanxiaoSelectActivity extends BaseActivity<BasePresenter, ActivitySanxiaoSelectBinding> {
    private String mId = "";
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
                sumitMessage();
            }
        });
    }

    @Override
    protected void initData() {
        super.initData();
        mId = getIntent().getStringExtra("id");
        List<SanXiaoSelectListModel> list = (List<SanXiaoSelectListModel>) CacheUtils.getInstance().loadCache(Constant.SANXIAO_SELECT);
        if (list == null) {
            loadData();
        } else {
            mDataList.addAll(list);
        }
        mAdapter = new Adapter();
        mBinding.elvBody.setAdapter(mAdapter);

    }

    private void loadData() {
        SanXiaoSelectListModel model = new SanXiaoSelectListModel();
        model.setTitle("三合一问题");
        model.getOptions().add(new SanXiaoSelectListModel.DataBean("人员住宿与经营、存储场所合用"));
        model.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));

        SanXiaoSelectListModel model1 = new SanXiaoSelectListModel();
        model1.setTitle("电器线路安全隐患");
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未接地线"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未使用漏电保护开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("未使用过载保护开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("电控箱保护盖缺失"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("使用花胶线"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("电气线路敷设在可燃材料上"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("采用闸刀开关"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("线路乱拉乱接"));
        model1.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));

        SanXiaoSelectListModel model2 = new SanXiaoSelectListModel();
        model2.setTitle("消防隐患");
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("场所内设置影响疏散逃生的防盗窗、铁栅栏"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("夹层未设置独立的直通室外的疏散通道"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("通道堵塞"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("灭火器前堆放障碍物"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("5.灭火器材配置不足"));
        model2.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));


        SanXiaoSelectListModel model3 = new SanXiaoSelectListModel();
        model3.setTitle("火灾隐患");
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("液化气_KG_瓶"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("天然气"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("危险化学品"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("危险物品"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("其他燃料"));
        model3.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));


        SanXiaoSelectListModel model4 = new SanXiaoSelectListModel();
        model4.setTitle("其他");
        model4.getOptions().add(new SanXiaoSelectListModel.DataBean("特种设备"));
        model4.getOptions().add(new SanXiaoSelectListModel.DataBean("有限空间"));
        model4.getOptions().add(new SanXiaoSelectListModel.DataBean("粉尘涉爆"));
        model4.getOptions().add(new SanXiaoSelectListModel.DataBean("危险作业"));
        model4.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));

        SanXiaoSelectListModel model5 = new SanXiaoSelectListModel();
        model5.setTitle("生产现场");
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("危险化学品生产、经营单位主要负责人和安全生产管理人员依法经考核合格。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("依据法规标准设定外部安全防护距离作为缓冲距离，防止危险化学品生产装置、储存设施在发生火灾、爆炸、毒气泄漏事故时造成重大人员伤亡和财产损失。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("涉及重点监管危险化工工艺的装置实现自动化控制，系统实现紧急停车功能，装备的自动化控制系统、紧急停车系统正常投入使用。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("构成一级、二级重大危险源的危险化学品罐区实现紧急切断功能；涉及毒性气体、液化气体、剧毒液体的一级、二级重大危险源的危险化学品罐区配备独立的安全仪表系统。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("全压力式液化烃储罐按照国家标准设置注水措施。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("液化烃、液氨、液氯等易燃易爆、有毒有害液化气体的充装使用万向管道充装系统。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean(" 光气、氯气等剧毒气体及硫化氢气体管道未穿越除厂区(包括化工园区、工业园区）外的公共区域。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("在役化工装置应经正规设计，且进行安全设计诊断。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("地区架空电力线路未穿越生产区，应符合国家标准要求。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("未使用淘汰落后安全技术工艺、设备目录列出的工艺、设备。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean(" 涉及可燃和有毒有害气体泄漏的场所，应按国家标准设置检测报警装置，爆炸危险场所按国家标准安装使用防爆电气设备。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("控制室或机柜间不得面向具有火灾、爆炸危险性装置一侧，应满足国家标准关于防火防爆的要求。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("化工生产装置应按照国家标准要求设置双重电源供电，自动化控制系统应设置不间断电源。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("安全阀、爆破片等安全附件处于正常投用。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("应建立与岗位相匹配的全员安全生产责任制，制定实施生产安全事故隐患排查治理制度。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("各生产岗位应制定操作规程和工艺控制指标"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("按照国家标准制定动火、进入受限空间等特殊作业管理制度，并有效执行。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("涉及重点监管危险化工工艺和金属有机物合成反应（包括格氏反应）的间歇和半间歇反应，要开展安全风险评估"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("按照国家标准分区分类储存危险化学品，不得超量、超品种储存危险化学品及相互禁配物质混放混存。"));
        model5.getOptions().add(new SanXiaoSelectListModel.DataBean("其他"));

        mDataList.add(model);
        mDataList.add(model1);
        mDataList.add(model2);
        mDataList.add(model3);
        mDataList.add(model5);
        mDataList.add(model4);
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

    private void sumitMessage() {
        AddSanXiaoSelectRequest selectRequest = new AddSanXiaoSelectRequest();
        List<AddSanXiaoSelectRequest.DataBean> dataList = new ArrayList<>();
        for (SanXiaoSelectListModel model : mDataList) {
            for (SanXiaoSelectListModel.DataBean dataBean : model.getOptions()) {
                if (dataBean.isselect()) {
                    AddSanXiaoSelectRequest.DataBean bean = new AddSanXiaoSelectRequest.DataBean();
                    bean.setTypeName(model.getTitle());
                    bean.setItemName(dataBean.getContent());
                    dataList.add(bean);
                }
            }
        }
        if (dataList.size() == 0) {
            showToast("请至少选择一项！");
            return;
        }
        selectRequest.setOptionItems(dataList);
        selectRequest.setTspId(mId);
        Api.getApi().addSanXiaoSelectList(getRequestBody(selectRequest), MyApplication.getInstance().getToken()).compose(callbackOnIOToMainThread()).subscribe(new BaseNetListener<SanXiaoSelectModel>(this, true) {
            @Override
            public void onSuccess(SanXiaoSelectModel baseBean) {
                showToast(baseBean.getMessage());
                CacheUtils.getInstance().saveCache(Constant.SANXIAO_SELECT, mDataList);//保存数据
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            sleep(1500);

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
