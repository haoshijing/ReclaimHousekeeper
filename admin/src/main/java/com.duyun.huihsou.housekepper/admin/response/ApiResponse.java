package com.duyun.huihsou.housekepper.admin.response;

import com.duyun.huishou.housekeeper.constants.RetCode;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private int code;
    private String msg;
    private T data;

    public ApiResponse(){
        this.code = RetCode.OK;
        this.msg = "SUCCESS";
    }

    /**
     * 发生错误不返回data
     * @param code
     * @param msg
     */
    public ApiResponse(int code,String msg){
      this.code = code;
      this.msg = msg;
    }

    public ApiResponse(T data){
        this.code = RetCode.OK;
        this.msg = "SUCCESS";
        this.data = data;
    }

    public ApiResponse(int code, String message, T data){
        this.code =code;
        this.msg = message;
        this.data = data;
    }

    public static ApiResponse responseError(Exception e) {
        return new ApiResponse(RetCode.SERVICE_ERROR, e.getMessage());
    }

}
