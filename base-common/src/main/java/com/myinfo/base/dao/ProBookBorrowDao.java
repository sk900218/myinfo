package com.myinfo.base.dao;

import com.myinfo.base.entity.ProBookBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProBookBorrowDao extends JpaRepository<ProBookBorrow, String> {

    public void deleteByBookId(String bookId);

    /**
     * 根据图书id查询借阅列表
     * @param bookId
     * @param pageable
     * @return
     */
    public Page<ProBookBorrow> findAllByBookId(String bookId, Pageable pageable);
}
