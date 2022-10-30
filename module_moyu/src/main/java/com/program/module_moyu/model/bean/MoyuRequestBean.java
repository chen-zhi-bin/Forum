package com.program.module_moyu.model.bean;

import com.google.gson.annotations.SerializedName;
import com.program.moudle_base.model.MoyuItemBean;

import java.io.Serializable;
import java.util.List;

public class MoyuRequestBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取动态成功.
     * data : {"id":"1513442206020595713","userId":"1499922423573647361","nickname":"希望程序能按我想的那样运行","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","company":null,"position":null,"content":"师傅，有没有考虑过出一出阳光沙滩的Android视频或文章<img class=\"emoji\" src=\"https://cdn.sunofbeaches.com/emoji/102.png\" width=\"20\" height=\"20\">，初学者想学习一下论坛类的app编写","linkCover":"","linkTitle":"","linkUrl":"","commentCount":7,"thumbUpCount":4,"images":[],"topicName":null,"topicId":"","createTime":"2022-04-11 17:01","hasThumbUp":false,"thumbUpList":["1433361655298891777","1139423796017500160","1302969105866940416","1339887900006932480"],"vip":false}
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
        return "MoyuRequestBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
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
         * thumbUpCount : 4
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
        private String topicName;
        @SerializedName("topicId")
        private String topicId;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("hasThumbUp")
        private Boolean hasThumbUp;
        @SerializedName("vip")
        private Boolean vip;
        @SerializedName("images")
        private List<String> images;
        @SerializedName("thumbUpList")
        private List<String> thumbUpList;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getCompany() {
            return company;
        }

        public String getPosition() {
            return position;
        }

        public String getContent() {
            return content;
        }

        public String getLinkCover() {
            return linkCover;
        }

        public String getLinkTitle() {
            return linkTitle;
        }

        public String getLinkUrl() {
            return linkUrl;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public Integer getThumbUpCount() {
            return thumbUpCount;
        }

        public String getTopicName() {
            return topicName;
        }

        public String getTopicId() {
            return topicId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public Boolean getHasThumbUp() {
            return hasThumbUp;
        }

        public Boolean getVip() {
            return vip;
        }

        public List<String> getImages() {
            return images;
        }

        public List<String> getThumbUpList() {
            return thumbUpList;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setLinkCover(String linkCover) {
            this.linkCover = linkCover;
        }

        public void setLinkTitle(String linkTitle) {
            this.linkTitle = linkTitle;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }

        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public void setThumbUpCount(Integer thumbUpCount) {
            this.thumbUpCount = thumbUpCount;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setHasThumbUp(Boolean hasThumbUp) {
            this.hasThumbUp = hasThumbUp;
        }

        public void setVip(Boolean vip) {
            this.vip = vip;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setThumbUpList(List<String> thumbUpList) {
            this.thumbUpList = thumbUpList;
        }

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
