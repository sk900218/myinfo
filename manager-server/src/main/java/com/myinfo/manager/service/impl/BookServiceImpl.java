package com.myinfo.manager.service.impl;

import com.myinfo.base.bean.PageRequestVo;
import com.myinfo.base.dao.ProBookDao;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.exception.ApiException;
import com.myinfo.manager.bean.req.BookBorrowListReq;
import com.myinfo.manager.bean.req.BookReq;
import com.myinfo.manager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private ProBookDao proBookDao;

    @Override
    public ProBook save(String name) throws ApiException {
        return null;
    }

    @Override
    public ProBook update(BookReq req) throws ApiException {
        return null;
    }

    @Override
    public void delete(String id) throws ApiException {

    }

    @Override
    public List<ProBook> queryList(PageRequestVo vo) throws ApiException {
        return null;
    }

    @Override
    public List<ProBookBorrow> queryBorrowList(BookBorrowListReq vo) throws ApiException {
        return null;
    }
}
