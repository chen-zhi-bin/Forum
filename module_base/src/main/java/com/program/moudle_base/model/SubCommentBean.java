package com.program.moudle_base.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 文章和问答的子评论
 */
public class SubCommentBean implements Serializable , MultiItemEntity, Parcelable {

    /**
     * _id : 963017818691862528
     * parentId : 963011228563668992
     * wendaId : 1513107843181506562
     * beUid : 1139423796017500160
     * beNickname : 工头断点
     * content : 我用的就是真机，应该是一开始我设置的retrofit和Android的版本问题
     * publishTime : 2022-04-11 10:08
     * yourUid : 1499922423573647361
     * yourAvatar : https://cdn.sunofbeaches.com/images/default_avatar.png
     * yourNickname : 头发和BUG只能没有一个
     * yourRole : null
     * vip : false
     */

    @SerializedName("_id")
    private String id;
    @SerializedName("parentId")
    private String parentId;
    @SerializedName("wendaId")
    private String wendaId;
    @SerializedName("beUid")
    private String beUid;
    @SerializedName("beNickname")
    private String beNickname;
    @SerializedName("content")
    private String content;
    @SerializedName("publishTime")
    private String publishTime;
    @SerializedName("yourUid")
    private String yourUid;
    @SerializedName("yourAvatar")
    private String yourAvatar;
    @SerializedName("yourNickname")
    private String yourNickname;
    @SerializedName("yourRole")
    private String yourRole;
    @SerializedName("vip")
    private Boolean vip;

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public String getWendaId() {
        return wendaId;
    }

    public String getBeUid() {
        return beUid;
    }

    public String getBeNickname() {
        return beNickname;
    }

    public String getContent() {
        return content;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public String getYourUid() {
        return yourUid;
    }

    public String getYourAvatar() {
        return yourAvatar;
    }

    public String getYourNickname() {
        return yourNickname;
    }

    public String getYourRole() {
        return yourRole;
    }

    public Boolean getVip() {
        return vip;
    }

    @Override
    public String toString() {
        return "SubCommentBean{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", wendaId='" + wendaId + '\'' +
                ", beUid='" + beUid + '\'' +
                ", beNickname='" + beNickname + '\'' +
                ", content='" + content + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", yourUid='" + yourUid + '\'' +
                ", yourAvatar='" + yourAvatar + '\'' +
                ", yourNickname='" + yourNickname + '\'' +
                ", yourRole='" + yourRole + '\'' +
                ", vip=" + vip +
                '}';
    }

    @Override
    public int getItemType() {
        return Constants.MultiItemType.TYPE_SUB_COMMENT;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.parentId);
        dest.writeString(this.wendaId);
        dest.writeString(this.beUid);
        dest.writeString(this.beNickname);
        dest.writeString(this.content);
        dest.writeString(this.publishTime);
        dest.writeString(this.yourUid);
        dest.writeString(this.yourAvatar);
        dest.writeString(this.yourNickname);
        dest.writeString(this.yourRole);
        dest.writeByte((byte) (vip!=null&&this.vip?1:0));
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readString();
        this.parentId = source.readString();
        this.wendaId = source.readString();
        this.beUid = source.readString();
        this.beNickname = source.readString();
        this.content = source.readString();
        this.publishTime = source.readString();
        this.yourUid = source.readString();
        this.yourAvatar = source.readString();
        this.yourNickname = source.readString();
        this.yourRole = source.readString();
        this.vip =  source.readByte()!=0;
    }

    public SubCommentBean() {
    }

    protected SubCommentBean(Parcel in) {
        this.id = in.readString();
        this.parentId = in.readString();
        this.wendaId = in.readString();
        this.beUid = in.readString();
        this.beNickname = in.readString();
        this.content = in.readString();
        this.publishTime = in.readString();
        this.yourUid = in.readString();
        this.yourAvatar = in.readString();
        this.yourNickname = in.readString();
        this.yourRole = in.readString();
        this.vip = in.readByte()!=0;
    }

    public static final Creator<SubCommentBean> CREATOR = new Creator<SubCommentBean>() {
        @Override
        public SubCommentBean createFromParcel(Parcel source) {
            return new SubCommentBean(source);
        }

        @Override
        public SubCommentBean[] newArray(int size) {
            return new SubCommentBean[size];
        }
    };
}
