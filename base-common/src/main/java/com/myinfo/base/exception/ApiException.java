package com.myinfo.base.exception;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.enums.ResCode;
import lombok.Getter;

/**
 * 接口异常类
 * @Author 盛凯 2020-12-22
 */
@Getter
public class ApiException extends Exception {

    private ResVo resVo;

    public ApiException() {
        this.resVo = new ResVo(ResCode.SYSTEM_ERROR);
    }

    public ApiException(ResCode resCode) {
        this.resVo = new ResVo(resCode);
    }

    public ApiException(ResCode resCode, String message) {
        super(message);
        this.resVo = new ResVo(resCode, null, message);
    }

    public ApiException(String message) {
        super(message);
        this.resVo = new ResVo(ResCode.SYSTEM_ERROR, null, message);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.resVo = new ResVo(ResCode.SYSTEM_ERROR, null, message);
    }

}
