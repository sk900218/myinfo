package com.myinfo.base.mapper;

import com.myinfo.base.entity.ProBookBorrow;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProBookBorrowMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProBookBorrow record);

    int insertSelective(ProBookBorrow record);

    ProBookBorrow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProBookBorrow record);

    int updateByPrimaryKey(ProBookBorrow record);

    /**
     * 随机获取一条未归还的借阅信息
     * @return
     */
    ProBookBorrow findRandom(String userId);
}