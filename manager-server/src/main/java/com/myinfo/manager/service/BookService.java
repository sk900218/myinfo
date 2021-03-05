package com.myinfo.manager.service;


import com.myinfo.base.bean.PageVo;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.service.BaseService;
import com.myinfo.manager.bean.req.BookBorrowListReq;
import com.myinfo.manager.bean.req.BookListReq;
import com.myinfo.manager.bean.req.BookUpdateReq;

/**
 * 图书管理
 * @author 盛凯 2021-2-26
 */
public interface BookService extends BaseService {

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
    public ProBook update(BookUpdateReq req) throws ApiException;

    /**
     * 删除图书
     * @param id
     * @throws ApiException
     */
    public void delete(String id) throws ApiException;

    /**
     * 查询图书
     * @param id
     * @return
     */
    public ProBook query(String id) throws ApiException;

    /**
     * 查询图书列表
     * @param req
     * @return
     * @throws ApiException
     */
    public PageVo<ProBook> queryList(BookListReq req) throws ApiException;

    /**
     * 查询图书借阅信息列表
     * @param req
     * @return
     * @throws ApiException
     */
    public PageVo<ProBookBorrow> queryBorrowList(BookBorrowListReq req) throws ApiException;
}
