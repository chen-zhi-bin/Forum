package com.program.module_home.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class CategoryBean implements Serializable {


    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : [{"id":"1160627057865043968","categoryName":"编程语言","order":0,"description":"计算机编程语言","createTime":"2019-08-12 03:02:56","pyName":"language"},{"id":"1160628608130199552","categoryName":"人工智能","order":0,"description":"AI，人工智能","createTime":"2019-08-12 03:06:54","pyName":"ai"},{"id":"1160629004139606016","categoryName":"前端/Flutter","order":0,"description":"前端开发相关内容","createTime":"2019-08-12 03:08:37","pyName":"frontend"},{"id":"1161217556019703808","categoryName":"猿(嫒)日常","order":0,"description":"记录程序员美好生活，更美好生活","createTime":"2019-08-13 06:06:54","pyName":"daily"},{"id":"1161256637437153280","categoryName":"安卓/iOS","order":9,"description":"安卓开发，google的android操作系统应用","createTime":"2019-08-13 08:42:12","pyName":"android"},{"id":"1161269553968238592","categoryName":"后台/大数据","order":0,"description":"后台，包括php,java...后台开发","createTime":"2019-08-13 09:33:32","pyName":"backend"},{"id":"1161269656481222656","categoryName":"测试&运维","order":0,"description":"测试和运维","createTime":"2019-08-13 09:33:56","pyName":"tsandops"},{"id":"1163536592044941312","categoryName":"算法/加密","order":11,"description":"算法/加密","createTime":"2019-08-20 03:41:56","pyName":"suanfa"},{"id":"1177517909203787776","categoryName":"程序员读书","order":2,"description":"程序员读书分类","createTime":"2019-09-27 05:38:41","pyName":"chengxuyuandushu"},{"id":"1196677079408574464","categoryName":"效率/工具","order":0,"description":"开发工具，提升效率相关的内容","createTime":"2019-11-19 02:30:24","pyName":"tools"}]
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataBean> data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "CategoryBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1160627057865043968
         * categoryName : 编程语言
         * order : 0.0
         * description : 计算机编程语言
         * createTime : 2019-08-12 03:02:56
         * pyName : language
         */

        @SerializedName("id")
        private String id;
        @SerializedName("categoryName")
        private String categoryName;
        @SerializedName("order")
        private int order;
        @SerializedName("description")
        private String description;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("pyName")
        private String pyName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getPyName() {
            return pyName;
        }

        public void setPyName(String pyName) {
            this.pyName = pyName;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", order=" + order +
                    ", description='" + description + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", pyName='" + pyName + '\'' +
                    '}';
        }
    }
}
