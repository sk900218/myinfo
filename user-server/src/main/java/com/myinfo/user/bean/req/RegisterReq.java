package com.myinfo.user.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
//涵盖父类属性打印
@ToString(callSuper = true)
@ApiModel("注册账户")
public class RegisterReq extends LoginReq {

    @ApiModelProperty(value = "昵称", required = true)
    private String nickname;

}
