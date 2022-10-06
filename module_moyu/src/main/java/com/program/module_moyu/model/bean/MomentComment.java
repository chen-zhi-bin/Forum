package com.program.module_moyu.model.bean;

public class MomentComment {
    //被评论id
    private String momentId;
    //内容
    private String content;

    public MomentComment(){

    }

    public MomentComment(String momentId, String content) {
        this.momentId = momentId;
        this.content = content;
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
}
