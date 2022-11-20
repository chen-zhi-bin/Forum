package com.program.moulde_login.model.bean;

public class UserVo {
    private String phoneNum;
    private String password;

    public UserVo(String phoneNum, String password) {
        this.phoneNum = phoneNum;
        this.password = password;
    }

    public UserVo() {
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
