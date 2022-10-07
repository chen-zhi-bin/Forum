package com.program.module_wenda.model.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.program.lib_common.Constants;

import java.io.Serializable;
import java.util.List;

public class WendaBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取相关问题成功.
     * data : [{"id":"1230530733462827008","title":"Retrofit上传文件携带信息失败返回400，已抓取log和截图onclick代码。跪求解~","userId":"1226683515316211712","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/28/rBsADV8qiYaAIW8SAAAv-bVQYIc042.png","nickname":"CHENJIAHUA","answerCount":0,"label":null,"createTime":"2020-02-21 08:54","isResolve":"0","viewCount":769,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["android","retrofit"]},{"id":"1243917706785271808","title":"Retrofit对OKHttp的优势在哪？","userId":"1243916062186016768","avatar":"https://cdn.sunofbeaches.com/images/default_avatar.png","nickname":"summer","answerCount":0,"label":null,"createTime":"2020-03-29 07:13","isResolve":"0","viewCount":609,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["retrofit"]},{"id":"1248245483885899776","title":"retrofit form-data 提交请求的问题","userId":"1240926457648218112","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/45/rBsADWBdkL6AN4BKAABeBgPK5KY111.png","nickname":"路不离开","answerCount":0,"label":null,"createTime":"2020-04-10 06:24","isResolve":"0","viewCount":820,"thumbUp":0,"sob":4,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"1","state":null,"labels":["安卓retrofit"]},{"id":"1257277030370717696","title":"新建Activity之后跑过APP不崩溃，加完Retrofit就崩溃了，看log没明白怎么解决，求助","userId":"1255088796991492096","avatar":"https://images.sunofbeaches.com/content/2021_05_18/844171416617091072.png","nickname":"冒着泡泡的汽水","answerCount":3,"label":null,"createTime":"2020-05-05 04:00","isResolve":"1","viewCount":1105,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["Retrofit网络编程"]},{"id":"1269989010764320768","title":"api请求时：msg='sign不能为空，请生成签名后再重新请求'","userId":"1219157891760525312","avatar":"https://imgs.sunofbeaches.com/group1/M00/00/1F/rBsADV7HhIKAIIseAABjbMVKs4E355.png","nickname":"Maybe","answerCount":1,"label":null,"createTime":"2020-06-09 05:45","isResolve":"1","viewCount":814,"thumbUp":0,"sob":2,"categoryId":"1161256637437153280","categoryName":"安卓/iOS","isVip":"0","state":null,"labels":["retrofit2"]}]
     */

    @SerializedName("success")
    private Boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private List<DataBean> data;

    public Boolean getSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<DataBean> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "WendaBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


    public static class DataBean implements Serializable, MultiItemEntity {
        /**
         * id : 1230530733462827008
         * title : Retrofit上传文件携带信息失败返回400，已抓取log和截图onclick代码。跪求解~
         * userId : 1226683515316211712
         * avatar : https://imgs.sunofbeaches.com/group1/M00/00/28/rBsADV8qiYaAIW8SAAAv-bVQYIc042.png
         * nickname : CHENJIAHUA
         * answerCount : 0
         * label : null
         * createTime : 2020-02-21 08:54
         * isResolve : 0
         * viewCount : 769
         * thumbUp : 0
         * sob : 2
         * categoryId : 1161256637437153280
         * categoryName : 安卓/iOS
         * isVip : 1
         * state : null
         * labels : ["android","retrofit"]
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
        @SerializedName("answerCount")
        private Integer answerCount;
        @SerializedName("label")
        private Object label;
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
        @SerializedName("isVip")
        private String isVip;
        @SerializedName("state")
        private Object state;
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

        public Integer getAnswerCount() {
            return answerCount;
        }

        public Object getLabel() {
            return label;
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

        public String getIsVip() {
            return isVip;
        }

        public Object getState() {
            return state;
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
                    ", answerCount=" + answerCount +
                    ", label=" + label +
                    ", createTime='" + createTime + '\'' +
                    ", isResolve='" + isResolve + '\'' +
                    ", viewCount=" + viewCount +
                    ", thumbUp=" + thumbUp +
                    ", sob=" + sob +
                    ", categoryId='" + categoryId + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", isVip='" + isVip + '\'' +
                    ", state=" + state +
                    ", labels=" + labels +
                    '}';
        }

        @Override
        public int getItemType() {
            return Constants.MultiItemType.TYPE_COMMENT;
        }
    }
}
