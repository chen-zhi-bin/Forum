package com.program.moudle_base.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class PriseQrCodeBean implements Serializable {

    /**
     * success : true
     * code : 10000
     * message : 获取打赏码成功.
     * data : {"qrcUrl":"https://imgs.sunofbeaches.com/group1/M00/00/02/rBPLFV1x6Q2AMjxyAADy5tr458c500.jpg","tips":"我视别人的钱财为粪土，但是你的就不一样啦！"}
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

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PriseQrCodeBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * qrcUrl : https://imgs.sunofbeaches.com/group1/M00/00/02/rBPLFV1x6Q2AMjxyAADy5tr458c500.jpg
         * tips : 我视别人的钱财为粪土，但是你的就不一样啦！
         */

        @SerializedName("qrcUrl")
        private String qrcUrl;
        @SerializedName("tips")
        private String tips;

        public String getQrcUrl() {
            return qrcUrl;
        }

        public void setQrcUrl(String qrcUrl) {
            this.qrcUrl = qrcUrl;
        }

        public String getTips() {
            return tips;
        }

        public void setTips(String tips) {
            this.tips = tips;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "qrcUrl='" + qrcUrl + '\'' +
                    ", tips='" + tips + '\'' +
                    '}';
        }
    }
}
