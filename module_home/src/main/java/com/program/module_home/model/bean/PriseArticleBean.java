package com.program.module_home.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PriseArticleBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取文章打赏列表成功.
     * data : [{"userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"希望程序能按我想的那样运行","sob":4,"createTime":"2022-10-24 20:23","vip":false},{"userId":"1504452765877800961","avatar":"https://images.sunofbeaches.com/content/2022_04_14/964124335407104000.png","nickname":"搬砖侠","sob":8,"createTime":"2022-09-02 20:10","vip":false},{"userId":"1247069679944470528","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/28/rBsADV8qufOAVRZDAABZjTaGYnc500.png","nickname":"MUZIII","sob":16,"createTime":"2022-08-28 21:22","vip":true},{"userId":"1153952789488054272","avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","nickname":"拉大锯","sob":16,"createTime":"2022-08-28 13:43","vip":false}]
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataBean> data;

    @Override
    public String toString() {
        return "PriseArticleBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

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

    public static class DataBean implements Serializable {
        /**
         * userId : 1499922423573647361
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * nickname : 希望程序能按我想的那样运行
         * sob : 4
         * createTime : 2022-10-24 20:23
         * vip : false
         */

        @SerializedName("userId")
        private String userId;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("sob")
        private Integer sob;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("vip")
        private Boolean vip;

        public String getUserId() {
            return userId;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public Integer getSob() {
            return sob;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Boolean getVip() {
            return vip;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userId='" + userId + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", sob=" + sob +
                    ", createTime='" + createTime + '\'' +
                    ", vip=" + vip +
                    '}';
        }
    }
}
