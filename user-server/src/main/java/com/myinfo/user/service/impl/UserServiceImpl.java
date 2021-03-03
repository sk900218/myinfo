package com.myinfo.user.service.impl;

import com.myinfo.base.consts.SystemConst;
import com.myinfo.base.dao.SysUserDao;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.enums.ResCode;
import com.myinfo.base.exception.ApiException;
import com.myinfo.base.utils.PwdUtils;
import com.myinfo.base.utils.UUIDUtil;
import com.myinfo.base.valid.ValidParam;
import com.myinfo.base.valid.ValidUtil;
import com.myinfo.base.valid.builder.StringValiRuleBuilder;
import com.myinfo.user.bean.req.LoginReq;
import com.myinfo.user.bean.req.RegisterReq;
import com.myinfo.user.bean.res.LoginRes;
import com.myinfo.user.service.AuthService;
import com.myinfo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private AuthService authService;

    @Override
    public LoginRes login(LoginReq req) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new StringValiRuleBuilder("account", "账号").notNull().maxSize("账号超出规定长度", 50));
        ruleList.add(new StringValiRuleBuilder("password", "密码").notNull());
        ValidUtil.valiParams(req, ruleList);

        /*校验是否存在*/
        SysUser sysUser = sysUserDao.findByAccount(req.getAccount());
        if(sysUser == null) {
            throw new ApiException(ResCode.LOGIC_ERROR, "账号不存在");
        }

        /*校验密码*/
        String pwd = PwdUtils.buildMd5Pwd(req.getPassword(), sysUser.getSalt(), SystemConst.PASSWORD_HASH_NUMBER);
        if(!sysUser.getPassword().equals(pwd)) {
            throw new ApiException(ResCode.LOGIC_ERROR, "密码错误");
        }

        /*生成令牌*/
        String token = authService.saveToken(sysUser);

        /*返回项*/
        LoginRes res = new LoginRes();
        res.setToken(token);
        res.setSysUser(sysUser);

        return res;
    }

    @Override
    public String register(RegisterReq req) throws ApiException {
        /*校验参数*/
        List<ValidParam> ruleList = new ArrayList<>();
        ruleList.add(new StringValiRuleBuilder("account", "账号").notNull().maxSize("账号超出规定长度", 50));
        ruleList.add(new StringValiRuleBuilder("password", "密码").notNull());
        ruleList.add(new StringValiRuleBuilder("nickname", "昵称").notNull().maxSize(50));
        ValidUtil.valiParams(req, ruleList);

        /*验证是否存在*/
        SysUser sysUser = sysUserDao.findByAccount(req.getAccount());
        if(sysUser != null) {
            throw new ApiException(ResCode.LOGIC_ERROR, "账号已存在");
        }

        /*保存用户*/
        sysUser = new SysUser();
        sysUser.setId(UUIDUtil.buildUUID());
        sysUser.setCreateTime(new Date());
        sysUser.setAccount(req.getAccount());
        sysUser.setNickname(req.getNickname());
        //密码加盐处理
        String salt = PwdUtils.buildSalt(SystemConst.PASSWORD_SALT_LENGTH);
        sysUser.setSalt(salt);
        String pwd = PwdUtils.buildMd5Pwd(req.getPassword(), salt, SystemConst.PASSWORD_HASH_NUMBER);
        sysUser.setPassword(pwd);
        sysUserDao.save(sysUser);

        return sysUser.getId();
    }
}
