package com.program.moulde_login.model.bean;

public class UserR {
    private String phoneNum;
    private String passWord;
    private String nickName;

    public UserR(String phoneNum, String passWord, String nickName) {
        this.phoneNum = phoneNum;
        this.passWord = passWord;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNum='" + phoneNum + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
