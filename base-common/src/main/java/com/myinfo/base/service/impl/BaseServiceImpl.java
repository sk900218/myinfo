package com.myinfo.base.service.impl;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.service.BaseService;
import com.myinfo.base.support.AuthSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private AuthSupport authSupport;

    @Override
    public SysUser getCurrUser() throws ApiException {
        ResVo<SysUser> resVo = authSupport.getCurrUser();
        return resVo.getData();
    }
}
