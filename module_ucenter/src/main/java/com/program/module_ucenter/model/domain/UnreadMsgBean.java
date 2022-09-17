package com.program.module_ucenter.model.domain;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UnreadMsgBean implements Serializable {


    /**
     * success : true
     * code : 10000
     * message : 操作成功
     * data : {"wendaMsgCount":7,"atMsgCount":0,"momentCommentCount":3,"systemMsgCount":52,"articleMsgCount":0,"thumbUpMsgCount":0,"shareMsgCount":0}
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
        return "UnreadMsgBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * wendaMsgCount : 7
         * atMsgCount : 0
         * momentCommentCount : 3
         * systemMsgCount : 52
         * articleMsgCount : 0
         * thumbUpMsgCount : 0
         * shareMsgCount : 0
         */

        @SerializedName("wendaMsgCount")
        private Integer wendaMsgCount;
        @SerializedName("atMsgCount")
        private Integer atMsgCount;
        @SerializedName("momentCommentCount")
        private Integer momentCommentCount;
        @SerializedName("systemMsgCount")
        private Integer systemMsgCount;
        @SerializedName("articleMsgCount")
        private Integer articleMsgCount;
        @SerializedName("thumbUpMsgCount")
        private Integer thumbUpMsgCount;
        @SerializedName("shareMsgCount")
        private Integer shareMsgCount;

        public Integer getWendaMsgCount() {
            return wendaMsgCount;
        }

        public Integer getAtMsgCount() {
            return atMsgCount;
        }

        public Integer getMomentCommentCount() {
            return momentCommentCount;
        }

        public Integer getSystemMsgCount() {
            return systemMsgCount;
        }

        public Integer getArticleMsgCount() {
            return articleMsgCount;
        }

        public Integer getThumbUpMsgCount() {
            return thumbUpMsgCount;
        }

        public Integer getShareMsgCount() {
            return shareMsgCount;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "wendaMsgCount=" + wendaMsgCount +
                    ", atMsgCount=" + atMsgCount +
                    ", momentCommentCount=" + momentCommentCount +
                    ", systemMsgCount=" + systemMsgCount +
                    ", articleMsgCount=" + articleMsgCount +
                    ", thumbUpMsgCount=" + thumbUpMsgCount +
                    ", shareMsgCount=" + shareMsgCount +
                    '}';
        }
    }
}
