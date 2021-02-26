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

@Data
@Entity
@ApiModel("图书")
public class ProBook {

    @ApiModelProperty("UUID")
    @Id
    private String id;

    @JsonFormat(pattern = DateConst.DATETIME_FORMAT, timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty("创建人id")
    @Column(name = "create_user_id", nullable = false)
    private String createUserId;

    @ApiModelProperty("创建人")
    @Column(name = "create_user_name", nullable = false)
    private String createUserName;

    @ApiModelProperty("书名")
    @Column(name = "name", nullable = false)
    private String name;


    @ApiModelProperty("借阅状态")
    @Column(name = "borrow_status", nullable = false)
    private Integer borrowStatus;

}