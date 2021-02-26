package com.myinfo.base.mapper;

import com.myinfo.base.entity.ProBook;

public interface ProBookMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProBook record);

    int insertSelective(ProBook record);

    ProBook selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProBook record);

    int updateByPrimaryKey(ProBook record);
}