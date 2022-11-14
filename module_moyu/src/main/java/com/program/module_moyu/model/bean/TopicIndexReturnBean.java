package com.program.module_moyu.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TopicIndexReturnBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取话题成功.
     * data : [{"id":"1384189862646657025","topicName":"代码之美","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1384190025620533249","topicName":"养生之道","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1384518339434385409","topicName":"求职&offer","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1384518529818038273","topicName":"职场经验","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1384518640040153089","topicName":"猿(媛)装备","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1388132359030759425","topicName":"打工人日常","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1384518863412006914","topicName":"小目标","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1388132146446655490","topicName":"段子笑话","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null},{"id":"1388132260582055938","topicName":"轮子推荐","followCount":0,"contentCount":0,"cover":null,"order":0,"description":null,"createTime":null,"updateTime":null}]
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
        return "TopicIndexReturnBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 1384189862646657025
         * topicName : 代码之美
         * followCount : 0
         * contentCount : 0
         * cover : null
         * order : 0
         * description : null
         * createTime : null
         * updateTime : null
         */

        @SerializedName("id")
        private String id;
        @SerializedName("topicName")
        private String topicName;
        @SerializedName("followCount")
        private Integer followCount;
        @SerializedName("contentCount")
        private Integer contentCount;
        @SerializedName("cover")
        private Object cover;
        @SerializedName("order")
        private Integer order;
        @SerializedName("description")
        private String description;
        @SerializedName("createTime")
        private Object createTime;
        @SerializedName("updateTime")
        private Object updateTime;

        public String getId() {
            return id;
        }

        public String getTopicName() {
            return topicName;
        }

        public Integer getFollowCount() {
            return followCount;
        }

        public Integer getContentCount() {
            return contentCount;
        }

        public Object getCover() {
            return cover;
        }

        public Integer getOrder() {
            return order;
        }

        public String getDescription() {
            return description;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", topicName='" + topicName + '\'' +
                    ", followCount=" + followCount +
                    ", contentCount=" + contentCount +
                    ", cover=" + cover +
                    ", order=" + order +
                    ", description=" + description +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    '}';
        }
    }
}
