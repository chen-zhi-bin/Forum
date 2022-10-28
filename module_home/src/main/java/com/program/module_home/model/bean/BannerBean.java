package com.program.module_home.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BannerBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取轮播图成功.
     * data : [{"targetUrl":"https://curl.qcloud.com/ofzAi4Nb","picUrl":"https://images.sunofbeaches.com/web/2022_02_17/943921723655323648.png","type":"1","createTime":"2022-02-18 01:28"},{"targetUrl":"https://shop.sunofbeach.net","picUrl":"https://imgs.sunofbeaches.com/group1/M00/00/05/rBsADV2rEz-AIzSoAABi-6nfiqs456.png","type":"1","createTime":"2019-10-19 08:00"},{"targetUrl":"https://www.sunofbeach.net/course-download","picUrl":"https://cdn.sunofbeaches.com/images/test/2.jpg","type":"0","createTime":"2019-09-19 08:00"},{"targetUrl":"https://www.sunofbeach.net/a/1201366916766224384","picUrl":"https://cdn.sunofbeaches.com/images/test/3.jpg","type":"0","createTime":"2019-09-19 08:00"},{"targetUrl":"https://www.sunofbeach.net/a/1200344514544390144","picUrl":"https://cdn.sunofbeaches.com/images/test/1.jpg","type":"0","createTime":"2019-04-13 08:00"}]
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

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<DataBean> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BannerBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * targetUrl : https://curl.qcloud.com/ofzAi4Nb
         * picUrl : https://images.sunofbeaches.com/web/2022_02_17/943921723655323648.png
         * type : 1
         * createTime : 2022-02-18 01:28
         */

        @SerializedName("targetUrl")
        private String targetUrl;
        @SerializedName("picUrl")
        private String picUrl;
        @SerializedName("type")
        private String type;
        @SerializedName("createTime")
        private String createTime;

        public String getTargetUrl() {
            return targetUrl;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public String getType() {
            return type;
        }

        public String getCreateTime() {
            return createTime;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "targetUrl='" + targetUrl + '\'' +
                    ", picUrl='" + picUrl + '\'' +
                    ", type='" + type + '\'' +
                    ", createTime='" + createTime + '\'' +
                    '}';
        }
    }
}
