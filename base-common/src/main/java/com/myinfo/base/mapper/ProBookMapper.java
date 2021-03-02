package com.myinfo.base.mapper;

import com.myinfo.base.entity.ProBook;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProBookMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProBook record);

    int insertSelective(ProBook record);

    ProBook selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProBook record);

    int updateByPrimaryKey(ProBook record);

    /**
     * 随机获取N本书
     * @param num
     * @return
     */
    List<ProBook> findRandomByNumber(Integer num);
}