package com.myinfo.apply.service.impl;
import com.myinfo.apply.bean.res.RandomBorrowBookReq;
import com.myinfo.apply.service.BookService;
import com.myinfo.base.entity.ProBook;
import com.myinfo.base.entity.ProBookBorrow;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.mapper.ProBookBorrowMapper;
import com.myinfo.base.mapper.ProBookMapper;
import com.myinfo.base.service.impl.BaseServiceImpl;
import com.myinfo.base.utils.ListUtils;
import com.myinfo.base.utils.UUIDUtil;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidUtil;
import com.myinfo.base.valid.builder.IntegerValiRuleBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl extends BaseServiceImpl implements BookService {

    @Autowired
    private ProBookMapper proBookMapper;
    @Autowired
    private ProBookBorrowMapper proBookBorrowMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProBook> randomBorrowBook(RandomBorrowBookReq req) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new IntegerValiRuleBuilder("num", "借阅数量").notNull().minVal("你至少应该借阅一本书", 1)
                .maxVal("你借阅的书太多了，最多支持借1000本！", 1000));
        ruleList.add(new IntegerValiRuleBuilder("cut", "是否被人截胡").notNull().spec(new Integer[]{0,1}));
        ValidUtil.valiParams(req, ruleList);

        /*获取当前登录用户*/
        SysUser sysUser = super.getCurrUser();

        /*获取要借阅的书籍*/
        List<ProBook> proBooks = proBookMapper.findRandomByNumber(req.getNum());
        if(ListUtils.isEmpty(proBooks)) {
            throw new ApiException(ResCode.LOGIC_ERROR, "没有书籍可以借阅了！");
        }

        /*循环借书*/
        Date date = new Date();
        for(int i=0; i<proBooks.size(); i++) {
            if(1 == req.getCut() && (Math.random() > 0.5)) {
                log.error("借书过程中被人截胡，account={}", sysUser.getAccount());
                throw new ApiException(ResCode.LOGIC_ERROR, "你在借到第" + (i+1) + "本书的时候被人截胡了，于是气的干脆不借了");
            }
            //更新借阅状态
            ProBook proBook = proBooks.get(i);
            proBook.setBorrowStatus(1);
            proBookMapper.updateByPrimaryKey(proBook);

            //借阅
            ProBookBorrow borrow = new ProBookBorrow();
            borrow.setId(UUIDUtil.buildUUID());
            borrow.setBookId(proBook.getId());
            borrow.setUserId(sysUser.getId());
            borrow.setUserName(sysUser.getNickname());
            borrow.setCreateTime(date);
            proBookBorrowMapper.insert(borrow);
        }
        return proBooks;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProBook randomReturnBook() throws ApiException {
        /*获取当前登录用户*/
        SysUser sysUser = super.getCurrUser();

        /*随机获取一本待还的书*/
        ProBookBorrow borrow = proBookBorrowMapper.findRandom(sysUser.getId());
        if(borrow == null) {
            throw new ApiException(ResCode.LOGIC_ERROR, "你已经没有待还的书籍了！");
        }

        /*查找书籍信息*/
        ProBook book = proBookMapper.selectByPrimaryKey(borrow.getBookId());
        if(book == null) {
            throw new ApiException(ResCode.LOGIC_ERROR, "没有找到对应书籍信息！");
        }

        /*归还*/
        //书籍解锁
        book.setBorrowStatus(0);
        proBookMapper.updateByPrimaryKey(book);
        //归还日期记录
        borrow.setReturnTime(new Date());
        proBookBorrowMapper.updateByPrimaryKey(borrow);

        return book;
    }
}
