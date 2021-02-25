package com.myinfo.base.enums;

import lombok.Getter;

/**
 * 接口响应错误码
 * @Author 盛凯
 */
@Getter
public enum ResCode {

    /**
     * 1**：参数异常
     * 2**：成功
     * 3**：鉴权异常
     * 4**：找不到某些资源
     * 5**：服务器出现错误
     * 6**：逻辑异常
     */
    PARAM_ERROR(100, "参数异常"),
    SUCCESS(200, "成功"),
    AUTH_ERROR(300, "鉴权异常"),
    NONE_ERROR(400, "找不到资源"),
    SYSTEM_ERROR(500, "服务器异常"),
    LOGIC_ERROR(600, "逻辑出现错误"),

    ;

    private int code;
    private String value;

    private ResCode(int code, String value) {
        this.code = code;
        this.value = value;
    }

}
