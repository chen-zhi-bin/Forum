package com.program.module_moyu.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.util.List;


public class MomentSubCommentBean implements Serializable , MultiItemEntity {

    /**
     * id : 1514144712749019137
     * userId : 1499922423573647361
     * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
     * position : null
     * company : null
     * nickname : 希望程序能按我想的那样运行
     * targetUserId : 1204736502274318336
     * targetUserNickname : A lonely cat
     * targetUserIsVip : true
     * createTime : 2022-04-13 15:33
     * content : 谢谢大佬的代码可以让我参考一下
     * thumbUpList : []
     * commentId : 1513457831329722370
     * vip : false
     */

    @SerializedName("id")
    private String id;
    @SerializedName("userId")
    private String userId;
    @SerializedName("avatar")
    private String avatar;
    @SerializedName("position")
    private Object position;
    @SerializedName("company")
    private Object company;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("targetUserId")
    private String targetUserId;
    @SerializedName("targetUserNickname")
    private String targetUserNickname;
    @SerializedName("targetUserIsVip")
    private Boolean targetUserIsVip;
    @SerializedName("createTime")
    private String createTime;
    @SerializedName("content")
    private String content;
    @SerializedName("commentId")
    private String commentId;
    @SerializedName("vip")
    private Boolean vip;
    @SerializedName("thumbUpList")
    private List<?> thumbUpList;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public Object getPosition() {
        return position;
    }

    public Object getCompany() {
        return company;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public String getTargetUserNickname() {
        return targetUserNickname;
    }

    public Boolean getTargetUserIsVip() {
        return targetUserIsVip;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getContent() {
        return content;
    }

    public String getCommentId() {
        return commentId;
    }

    public Boolean getVip() {
        return vip;
    }

    public List<?> getThumbUpList() {
        return thumbUpList;
    }

    @Override
    public String toString() {
        return "MomentSubComment{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", avatar='" + avatar + '\'' +
                ", position=" + position +
                ", company=" + company +
                ", nickname='" + nickname + '\'' +
                ", targetUserId='" + targetUserId + '\'' +
                ", targetUserNickname='" + targetUserNickname + '\'' +
                ", targetUserIsVip=" + targetUserIsVip +
                ", createTime='" + createTime + '\'' +
                ", content='" + content + '\'' +
                ", commentId='" + commentId + '\'' +
                ", vip=" + vip +
                ", thumbUpList=" + thumbUpList +
                '}';
    }

    @Override
    public int getItemType() {
        return Constants.MultiItemType.TYPE_SUB_COMMENT;
    }
}
