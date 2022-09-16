package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginoutBean implements Serializable {


    /**
     * success : true
     * code : 10000
     * message : 操作成功
     * data : {"id":"1499922423573647361","roles":null,"lev":0,"isVip":"0","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"希望程序能按我想的那样运行","token":null,"fansCount":null,"followCount":null}
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
        return "LoginoutBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1499922423573647361
         * roles : null
         * lev : 0
         * isVip : 0
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * nickname : 希望程序能按我想的那样运行
         * token : null
         * fansCount : null
         * followCount : null
         */

        @SerializedName("id")
        private String id;
        @SerializedName("roles")
        private Object roles;
        @SerializedName("lev")
        private Integer lev;
        @SerializedName("isVip")
        private String isVip;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("token")
        private Object token;
        @SerializedName("fansCount")
        private Object fansCount;
        @SerializedName("followCount")
        private Object followCount;



        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", roles=" + roles +
                    ", lev=" + lev +
                    ", isVip='" + isVip + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", token=" + token +
                    ", fansCount=" + fansCount +
                    ", followCount=" + followCount +
                    '}';
        }
    }
}
