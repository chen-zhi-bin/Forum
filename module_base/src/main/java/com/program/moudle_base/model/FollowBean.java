package com.program.moudle_base.model;

import com.google.gson.annotations.SerializedName;

public class FollowBean {

//0表示没有关注对方，可以显示为：关注
//1表示对方关注自己，可以显示为：回粉
//2表示已经关注对方，可以显示为：已关注
//3表示相互关注，可以显示为：相互关注

    /**
     * success : true
     * code : 10000
     * message : 查询成功.
     * data : 2
     */

    @SerializedName("success")
    private boolean success;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Integer data;

    public boolean isSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Integer getData() {
        return data;
    }

    @Override
    public String toString() {
        return "FollowBean{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
