package com.myinfo.base.mapper;

import com.myinfo.base.entity.ProBookBorrow;

public interface ProBookBorrowMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProBookBorrow record);

    int insertSelective(ProBookBorrow record);

    ProBookBorrow selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProBookBorrow record);

    int updateByPrimaryKey(ProBookBorrow record);
}