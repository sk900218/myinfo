package com.myinfo.base.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页查询条件VO
 * @author 盛凯 2020-12-23
 */
@Data
@ApiModel("分页查询")
public class PageRequestVo {

    @ApiModelProperty(value = "当前页数（默认1）")
    private int page = 1;
    @ApiModelProperty(value = "查询行数（默认10）")
    private int rows = 10;

}
