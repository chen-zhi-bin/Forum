package com.program.module_home.model.bean;

public class CommentInputBean {
    private String parentId;
    private String articleId;
    private String commentContent;

    public CommentInputBean(String articleId, String commentContent) {
        this.articleId = articleId;
        this.commentContent = commentContent;
        this.parentId="0";
    }

    public CommentInputBean(String parentId, String articleId, String commentContent) {
        this.parentId = parentId;
        this.articleId = articleId;
        this.commentContent = commentContent;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentInputBean{" +
                "parentId='" + parentId + '\'' +
                ", articleId='" + articleId + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
