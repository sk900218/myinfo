package com.myinfo.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@ApiModel("图书借阅")
public class ProBookBorrow {

    @ApiModelProperty("UUID")
    @Id
    private String id;

    @ApiModelProperty("图书id")
    @Column(name = "book_id", nullable = false)
    private String bookId;

    @ApiModelProperty("图书名称")
    @Column(name = "book_name", nullable = false)
    private String bookName;

    @ApiModelProperty("借阅人id")
    @Column(name = "user_id", nullable = false)
    private String userId;

    @ApiModelProperty("借阅人名称")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @JsonFormat(pattern = DateConst.DATETIME_FORMAT, timezone = "GMT+8")
    @ApiModelProperty("借阅时间")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @JsonFormat(pattern = DateConst.DATETIME_FORMAT, timezone = "GMT+8")
    @ApiModelProperty("归还时间")
    @Column(name = "return_time")
    private Date returnTime;
}