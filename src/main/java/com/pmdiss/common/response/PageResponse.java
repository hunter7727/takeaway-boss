package com.pmdiss.common.response;


import com.pmdiss.common.enums.ResponseCode;

import java.io.Serializable;
import java.util.List;

/**
 * 返回结果
 */
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = -2802266823031437597L;

    private int code;

    private String msg;

    private Integer totalPage;

    private Integer totalCount;

    private List<T> list;


    private PageResponse(int code, String msg, List<T> list, Integer totalPage, Integer totalCount) {
        this.code = code;
        this.msg = msg;
        this.list = list;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
    }

    public static <T> PageResponse<T> OK(List<T> list, Integer totalPage, Integer totalCount) {
        return new PageResponse<>(ResponseCode.OK.getCode(), ResponseCode.OK.getMsg(), list, totalPage, totalCount);
    }

    public static <T> PageResponse<T> ERROR(List<T> list, Integer totalPage, Integer totalCount) {
        return new PageResponse<>(ResponseCode.SYSTEM_ERROR.getCode(), ResponseCode.SYSTEM_ERROR.getMsg(), list, totalPage, totalCount);
    }

    public static <T> PageResponse<T> response(int code, String msg, List<T> list, Integer totalPage, Integer totalCount) {
        return new PageResponse<>(code, msg, list, totalPage, totalCount);
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

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
