package com.myinfo.apply.bean.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@ApiModel("随便借阅书籍")
public class RandomBorrowBookReq {

    @ApiModelProperty(value = "书籍数量", required = true)
    private Integer num;

    @ApiModelProperty(value = "是否被人截胡", required = true, allowableValues = "0,1")
    private Integer cut = 0;

}