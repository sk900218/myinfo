package com.myinfo.manager.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
@ApiModel("图书")
public class BookUpdateReq {

    @ApiModelProperty("UUID")
    private String id;

    @ApiModelProperty("书名")
    @Column(name = "name", nullable = false)
    private String name;

}