package com.duyun.huihsou.housekepper.admin.request;

import java.io.Serializable;
import java.util.Objects;

public class AdminUserParams implements Serializable {


    private String name;

    private String passWord;

    private String verifyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminUserParams)) return false;
        AdminUserParams that = (AdminUserParams) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(passWord, that.passWord) &&
                Objects.equals(verifyCode, that.verifyCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passWord, verifyCode);
    }
}
