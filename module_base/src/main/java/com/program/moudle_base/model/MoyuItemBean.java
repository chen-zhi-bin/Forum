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
