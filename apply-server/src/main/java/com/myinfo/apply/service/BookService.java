package com.myinfo.apply.service;


import com.myinfo.apply.bean.res.RandomBorrowBookReq;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.service.BaseService;

import java.util.List;

/**
 * 图书
 * @author 盛凯 2021-3-2
 */
public interface BookService extends BaseService {

    /**
     * 随便借阅一本书籍
     * @param req
     * @return
     * @throws ApiException
     */
    public List<ProBook> randomBorrowBook(RandomBorrowBookReq req) throws ApiException;

    /**
     * 随便归还一本书
     * @return
     * @throws ApiException
     */
    public ProBook randomReturnBook() throws ApiException;
}
