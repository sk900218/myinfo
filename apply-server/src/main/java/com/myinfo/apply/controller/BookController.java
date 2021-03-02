package com.myinfo.apply.controller;

import com.myinfo.apply.bean.res.RandomBorrowBookReq;
import com.myinfo.apply.service.BookService;
import com.myinfo.base.bean.ResVo;
import com.myinfo.base.controller.BaseController;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.exception.ApiException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("book")
@Api(tags = "书籍相关")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @ApiOperation(value = "随机借阅书籍")
    @PostMapping("/random/borrow")
    public ResVo<List<ProBook>> randomBorrow(RandomBorrowBookReq req) {
        try {
            List<ProBook> result = bookService.randomBorrowBook(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "随机归还书籍")
    @PostMapping("/random/return")
    public ResVo<ProBook> randomReturn() {
        try {
            ProBook result = bookService.randomReturnBook();
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

}
