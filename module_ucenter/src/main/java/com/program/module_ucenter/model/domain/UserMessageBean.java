package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserMessageBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取用户信息成功.
     * data : {"userId":"1153952789488054272","nickname":"拉大锯","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/07/rBsADV22ZymAV8BwAABVL9XtNSU926.png","position":"首席打杂工程师","company":"阳光沙滩","sign":"三界之内没有我解不了的bug","area":"广东省/深圳市/福田区","vip":false}
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    @Override
    public String toString() {
        return "UserMessageBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * userId : 1153952789488054272
         * nickname : 拉大锯
         * avatar : https://imgs.sunofbeaches.com/group1/M00/00/07/rBsADV22ZymAV8BwAABVL9XtNSU926.png
         * position : 首席打杂工程师
         * company : 阳光沙滩
         * sign : 三界之内没有我解不了的bug
         * area : 广东省/深圳市/福田区
         * vip : false
         */

        @SerializedName("userId")
        private String userId;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("position")
        private String position;
        @SerializedName("company")
        private String company;
        @SerializedName("sign")
        private String sign;
        @SerializedName("area")
        private String area;
        @SerializedName("vip")
        private Boolean vip;

        public String getUserId() {
            return userId;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getPosition() {
            return position;
        }

        public String getCompany() {
            return company;
        }

        public String getSign() {
            return sign;
        }

        public String getArea() {
            return area;
        }

        public Boolean getVip() {
            return vip;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userId='" + userId + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", position='" + position + '\'' +
                    ", company='" + company + '\'' +
                    ", sign='" + sign + '\'' +
                    ", area='" + area + '\'' +
                    ", vip=" + vip +
                    '}';
        }
    }
}
