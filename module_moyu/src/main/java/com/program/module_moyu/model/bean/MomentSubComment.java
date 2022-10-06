package com.program.module_moyu.model.bean;

public class MomentSubComment {

    //content为评论内容，momentId为动态Id，targetUserId是被评论内容的用户Id，commentId为被评论内容的Id
    private String momentId;
    private String content;
    private String targetUserId;
    private String commentId;

    public MomentSubComment(String momentId, String content, String targetUserId, String commentId) {
        this.momentId = momentId;
        this.content = content;
        this.targetUserId = targetUserId;
        this.commentId = commentId;
    }

    public String getMomentId() {
        return momentId;
    }

    public void setMomentId(String momentId) {
        this.momentId = momentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
