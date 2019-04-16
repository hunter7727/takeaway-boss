package com.pmdiss.common.response;

import com.ajy.core.common.enums.ResponseCode;

import java.io.Serializable;

/**
 * 返回结果
 */
public class ApiResponse<T> implements Serializable{

    private static final long serialVersionUID = -2342598956617529288L;

    private int code;

    private String msg;

    private T data;


    private ApiResponse(int code, String  msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static  <T> ApiResponse<T> OK(T data){
        return new ApiResponse<>(ResponseCode.OK.getCode(),ResponseCode.OK.getMsg(),data);
    }

    public static <T> ApiResponse<T> ERROR(T data){
        return new ApiResponse<>(ResponseCode.SYSTEM_ERROR.getCode(),ResponseCode.SYSTEM_ERROR.getMsg(),data);
    }

    public static <T> ApiResponse<T> response(int code, String msg, T data){
        return new ApiResponse<>(code,msg,data);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
