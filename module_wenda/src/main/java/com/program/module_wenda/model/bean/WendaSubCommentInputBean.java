package com.program.module_wenda.model.bean;

public class WendaSubCommentInputBean {
    /**
     * parentId 被评论的答案ID
     beNickname 被评论人的昵称
     beUid 被评论人的用户ID
     wendaId 问题的ID
     */
    private String beNickname;
    private String beUid;
    private String content;
    private String parentId;
    private String wendaId;

    public WendaSubCommentInputBean(String parentId,String beNickname,String beUid, String wendaId,String content) {
        this.beNickname = beNickname;
        this.beUid = beUid;
        this.content = content;
        this.parentId = parentId;
        this.wendaId = wendaId;
    }

    public String getBeNickname() {
        return beNickname;
    }

    public String getBeUid() {
        return beUid;
    }

    public String getContent() {
        return content;
    }

    public String getParentId() {
        return parentId;
    }

    public String getWendaId() {
        return wendaId;
    }
}
