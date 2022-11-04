package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class RankingSobBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取积分排行成功.
     * data : [{"userId":"1204736502274318336","avatar":"https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png","nickname":"A lonely cat","sob":6444,"createTime":"2021-04-14 09:36:37","isVip":true},{"userId":"1173631787251826688","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/02/rBPLFV1_tdaAGj9cAAAfE2I_q9o259.png","nickname":"豪豪好吗","sob":5434,"createTime":"2021-04-26 07:41:38","isVip":true},{"userId":"1260005644669403136","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/22/rBsADV7rZ-CAHJqDAABpHVtPIxE198.png","nickname":"loneliness","sob":4395,"createTime":"2021-02-24 10:05:10","isVip":true},{"userId":"1274617957070172160","avatar":"https://images.sunofbeaches.com/content/2021_07_31/871097823611846656.png","nickname":"域外","sob":4289,"createTime":"2020-12-24 11:04:57","isVip":true},{"userId":"1166178972732514304","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/2B/rBsADV82cKqAQk8aAABNUYmJxSM060.png","nickname":"rocky","sob":3628,"createTime":"2021-03-25 03:50:06","isVip":true},{"userId":"1339887900006932480","avatar":"https://images.sunofbeaches.com/content/2022_07_06/994205825054539776.png","nickname":"星期八","sob":3528,"createTime":"2020-12-18 11:24:29","isVip":true},{"userId":"1256120724666454016","avatar":"https://images.sunofbeaches.com/content/2022_06_22/989093103333801984.png","nickname":"夙夜星辰叹","sob":3517,"createTime":"2021-04-25 09:26:36","isVip":true},{"userId":"1347474750661849088","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAYITCAJpK1AABZPRa3kCo649.png","nickname":"Romantic","sob":3390,"createTime":"2021-04-28 11:06:18","isVip":true},{"userId":"1279241123625246720","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/3A/rBsADV_PbTyAJexxAABHFzLgPUo164.png","nickname":"Xiao9mmDa","sob":3358,"createTime":"2021-04-22 06:11:38","isVip":true},{"userId":"1171041086097883136","avatar":"https://images.sunofbeaches.com/content/2021_09_29/892718450277875712.png","nickname":"竭风","sob":2831,"createTime":"2021-04-08 04:37:19","isVip":true},{"userId":"1212268821507858432","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"破小布的小花狗","sob":2575,"createTime":"2021-04-09 05:57:35","isVip":true},{"userId":"1216830916760965120","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/0E/rBsADV4c3lOAe3XQAAARPTB-zes803.png","nickname":"π大星","sob":2489,"createTime":"2021-04-17 07:44:56","isVip":true}]
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
        return "RankingSobBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * userId : 1204736502274318336
         * avatar : https://images.sunofbeaches.com/content/2022_05_21/977732823475552256.png
         * nickname : A lonely cat
         * sob : 6444.0
         * createTime : 2021-04-14 09:36:37
         * isVip : true
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
        @SerializedName("isVip")
        private Boolean isVip;

        public String getUserId() {
            return userId;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public int getSob() {
            return sob;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Boolean getVip() {
            return isVip;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "userId='" + userId + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", sob=" + sob +
                    ", createTime='" + createTime + '\'' +
                    ", isVip=" + isVip +
                    '}';
        }
    }
}
