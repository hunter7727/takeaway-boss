package com.pmdiss.common.exception;


import com.ajy.core.common.enums.ResponseCode;
import com.ajy.core.common.response.ApiResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 全局异常拦截
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理ApiException
     * @param exception
     * @return
     */
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ApiResponse apiExceptionHandler(ApiException exception){
        ApiResponse apiResponse = ApiResponse.response(exception.getErrorCode(),exception.getErrorMsg(),null);
        return apiResponse;
    }

    /**
     * 处理其他的Exception
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse apiExceptionHandler(Exception exception){
        ApiResponse apiResponse = ApiResponse.response(ResponseCode.SYSTEM_ERROR.getCode(),exception.getMessage(),null);
        return apiResponse;
    }

}
