package com.myinfo.user.service;


import com.myinfo.base.entity.SysUser;
import com.myinfo.base.exception.ApiException;
import com.myinfo.user.bean.req.LoginReq;
import com.myinfo.user.bean.req.RegisterReq;

/**
 * 用户管理
 * @author 盛凯 2021-2-24
 */
public interface UserService {

    /**
     * 用户登录
     * @param req
     * @throws ApiException
     */
    public SysUser login(LoginReq req) throws ApiException;

    /**
     * 用户注册
     * @param req
     * @throws ApiException
     */
    public void register(RegisterReq req) throws ApiException;

}
