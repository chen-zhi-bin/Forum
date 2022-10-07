package com.program.module_wenda.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

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

    public static class DataBean implements Serializable {
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
        private Object label;
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

        public Object getLabel() {
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
    }
}
