package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class UcenterInfo implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取用户信息成功.
     * data : {"userId":"1499922423573647361","email":null,"company":null,"position":null,"sign":null,"goodAt":"bug?","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","isvIP":"0","area":null,"sex":2,"phoneNum":"1580****031"}
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
        return "UcenterInfo{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * userId : 1499922423573647361
         * email : null
         * company : null
         * position : null
         * sign : null
         * goodAt : bug?
         * nickname : 希望程序能按我想的那样运行
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * isvIP : 0
         * area : null
         * sex : 2
         * phoneNum : 1580****031
         */

        @SerializedName("userId")
        private String userId;
        @SerializedName("email")
        private Object email;
        @SerializedName("company")
        private String company;
        @SerializedName("position")
        private String position;
        @SerializedName("sign")
        private String sign;
        @SerializedName("goodAt")
        private String goodAt;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("isvIP")
        private String isvIP;
        @SerializedName("area")
        private String area;
        @SerializedName("sex")
        private Integer sex;
        @SerializedName("phoneNum")
        private String phoneNum;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getGoodAt() {
            return goodAt;
        }

        public void setGoodAt(String goodAt) {
            this.goodAt = goodAt;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getIsvIP() {
            return isvIP;
        }

        public void setIsvIP(String isvIP) {
            this.isvIP = isvIP;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public Integer getSex() {
            return sex;
        }

        public void setSex(Integer sex) {
            this.sex = sex;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userId='" + userId + '\'' +
                    ", email=" + email +
                    ", company='" + company + '\'' +
                    ", position='" + position + '\'' +
                    ", sign='" + sign + '\'' +
                    ", goodAt='" + goodAt + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", isvIP='" + isvIP + '\'' +
                    ", area='" + area + '\'' +
                    ", sex=" + sex +
                    ", phoneNum='" + phoneNum + '\'' +
                    '}';
        }
    }
}
