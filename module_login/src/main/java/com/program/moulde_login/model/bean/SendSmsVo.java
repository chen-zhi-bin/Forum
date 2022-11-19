package com.program.moulde_login.model.bean;

public class SendSmsVo {
    private String phoneNumber;
    private String verifyCode;

    public SendSmsVo() {
    }

    public SendSmsVo(String phoneNumber, String verifyCode) {
        this.phoneNumber = phoneNumber;
        this.verifyCode = verifyCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
