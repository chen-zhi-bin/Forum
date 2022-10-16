package com.program.module_wenda.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class WendaContentBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取问答内容成功.
     * data : {"id":"1513107843181506562","title":"Retrofit初始化问题","userId":"1499922423573647361","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"希望程序能按我想的那样运行","description":"<p>Retrofit初始化出现问题导致app崩溃<\/p><p><br><\/p><p>OplusCustomizeRestrictionManager: sInstance is null, start a new sInstance<\/p><p>ExceptionInInitializerError<\/p><p><br><\/p><p><img src=\"https://images.sunofbeaches.com/content/2022_04_10/962786419523190784.png\"><\/p><p>代码如下<\/p><p><img src=\"https://images.sunofbeaches.com/content/2022_04_10/962786711081844736.png\"><\/p><p><br><\/p><p>调用代码：<\/p><p><img src=\"https://images.sunofbeaches.com/content/2022_04_10/962786859425988608.png\"><\/p><p><br><\/p><p>我寻思着好像也没啥问题啊，怎么就为空崩溃了呢，求解<\/p>","answerCount":6,"label":null,"isVip":"0","createTime":"2022-04-10 18:53","isResolve":"1","viewCount":128,"thumbUp":1,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","labels":["Retrofit"]}
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataBean data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataBean getData() {
        return data;
    }

    @Override
    public String toString() {
        return "WendaContentBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable, Parcelable {
        /**
         * id : 1513107843181506562
         * title : Retrofit初始化问题
         * userId : 1499922423573647361
         * avatar : https://cdn.sunofbeaches.com/images/default_avatar.png
         * nickname : 希望程序能按我想的那样运行
         * description : <p>Retrofit初始化出现问题导致app崩溃</p><p><br></p><p>OplusCustomizeRestrictionManager: sInstance is null, start a new sInstance</p><p>ExceptionInInitializerError</p><p><br></p><p><img src="https://images.sunofbeaches.com/content/2022_04_10/962786419523190784.png"></p><p>代码如下</p><p><img src="https://images.sunofbeaches.com/content/2022_04_10/962786711081844736.png"></p><p><br></p><p>调用代码：</p><p><img src="https://images.sunofbeaches.com/content/2022_04_10/962786859425988608.png"></p><p><br></p><p>我寻思着好像也没啥问题啊，怎么就为空崩溃了呢，求解</p>
         * answerCount : 6
         * label : null
         * isVip : 0
         * createTime : 2022-04-10 18:53
         * isResolve : 1
         * viewCount : 128
         * thumbUp : 1
         * sob : 2
         * categoryId : 1161256637437153280
         * categoryName : 安卓/iOS
         * labels : ["Retrofit"]
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;
        @SerializedName("userId")
        private String userId;
        @SerializedName("avatar")
        private String avatar;
        @SerializedName("nickname")
        private String nickname;
        @SerializedName("description")
        private String description;
        @SerializedName("answerCount")
        private Integer answerCount;
        @SerializedName("label")
        private String label;
        @SerializedName("isVip")
        private String isVip;
        @SerializedName("createTime")
        private String createTime;
        @SerializedName("isResolve")
        private String isResolve;
        @SerializedName("viewCount")
        private Integer viewCount;
        @SerializedName("thumbUp")
        private Integer thumbUp;
        @SerializedName("sob")
        private Integer sob;
        @SerializedName("categoryId")
        private String categoryId;
        @SerializedName("categoryName")
        private String categoryName;
        @SerializedName("labels")
        private List<String> labels;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getUserId() {
            return userId;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public String getDescription() {
            return description;
        }

        public Integer getAnswerCount() {
            return answerCount;
        }

        public String getLabel() {
            return label;
        }

        public String getIsVip() {
            return isVip;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getIsResolve() {
            return isResolve;
        }

        public Integer getViewCount() {
            return viewCount;
        }

        public Integer getThumbUp() {
            return thumbUp;
        }

        public Integer getSob() {
            return sob;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public List<String> getLabels() {
            return labels;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", userId='" + userId + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", description='" + description + '\'' +
                    ", answerCount=" + answerCount +
                    ", label=" + label +
                    ", isVip='" + isVip + '\'' +
                    ", createTime='" + createTime + '\'' +
                    ", isResolve='" + isResolve + '\'' +
                    ", viewCount=" + viewCount +
                    ", thumbUp=" + thumbUp +
                    ", sob=" + sob +
                    ", categoryId='" + categoryId + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", labels=" + labels +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.title);
            dest.writeString(this.userId);
            dest.writeString(this.avatar);
            dest.writeString(this.nickname);
            dest.writeString(this.description);
            dest.writeInt(this.answerCount);
            dest.writeString(this.label);
            dest.writeString(this.isVip);
            dest.writeString(this.createTime);
            dest.writeString(this.isResolve);
            dest.writeInt(this.viewCount);
            dest.writeInt(this.thumbUp);
            dest.writeInt(this.sob);
            dest.writeString(this.categoryId);
            dest.writeString(this.categoryName);
            dest.writeStringList(this.labels);
        }

        protected DataBean(Parcel in) {
            String id = in.readString();
            this.id = id!=null?id:"";
            String title = in.readString();
            this.title = title!=null?title:"";
            String userId = in.readString();
            this.userId = userId!=null?userId:"";
            String avatar = in.readString();
            this.avatar = avatar!=null?avatar:"";
            String nickname = in.readString();
            this.nickname = nickname!=null?nickname:"";
            String description = in.readString();
            this.description = description!=null?description:"";
            this.answerCount = (Integer) in.readInt();
            String label = in.readString();
            this.label = label!=null?label:"";
            String isVip = in.readString();
            this.isVip = isVip!=null?isVip:"";
            String createTime = in.readString();
            this.createTime = createTime!=null?createTime:"";
            String isResolve = in.readString();
            this.isResolve = isResolve!=null?isResolve:"";
            this.viewCount = (Integer) in.readInt();
            this.thumbUp = (Integer) in.readInt();
            this.sob = (Integer) in.readInt();
            String categoryId = in.readString();
            this.categoryId = categoryId!=null?categoryId:"";
            String categoryName = in.readString();
            this.categoryName = categoryName!=null?categoryName:"";
            ArrayList<String> stringArrayList = in.createStringArrayList();
            this.labels = stringArrayList!=null?stringArrayList:CollectionsKt.mutableListOf();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}
