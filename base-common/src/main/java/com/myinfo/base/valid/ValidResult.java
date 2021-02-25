package com.myinfo.base.valid;

/**
 * 字段校验返回信息
 * @author 盛凯 2020-12-24
 */
public class ValidResult {

    private String message; //消息
    private Boolean result; //结果

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
