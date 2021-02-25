package com.myinfo.user.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
//涵盖父类属性打印
@ToString(callSuper = true)
@ApiModel("用户登录")
public class LoginReq {

    @ApiModelProperty(value = "账号", required = true)
    private String account;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
