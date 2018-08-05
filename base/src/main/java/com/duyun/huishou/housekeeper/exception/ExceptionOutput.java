package com.duyun.huishou.housekeeper.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ExceptionOutput {
    private Integer code = 0;
    private String msg = "";

    public ExceptionOutput() {
    }

    public ExceptionOutput(Integer errorCode, String errorMsg) {
        this.code = errorCode;
        this.msg = errorMsg;
    }


    public Integer getCode() {
        return code;
    }

    public ExceptionOutput setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ExceptionOutput setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}