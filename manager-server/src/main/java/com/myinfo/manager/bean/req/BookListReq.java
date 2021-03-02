package com.myinfo.manager.bean.req;

import com.myinfo.base.bean.PageRequestVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("图书借阅人列表")
public class BookListReq extends PageRequestVo {

    @ApiModelProperty("图书名称")
    private String bookName;

}