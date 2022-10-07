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

    public SubCommentBean(Parcel parcel) {
        parcel.writeString(this.id);
        parcel.writeString(this.wendaId);
        parcel.writeString(this.beNickname);
        parcel.writeString(this.beUid);
        parcel.writeString(this.content);
        parcel.writeString(this.parentId);
        parcel.writeString(this.publishTime);
        parcel.writeByte((byte)(this.vip ? 1 : 0));
        parcel.writeString(this.yourAvatar);
        parcel.writeString(this.yourNickname);
        parcel.writeString(this.yourRole);
        parcel.writeString(this.yourUid);
    }

    public static final Creator<SubCommentBean> CREATOR = new Creator<SubCommentBean>() {
        @Override
        public SubCommentBean createFromParcel(Parcel in) {
            return new SubCommentBean(in);
        }

        @Override
        public SubCommentBean[] newArray(int size) {
            return new SubCommentBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(wendaId);
        parcel.writeString(beNickname);
        parcel.writeString(beUid);
        parcel.writeString(content);
        parcel.writeString(parentId);
        parcel.writeString(publishTime);
        parcel.writeByte((byte) (vip? 1 : 0));
        parcel.writeString(yourAvatar);
        parcel.writeString(yourNickname);
        parcel.writeString(yourRole);
        parcel.writeString(yourUid);
    }

    @Override
    public int getItemType() {
        return Constants.MultiItemType.TYPE_SUB_COMMENT;
    }

    public static final class CREATOR implements Creator{

        @Override
        public Object createFromParcel(Parcel parcel) {
            return new SubCommentBean(parcel);
        }

        @Override
        public Object[] newArray(int i) {
            return new SubCommentBean[i];
        }
    }
}
