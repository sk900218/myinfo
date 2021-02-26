package com.myinfo.user.controller;

import com.myinfo.base.bean.ResVo;
import com.myinfo.base.consts.SessionConst;
import com.myinfo.base.controller.BaseController;
import com.myinfo.base.entity.SysUser;
import com.myinfo.base.exception.ApiException;
import com.myinfo.user.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("auth")
@Api(tags = "鉴权相关")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "token验证")
    @PostMapping("/token/valid")
    public ResVo tokenValid(HttpServletRequest request) {
        try {
            String token = request.getHeader(SessionConst.AUTH_TOKEN);
            ResVo<SysUser> result = authService.tokenAuth(token);
            return result;
        } catch (ApiException e) {
            return e.getResVo();
        }
    }

}
