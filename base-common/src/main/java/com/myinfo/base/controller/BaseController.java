package com.myinfo.base.controller;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.enums.ResCode;

public class BaseController<T> {

    /**
     * 返回成功
     * @return
     */
    protected ResVo success() {
        return new ResVo<>(ResCode.SUCCESS, null, null);
    }

    /**
     * 填入数据返回成功
     * @param data
     * @return
     */
    protected ResVo<T> success(T data) {
        return new ResVo<>(ResCode.SUCCESS, data, null);
    }

    /**
     * 填入数据和消息返回成功
     * @param data
     * @param message
     * @return
     */
    protected ResVo<T> success(T data, String message) {
        return new ResVo<>(ResCode.SUCCESS, data, message);
    }

    /**
     * 生成返回对象
     * @return
     */
    protected ResVo build(ResCode ResCode) {
        return new ResVo<>(ResCode);
    }

    /**
     * 填入数据生成返回对象
     * @param data
     * @return
     */
    protected ResVo<T> build(ResCode ResCode, T data) {
        return new ResVo<>(ResCode, data);
    }

    /**
     * 填入数据和消息生成返回对象
     * @param data
     * @param message
     * @return
     */
    protected ResVo<T> build(ResCode ResCode, T data, String message) {
        return new ResVo<>(ResCode, data, message);
    }
}
