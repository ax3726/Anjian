package com.anjian.model.record;

import java.util.List;

/**
 * Created by Administrator on 2018/7/10.
 */

public class QiyeSelectListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"createBy":null,"createName":null,"createTime":"2018-05-18 19:58:37","enterpriseId":"989167599474446337","enterpriseName":null,"id":"1","isDel":0,"optionItems":"[{\"typeName\":\"主体合法\",\"itemList\":[{\"itemName\":\"证照齐全有效\",\"status\":\"0\"},{\"itemName\":\"生产经营活动符合核准、许可范围。\",\"status\":1},{\"itemName\":\"无违规转让、出租证照行为。\",\"status\":1}],\"seq\":1},{\"typeName\":\"组织保障\",\"itemList\":[{\"itemName\":\"设置安全生产管理机构或配备安全生产管理人员。\",\"status\":1},{\"itemName\":\"逐级签订安全生产责任书。\",\"status\":1},{\"itemName\":\"工会组织或员工代表参与安全监督。\",\"status\":1}],\"seq\":2},{\"typeName\":\"宣传教育\",\"itemList\":[{\"itemName\":\"主要负责人、安全管理人员经培训合格后任职。\",\"status\":1},{\"itemName\":\"特种作业人员取得特种作业操作资格证书\",\"status\":1},{\"itemName\":\"员工进行\u201c三级\u201d安全教育\",\"status\":1},{\"itemName\":\"\u201c四新\u201d安全教育培训。\",\"status\":1},{\"itemName\":\"教育培训的课程、课时安排符合规定。\",\"status\":1},{\"itemName\":\"组织员工学习本单位安全管理规章制度。\",\"status\":1},{\"itemName\":\"开展\u201c安全生产月\u201d宣传活动。\",\"status\":1}],\"seq\":3},{\"typeName\":\"安全权益\",\"itemList\":[{\"itemName\":\"与员工劳动合同有劳动保护、条件和职业危害防护条款。\",\"status\":1},{\"itemName\":\"对从业人员告知场所、岗位危险因素防范、应急措施。\",\"status\":1},{\"itemName\":\"从业人员配备劳动防护用品，并正确佩戴、使用。\",\"status\":1},{\"itemName\":\"为从业人员缴纳工伤等社会保险费。\",\"status\":1},{\"itemName\":\"对从事接触职业病危害作业的人员健康检查。\",\"status\":1}],\"seq\":4},{\"typeName\":\"规章制度\",\"itemList\":[{\"itemName\":\"制订企业安全生产年度计划和专项工作方案。\",\"status\":1},{\"itemName\":\"建立健全安全生产管理制度。\",\"status\":1},{\"itemName\":\"实施作业许可证，严格履行审批手续。\",\"status\":1},{\"itemName\":\"安全生产档案内容齐全。\",\"status\":1},{\"itemName\":\"各岗位安全生产操作规程。\",\"status\":1},{\"itemName\":\"生产经营项目、场所有多个承包、的安全生产管理协议。\",\"status\":1}],\"seq\":5},{\"typeName\":\"安全条件\",\"itemList\":[{\"itemName\":\"保证安全生产的资金投入。\",\"status\":1},{\"itemName\":\"执行\u201c三同时\u201d制度安全设施设计审查、竣工验收等。\",\"status\":1},{\"itemName\":\"企业建筑工程经消防部门认可。\",\"status\":1},{\"itemName\":\"与周边建(构)筑物防火距离符合国家规定标准；\",\"status\":1},{\"itemName\":\"重点部位和重大危险源实施有效监控。\",\"status\":1},{\"itemName\":\"按规定要求配置消防设施且保持应急状态。\",\"status\":1},{\"itemName\":\"危险化学品检测报警仪、防火防爆装置、联锁装置。\",\"status\":1},{\"itemName\":\"特种设备及安全附件定期校验均在有效期内。\",\"status\":1},{\"itemName\":\"电气设备选用布置和临时电线架设符合电气规程标准。\",\"status\":1},{\"itemName\":\"有较大危险因素的场所、设施、设备，明显的安全警示。\",\"status\":1},{\"itemName\":\"存在\u201c三合一\u201d厂房。\",\"status\":1}],\"seq\":6}]","remark":"666","updateBy":"1","updateTime":"2018-07-08 00:45:32"}]
     * message : 成功
     */

    private int code;
    private int count;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createBy : null
         * createName : null
         * createTime : 2018-05-18 19:58:37
         * enterpriseId : 989167599474446337
         * enterpriseName : null
         * id : 1
         * isDel : 0
         * optionItems : [{"typeName":"主体合法","itemList":[{"itemName":"证照齐全有效","status":"0"},{"itemName":"生产经营活动符合核准、许可范围。","status":1},{"itemName":"无违规转让、出租证照行为。","status":1}],"seq":1},{"typeName":"组织保障","itemList":[{"itemName":"设置安全生产管理机构或配备安全生产管理人员。","status":1},{"itemName":"逐级签订安全生产责任书。","status":1},{"itemName":"工会组织或员工代表参与安全监督。","status":1}],"seq":2},{"typeName":"宣传教育","itemList":[{"itemName":"主要负责人、安全管理人员经培训合格后任职。","status":1},{"itemName":"特种作业人员取得特种作业操作资格证书","status":1},{"itemName":"员工进行“三级”安全教育","status":1},{"itemName":"“四新”安全教育培训。","status":1},{"itemName":"教育培训的课程、课时安排符合规定。","status":1},{"itemName":"组织员工学习本单位安全管理规章制度。","status":1},{"itemName":"开展“安全生产月”宣传活动。","status":1}],"seq":3},{"typeName":"安全权益","itemList":[{"itemName":"与员工劳动合同有劳动保护、条件和职业危害防护条款。","status":1},{"itemName":"对从业人员告知场所、岗位危险因素防范、应急措施。","status":1},{"itemName":"从业人员配备劳动防护用品，并正确佩戴、使用。","status":1},{"itemName":"为从业人员缴纳工伤等社会保险费。","status":1},{"itemName":"对从事接触职业病危害作业的人员健康检查。","status":1}],"seq":4},{"typeName":"规章制度","itemList":[{"itemName":"制订企业安全生产年度计划和专项工作方案。","status":1},{"itemName":"建立健全安全生产管理制度。","status":1},{"itemName":"实施作业许可证，严格履行审批手续。","status":1},{"itemName":"安全生产档案内容齐全。","status":1},{"itemName":"各岗位安全生产操作规程。","status":1},{"itemName":"生产经营项目、场所有多个承包、的安全生产管理协议。","status":1}],"seq":5},{"typeName":"安全条件","itemList":[{"itemName":"保证安全生产的资金投入。","status":1},{"itemName":"执行“三同时”制度安全设施设计审查、竣工验收等。","status":1},{"itemName":"企业建筑工程经消防部门认可。","status":1},{"itemName":"与周边建(构)筑物防火距离符合国家规定标准；","status":1},{"itemName":"重点部位和重大危险源实施有效监控。","status":1},{"itemName":"按规定要求配置消防设施且保持应急状态。","status":1},{"itemName":"危险化学品检测报警仪、防火防爆装置、联锁装置。","status":1},{"itemName":"特种设备及安全附件定期校验均在有效期内。","status":1},{"itemName":"电气设备选用布置和临时电线架设符合电气规程标准。","status":1},{"itemName":"有较大危险因素的场所、设施、设备，明显的安全警示。","status":1},{"itemName":"存在“三合一”厂房。","status":1}],"seq":6}]
         * remark : 666
         * updateBy : 1
         * updateTime : 2018-07-08 00:45:32
         */

        private String createBy;
        private String createName;
        private String createTime;
        private String enterpriseId;
        private String enterpriseName;
        private String id;
        private int isDel;
        private String optionItems;
        private String remark;
        private String updateBy;
        private String updateTime;

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsDel() {
            return isDel;
        }

        public void setIsDel(int isDel) {
            this.isDel = isDel;
        }

        public String getOptionItems() {
            return optionItems;
        }

        public void setOptionItems(String optionItems) {
            this.optionItems = optionItems;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
