package com.myinfo.user.bean.res;

import com.myinfo.base.entity.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
//涵盖父类属性打印
@ToString(callSuper = true)
@ApiModel("用户登录返回")
public class LoginRes {

    @ApiModelProperty(value = "令牌", required = true)
    private String token;
    @ApiModelProperty(value = "用户信息", required = true)
    private SysUser sysUser;

}
