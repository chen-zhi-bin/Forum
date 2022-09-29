package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;
import com.program.moudle_base.model.MoyuItemBean;

import java.io.Serializable;
import java.util.List;

public class MoyuBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取摸鱼动态成功.
     * data : [{"id":"1513442206020595713","userId":"1499922423573647361","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/102.png\" width=\"20\" height=\"20\">，初学者想学习一下论坛类的app编写","linkCover":"","linkTitle":"","linkUrl":"","commentCount":7,"thumbUpCount":0,"images":[],"topicName":null,"topicId":"","createTime":"2022-04-11 17:01","hasThumbUp":false,"thumbUpList":["1433361655298891777","1139423796017500160","1302969105866940416","1339887900006932480"],"vip":false}]
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<MoyuItemBean> data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<MoyuItemBean> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "MoyuBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean extends MoyuItemBean implements Serializable {
        /**
         * id : 1513442206020595713
         * userId : 1499922423573647361
         * nickname : 希望程序能按我想的那样运行
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * company : null
         * position : null
         * content : 师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class="emoji" src="https://cdn.sunofbeaches.com/emoji/102.png" width="20" height="20">，初学者想学习一下论坛类的app编写
         * linkCover :
         * linkTitle :
         * linkUrl :
         * commentCount : 7
         * thumbUpCount : 0
         * images : []
         * topicName : null
         * topicId :
         * createTime : 2022-04-11 17:01
         * hasThumbUp : false
         * thumbUpList : ["1433361655298891777","1139423796017500160","1302969105866940416","1339887900006932480"]
         * vip : false
         */

        @SerializedName("id")
        private String id;
        @SerializedName("userId")
        private String userId;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("company")
        private String company;
        @SerializedName("position")
        private String position;
        @SerializedName("content")
        private String content;
        @SerializedName("linkCover")
        private String linkCover;
        @SerializedName("linkTitle")
        private String linkTitle;
        @SerializedName("linkUrl")
        private String linkUrl;
        @SerializedName("commentCount")
        private Integer commentCount;
        @SerializedName("thumbUpCount")
        private Integer thumbUpCount;
        @SerializedName("topicName")
        private Object topicName;
        @SerializedName("topicId")
        private String topicId;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("hasThumbUp")
        private Boolean hasThumbUp;
        @SerializedName("vip")
        private Boolean vip;
        @SerializedName("images")
        private List<?> images;
        @SerializedName("thumbUpList")
        private List<String> thumbUpList;



        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", userId='" + userId + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", company=" + company +
                    ", position=" + position +
                    ", content='" + content + '\'' +
                    ", linkCover='" + linkCover + '\'' +
                    ", linkTitle='" + linkTitle + '\'' +
                    ", linkUrl='" + linkUrl + '\'' +
                    ", commentCount=" + commentCount +
                    ", thumbUpCount=" + thumbUpCount +
                    ", topicName=" + topicName +
                    ", topicId='" + topicId + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", hasThumbUp=" + hasThumbUp +
                    ", vip=" + vip +
                    ", images=" + images +
                    ", thumbUpList=" + thumbUpList +
                    '}';
        }
    }
}
