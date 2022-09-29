package com.program.moudle_base.model;

import java.util.List;

public class MoyuItemBean {

    private String id;

    private String userId;

    private String nickname;

    private String avatar;

    private String company;

    private String position;

    private String content;

    private String linkCover;

    private String linkTitle;

    private String linkUrl;

    private Integer commentCount;

    private Integer thumbUpCount;

    private String topicName;

    private String topicId;

    private String createTime;

    private Boolean hasThumbUp;

    private Boolean vip;

    private List<String> images;

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

    @Override
    public String toString() {
        return "MoyuItemBean{" +
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
