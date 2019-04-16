package com.pmdiss.common.enums;

/**
 * @author: wenqiang
 * @date: 2019/3/18 9:44
 *
 * 响应码信息
 */
public enum ResponseCode {

    OK(0,"成功"),
    SYSTEM_ERROR(50000,"系统错误"),
    ILLEGAL_PARAM(50001,"非法参数");

    private int code;

    private String msg;

    private ResponseCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
