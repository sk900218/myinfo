package com.myinfo.manager.service;


import com.myinfo.base.bean.PageRequestVo;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.exception.ApiException;
import com.myinfo.manager.bean.req.BookBorrowListReq;
import com.myinfo.manager.bean.req.BookReq;

import java.util.List;

/**
 * 图书管理
 * @author 盛凯 2021-2-26
 */
public interface BookService {

    /**
     * 增加图书
     * @param name 图书名称
     * @throws ApiException
     */
    public ProBook save(String name) throws ApiException;

    /**
     * 修改图书
     * @param req
     * @throws ApiException
     */
    public ProBook update(BookReq req) throws ApiException;

    /**
     * 删除图书
     * @param id
     * @throws ApiException
     */
    public void delete(String id) throws ApiException;

    /**
     * 查询图书列表
     * @param vo
     * @return
     * @throws ApiException
     */
    public List<ProBook> queryList(PageRequestVo vo) throws ApiException;

    /**
     * 查询图书借阅信息列表
     * @param vo
     * @return
     * @throws ApiException
     */
    public List<ProBookBorrow> queryBorrowList(BookBorrowListReq vo) throws ApiException;
}
