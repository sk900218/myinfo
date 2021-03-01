package com.myinfo.manager.service.impl;

import com.myinfo.base.bean.PageRequestVo;
import com.myinfo.base.bean.PageVo;
import com.myinfo.base.dao.ProBookBorrowDao;
import com.myinfo.base.dao.ProBookDao;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.service.impl.BaseServiceImpl;
import com.myinfo.base.utils.UUIDUtil;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidUtil;
import com.myinfo.base.valid.builder.IntegerValiRuleBuilder;
import com.myinfo.base.valid.builder.StringValiRuleBuilder;
import com.myinfo.manager.bean.req.BookBorrowListReq;
import com.myinfo.manager.bean.req.BookUpdateReq;
import com.myinfo.manager.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl extends BaseServiceImpl implements BookService {

    @Autowired
    private ProBookDao proBookDao;
    @Autowired
    private ProBookBorrowDao proBookBorrowDao;

    @Override
    public ProBook save(String name) throws ApiException {
        /*校验参数*/
        if(StringUtils.isEmpty(name)) {
            throw new ApiException(ResCode.PARAM_ERROR, "请输入图书名");
        } else if(name.length() > 50) {
            throw new ApiException(ResCode.PARAM_ERROR, "图书名长度超出范围");
        }

        /*获取当前登录用户*/
        SysUser user = this.getCurrUser();

        /*创建对象并保存*/
        ProBook book = new ProBook();
        book.setId(UUIDUtil.buildUUID());
        book.setCreateTime(new Date());
        book.setCreateUserId(user.getId());
        book.setCreateUserName(user.getNickname());
        book.setName(name);
        book.setBorrowStatus(0); //借阅状态 0=未借阅 1=已借阅
        proBookDao.save(book);

        return book;
    }

    @Override
    public ProBook update(BookUpdateReq req) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new StringValiRuleBuilder("id", "UUID").notNull());
        ruleList.add(new StringValiRuleBuilder("name", "书名").notNull().maxSize(50));
        ValidUtil.valiParams(req, ruleList);

        /*更新*/
        //获取图书
        ProBook book = proBookDao.getOne(req.getId());
        if(book == null) {
            throw new ApiException(ResCode.PARAM_ERROR, "图书不存在");
        }
        book.setName(req.getName());
        proBookDao.save(book);

        return book;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        /*校验参数*/
        if(StringUtils.isEmpty(id)) {
            throw new ApiException(ResCode.PARAM_ERROR, "参数异常");
        }

        /*删除*/
        //优先删除借阅信息
        proBookBorrowDao.deleteByBookId(id);
        //删除图书信息
        proBookDao.deleteById(id);
    }

    @Override
    public PageVo<ProBook> queryList(PageRequestVo vo) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new IntegerValiRuleBuilder("page", "当前页").notNull());
        ruleList.add(new IntegerValiRuleBuilder("rows", "行数").notNull().maxVal(1000));
        ValidUtil.valiParams(vo, ruleList);

        /*分页查询*/
        Pageable pageable = PageRequest.of(vo.getPage() - 1, vo.getRows()
                , Sort.by(Sort.Order.desc(new ProBook().getCreateTime().getClass().getSimpleName())));
        Page<ProBook> pages = proBookDao.findAll(pageable);

        /*结果集封装*/
        PageVo<ProBook> result = new PageVo<>();
        result.setPage(vo.getPage() + 1);
        result.setRows(vo.getRows());
        result.setTotal(pages.getTotalElements());
        result.setMaxPage(pages.getTotalPages());
        result.setData(pages.getContent());

        return result;
    }

    @Override
    public PageVo<ProBookBorrow> queryBorrowList(BookBorrowListReq req) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new IntegerValiRuleBuilder("page", "当前页").notNull());
        ruleList.add(new IntegerValiRuleBuilder("rows", "行数").notNull().maxVal(1000));
        ruleList.add(new StringValiRuleBuilder("bookId", "对应图书").notNull());
        ValidUtil.valiParams(req, ruleList);

        /*分页查询*/
        Pageable pageable = PageRequest.of(req.getPage() - 1, req.getRows()
                , Sort.by(Sort.Order.desc(new ProBookBorrow().getCreateTime().getClass().getSimpleName())));
        Page<ProBookBorrow> pages = proBookBorrowDao.findAllByBookId(req.getBookId(), pageable);

        /*结果集封装*/
        PageVo<ProBookBorrow> result = new PageVo<>();
        result.setPage(req.getPage() + 1);
        result.setRows(req.getRows());
        result.setTotal(pages.getTotalElements());
        result.setMaxPage(pages.getTotalPages());
        result.setData(pages.getContent());

        return result;
    }
}
