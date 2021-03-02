package com.myinfo.manager.bean.req;

import com.myinfo.base.bean.PageRequestVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@ApiModel("图书借阅人列表")
public class BookBorrowListReq extends PageRequestVo {

    @ApiModelProperty(value = "图书id", required = true)
    private String bookId;

}