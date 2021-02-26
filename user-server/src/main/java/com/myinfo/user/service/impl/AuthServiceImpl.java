package com.myinfo.user.service.impl;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.consts.SessionConst;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.support.RedisSupport;
import com.myinfo.base.utils.TokenUtils;
import com.myinfo.user.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private RedisSupport redisSupport;

    @Override
    public String saveToken(SysUser sysUser) {
        String token = TokenUtils.buildToken();
        //暂不进行单点登录限制，允许多端登录
        String key = SessionConst.AUTH_TOKEN + "_" + token;
        redisSupport.set(key, sysUser, SessionConst.AUTH_TOKEN_SECONOD);
        return token;
    }

    @Override
    public SysUser getToken(String token) {
        String key = SessionConst.AUTH_TOKEN + "_" + token;
        SysUser sysUser = (SysUser)redisSupport.get(key);
        if(sysUser != null) {
            //取出的同时续约
            redisSupport.set(key, sysUser, SessionConst.AUTH_TOKEN_SECONOD);
        }
        return sysUser;
    }

    @Override
    public ResVo<SysUser> tokenAuth(String token) throws ApiException {
        if(StringUtils.isEmpty(token)) {
            throw new ApiException(ResCode.PARAM_ERROR, "鉴权token未输入");
        }
        ResVo<SysUser> resVo = null;
        SysUser sysUser = this.getToken(token);
        if(sysUser != null) {
            resVo = new ResVo(ResCode.SUCCESS, sysUser);
        } else {
            resVo = new ResVo(ResCode.AUTH_ERROR, "Token已过期");
        }
        return resVo;
    }
}
