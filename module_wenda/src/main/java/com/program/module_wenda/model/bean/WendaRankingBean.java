package com.program.module_wenda.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WendaRankingBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取周排行榜成功
     * data : [{"avatar":"https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png","nickname":"拉大锯","count":4,"userId":"1153952789488054272","vip":false},{"avatar":"https://images.sunofbeaches.com/content/2022_06_19/988129204933492736.png","nickname":"断点","count":3,"userId":"1139423796017500160","vip":true},{"avatar":"https://images.sunofbeaches.com/content/2022_02_23/946075681748418560.jpg","nickname":"包租公","count":1,"userId":"1438863588197507073","vip":false},{"avatar":"https://images.sunofbeaches.com/content/2022_10_04/1027034193235804160.jpg","nickname":"清风ccc","count":1,"userId":"1404813466421735425","vip":false},{"avatar":"https://images.sunofbeaches.com/content/2021_09_29/892718450277875712.png","nickname":"竭风","count":1,"userId":"1171041086097883136","vip":true},{"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"cry","count":1,"userId":"1533490475221127169","vip":false},{"avatar":"https://images.sunofbeaches.com/content/2022_06_22/989110843536834560.png","nickname":"阿肥","count":1,"userId":"1382711465131241472","vip":false},{"avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"拿起我的九尺钉耙","count":1,"userId":"1573815242167685121","vip":false},{"avatar":"https://imgs.sunofbeaches.com/group1/M00/00/28/rBsADV8qufOAVRZDAABZjTaGYnc500.png","nickname":"MUZIII","count":1,"userId":"1247069679944470528","vip":true},{"avatar":"https://images.sunofbeaches.com/content/2022_10_29/1035875960588599296.jpg","nickname":"BaGa","count":1,"userId":"1463783870984896513","vip":true}]
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
        return "WendaRankingBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * avatar : https://images.sunofbeaches.com/content/2022_01_04/927902852251123712.png
         * nickname : 拉大锯
         * count : 4
         * userId : 1153952789488054272
         * vip : false
         */

        @SerializedName("avatar")
        private String avatar;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("count")
        private Integer count;
        @SerializedName("userId")
        private String userId;
        @SerializedName("vip")
        private Boolean vip;

        public String getAvatar() {
            return avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public Integer getCount() {
            return count;
        }

        public String getUserId() {
            return userId;
        }

        public Boolean getVip() {
            return vip;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", count=" + count +
                    ", userId='" + userId + '\'' +
                    ", vip=" + vip +
                    '}';
        }
    }
}
