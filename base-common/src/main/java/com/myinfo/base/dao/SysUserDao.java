package com.myinfo.base.dao;

import com.myinfo.base.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserDao extends JpaRepository<SysUser, String> {

    SysUser findByAccount(String account);

}
