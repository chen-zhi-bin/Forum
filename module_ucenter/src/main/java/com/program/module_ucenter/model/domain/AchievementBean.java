package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AchievementBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取成就成功.
     * data : {"id":"1499922681471512578","userId":"1499922423573647361","articleDxView":0,"shareDxView":0,"articleTotal":0,"shareTotal":0,"wendaTotal":5,"asCount":0,"resolveCount":0,"fansDx":0,"fansCount":0,"thumbUpDx":0,"thumbUpTotal":0,"followCount":0,"momentCount":1,"favorites":0,"sobDx":2,"sob":184,"createTime":null,"updateTime":"2022-05-12 12:02","atotalView":0,"stotalView":0}
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
        return "AchievementBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1499922681471512578
         * userId : 1499922423573647361
         * articleDxView : 0
         * shareDxView : 0
         * articleTotal : 0
         * shareTotal : 0
         * wendaTotal : 5
         * asCount : 0
         * resolveCount : 0
         * fansDx : 0
         * fansCount : 0
         * thumbUpDx : 0
         * thumbUpTotal : 0
         * followCount : 0
         * momentCount : 1
         * favorites : 0
         * sobDx : 2
         * sob : 184
         * createTime : null
         * updateTime : 2022-05-12 12:02
         * atotalView : 0
         * stotalView : 0
         */

        @SerializedName("id")
        private String id;
        @SerializedName("userId")
        private String userId;
        @SerializedName("articleDxView")
        private Integer articleDxView;
        @SerializedName("shareDxView")
        private Integer shareDxView;
        @SerializedName("articleTotal")
        private Integer articleTotal;
        @SerializedName("shareTotal")
        private Integer shareTotal;
        @SerializedName("wendaTotal")
        private Integer wendaTotal;
        @SerializedName("asCount")
        private Integer asCount;
        @SerializedName("resolveCount")
        private Integer resolveCount;
        @SerializedName("fansDx")
        private Integer fansDx;
        @SerializedName("fansCount")
        private Integer fansCount;
        @SerializedName("thumbUpDx")
        private Integer thumbUpDx;
        @SerializedName("thumbUpTotal")
        private Integer thumbUpTotal;
        @SerializedName("followCount")
        private Integer followCount;
        @SerializedName("momentCount")
        private Integer momentCount;
        @SerializedName("favorites")
        private Integer favorites;
        @SerializedName("sobDx")
        private Integer sobDx;
        @SerializedName("sob")
        private Integer sob;
        @SerializedName("createTime")
        private Object createTime;
        @SerializedName("updateTime")
        private String updateTime;
        @SerializedName("atotalView")
        private Integer atotalView;
        @SerializedName("stotalView")
        private Integer stotalView;

        public String getId() {
            return id;
        }

        public String getUserId() {
            return userId;
        }

        public Integer getArticleDxView() {
            return articleDxView;
        }

        public Integer getShareDxView() {
            return shareDxView;
        }

        public Integer getArticleTotal() {
            return articleTotal;
        }

        public Integer getShareTotal() {
            return shareTotal;
        }

        public Integer getWendaTotal() {
            return wendaTotal;
        }

        public Integer getAsCount() {
            return asCount;
        }

        public Integer getResolveCount() {
            return resolveCount;
        }

        public Integer getFansDx() {
            return fansDx;
        }

        public Integer getFansCount() {
            return fansCount;
        }

        public Integer getThumbUpDx() {
            return thumbUpDx;
        }

        public Integer getThumbUpTotal() {
            return thumbUpTotal;
        }

        public Integer getFollowCount() {
            return followCount;
        }

        public Integer getMomentCount() {
            return momentCount;
        }

        public Integer getFavorites() {
            return favorites;
        }

        public Integer getSobDx() {
            return sobDx;
        }

        public Integer getSob() {
            return sob;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public Integer getAtotalView() {
            return atotalView;
        }

        public Integer getStotalView() {
            return stotalView;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", userId='" + userId + '\'' +
                    ", articleDxView=" + articleDxView +
                    ", shareDxView=" + shareDxView +
                    ", articleTotal=" + articleTotal +
                    ", shareTotal=" + shareTotal +
                    ", wendaTotal=" + wendaTotal +
                    ", asCount=" + asCount +
                    ", resolveCount=" + resolveCount +
                    ", fansDx=" + fansDx +
                    ", fansCount=" + fansCount +
                    ", thumbUpDx=" + thumbUpDx +
                    ", thumbUpTotal=" + thumbUpTotal +
                    ", followCount=" + followCount +
                    ", momentCount=" + momentCount +
                    ", favorites=" + favorites +
                    ", sobDx=" + sobDx +
                    ", sob=" + sob +
                    ", createTime=" + createTime +
                    ", updateTime='" + updateTime + '\'' +
                    ", atotalView=" + atotalView +
                    ", stotalView=" + stotalView +
                    '}';
        }
    }
}
