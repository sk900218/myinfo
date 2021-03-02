package com.myinfo.manager.bean.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("图书")
public class BookUpdateReq {

    @ApiModelProperty(value = "UUID", required = true)
    private String id;

    @ApiModelProperty(value = "书名", required = true)
    private String name;

}