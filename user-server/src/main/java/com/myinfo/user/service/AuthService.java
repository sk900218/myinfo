package com.myinfo.user.service;


import com.myinfo.base.bean.ResVo;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.exception.ApiException;

/**
 * 鉴权
 * @author 盛凯 2021-2-26
 */
public interface AuthService {

    /**
     * 保存鉴权
     * @param sysUser
     * @return
     */
    public String saveToken(SysUser sysUser);

    /**
     * 获取鉴权信息
     * @param token
     * @return
     */
    public SysUser getToken(String token);

    /**
     * token鉴权
     * @param token
     * @return
     */
    public ResVo<SysUser> tokenAuth(String token) throws ApiException;
}
