package com.program.module_home.model.bean;

public class SubCommentInputBean {
    private String articleId;
    private String beNickname;
    private String beUid;
    private String content;
    private String parentId;

    public SubCommentInputBean(
            String articleId,
            String parentId,
            String beUid,
            String beNickname,
            String comment
    ) {
        this.articleId = articleId;
        this.beNickname = beNickname;
        this.beUid = beUid;
        this.content = comment;
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "SubCommentInputBean{" +
                "articleId='" + articleId + '\'' +
                ", beNickname='" + beNickname + '\'' +
                ", beUid='" + beUid + '\'' +
                ", conent='" + content + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getBeNickname() {
        return beNickname;
    }

    public void setBeNickname(String beNickname) {
        this.beNickname = beNickname;
    }

    public String getBeUid() {
        return beUid;
    }

    public void setBeUid(String beUid) {
        this.beUid = beUid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
