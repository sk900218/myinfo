package com.myinfo.base.bean;

import com.myinfo.base.enums.ResCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 接口通用返回类
 * @Author 盛凯
 */
@Data
@ApiModel(value = "通用返回字段", description = "所有返回参数，都会被其包裹！")
public class ResVo<T> {

    @ApiModelProperty(value = "返回码")
    private int code;
    @ApiModelProperty(value = "对象")
    private T data;
    @ApiModelProperty(value = "消息")
    private String message;

    public ResVo(ResCode resCode) {
        this.code = resCode.getCode();
        this.message = resCode.getValue();
    }
    public ResVo(ResCode resCode, String message) {
        this.code = resCode.getCode();
        this.message = message;
    }
    public ResVo(ResCode resCode, T data) {
        this.code = resCode.getCode();
        this.data = data;
        this.message = resCode.getValue();
    }
    public ResVo(ResCode resCode, T data, String message) {
        this.code = resCode.getCode();
        this.data = data;
        this.message = message;
    }

}
