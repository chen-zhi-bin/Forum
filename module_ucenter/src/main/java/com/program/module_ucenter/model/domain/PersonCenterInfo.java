package com.program.module_ucenter.model.domain;

public class PersonCenterInfo {
    private String area;
    private String avatar;
    private String company;
    private String email;
    private String goodAt;
    private String isvIP;
    private String nickname;
    private String phoneNum;
    private String position;
    private Integer sex;
    private String sign;
    private String userId;


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    public String getIsvIP() {
        return isvIP;
    }

    public void setIsvIP(String isvIP) {
        this.isvIP = isvIP;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PersonCenterInfo{" +
                "area='" + area + '\'' +
                ", avatar='" + avatar + '\'' +
                ", company='" + company + '\'' +
                ", email='" + email + '\'' +
                ", goodAt='" + goodAt + '\'' +
                ", isvIP='" + isvIP + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", position='" + position + '\'' +
                ", sex=" + sex +
                ", sign='" + sign + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
