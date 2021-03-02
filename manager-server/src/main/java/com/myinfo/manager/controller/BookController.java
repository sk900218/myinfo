package com.myinfo.manager.controller;

import com.myinfo.base.bean.PageVo;
import com.myinfo.base.bean.ResVo;
import com.myinfo.base.controller.BaseController;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.exception.ApiException;
import com.myinfo.manager.bean.req.BookBorrowListReq;
import com.myinfo.manager.bean.req.BookListReq;
import com.myinfo.manager.bean.req.BookUpdateReq;
import com.myinfo.manager.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("book")
@Api(tags = "图书相关")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "增加图书")
    @PostMapping
    public ResVo<ProBook> save(@ApiParam(value = "书名", required = true) @RequestParam("name") String name, HttpServletRequest request) {
        try {
            ProBook result = bookService.save(name);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "更新图书")
    @PutMapping
    public ResVo<ProBook> update(BookUpdateReq req) {
        try {
            ProBook result = bookService.update(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "删除图书")
    @DeleteMapping("/{id}")
    public ResVo<ProBook> delete(@ApiParam(value = "UUID", required = true) @PathVariable("id") String id) {
        try {
            bookService.delete(id);
            return success();
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "查询图书列表")
    @GetMapping("/list")
    public ResVo<PageVo<ProBook>> list(BookListReq req) {
        try {
            PageVo<ProBook> result = bookService.queryList(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

    @ApiOperation(value = "查询图书借阅列表")
    @GetMapping("/borrow/list")
    public ResVo<PageVo<ProBookBorrow>> borrowList(BookBorrowListReq req) {
        try {
            PageVo<ProBookBorrow> result = bookService.queryBorrowList(req);
            return success(result);
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

}
