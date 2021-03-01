package com.myinfo.base.service;

import com.myinfo.base.entity.SysUser;
import com.myinfo.base.exception.ApiException;
import org.springframework.stereotype.Service;

@Service
public interface BaseService {

    /**
     * 获取当前登录用户
     * @return
     * @throws ApiException
     */
    public SysUser getCurrUser() throws ApiException;

}
