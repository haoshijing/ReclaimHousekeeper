package com.duyun.huihsou.housekepper.pc.request;

public class UserParams {

    private Integer id;

    private String openId;

    private String headUrl;

    private Integer version;

    private String password;

    private String newPwd1;

    private String newPwd2;

    private String salt;

    private String mobile;

    private String verifyCode;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {

        this.openId = openId == null ? null : headUrl.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNewPwd1() {
        return newPwd1;
    }

    public void setNewPwd1(String newPwd1) {
        this.newPwd1 = newPwd1  == null ? null : newPwd1.trim();
    }

    public String getNewPwd2() {
        return newPwd2;
    }

    public void setNewPwd2(String newPwd2) {
        this.newPwd2 = newPwd2  == null ? null : newPwd2.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt  == null ? null : salt.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {

        this.mobile = mobile  == null ? null : mobile.trim();
    }

    public String getVerifyCode() {
        return verifyCode;
    }


    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }
}
