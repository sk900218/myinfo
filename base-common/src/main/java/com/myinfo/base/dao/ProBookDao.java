package com.myinfo.base.dao;

import com.myinfo.base.entity.ProBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProBookDao extends JpaRepository<ProBook, String> {

    /**
     * 查询图书列表
     * @param bookName
     * @param pageable
     * @return
     */
    @Query("select t from ProBook t where name like concat('%', :bookName, '%')")
    public Page<ProBook> findAllByBookName(@Param("bookName") String bookName, Pageable pageable);

}
