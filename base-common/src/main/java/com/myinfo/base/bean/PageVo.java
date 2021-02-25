package com.myinfo.base.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页返回数据
 * @author 盛凯 2020-12-23
 */
@Data
@NoArgsConstructor
@ApiModel("分页信息")
public class PageVo<T> {

    @ApiModelProperty(value = "当前页")
    private int page;
    @ApiModelProperty(value = "每页行数")
    private int rows;
    @ApiModelProperty(value = "总数据数")
    private long total;
    @ApiModelProperty(value = "总页数")
    private int maxPage;
    @ApiModelProperty(value = "数据集")
    private List<T> data;

}
