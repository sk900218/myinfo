package com.myinfo.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myinfo.base.consts.DateConst;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户
 * @author 盛凯 2021-2-24
 */
@Data
@Entity
@ApiModel("用户")
public class SysUser {

    @ApiModelProperty("UUID")
    @Id
    private String id;

    @JsonFormat(pattern = DateConst.DATETIME_FORMAT, timezone = "GMT+8")
    @ApiModelProperty("注册时间")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @ApiModelProperty("账号")
    @Column(name = "account", nullable = false)
    private String account;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "salt", nullable = false)
    private String salt;

    @ApiModelProperty("昵称")
    @Column(name = "nickname", nullable = false)
    private String nickname;

}